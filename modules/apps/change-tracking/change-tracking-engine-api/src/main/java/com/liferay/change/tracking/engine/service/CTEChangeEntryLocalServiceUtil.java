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
 * Provides the local service utility for CTEChangeEntry. This utility wraps
 * {@link com.liferay.change.tracking.engine.service.impl.CTEChangeEntryLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CTEChangeEntryLocalService
 * @see com.liferay.change.tracking.engine.service.base.CTEChangeEntryLocalServiceBaseImpl
 * @see com.liferay.change.tracking.engine.service.impl.CTEChangeEntryLocalServiceImpl
 * @generated
 */
@ProviderType
public class CTEChangeEntryLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.change.tracking.engine.service.impl.CTEChangeEntryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addCTEChangeCollectionCTEChangeEntries(
		long cteChangeCollectionId,
		java.util.List<com.liferay.change.tracking.engine.model.CTEChangeEntry> cteChangeEntries) {
		getService()
			.addCTEChangeCollectionCTEChangeEntries(cteChangeCollectionId,
			cteChangeEntries);
	}

	public static void addCTEChangeCollectionCTEChangeEntries(
		long cteChangeCollectionId, long[] cteChangeEntryIds) {
		getService()
			.addCTEChangeCollectionCTEChangeEntries(cteChangeCollectionId,
			cteChangeEntryIds);
	}

	public static void addCTEChangeCollectionCTEChangeEntry(
		long cteChangeCollectionId,
		com.liferay.change.tracking.engine.model.CTEChangeEntry cteChangeEntry) {
		getService()
			.addCTEChangeCollectionCTEChangeEntry(cteChangeCollectionId,
			cteChangeEntry);
	}

	public static void addCTEChangeCollectionCTEChangeEntry(
		long cteChangeCollectionId, long cteChangeEntryId) {
		getService()
			.addCTEChangeCollectionCTEChangeEntry(cteChangeCollectionId,
			cteChangeEntryId);
	}

	/**
	* Adds the cte change entry to the database. Also notifies the appropriate model listeners.
	*
	* @param cteChangeEntry the cte change entry
	* @return the cte change entry that was added
	*/
	public static com.liferay.change.tracking.engine.model.CTEChangeEntry addCTEChangeEntry(
		com.liferay.change.tracking.engine.model.CTEChangeEntry cteChangeEntry) {
		return getService().addCTEChangeEntry(cteChangeEntry);
	}

	public static void clearCTEChangeCollectionCTEChangeEntries(
		long cteChangeCollectionId) {
		getService()
			.clearCTEChangeCollectionCTEChangeEntries(cteChangeCollectionId);
	}

	/**
	* Creates a new cte change entry with the primary key. Does not add the cte change entry to the database.
	*
	* @param cteChangeEntryId the primary key for the new cte change entry
	* @return the new cte change entry
	*/
	public static com.liferay.change.tracking.engine.model.CTEChangeEntry createCTEChangeEntry(
		long cteChangeEntryId) {
		return getService().createCTEChangeEntry(cteChangeEntryId);
	}

	public static void deleteCTEChangeCollectionCTEChangeEntries(
		long cteChangeCollectionId,
		java.util.List<com.liferay.change.tracking.engine.model.CTEChangeEntry> cteChangeEntries) {
		getService()
			.deleteCTEChangeCollectionCTEChangeEntries(cteChangeCollectionId,
			cteChangeEntries);
	}

	public static void deleteCTEChangeCollectionCTEChangeEntries(
		long cteChangeCollectionId, long[] cteChangeEntryIds) {
		getService()
			.deleteCTEChangeCollectionCTEChangeEntries(cteChangeCollectionId,
			cteChangeEntryIds);
	}

	public static void deleteCTEChangeCollectionCTEChangeEntry(
		long cteChangeCollectionId,
		com.liferay.change.tracking.engine.model.CTEChangeEntry cteChangeEntry) {
		getService()
			.deleteCTEChangeCollectionCTEChangeEntry(cteChangeCollectionId,
			cteChangeEntry);
	}

	public static void deleteCTEChangeCollectionCTEChangeEntry(
		long cteChangeCollectionId, long cteChangeEntryId) {
		getService()
			.deleteCTEChangeCollectionCTEChangeEntry(cteChangeCollectionId,
			cteChangeEntryId);
	}

	/**
	* Deletes the cte change entry from the database. Also notifies the appropriate model listeners.
	*
	* @param cteChangeEntry the cte change entry
	* @return the cte change entry that was removed
	*/
	public static com.liferay.change.tracking.engine.model.CTEChangeEntry deleteCTEChangeEntry(
		com.liferay.change.tracking.engine.model.CTEChangeEntry cteChangeEntry) {
		return getService().deleteCTEChangeEntry(cteChangeEntry);
	}

	/**
	* Deletes the cte change entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cteChangeEntryId the primary key of the cte change entry
	* @return the cte change entry that was removed
	* @throws PortalException if a cte change entry with the primary key could not be found
	*/
	public static com.liferay.change.tracking.engine.model.CTEChangeEntry deleteCTEChangeEntry(
		long cteChangeEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteCTEChangeEntry(cteChangeEntryId);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.change.tracking.engine.model.impl.CTEChangeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.change.tracking.engine.model.impl.CTEChangeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.change.tracking.engine.model.CTEChangeEntry fetchCTEChangeEntry(
		long cteChangeEntryId) {
		return getService().fetchCTEChangeEntry(cteChangeEntryId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<com.liferay.change.tracking.engine.model.CTEChangeEntry> getCTEChangeCollectionCTEChangeEntries(
		long cteChangeCollectionId) {
		return getService()
				   .getCTEChangeCollectionCTEChangeEntries(cteChangeCollectionId);
	}

	public static java.util.List<com.liferay.change.tracking.engine.model.CTEChangeEntry> getCTEChangeCollectionCTEChangeEntries(
		long cteChangeCollectionId, int start, int end) {
		return getService()
				   .getCTEChangeCollectionCTEChangeEntries(cteChangeCollectionId,
			start, end);
	}

	public static java.util.List<com.liferay.change.tracking.engine.model.CTEChangeEntry> getCTEChangeCollectionCTEChangeEntries(
		long cteChangeCollectionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.change.tracking.engine.model.CTEChangeEntry> orderByComparator) {
		return getService()
				   .getCTEChangeCollectionCTEChangeEntries(cteChangeCollectionId,
			start, end, orderByComparator);
	}

	public static int getCTEChangeCollectionCTEChangeEntriesCount(
		long cteChangeCollectionId) {
		return getService()
				   .getCTEChangeCollectionCTEChangeEntriesCount(cteChangeCollectionId);
	}

	/**
	* Returns the cteChangeCollectionIds of the cte change collections associated with the cte change entry.
	*
	* @param cteChangeEntryId the cteChangeEntryId of the cte change entry
	* @return long[] the cteChangeCollectionIds of cte change collections associated with the cte change entry
	*/
	public static long[] getCTEChangeCollectionPrimaryKeys(
		long cteChangeEntryId) {
		return getService().getCTEChangeCollectionPrimaryKeys(cteChangeEntryId);
	}

	/**
	* Returns a range of all the cte change entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.change.tracking.engine.model.impl.CTEChangeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cte change entries
	* @param end the upper bound of the range of cte change entries (not inclusive)
	* @return the range of cte change entries
	*/
	public static java.util.List<com.liferay.change.tracking.engine.model.CTEChangeEntry> getCTEChangeEntries(
		int start, int end) {
		return getService().getCTEChangeEntries(start, end);
	}

	/**
	* Returns the number of cte change entries.
	*
	* @return the number of cte change entries
	*/
	public static int getCTEChangeEntriesCount() {
		return getService().getCTEChangeEntriesCount();
	}

	/**
	* Returns the cte change entry with the primary key.
	*
	* @param cteChangeEntryId the primary key of the cte change entry
	* @return the cte change entry
	* @throws PortalException if a cte change entry with the primary key could not be found
	*/
	public static com.liferay.change.tracking.engine.model.CTEChangeEntry getCTEChangeEntry(
		long cteChangeEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getCTEChangeEntry(cteChangeEntryId);
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

	public static java.util.List<?extends com.liferay.portal.kernel.model.PersistedModel> getPersistedModel(
		long resourcePrimKey)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(resourcePrimKey);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	public static boolean hasCTEChangeCollectionCTEChangeEntries(
		long cteChangeCollectionId) {
		return getService()
				   .hasCTEChangeCollectionCTEChangeEntries(cteChangeCollectionId);
	}

	public static boolean hasCTEChangeCollectionCTEChangeEntry(
		long cteChangeCollectionId, long cteChangeEntryId) {
		return getService()
				   .hasCTEChangeCollectionCTEChangeEntry(cteChangeCollectionId,
			cteChangeEntryId);
	}

	public static void setCTEChangeCollectionCTEChangeEntries(
		long cteChangeCollectionId, long[] cteChangeEntryIds) {
		getService()
			.setCTEChangeCollectionCTEChangeEntries(cteChangeCollectionId,
			cteChangeEntryIds);
	}

	/**
	* Updates the cte change entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cteChangeEntry the cte change entry
	* @return the cte change entry that was updated
	*/
	public static com.liferay.change.tracking.engine.model.CTEChangeEntry updateCTEChangeEntry(
		com.liferay.change.tracking.engine.model.CTEChangeEntry cteChangeEntry) {
		return getService().updateCTEChangeEntry(cteChangeEntry);
	}

	public static CTEChangeEntryLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CTEChangeEntryLocalService, CTEChangeEntryLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CTEChangeEntryLocalService.class);

		ServiceTracker<CTEChangeEntryLocalService, CTEChangeEntryLocalService> serviceTracker =
			new ServiceTracker<CTEChangeEntryLocalService, CTEChangeEntryLocalService>(bundle.getBundleContext(),
				CTEChangeEntryLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}