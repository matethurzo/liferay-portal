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

package com.liferay.exportimport.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.exportimport.exception.NoSuchEntityPublicationException;
import com.liferay.exportimport.model.EntityPublication;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

/**
 * Provides the local service interface for EntityPublication. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see EntityPublicationLocalServiceUtil
 * @see com.liferay.exportimport.service.base.EntityPublicationLocalServiceBaseImpl
 * @see com.liferay.exportimport.service.impl.EntityPublicationLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface EntityPublicationLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EntityPublicationLocalServiceUtil} to access the entity publication local service. Add custom service methods to {@link com.liferay.exportimport.service.impl.EntityPublicationLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the entity publication to the database. Also notifies the appropriate model listeners.
	*
	* @param entityPublication the entity publication
	* @return the entity publication that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public EntityPublication addEntityPublication(
		EntityPublication entityPublication);

	public EntityPublication addEntityPublication(long userId,
		long classNameId, long classPK, Date publicationDate)
		throws PortalException;

	public EntityPublication addEntityPublication(long userId,
		java.lang.String className, long classPK, Date publicationDate)
		throws PortalException;

	/**
	* Creates a new entity publication with the primary key. Does not add the entity publication to the database.
	*
	* @param id the primary key for the new entity publication
	* @return the new entity publication
	*/
	public EntityPublication createEntityPublication(long id);

	/**
	* Deletes the entity publication from the database. Also notifies the appropriate model listeners.
	*
	* @param entityPublication the entity publication
	* @return the entity publication that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public EntityPublication deleteEntityPublication(
		EntityPublication entityPublication);

	/**
	* Deletes the entity publication with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the entity publication
	* @return the entity publication that was removed
	* @throws PortalException if a entity publication with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public EntityPublication deleteEntityPublication(long id)
		throws PortalException;

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	public DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.exportimport.model.impl.EntityPublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.exportimport.model.impl.EntityPublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EntityPublication fetchEntityPublication(long id);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EntityPublication fetchEntityPublication(long classNameId,
		long classPK);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EntityPublication fetchEntityPublication(
		java.lang.String className, long classPK);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	* Returns the entity publication with the primary key.
	*
	* @param id the primary key of the entity publication
	* @return the entity publication
	* @throws PortalException if a entity publication with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EntityPublication getEntityPublication(long id)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EntityPublication getEntityPublication(long classNameId, long classPK)
		throws NoSuchEntityPublicationException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EntityPublication getEntityPublication(java.lang.String className,
		long classPK) throws NoSuchEntityPublicationException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EntityPublication> getEntityPublications();

	/**
	* Returns a range of all the entity publications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.exportimport.model.impl.EntityPublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of entity publications
	* @param end the upper bound of the range of entity publications (not inclusive)
	* @return the range of entity publications
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EntityPublication> getEntityPublications(int start, int end);

	/**
	* Returns the number of entity publications.
	*
	* @return the number of entity publications
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getEntityPublicationsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Updates the entity publication in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param entityPublication the entity publication
	* @return the entity publication that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public EntityPublication updateEntityPublication(
		EntityPublication entityPublication);

	public EntityPublication updateEntityPublication(long userId,
		long classNameId, long classPK, Date publicationDate)
		throws PortalException;

	public EntityPublication updateEntityPublication(long userId,
		java.lang.String className, long classPK, Date publicationDate)
		throws PortalException;
}