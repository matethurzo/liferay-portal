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

package com.liferay.change.tracking.service.impl;

import com.liferay.change.tracking.exception.DuplicateCTEEntryException;
import com.liferay.change.tracking.model.ChangeTrackingCollection;
import com.liferay.change.tracking.model.ChangeTrackingEntry;
import com.liferay.change.tracking.service.base.ChangeTrackingEntryLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 * @author Daniel Kocsis
 */
public class ChangeTrackingEntryLocalServiceImpl
	extends ChangeTrackingEntryLocalServiceBaseImpl {

	@Override
	public ChangeTrackingEntry addEntry(
			long companyId, long userId, long collectionId, long classNameId,
			long classPK, long resourcePrimKey, ServiceContext serviceContext)
		throws PortalException {

		_validate(collectionId, classNameId, classPK);

		long id = counterLocalService.increment();

		ChangeTrackingEntry entry = changeTrackingEntryPersistence.create(id);

		User user = userLocalService.getUser(userId);
		Date now = new Date();

		entry.setCompanyId(companyId);
		entry.setUserId(user.getUserId());
		entry.setUserName(user.getFullName());
		entry.setCreateDate(serviceContext.getCreateDate(now));
		entry.setModifiedDate(serviceContext.getModifiedDate(now));

		entry.setClassNameId(classNameId);
		entry.setClassPK(classPK);
		entry.setResourcePrimKey(resourcePrimKey);

		entry = changeTrackingEntryPersistence.update(entry);

		changeTrackingCollectionLocalService.
			addChangeTrackingEntryChangeTrackingCollection(
				entry.getChangeTrackingEntryId(), collectionId);

		return entry;
	}

	private void _validate(long collectionId, long classNameId, long classPK)
		throws PortalException {

		changeTrackingCollectionLocalService.getChangeTrackingCollection(
			collectionId);

		List<ChangeTrackingEntry> entries =
			changeTrackingEntryPersistence.findByC_C(classNameId, classPK);

		for (ChangeTrackingEntry entry : entries) {
			List<ChangeTrackingCollection> collections =
				changeTrackingCollectionLocalService.
					getChangeTrackingEntryChangeTrackingCollections(
						entry.getChangeTrackingEntryId());

			for (ChangeTrackingCollection collection : collections) {
				if (collection.getChangeTrackingCollectionId() ==
						collectionId) {

					throw new DuplicateCTEEntryException();
				}
			}
		}
	}

}