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

package com.liferay.exportimport.service.impl;

import com.liferay.exportimport.exception.NoSuchEntityPublicationException;
import com.liferay.exportimport.model.EntityPublication;
import com.liferay.exportimport.service.base.EntityPublicationLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the entity publication local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.exportimport.service.EntityPublicationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EntityPublicationLocalServiceBaseImpl
 * @see com.liferay.exportimport.service.EntityPublicationLocalServiceUtil
 */
public class EntityPublicationLocalServiceImpl
	extends EntityPublicationLocalServiceBaseImpl {

	@Override
	public EntityPublication addEntityPublication(
			long userId, long classNameId, long classPK, Date publicationDate)
		throws PortalException {

		long id = counterLocalService.increment();

		EntityPublication entityPublication =
			entityPublicationPersistence.create(id);

		User user = userLocalService.getUser(userId);

		entityPublication.setUserId(user.getUserId());
		entityPublication.setUserName(user.getFullName());

		entityPublication.setClassNameId(classNameId);
		entityPublication.setClassPK(classPK);
		entityPublication.setPublicationDate(publicationDate);

		return entityPublicationPersistence.update(entityPublication);
	}

	@Override
	public EntityPublication addEntityPublication(
			long userId, String className, long classPK, Date publicationDate)
		throws PortalException {

		long classNameId = classNameLocalService.getClassNameId(className);

		return addEntityPublication(
			userId, classNameId, classPK, publicationDate);
	}

	@Override
	public EntityPublication fetchEntityPublication(
		long classNameId, long classPK) {

		return entityPublicationPersistence.fetchByC_C(classNameId, classPK);
	}

	@Override
	public EntityPublication fetchEntityPublication(
		String className, long classPK) {

		long classNameId = classNameLocalService.getClassNameId(className);

		return fetchEntityPublication(classNameId, classPK);
	}

	@Override
	public EntityPublication getEntityPublication(
			long classNameId, long classPK)
		throws NoSuchEntityPublicationException {

		return entityPublicationPersistence.findByC_C(classNameId, classPK);
	}

	@Override
	public EntityPublication getEntityPublication(
			String className, long classPK)
		throws NoSuchEntityPublicationException {

		long classNameId = classNameLocalService.getClassNameId(className);

		return getEntityPublication(classNameId, classPK);
	}

	@Override
	public List<EntityPublication> getEntityPublications() {
		return entityPublicationPersistence.findAll();
	}

	@Override
	public EntityPublication updateEntityPublication(
			long userId, long classNameId, long classPK, Date publicationDate)
		throws PortalException {

		EntityPublication existingEntityPublication =
			entityPublicationPersistence.fetchByC_C(classNameId, classPK);

		if (existingEntityPublication == null) {
			return addEntityPublication(
				userId, classNameId, classPK, publicationDate);
		}

		User user = userLocalService.getUser(userId);

		existingEntityPublication.setUserId(user.getUserId());
		existingEntityPublication.setUserName(user.getFullName());

		existingEntityPublication.setPublicationDate(publicationDate);

		return entityPublicationPersistence.update(existingEntityPublication);
	}

	@Override
	public EntityPublication updateEntityPublication(
			long userId, String className, long classPK, Date publicationDate)
		throws PortalException {

		long classNameId = classNameLocalService.getClassNameId(className);

		return updateEntityPublication(
			userId, classNameId, classPK, publicationDate);
	}

}