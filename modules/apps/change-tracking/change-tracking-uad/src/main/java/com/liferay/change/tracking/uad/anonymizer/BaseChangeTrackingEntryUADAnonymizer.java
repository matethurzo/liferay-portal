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

package com.liferay.change.tracking.uad.anonymizer;

import com.liferay.change.tracking.model.ChangeTrackingEntry;
import com.liferay.change.tracking.service.ChangeTrackingEntryLocalService;
import com.liferay.change.tracking.uad.constants.ChangeTrackingUADConstants;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;

import com.liferay.user.associated.data.anonymizer.DynamicQueryUADAnonymizer;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the change tracking entry UAD anonymizer.
 *
 * <p>
 * This implementation exists only as a container for the default methods
 * generated by ServiceBuilder. All custom service methods should be put in
 * {@link ChangeTrackingEntryUADAnonymizer}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class BaseChangeTrackingEntryUADAnonymizer
	extends DynamicQueryUADAnonymizer<ChangeTrackingEntry> {
	@Override
	public void autoAnonymize(ChangeTrackingEntry changeTrackingEntry,
		long userId, User anonymousUser) throws PortalException {
		if (changeTrackingEntry.getUserId() == userId) {
			changeTrackingEntry.setUserId(anonymousUser.getUserId());
			changeTrackingEntry.setUserName(anonymousUser.getFullName());
		}

		changeTrackingEntryLocalService.updateChangeTrackingEntry(changeTrackingEntry);
	}

	@Override
	public void delete(ChangeTrackingEntry changeTrackingEntry)
		throws PortalException {
		changeTrackingEntryLocalService.deleteChangeTrackingEntry(changeTrackingEntry);
	}

	@Override
	public Class<ChangeTrackingEntry> getTypeClass() {
		return ChangeTrackingEntry.class;
	}

	@Override
	protected ActionableDynamicQuery doGetActionableDynamicQuery() {
		return changeTrackingEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	protected String[] doGetUserIdFieldNames() {
		return ChangeTrackingUADConstants.USER_ID_FIELD_NAMES_CHANGE_TRACKING_ENTRY;
	}

	@Reference
	protected ChangeTrackingEntryLocalService changeTrackingEntryLocalService;
}