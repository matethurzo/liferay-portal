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

import com.liferay.change.tracking.engine.model.CTEChangeEntry;

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
import com.liferay.portal.kernel.service.PersistedResourcedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for CTEChangeEntry. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see CTEChangeEntryLocalServiceUtil
 * @see com.liferay.change.tracking.engine.service.base.CTEChangeEntryLocalServiceBaseImpl
 * @see com.liferay.change.tracking.engine.service.impl.CTEChangeEntryLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface CTEChangeEntryLocalService extends BaseLocalService,
	PersistedModelLocalService, PersistedResourcedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CTEChangeEntryLocalServiceUtil} to access the cte change entry local service. Add custom service methods to {@link com.liferay.change.tracking.engine.service.impl.CTEChangeEntryLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public void addCTEChangeCollectionCTEChangeEntries(
		long cteChangeCollectionId, List<CTEChangeEntry> cteChangeEntries);

	public void addCTEChangeCollectionCTEChangeEntries(
		long cteChangeCollectionId, long[] cteChangeEntryIds);

	public void addCTEChangeCollectionCTEChangeEntry(
		long cteChangeCollectionId, CTEChangeEntry cteChangeEntry);

	public void addCTEChangeCollectionCTEChangeEntry(
		long cteChangeCollectionId, long cteChangeEntryId);

	/**
	* Adds the cte change entry to the database. Also notifies the appropriate model listeners.
	*
	* @param cteChangeEntry the cte change entry
	* @return the cte change entry that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public CTEChangeEntry addCTEChangeEntry(CTEChangeEntry cteChangeEntry);

	public void clearCTEChangeCollectionCTEChangeEntries(
		long cteChangeCollectionId);

	/**
	* Creates a new cte change entry with the primary key. Does not add the cte change entry to the database.
	*
	* @param cteChangeEntryId the primary key for the new cte change entry
	* @return the new cte change entry
	*/
	@Transactional(enabled = false)
	public CTEChangeEntry createCTEChangeEntry(long cteChangeEntryId);

	public void deleteCTEChangeCollectionCTEChangeEntries(
		long cteChangeCollectionId, List<CTEChangeEntry> cteChangeEntries);

	public void deleteCTEChangeCollectionCTEChangeEntries(
		long cteChangeCollectionId, long[] cteChangeEntryIds);

	public void deleteCTEChangeCollectionCTEChangeEntry(
		long cteChangeCollectionId, CTEChangeEntry cteChangeEntry);

	public void deleteCTEChangeCollectionCTEChangeEntry(
		long cteChangeCollectionId, long cteChangeEntryId);

	/**
	* Deletes the cte change entry from the database. Also notifies the appropriate model listeners.
	*
	* @param cteChangeEntry the cte change entry
	* @return the cte change entry that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public CTEChangeEntry deleteCTEChangeEntry(CTEChangeEntry cteChangeEntry);

	/**
	* Deletes the cte change entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cteChangeEntryId the primary key of the cte change entry
	* @return the cte change entry that was removed
	* @throws PortalException if a cte change entry with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public CTEChangeEntry deleteCTEChangeEntry(long cteChangeEntryId)
		throws PortalException;

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CTEChangeEntry fetchCTEChangeEntry(long cteChangeEntryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CTEChangeEntry> getCTEChangeCollectionCTEChangeEntries(
		long cteChangeCollectionId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CTEChangeEntry> getCTEChangeCollectionCTEChangeEntries(
		long cteChangeCollectionId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CTEChangeEntry> getCTEChangeCollectionCTEChangeEntries(
		long cteChangeCollectionId, int start, int end,
		OrderByComparator<CTEChangeEntry> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCTEChangeCollectionCTEChangeEntriesCount(
		long cteChangeCollectionId);

	/**
	* Returns the cteChangeCollectionIds of the cte change collections associated with the cte change entry.
	*
	* @param cteChangeEntryId the cteChangeEntryId of the cte change entry
	* @return long[] the cteChangeCollectionIds of cte change collections associated with the cte change entry
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getCTEChangeCollectionPrimaryKeys(long cteChangeEntryId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CTEChangeEntry> getCTEChangeEntries(int start, int end);

	/**
	* Returns the number of cte change entries.
	*
	* @return the number of cte change entries
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getCTEChangeEntriesCount();

	/**
	* Returns the cte change entry with the primary key.
	*
	* @param cteChangeEntryId the primary key of the cte change entry
	* @return the cte change entry
	* @throws PortalException if a cte change entry with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CTEChangeEntry getCTEChangeEntry(long cteChangeEntryId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<?extends PersistedModel> getPersistedModel(long resourcePrimKey)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasCTEChangeCollectionCTEChangeEntries(
		long cteChangeCollectionId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasCTEChangeCollectionCTEChangeEntry(
		long cteChangeCollectionId, long cteChangeEntryId);

	public void setCTEChangeCollectionCTEChangeEntries(
		long cteChangeCollectionId, long[] cteChangeEntryIds);

	/**
	* Updates the cte change entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param cteChangeEntry the cte change entry
	* @return the cte change entry that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public CTEChangeEntry updateCTEChangeEntry(CTEChangeEntry cteChangeEntry);
}