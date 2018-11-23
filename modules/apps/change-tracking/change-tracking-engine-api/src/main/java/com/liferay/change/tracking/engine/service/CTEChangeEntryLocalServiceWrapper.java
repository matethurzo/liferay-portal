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
 * Provides a wrapper for {@link CTEChangeEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CTEChangeEntryLocalService
 * @generated
 */
@ProviderType
public class CTEChangeEntryLocalServiceWrapper
	implements CTEChangeEntryLocalService,
		ServiceWrapper<CTEChangeEntryLocalService> {
	public CTEChangeEntryLocalServiceWrapper(
		CTEChangeEntryLocalService cteChangeEntryLocalService) {
		_cteChangeEntryLocalService = cteChangeEntryLocalService;
	}

	@Override
	public void addCTEChangeCollectionCTEChangeEntries(
		long cteChangeCollectionId,
		java.util.List<com.liferay.change.tracking.engine.model.CTEChangeEntry> cteChangeEntries) {
		_cteChangeEntryLocalService.addCTEChangeCollectionCTEChangeEntries(cteChangeCollectionId,
			cteChangeEntries);
	}

	@Override
	public void addCTEChangeCollectionCTEChangeEntries(
		long cteChangeCollectionId, long[] cteChangeEntryIds) {
		_cteChangeEntryLocalService.addCTEChangeCollectionCTEChangeEntries(cteChangeCollectionId,
			cteChangeEntryIds);
	}

	@Override
	public void addCTEChangeCollectionCTEChangeEntry(
		long cteChangeCollectionId,
		com.liferay.change.tracking.engine.model.CTEChangeEntry cteChangeEntry) {
		_cteChangeEntryLocalService.addCTEChangeCollectionCTEChangeEntry(cteChangeCollectionId,
			cteChangeEntry);
	}

	@Override
	public void addCTEChangeCollectionCTEChangeEntry(
		long cteChangeCollectionId, long cteChangeEntryId) {
		_cteChangeEntryLocalService.addCTEChangeCollectionCTEChangeEntry(cteChangeCollectionId,
			cteChangeEntryId);
	}

	/**
	* Adds the cte change entry to the database. Also notifies the appropriate model listeners.
	*
	* @param cteChangeEntry the cte change entry
	* @return the cte change entry that was added
	*/
	@Override
	public com.liferay.change.tracking.engine.model.CTEChangeEntry addCTEChangeEntry(
		com.liferay.change.tracking.engine.model.CTEChangeEntry cteChangeEntry) {
		return _cteChangeEntryLocalService.addCTEChangeEntry(cteChangeEntry);
	}

	@Override
	public void clearCTEChangeCollectionCTEChangeEntries(
		long cteChangeCollectionId) {
		_cteChangeEntryLocalService.clearCTEChangeCollectionCTEChangeEntries(cteChangeCollectionId);
	}

	/**
	* Creates a new cte change entry with the primary key. Does not add the cte change entry to the database.
	*
	* @param cteChangeEntryId the primary key for the new cte change entry
	* @return the new cte change entry
	*/
	@Override
	public com.liferay.change.tracking.engine.model.CTEChangeEntry createCTEChangeEntry(
		long cteChangeEntryId) {
		return _cteChangeEntryLocalService.createCTEChangeEntry(cteChangeEntryId);
	}

	@Override
	public void deleteCTEChangeCollectionCTEChangeEntries(
		long cteChangeCollectionId,
		java.util.List<com.liferay.change.tracking.engine.model.CTEChangeEntry> cteChangeEntries) {
		_cteChangeEntryLocalService.deleteCTEChangeCollectionCTEChangeEntries(cteChangeCollectionId,
			cteChangeEntries);
	}

	@Override
	public void deleteCTEChangeCollectionCTEChangeEntries(
		long cteChangeCollectionId, long[] cteChangeEntryIds) {
		_cteChangeEntryLocalService.deleteCTEChangeCollectionCTEChangeEntries(cteChangeCollectionId,
			cteChangeEntryIds);
	}

	@Override
	public void deleteCTEChangeCollectionCTEChangeEntry(
		long cteChangeCollectionId,
		com.liferay.change.tracking.engine.model.CTEChangeEntry cteChangeEntry) {
		_cteChangeEntryLocalService.deleteCTEChangeCollectionCTEChangeEntry(cteChangeCollectionId,
			cteChangeEntry);
	}

	@Override
	public void deleteCTEChangeCollectionCTEChangeEntry(
		long cteChangeCollectionId, long cteChangeEntryId) {
		_cteChangeEntryLocalService.deleteCTEChangeCollectionCTEChangeEntry(cteChangeCollectionId,
			cteChangeEntryId);
	}

	/**
	* Deletes the cte change entry from the database. Also notifies the appropriate model listeners.
	*
	* @param cteChangeEntry the cte change entry
	* @return the cte change entry that was removed
	*/
	@Override
	public com.liferay.change.tracking.engine.model.CTEChangeEntry deleteCTEChangeEntry(
		com.liferay.change.tracking.engine.model.CTEChangeEntry cteChangeEntry) {
		return _cteChangeEntryLocalService.deleteCTEChangeEntry(cteChangeEntry);
	}

	/**
	* Deletes the cte change entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cteChangeEntryId the primary key of the cte change entry
	* @return the cte change entry that was removed
	* @throws PortalException if a cte change entry with the primary key could not be found
	*/
	@Override
	public com.liferay.change.tracking.engine.model.CTEChangeEntry deleteCTEChangeEntry(
		long cteChangeEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _cteChangeEntryLocalService.deleteCTEChangeEntry(cteChangeEntryId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _cteChangeEntryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cteChangeEntryLocalService.dynamicQuery();
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
		return _cteChangeEntryLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _cteChangeEntryLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _cteChangeEntryLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _cteChangeEntryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _cteChangeEntryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.change.tracking.engine.model.CTEChangeEntry fetchCTEChangeEntry(
		long cteChangeEntryId) {
		return _cteChangeEntryLocalService.fetchCTEChangeEntry(cteChangeEntryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _cteChangeEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.liferay.change.tracking.engine.model.CTEChangeEntry> getCTEChangeCollectionCTEChangeEntries(
		long cteChangeCollectionId) {
		return _cteChangeEntryLocalService.getCTEChangeCollectionCTEChangeEntries(cteChangeCollectionId);
	}

	@Override
	public java.util.List<com.liferay.change.tracking.engine.model.CTEChangeEntry> getCTEChangeCollectionCTEChangeEntries(
		long cteChangeCollectionId, int start, int end) {
		return _cteChangeEntryLocalService.getCTEChangeCollectionCTEChangeEntries(cteChangeCollectionId,
			start, end);
	}

	@Override
	public java.util.List<com.liferay.change.tracking.engine.model.CTEChangeEntry> getCTEChangeCollectionCTEChangeEntries(
		long cteChangeCollectionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.change.tracking.engine.model.CTEChangeEntry> orderByComparator) {
		return _cteChangeEntryLocalService.getCTEChangeCollectionCTEChangeEntries(cteChangeCollectionId,
			start, end, orderByComparator);
	}

	@Override
	public int getCTEChangeCollectionCTEChangeEntriesCount(
		long cteChangeCollectionId) {
		return _cteChangeEntryLocalService.getCTEChangeCollectionCTEChangeEntriesCount(cteChangeCollectionId);
	}

	/**
	* Returns the cteChangeCollectionIds of the cte change collections associated with the cte change entry.
	*
	* @param cteChangeEntryId the cteChangeEntryId of the cte change entry
	* @return long[] the cteChangeCollectionIds of cte change collections associated with the cte change entry
	*/
	@Override
	public long[] getCTEChangeCollectionPrimaryKeys(long cteChangeEntryId) {
		return _cteChangeEntryLocalService.getCTEChangeCollectionPrimaryKeys(cteChangeEntryId);
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
	@Override
	public java.util.List<com.liferay.change.tracking.engine.model.CTEChangeEntry> getCTEChangeEntries(
		int start, int end) {
		return _cteChangeEntryLocalService.getCTEChangeEntries(start, end);
	}

	/**
	* Returns the number of cte change entries.
	*
	* @return the number of cte change entries
	*/
	@Override
	public int getCTEChangeEntriesCount() {
		return _cteChangeEntryLocalService.getCTEChangeEntriesCount();
	}

	/**
	* Returns the cte change entry with the primary key.
	*
	* @param cteChangeEntryId the primary key of the cte change entry
	* @return the cte change entry
	* @throws PortalException if a cte change entry with the primary key could not be found
	*/
	@Override
	public com.liferay.change.tracking.engine.model.CTEChangeEntry getCTEChangeEntry(
		long cteChangeEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _cteChangeEntryLocalService.getCTEChangeEntry(cteChangeEntryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _cteChangeEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _cteChangeEntryLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<?extends com.liferay.portal.kernel.model.PersistedModel> getPersistedModel(
		long resourcePrimKey)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _cteChangeEntryLocalService.getPersistedModel(resourcePrimKey);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _cteChangeEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public boolean hasCTEChangeCollectionCTEChangeEntries(
		long cteChangeCollectionId) {
		return _cteChangeEntryLocalService.hasCTEChangeCollectionCTEChangeEntries(cteChangeCollectionId);
	}

	@Override
	public boolean hasCTEChangeCollectionCTEChangeEntry(
		long cteChangeCollectionId, long cteChangeEntryId) {
		return _cteChangeEntryLocalService.hasCTEChangeCollectionCTEChangeEntry(cteChangeCollectionId,
			cteChangeEntryId);
	}

	@Override
	public void setCTEChangeCollectionCTEChangeEntries(
		long cteChangeCollectionId, long[] cteChangeEntryIds) {
		_cteChangeEntryLocalService.setCTEChangeCollectionCTEChangeEntries(cteChangeCollectionId,
			cteChangeEntryIds);
	}

	/**
	* Updates the cte change entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cteChangeEntry the cte change entry
	* @return the cte change entry that was updated
	*/
	@Override
	public com.liferay.change.tracking.engine.model.CTEChangeEntry updateCTEChangeEntry(
		com.liferay.change.tracking.engine.model.CTEChangeEntry cteChangeEntry) {
		return _cteChangeEntryLocalService.updateCTEChangeEntry(cteChangeEntry);
	}

	@Override
	public CTEChangeEntryLocalService getWrappedService() {
		return _cteChangeEntryLocalService;
	}

	@Override
	public void setWrappedService(
		CTEChangeEntryLocalService cteChangeEntryLocalService) {
		_cteChangeEntryLocalService = cteChangeEntryLocalService;
	}

	private CTEChangeEntryLocalService _cteChangeEntryLocalService;
}