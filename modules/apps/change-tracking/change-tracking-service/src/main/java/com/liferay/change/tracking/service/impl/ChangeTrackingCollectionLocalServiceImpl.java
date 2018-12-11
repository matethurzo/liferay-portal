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

import com.liferay.change.tracking.exception.CollectionNameException;
import com.liferay.change.tracking.model.ChangeTrackingCollection;
import com.liferay.change.tracking.model.ChangeTrackingEntry;
import com.liferay.change.tracking.service.base.ChangeTrackingCollectionLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 * @author Daniel Kocsis
 */
public class ChangeTrackingCollectionLocalServiceImpl
	extends ChangeTrackingCollectionLocalServiceBaseImpl {

	public ChangeTrackingCollection addCollection(
			long companyId, long userId, String name, String description,
			ServiceContext serviceContext)
		throws PortalException {

		_validate(name);

		long id = counterLocalService.increment();

		ChangeTrackingCollection collection =
			changeTrackingCollectionPersistence.create(id);

		User user = userLocalService.getUser(userId);
		Date now = new Date();

		collection.setCompanyId(companyId);
		collection.setUserId(user.getUserId());
		collection.setUserName(user.getFullName());
		collection.setCreateDate(serviceContext.getCreateDate(now));
		collection.setModifiedDate(serviceContext.getModifiedDate(now));

		collection.setName(name);
		collection.setDescription(description);

		return changeTrackingCollectionPersistence.update(collection);
	}

	@Override
	public ChangeTrackingCollection deleteCollection(
		ChangeTrackingCollection collection) {

		List<ChangeTrackingEntry> entries =
			changeTrackingCollectionPersistence.getChangeTrackingEntries(
				collection.getChangeTrackingCollectionId());

		for (ChangeTrackingEntry entry : entries) {
			int collectionsSize =
				changeTrackingEntryPersistence.getChangeTrackingCollectionsSize(
					collection.getChangeTrackingCollectionId());

			if (collectionsSize > 1) {
				continue;
			}

			changeTrackingEntryLocalService.deleteChangeTrackingEntry(entry);
		}

		changeTrackingCollectionPersistence.remove(collection);
		changeTrackingCollectionPersistence.clearChangeTrackingEntries(
			collection.getChangeTrackingCollectionId());

		return collection;
	}

	@Override
	public void deleteCollection(long companyId) {
		List<ChangeTrackingCollection> collections =
			changeTrackingCollectionPersistence.findByCompanyId(companyId);

		for (ChangeTrackingCollection collection : collections) {
			changeTrackingCollectionLocalService.deleteCollection(collection);
		}
	}

	@Override
	public ChangeTrackingCollection fetchCollection(
		long companyId, String name) {

		return changeTrackingCollectionPersistence.fetchByC_N(companyId, name);
	}

	@Override
	public List<ChangeTrackingCollection> getCollections(long companyId) {
		return changeTrackingCollectionPersistence.findByCompanyId(companyId);
	}

	private void _validate(String name) throws CollectionNameException {
		if (Validator.isNull(name)) {
			throw new CollectionNameException();
		}
	}

}