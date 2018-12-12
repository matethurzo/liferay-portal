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

import com.liferay.change.tracking.ChangeTrackingManager;
import com.liferay.change.tracking.constants.ChangeTrackingConstants;
import com.liferay.change.tracking.constants.ChangeTrackingPortletKeys;
import com.liferay.change.tracking.model.ChangeTrackingCollection;
import com.liferay.change.tracking.model.ChangeTrackingEntry;
import com.liferay.change.tracking.service.ChangeTrackingCollectionLocalService;
import com.liferay.change.tracking.service.ChangeTrackingEntryLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.PortalPreferences;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.TransactionConfig;
import com.liferay.portal.kernel.transaction.TransactionInvokerUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Daniel Kocsis
 */
@Component(immediate = true, service = ChangeTrackingManager.class)
public class ChangeTrackingManagerImpl implements ChangeTrackingManager {

	@Override
	public void checkoutCTCollection(
		long companyId, long userId, long ctCollectionId) {

		if (!isChangeTrackingEnabled(companyId)) {
			return;
		}

		Optional<ChangeTrackingCollection> ctCollectionOptional =
			getCTCollectionOptional(ctCollectionId);

		if (!ctCollectionOptional.isPresent()) {
			_log.error(
				"Unable to checkout change collection with id " +
					ctCollectionId);

			return;
		}

		try {
			TransactionInvokerUtil.invoke(
				_transactionConfig,
				() -> {
					_updateUserCollection(userId, ctCollectionId);

					return null;
				});
		}
		catch (Throwable t) {
			_log.error("Unable to change user's active collection set", t);
		}
	}

	@Override
	public Optional<ChangeTrackingCollection> createCTCollection(
		long companyId, long userId, String name, String description) {

		if (ChangeTrackingConstants.CHANGE_COLLECTION_NAME_PRODUCTION.equals(
				name) ||
			!isChangeTrackingEnabled(companyId)) {

			return Optional.empty();
		}

		return _createCTCollection(companyId, userId, name, description);
	}

	@Override
	public void deleteCTCollection(long userId, long ctCollectionId) {
		Optional<ChangeTrackingCollection> ctCollectionOptional =
			getCTCollectionOptional(ctCollectionId);

		if (!ctCollectionOptional.isPresent()) {
			_log.error(
				"Unable to delete change collection with id " + ctCollectionId);

			return;
		}

		_changeTrackingCollectionLocalService.deleteChangeTrackingCollection(
			ctCollectionOptional.get());
	}

	@Override
	public void disableChangeTracking(long companyId, long userId) {
		if (!isChangeTrackingEnabled(companyId)) {
			return;
		}

		try {
			TransactionInvokerUtil.invoke(
				_transactionConfig,
				() -> {
					_changeTrackingCollectionLocalService.
						deleteCompanyChangeTrackingCollections(companyId);

					_productionCTCollection = null;

					return null;
				});
		}
		catch (Throwable t) {
			_log.error("Unable to disable change tracking", t);
		}
	}

	@Override
	public void enableChangeTracking(long companyId, long userId) {
		if (isChangeTrackingEnabled(companyId)) {
			return;
		}

		try {
			TransactionInvokerUtil.invoke(
				_transactionConfig,
				() -> {
					Optional<ChangeTrackingCollection> ctCollectionOptional =
						_createCTCollection(
							companyId, userId,
							ChangeTrackingConstants.
								CHANGE_COLLECTION_NAME_PRODUCTION,
							StringPool.BLANK);

					ctCollectionOptional.ifPresent(
						ctCollection -> {
							_productionCTCollection =
								ctCollectionOptional.orElse(null);

							checkoutCTCollection(
								companyId, userId,
								ctCollection.getChangeTrackingCollectionId());
						});

					return null;
				});
		}
		catch (Throwable t) {
			_log.error("Unable to enable change tracking", t);
		}
	}

	@Override
	public Optional<ChangeTrackingCollection> getActiveCTCollectionOptional(
		long companyId, long userId) {

		if (!isChangeTrackingEnabled(companyId)) {
			return Optional.empty();
		}

		long recentCTCollectionId = _getUserCollectionId(userId);

		if (recentCTCollectionId == 0L) {
			Optional<ChangeTrackingCollection> productionCTCollectionOptional =
				getProductionCTCollectionOptional(companyId);

			recentCTCollectionId = productionCTCollectionOptional.map(
				ChangeTrackingCollection::getChangeTrackingCollectionId
			).orElse(
				0L
			);

			checkoutCTCollection(companyId, userId, recentCTCollectionId);
		}

		return getCTCollectionOptional(recentCTCollectionId);
	}

	@Override
	public Optional<ChangeTrackingCollection> getCTCollectionOptional(
		long ctCollectionId) {

		ChangeTrackingCollection ctCollection =
			_changeTrackingCollectionLocalService.fetchChangeTrackingCollection(
				ctCollectionId);

		return Optional.ofNullable(ctCollection);
	}

	@Override
	public List<ChangeTrackingCollection> getCTCollections(long companyId) {
		if (!isChangeTrackingEnabled(companyId)) {
			return Collections.emptyList();
		}

		return _changeTrackingCollectionLocalService.
			getChangeTrackingCollections(companyId);
	}

	@Override
	public List<ChangeTrackingEntry> getCTEntries(long ctCollectionId) {
		return _changeTrackingEntryLocalService.
			getChangeTrackingCollectionChangeTrackingEntries(ctCollectionId);
	}

	public Optional<ChangeTrackingCollection> getProductionCTCollectionOptional(
		long companyId) {

		if (_productionCTCollection == null) {
			_productionCTCollection =
				_changeTrackingCollectionLocalService.
					fetchChangeTrackingCollection(
						companyId,
						ChangeTrackingConstants.
							CHANGE_COLLECTION_NAME_PRODUCTION);
		}

		return Optional.ofNullable(_productionCTCollection);
	}

