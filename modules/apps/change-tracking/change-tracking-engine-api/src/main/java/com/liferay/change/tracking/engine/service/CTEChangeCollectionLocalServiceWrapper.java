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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CTEChangeCollectionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CTEChangeCollectionLocalService
 * @generated
 */
@ProviderType
public class CTEChangeCollectionLocalServiceWrapper
	implements CTEChangeCollectionLocalService,
		ServiceWrapper<CTEChangeCollectionLocalService> {
	public CTEChangeCollectionLocalServiceWrapper(
		CTEChangeCollectionLocalService cteChangeCollectionLocalService) {
		_cteChangeCollectionLocalService = cteChangeCollectionLocalService;
	}

	/**
	* Adds the cte change collection to the database. Also notifies the appropriate model listeners.
	*
	* @param cteChangeCollection the cte change collection
	* @return the cte change collection that was added
	*/
	@Override
	public com.liferay.change.tracking.engine.model.CTEChangeCollection addCTEChangeCollection(
		com.liferay.change.tracking.engine.model.CTEChangeCollection cteChangeCollection) {
		return _cteChangeCollectionLocalService.addCTEChangeCollection(cteChangeCollection);
	}

	@Override
	public void addCTEChangeEntryCTEChangeCollection(long cteChangeEntryId,
		com.liferay.change.tracking.engine.model.CTEChangeCollection cteChangeCollection) {
		_cteChangeCollectionLocalService.addCTEChangeEntryCTEChangeCollection(cteChangeEntryId,
			cteChangeCollection);
	}

	@Override
	public void addCTEChangeEntryCTEChangeCollection(long cteChangeEntryId,
		long cteChangeCollectionId) {
		_cteChangeCollectionLocalService.addCTEChangeEntryCTEChangeCollection(cteChangeEntryId,
			cteChangeCollectionId);
	}

	@Override
	public void addCTEChangeEntryCTEChangeCollections(long cteChangeEntryId,
		java.util.List<com.liferay.change.tracking.engine.model.CTEChangeCollection> cteChangeCollections) {
		_cteChangeCollectionLocalService.addCTEChangeEntryCTEChangeCollections(cteChangeEntryId,
			cteChangeCollections);
	}

	@Override
	public void addCTEChangeEntryCTEChangeCollections(long cteChangeEntryId,
		long[] cteChangeCollectionIds) {
		_cteChangeCollectionLocalService.addCTEChangeEntryCTEChangeCollections(cteChangeEntryId,
			cteChangeCollectionIds);
	}

	@Override
	public void clearCTEChangeEntryCTEChangeCollections(long cteChangeEntryId) {
		_cteChangeCollectionLocalService.clearCTEChangeEntryCTEChangeCollections(cteChangeEntryId);
	}

	/**
	* Creates a new cte change collection with the primary key. Does not add the cte change collection to the database.
	*
	* @param cteChangeCollectionId the primary key for the new cte change collection
	* @return the new cte change collection
	*/
	@Override
	public com.liferay.change.tracking.engine.model.CTEChangeCollection createCTEChangeCollection(
		long cteChangeCollectionId) {
		return _cteChangeCollectionLocalService.createCTEChangeCollection(cteChangeCollectionId);
	}

	/**
	* Deletes the cte change collection from the database. Also notifies the appropriate model listeners.
	*
	* @param cteChangeCollection the cte change collection
	* @return the cte change collection that was removed
	*/
	@Override
	public com.liferay.change.tracking.engine.model.CTEChangeCollection deleteCTEChangeCollection(
		com.liferay.change.tracking.engine.model.CTEChangeCollection cteChangeCollection) {
		return _cteChangeCollectionLocalService.deleteCTEChangeCollection(cteChangeCollection);
	}

	/**
	* Deletes the cte change collection with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cteChangeCollectionId the primary key of the cte change collection
	* @return the cte change collection that was removed
	* @throws PortalException if a cte change collection with the primary key could not be found
	*/
	@Override
	public com.liferay.change.tracking.engine.model.CTEChangeCollection deleteCTEChangeCollection(
		long cteChangeCollectionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _cteChangeCollectionLocalService.deleteCTEChangeCollection(cteChangeCollectionId);
	}

	@Override
	public void deleteCTEChangeEntryCTEChangeCollection(long cteChangeEntryId,
		com.liferay.change.tracking.engine.model.CTEChangeCollection cteChangeCollection) {
		_cteChangeCollectionLocalService.deleteCTEChangeEntryCTEChangeCollection(cteChangeEntryId,
			cteChangeCollection);
	}

	@Override
	public void deleteCTEChangeEntryCTEChangeCollection(long cteChangeEntryId,
		long cteChangeCollectionId) {
		_cteChangeCollectionLocalService.deleteCTEChangeEntryCTEChangeCollection(cteChangeEntryId,
			cteChangeCollectionId);
	}

	@Override
	public void deleteCTEChangeEntryCTEChangeCollections(
		long cteChangeEntryId,
		java.util.List<com.liferay.change.tracking.engine.model.CTEChangeCollection> cteChangeCollections) {
		_cteChangeCollectionLocalService.deleteCTEChangeEntryCTEChangeCollections(cteChangeEntryId,
			cteChangeCollections);
	}

	@Override
	public void deleteCTEChangeEntryCTEChangeCollections(
		long cteChangeEntryId, long[] cteChangeCollectionIds) {
		_cteChangeCollectionLocalService.deleteCTEChangeEntryCTEChangeCollections(cteChangeEntryId,
			cteChangeCollectionIds);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _cteChangeCollectionLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cteChangeCollectionLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _cteChangeCollectionLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _cteChangeCollectionLocalService.dynamicQuery(dynamicQuery,
			start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _cteChangeCollectionLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _cteChangeCollectionLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _cteChangeCollectionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.change.tracking.engine.model.CTEChangeCollection fetchCTEChangeCollection(
		long cteChangeCollectionId) {
		return _cteChangeCollectionLocalService.fetchCTEChangeCollection(cteChangeCollectionId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _cteChangeCollectionLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the cte change collection with the primary key.
	*
	* @param cteChangeCollectionId the primary key of the cte change collection
	* @return the cte change collection
	* @throws PortalException if a cte change collection with the primary key could not be found
	*/
	@Override
	public com.liferay.change.tracking.engine.model.CTEChangeCollection getCTEChangeCollection(
		long cteChangeCollectionId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _cteChangeCollectionLocalService.getCTEChangeCollection(cteChangeCollectionId);
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
	@Override
	public java.util.List<com.liferay.change.tracking.engine.model.CTEChangeCollection> getCTEChangeCollections(
		int start, int end) {
		return _cteChangeCollectionLocalService.getCTEChangeCollections(start,
			end);
	}

	/**
	* Returns the number of cte change collections.
	*
	* @return the number of cte change collections
	*/
	@Override
	public int getCTEChangeCollectionsCount() {
		return _cteChangeCollectionLocalService.getCTEChangeCollectionsCount();
	}

	@Override
	public java.util.List<com.liferay.change.tracking.engine.model.CTEChangeCollection> getCTEChangeEntryCTEChangeCollections(
		long cteChangeEntryId) {
		return _cteChangeCollectionLocalService.getCTEChangeEntryCTEChangeCollections(cteChangeEntryId);
	}

	@Override
	public java.util.List<com.liferay.change.tracking.engine.model.CTEChangeCollection> getCTEChangeEntryCTEChangeCollections(
		long cteChangeEntryId, int start, int end) {
		return _cteChangeCollectionLocalService.getCTEChangeEntryCTEChangeCollections(cteChangeEntryId,
			start, end);
	}

	@Override
	public java.util.List<com.liferay.change.tracking.engine.model.CTEChangeCollection> getCTEChangeEntryCTEChangeCollections(
		long cteChangeEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.change.tracking.engine.model.CTEChangeCollection> orderByComparator) {
		return _cteChangeCollectionLocalService.getCTEChangeEntryCTEChangeCollections(cteChangeEntryId,
			start, end, orderByComparator);
	}

	@Override
	public int getCTEChangeEntryCTEChangeCollectionsCount(long cteChangeEntryId) {
		return _cteChangeCollectionLocalService.getCTEChangeEntryCTEChangeCollectionsCount(cteChangeEntryId);
	}

	/**
	* Returns the cteChangeEntryIds of the cte change entries associated with the cte change collection.
	*
	* @param cteChangeCollectionId the cteChangeCollectionId of the cte change collection
	* @return long[] the cteChangeEntryIds of cte change entries associated with the cte change collection
	*/
	@Override
	public long[] getCTEChangeEntryPrimaryKeys(long cteChangeCollectionId) {
		return _cteChangeCollectionLocalService.getCTEChangeEntryPrimaryKeys(cteChangeCollectionId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _cteChangeCollectionLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _cteChangeCollectionLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _cteChangeCollectionLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean hasCTEChangeEntryCTEChangeCollection(long cteChangeEntryId,
		long cteChangeCollectionId) {
		return _cteChangeCollectionLocalService.hasCTEChangeEntryCTEChangeCollection(cteChangeEntryId,
			cteChangeCollectionId);
	}

	@Override
	public boolean hasCTEChangeEntryCTEChangeCollections(long cteChangeEntryId) {
		return _cteChangeCollectionLocalService.hasCTEChangeEntryCTEChangeCollections(cteChangeEntryId);
	}

	@Override
	public void setCTEChangeEntryCTEChangeCollections(long cteChangeEntryId,
		long[] cteChangeCollectionIds) {
		_cteChangeCollectionLocalService.setCTEChangeEntryCTEChangeCollections(cteChangeEntryId,
			cteChangeCollectionIds);
	}

	/**
	* Updates the cte change collection in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cteChangeCollection the cte change collection
	* @return the cte change collection that was updated
	*/
	@Override
	public com.liferay.change.tracking.engine.model.CTEChangeCollection updateCTEChangeCollection(
		com.liferay.change.tracking.engine.model.CTEChangeCollection cteChangeCollection) {
		return _cteChangeCollectionLocalService.updateCTEChangeCollection(cteChangeCollection);
	}

	@Override
	public CTEChangeCollectionLocalService getWrappedService() {
		return _cteChangeCollectionLocalService;
	}

	@Override
	public void setWrappedService(
		CTEChangeCollectionLocalService cteChangeCollectionLocalService) {
		_cteChangeCollectionLocalService = cteChangeCollectionLocalService;
	}

	private CTEChangeCollectionLocalService _cteChangeCollectionLocalService;
}