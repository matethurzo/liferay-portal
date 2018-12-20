/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.change.tracking.internal;

import com.liferay.change.tracking.CTEngineManager;
import com.liferay.change.tracking.CTManager;
import com.liferay.change.tracking.model.CTCollection;
import com.liferay.change.tracking.model.CTEntry;
import com.liferay.change.tracking.service.CTEntryLocalService;
import com.liferay.change.tracking.util.CTEntryCreateDateComparator;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.orm.QueryDefinition;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.ListUtil;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Daniel Kocsis
 */
@Component(immediate = true, service = CTManager.class)
public class CTManagerImpl implements CTManager {

	@Override
	public Optional<CTEntry> getLatestModelChangeCTEntryOptional(
		long userId, long resourcePrimKey) {

		User user = _userLocalService.fetchUser(userId);

		if (user == null) {
			_log.error("Unable to get user " + userId);

			return Optional.empty();
		}

		if (!_ctEngineManager.isChangeTrackingEnabled(user.getCompanyId())) {
			return Optional.empty();
		}

		QueryDefinition<CTEntry> queryDefinition = new QueryDefinition<>();

		queryDefinition.setStart(0);
		queryDefinition.setEnd(1);

		queryDefinition.setOrderByComparator(new CTEntryCreateDateComparator());

		List<CTEntry> ctEntries = getModelChangeCTEntries(
			userId, resourcePrimKey, queryDefinition);

		if (ListUtil.isEmpty(ctEntries)) {
			return Optional.empty();
		}

		return Optional.of(ctEntries.get(0));
	}

	@Override
	public List<CTEntry> getModelChangeCTEntries(
		long userId, long resourcePrimKey) {

		QueryDefinition<CTEntry> queryDefinition = new QueryDefinition<>();

		queryDefinition.setOrderByComparator(
			new CTEntryCreateDateComparator(true));

		return getModelChangeCTEntries(
			userId, resourcePrimKey, queryDefinition);
	}

	@Override
	public List<CTEntry> getModelChangeCTEntries(
		long userId, long resourcePrimKey,
		QueryDefinition<CTEntry> queryDefinition) {

		User user = _userLocalService.fetchUser(userId);

		if (user == null) {
			_log.error("Unable to get user " + userId);

			return Collections.emptyList();
		}

		if (!_ctEngineManager.isChangeTrackingEnabled(user.getCompanyId())) {
			return Collections.emptyList();
		}

		Optional<CTCollection> ctCollectionOptional =
			_ctEngineManager.getActiveCTCollectionOptional(userId);

		long ctCollectionId = ctCollectionOptional.map(
			CTCollection::getCtCollectionId
		).orElse(
			0L
		);

		return _ctEntryLocalService.fetchCTEntries(
			ctCollectionId, resourcePrimKey, queryDefinition);
	}

	@Override
	public Optional<CTEntry> getModelChangeCTEntryOptional(
		long userId, long classNameId, long classPK) {

		User user = _userLocalService.fetchUser(userId);

		if (user == null) {
			_log.error("Unable to find user " + userId);

			return Optional.empty();
		}

		if (!_ctEngineManager.isChangeTrackingEnabled(user.getCompanyId()) ||
			!_ctEngineManager.isChangeTrackingSupported(
				user.getCompanyId(), classNameId)) {

			return Optional.empty();
		}

		CTEntry ctEntry = _ctEntryLocalService.fetchCTEntry(
			classNameId, classPK);

		return Optional.ofNullable(ctEntry);
	}

	@Override
	public Optional<CTEntry> registerModelChange(
		long userId, long classNameId, long classPK, long resourcePrimKey) {

		User user = _userLocalService.fetchUser(userId);

		if (user == null) {
			_log.error("Unable to find user " + userId);

			return Optional.empty();
		}

		if (!_ctEngineManager.isChangeTrackingEnabled(user.getCompanyId()) ||
			!_ctEngineManager.isChangeTrackingSupported(
				user.getCompanyId(), classNameId)) {

			return Optional.empty();
		}

		Optional<CTCollection> ctCollectionOptional =
			_ctEngineManager.getActiveCTCollectionOptional(userId);

		return ctCollectionOptional.map(
			ctCollection -> {
				try {
					return _ctEntryLocalService.addCTEntry(
						userId, classNameId, classPK, resourcePrimKey,
						ctCollection.getCtCollectionId(), new ServiceContext());
				}
				catch (PortalException pe) {
					StringBundler sb = new StringBundler(5);

					sb.append("Unable to register model change {classNameId: ");
					sb.append(classNameId);
					sb.append(" , classPK: ");
					sb.append(classPK);
					sb.append("}");

					_log.error(sb.toString(), pe);

					return null;
				}
			});
	}

	private static final Log _log = LogFactoryUtil.getLog(CTManagerImpl.class);

	@Reference
	private CTEngineManager _ctEngineManager;

	@Reference
	private CTEntryLocalService _ctEntryLocalService;

	@Reference
	private UserLocalService _userLocalService;

}