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

package com.liferay.change.tracking.engine.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for CTEChangeCollection. This utility wraps
 * {@link com.liferay.change.tracking.engine.service.impl.CTEChangeCollectionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CTEChangeCollectionLocalService
 * @see com.liferay.change.tracking.engine.service.base.CTEChangeCollectionLocalServiceBaseImpl
 * @see com.liferay.change.tracking.engine.service.impl.CTEChangeCollectionLocalServiceImpl
 * @generated
 */
@ProviderType
public class CTEChangeCollectionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.change.tracking.engine.service.impl.CTEChangeCollectionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the cte change collection to the database. Also notifies the appropriate model listeners.
	*
	* @param cteChangeCollection the cte change collection
	* @return the cte change collection that was added
	*/
	public static com.liferay.change.tracking.engine.model.CTEChangeCollection addCTEChangeCollection(
		com.liferay.change.tracking.engine.model.CTEChangeCollection cteChangeCollection) {
		return getService().addCTEChangeCollection(cteChangeCollection);
	}

	public static void addCTEChangeEntryCTEChangeCollection(
		long cteChangeEntryId,
		com.liferay.change.tracking.engine.model.CTEChangeCollection cteChangeCollection) {
		getService()
			.addCTEChangeEntryCTEChangeCollection(cteChangeEntryId,
			cteChangeCollection);
	}

	public static void addCTEChangeEntryCTEChangeCollection(
		long cteChangeEntryId, long cteChangeCollectionId) {
		getService()
			.addCTEChangeEntryCTEChangeCollection(cteChangeEntryId,
			cteChangeCollectionId);
	}

	public static void addCTEChangeEntryCTEChangeCollections(
		long cteChangeEntryId,
		java.util.List<com.liferay.change.tracking.engine.model.CTEChangeCollection> cteChangeCollections) {
		getService()
			.addCTEChangeEntryCTEChangeCollections(cteChangeEntryId,
			cteChangeCollections);
	}

	public static void addCTEChangeEntryCTEChangeCollections(
		long cteChangeEntryId, long[] cteChangeCollectionIds) {
		getService()
			.addCTEChangeEntryCTEChangeCollections(cteChangeEntryId,
			cteChangeCollectionIds);
	}

	public static void clearCTEChangeEntryCTEChangeCollections(
		long cteChangeEntryId) {
		getService().clearCTEChangeEntryCTEChangeCollections(cteChangeEntryId);
	}

	/**
	* Creates a new cte change collection with the primary key. Does not add the cte change collection to the database.
	*
	* @param cteChangeCollectionId the primary key for the new cte change collection
	* @return the new cte change collection
	*/
	public static com.liferay.change.tracking.engine.model.CTEChangeCollection createCTEChangeCollection(
		long cteChangeCollectionId) {
		return getService().createCTEChangeCollection(cteChangeCollectionId);
	}

	/**
	* Deletes the cte change collection from the database. Also notifies the appropriate model listeners.
	*
	* @param cteChangeCollection the cte change collection
	* @return the cte change collection that was removed
	*/
	public static com.liferay.change.tracking.engine.model.CTEChangeCollection deleteCTEChangeCollection(
		com.liferay.change.tracking.engine.model.CTEChangeCollection cteChangeCollection) {
		return getService().deleteCTEChangeCollection(cteChangeCollection);
	}

	/**
	* Deletes the cte change collection with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cteChangeCollectionId the primary key of the cte change collection
	* @return the cte change collection that was removed
	* @throws PortalException if a cte change collection with the primary key could not be found
	*/
	public static com.liferay.change.tracking.engine.model.CTEChangeCollection deleteCTEChangeCollection(
		long cteChangeCollectionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteCTEChangeCollection(cteChangeCollectionId);
	}

	public static void deleteCTEChangeEntryCTEChangeCollection(
		long cteChangeEntryId,
		com.liferay.change.tracking.engine.model.CTEChangeCollection cteChangeCollection) {
		getService()
			.deleteCTEChangeEntryCTEChangeCollection(cteChangeEntryId,
			cteChangeCollection);
	}

	public static void deleteCTEChangeEntryCTEChangeCollection(
		long cteChangeEntryId, long cteChangeCollectionId) {
		getService()
			.deleteCTEChangeEntryCTEChangeCollection(cteChangeEntryId,
			cteChangeCollectionId);
	}

	public static void deleteCTEChangeEntryCTEChangeCollections(
		long cteChangeEntryId,
		java.util.List<com.liferay.change.tracking.engine.model.CTEChangeCollection> cteChangeCollections) {
		getService()
			.deleteCTEChangeEntryCTEChangeCollections(cteChangeEntryId,
			cteChangeCollections);
	}

	public static void deleteCTEChangeEntryCTEChangeCollections(
		long cteChangeEntryId, long[] cteChangeCollectionIds) {
		getService()
			.deleteCTEChangeEntryCTEChangeCollections(cteChangeEntryId,
			cteChangeCollectionIds);
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.change.tracking.engine.model.impl.CTEChangeCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.change.tracking.engine.model.impl.CTEChangeCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.change.tracking.engine.model.CTEChangeCollection fetchCTEChangeCollection(
		long cteChangeCollectionId) {
		return getService().fetchCTEChangeCollection(cteChangeCollectionId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	/**
	* Returns the cte change collection with the primary key.
	*
	* @param cteChangeCollectionId the primary key of the cte change collection
	* @return the cte change collection
	* @throws PortalException if a cte change collection with the primary key could not be found
	*/
	public static com.liferay.change.tracking.engine.model.CTEChangeCollection getCTEChangeCollection(
		long cteChangeCollectionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCTEChangeCollection(cteChangeCollectionId);
	}

	/**
	* Returns a range of all the cte change collections.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.change.tracking.engine.model.impl.CTEChangeCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cte change collections
	* @param end the upper bound of the range of cte change collections (not inclusive)
	* @return the range of cte change collections
	*/
	public static java.util.List<com.liferay.change.tracking.engine.model.CTEChangeCollection> getCTEChangeCollections(
		int start, int end) {
		return getService().getCTEChangeCollections(start, end);
	}

	/**
	* Returns the number of cte change collections.
	*
	* @return the number of cte change collections
	*/
	public static int getCTEChangeCollectionsCount() {
		return getService().getCTEChangeCollectionsCount();
	}

	public static java.util.List<com.liferay.change.tracking.engine.model.CTEChangeCollection> getCTEChangeEntryCTEChangeCollections(
		long cteChangeEntryId) {
		return getService()
				   .getCTEChangeEntryCTEChangeCollections(cteChangeEntryId);
	}

	public static java.util.List<com.liferay.change.tracking.engine.model.CTEChangeCollection> getCTEChangeEntryCTEChangeCollections(
		long cteChangeEntryId, int start, int end) {
		return getService()
				   .getCTEChangeEntryCTEChangeCollections(cteChangeEntryId,
			start, end);
	}

	public static java.util.List<com.liferay.change.tracking.engine.model.CTEChangeCollection> getCTEChangeEntryCTEChangeCollections(
		long cteChangeEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.change.tracking.engine.model.CTEChangeCollection> orderByComparator) {
		return getService()
				   .getCTEChangeEntryCTEChangeCollections(cteChangeEntryId,
			start, end, orderByComparator);
	}

	public static int getCTEChangeEntryCTEChangeCollectionsCount(
		long cteChangeEntryId) {
		return getService()
				   .getCTEChangeEntryCTEChangeCollectionsCount(cteChangeEntryId);
	}

	/**
	* Returns the cteChangeEntryIds of the cte change entries associated with the cte change collection.
	*
	* @param cteChangeCollectionId the cteChangeCollectionId of the cte change collection
	* @return long[] the cteChangeEntryIds of cte change entries associated with the cte change collection
	*/
	public static long[] getCTEChangeEntryPrimaryKeys(
		long cteChangeCollectionId) {
		return getService().getCTEChangeEntryPrimaryKeys(cteChangeCollectionId);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	public static boolean hasCTEChangeEntryCTEChangeCollection(
		long cteChangeEntryId, long cteChangeCollectionId) {
		return getService()
				   .hasCTEChangeEntryCTEChangeCollection(cteChangeEntryId,
			cteChangeCollectionId);
	}

	public static boolean hasCTEChangeEntryCTEChangeCollections(
		long cteChangeEntryId) {
		return getService()
				   .hasCTEChangeEntryCTEChangeCollections(cteChangeEntryId);
	}

	public static void setCTEChangeEntryCTEChangeCollections(
		long cteChangeEntryId, long[] cteChangeCollectionIds) {
		getService()
			.setCTEChangeEntryCTEChangeCollections(cteChangeEntryId,
			cteChangeCollectionIds);
	}

	/**
	* Updates the cte change collection in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cteChangeCollection the cte change collection
	* @return the cte change collection that was updated
	*/
	public static com.liferay.change.tracking.engine.model.CTEChangeCollection updateCTEChangeCollection(
		com.liferay.change.tracking.engine.model.CTEChangeCollection cteChangeCollection) {
		return getService().updateCTEChangeCollection(cteChangeCollection);
	}

	public static CTEChangeCollectionLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CTEChangeCollectionLocalService, CTEChangeCollectionLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CTEChangeCollectionLocalService.class);

		ServiceTracker<CTEChangeCollectionLocalService, CTEChangeCollectionLocalService> serviceTracker =
			new ServiceTracker<CTEChangeCollectionLocalService, CTEChangeCollectionLocalService>(bundle.getBundleContext(),
				CTEChangeCollectionLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}