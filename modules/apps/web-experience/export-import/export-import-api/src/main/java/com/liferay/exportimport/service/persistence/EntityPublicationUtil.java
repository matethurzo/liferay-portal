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

package com.liferay.exportimport.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.exportimport.model.EntityPublication;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the entity publication service. This utility wraps {@link com.liferay.exportimport.service.persistence.impl.EntityPublicationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EntityPublicationPersistence
 * @see com.liferay.exportimport.service.persistence.impl.EntityPublicationPersistenceImpl
 * @generated
 */
@ProviderType
public class EntityPublicationUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(EntityPublication entityPublication) {
		getPersistence().clearCache(entityPublication);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<EntityPublication> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EntityPublication> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EntityPublication> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<EntityPublication> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static EntityPublication update(EntityPublication entityPublication) {
		return getPersistence().update(entityPublication);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static EntityPublication update(
		EntityPublication entityPublication, ServiceContext serviceContext) {
		return getPersistence().update(entityPublication, serviceContext);
	}

	/**
	* Returns the entity publication where classNameId = &#63; and classPK = &#63; or throws a {@link NoSuchEntityPublicationException} if it could not be found.
	*
	* @param classNameId the class name ID
	* @param classPK the class pk
	* @return the matching entity publication
	* @throws NoSuchEntityPublicationException if a matching entity publication could not be found
	*/
	public static EntityPublication findByC_C(long classNameId, long classPK)
		throws com.liferay.exportimport.exception.NoSuchEntityPublicationException {
		return getPersistence().findByC_C(classNameId, classPK);
	}

	/**
	* Returns the entity publication where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param classNameId the class name ID
	* @param classPK the class pk
	* @return the matching entity publication, or <code>null</code> if a matching entity publication could not be found
	*/
	public static EntityPublication fetchByC_C(long classNameId, long classPK) {
		return getPersistence().fetchByC_C(classNameId, classPK);
	}

	/**
	* Returns the entity publication where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param classNameId the class name ID
	* @param classPK the class pk
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching entity publication, or <code>null</code> if a matching entity publication could not be found
	*/
	public static EntityPublication fetchByC_C(long classNameId, long classPK,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByC_C(classNameId, classPK, retrieveFromCache);
	}

	/**
	* Removes the entity publication where classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param classNameId the class name ID
	* @param classPK the class pk
	* @return the entity publication that was removed
	*/
	public static EntityPublication removeByC_C(long classNameId, long classPK)
		throws com.liferay.exportimport.exception.NoSuchEntityPublicationException {
		return getPersistence().removeByC_C(classNameId, classPK);
	}

	/**
	* Returns the number of entity publications where classNameId = &#63; and classPK = &#63;.
	*
	* @param classNameId the class name ID
	* @param classPK the class pk
	* @return the number of matching entity publications
	*/
	public static int countByC_C(long classNameId, long classPK) {
		return getPersistence().countByC_C(classNameId, classPK);
	}

	/**
	* Caches the entity publication in the entity cache if it is enabled.
	*
	* @param entityPublication the entity publication
	*/
	public static void cacheResult(EntityPublication entityPublication) {
		getPersistence().cacheResult(entityPublication);
	}

	/**
	* Caches the entity publications in the entity cache if it is enabled.
	*
	* @param entityPublications the entity publications
	*/
	public static void cacheResult(List<EntityPublication> entityPublications) {
		getPersistence().cacheResult(entityPublications);
	}

	/**
	* Creates a new entity publication with the primary key. Does not add the entity publication to the database.
	*
	* @param id the primary key for the new entity publication
	* @return the new entity publication
	*/
	public static EntityPublication create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the entity publication with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the entity publication
	* @return the entity publication that was removed
	* @throws NoSuchEntityPublicationException if a entity publication with the primary key could not be found
	*/
	public static EntityPublication remove(long id)
		throws com.liferay.exportimport.exception.NoSuchEntityPublicationException {
		return getPersistence().remove(id);
	}

	public static EntityPublication updateImpl(
		EntityPublication entityPublication) {
		return getPersistence().updateImpl(entityPublication);
	}

	/**
	* Returns the entity publication with the primary key or throws a {@link NoSuchEntityPublicationException} if it could not be found.
	*
	* @param id the primary key of the entity publication
	* @return the entity publication
	* @throws NoSuchEntityPublicationException if a entity publication with the primary key could not be found
	*/
	public static EntityPublication findByPrimaryKey(long id)
		throws com.liferay.exportimport.exception.NoSuchEntityPublicationException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the entity publication with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the entity publication
	* @return the entity publication, or <code>null</code> if a entity publication with the primary key could not be found
	*/
	public static EntityPublication fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, EntityPublication> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the entity publications.
	*
	* @return the entity publications
	*/
	public static List<EntityPublication> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the entity publications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EntityPublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of entity publications
	* @param end the upper bound of the range of entity publications (not inclusive)
	* @return the range of entity publications
	*/
	public static List<EntityPublication> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the entity publications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EntityPublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of entity publications
	* @param end the upper bound of the range of entity publications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of entity publications
	*/
	public static List<EntityPublication> findAll(int start, int end,
		OrderByComparator<EntityPublication> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the entity publications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EntityPublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of entity publications
	* @param end the upper bound of the range of entity publications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of entity publications
	*/
	public static List<EntityPublication> findAll(int start, int end,
		OrderByComparator<EntityPublication> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the entity publications from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of entity publications.
	*
	* @return the number of entity publications
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static EntityPublicationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EntityPublicationPersistence, EntityPublicationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(EntityPublicationPersistence.class);

		ServiceTracker<EntityPublicationPersistence, EntityPublicationPersistence> serviceTracker =
			new ServiceTracker<EntityPublicationPersistence, EntityPublicationPersistence>(bundle.getBundleContext(),
				EntityPublicationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}