	@Override
	public boolean isChangeTrackingEnabled(long companyId) {
		Optional<ChangeTrackingCollection> productionCTCollection =
			getProductionCTCollectionOptional(companyId);

		return productionCTCollection.isPresent();
	}

	@Override
	public boolean isChangeTrackingSupported(
		long companyId, Class<BaseModel> clazz) {

		return false;
	}

	@Override
	public void publishCTCollection(
		long companyId, long userId, long ctCollectionId) {

		if (!isChangeTrackingEnabled(companyId)) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"Unable to publish change collection because change " +
						"tracking is not enabled in company " + companyId);
			}

			return;
		}

		List<ChangeTrackingEntry> ctEntries = getCTEntries(ctCollectionId);

		if (ListUtil.isEmpty(ctEntries)) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"Unable to find any change entries with change " +
						"collection id " + ctCollectionId);
			}

			return;
		}

		try {
			TransactionInvokerUtil.invoke(
				_transactionConfig,
				() -> {
					_publishCTEntries(
						companyId, userId, ctCollectionId, ctEntries);

					return null;
				});
		}
		catch (Throwable t) {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"Unable to publish change entries to change collection " +
						ctCollectionId,
					t);
			}
		}
	}

	private void _copyEntriesFromProduction(
		ChangeTrackingCollection ctCollection) {

		Optional<ChangeTrackingCollection> productionCTCollectionOptional =
			getProductionCTCollectionOptional(ctCollection.getCompanyId());

		List<ChangeTrackingEntry> productionCTEntries =
			productionCTCollectionOptional.map(
				ChangeTrackingCollection::getChangeTrackingCollectionId
			).map(
				this::getCTEntries
			).orElse(
				Collections.emptyList()
			);

		for (ChangeTrackingEntry ctEntry : productionCTEntries) {
			_changeTrackingCollectionLocalService.
				addChangeTrackingEntryChangeTrackingCollection(
					ctEntry.getChangeTrackingEntryId(), ctCollection);
		}
	}

	private Optional<ChangeTrackingCollection> _createCTCollection(
		long companyId, long userId, String name, String description) {

		ChangeTrackingCollection ctCollection = null;

		try {
			ctCollection = TransactionInvokerUtil.invoke(
				_transactionConfig,
				() -> {
					ChangeTrackingCollection addedCTCollection =
						_changeTrackingCollectionLocalService.
							addChangeTrackingCollection(
								companyId, userId, name, description,
								new ServiceContext());

					_copyEntriesFromProduction(addedCTCollection);

					return addedCTCollection;
				});
		}
		catch (Throwable t) {
			_log.error(
				"Unable to create change collection with name " + name, t);
		}

		return Optional.ofNullable(ctCollection);
	}

	private long _getUserCollectionId(long userId) {
		User user = _userLocalService.fetchUser(userId);

		if (user == null) {
			_log.error("Unable to find user with id " + userId);

			return 0L;
		}

		PortalPreferences portalPreferences =
			PortletPreferencesFactoryUtil.getPortalPreferences(
				userId, !user.isDefaultUser());

		return GetterUtil.getLong(
			portalPreferences.getValue(
				ChangeTrackingPortletKeys.CHANGE_LISTS,
				_RECENT_CHANGE_COLLECTION_ID));
	}

	private void _publishCTEntries(
		long companyId, long userId, long ctCollectionId,
		List<ChangeTrackingEntry> ctEntries) {

		Optional<ChangeTrackingCollection> productionCTCollectionOptional =
			getProductionCTCollectionOptional(companyId);

		if (!productionCTCollectionOptional.isPresent()) {
			return;
		}

		long productionCTCollectionId = productionCTCollectionOptional.map(
			ChangeTrackingCollection::getChangeTrackingCollectionId
		).get();

		_changeTrackingEntryLocalService.
			addChangeTrackingCollectionChangeTrackingEntries(
				productionCTCollectionId, ctEntries);

		Optional<ChangeTrackingCollection> ctCollectionOptional =
			getCTCollectionOptional(ctCollectionId);

		if (!ctCollectionOptional.isPresent()) {
			return;
		}

		try {
			_changeTrackingCollectionLocalService.updateStatus(
				userId, ctCollectionOptional.get(),
				WorkflowConstants.STATUS_APPROVED, new ServiceContext());
		}
		catch (PortalException pe) {
			_log.error(
				"Unable to update the status of the published change " +
					"collection",
				pe);
		}
	}

	private void _updateUserCollection(long userId, long ctCollectionId) {
		User user = _userLocalService.fetchUser(userId);

		PortalPreferences portalPreferences =
			PortletPreferencesFactoryUtil.getPortalPreferences(
				userId, !user.isDefaultUser());

		portalPreferences.setValue(
			ChangeTrackingPortletKeys.CHANGE_LISTS,
			_RECENT_CHANGE_COLLECTION_ID, String.valueOf(ctCollectionId));
	}

	private static final String _RECENT_CHANGE_COLLECTION_ID =
		"recentChangeCollectionId";

	private static final Log _log = LogFactoryUtil.getLog(
		ChangeTrackingManagerImpl.class);

	@Reference
	private ChangeTrackingCollectionLocalService
		_changeTrackingCollectionLocalService;

	@Reference
	private ChangeTrackingEntryLocalService _changeTrackingEntryLocalService;

	private ChangeTrackingCollection _productionCTCollection;
	private final TransactionConfig _transactionConfig =
		TransactionConfig.Factory.create(
			Propagation.REQUIRED, new Class<?>[] {Exception.class});

	@Reference
	private UserLocalService _userLocalService;

}