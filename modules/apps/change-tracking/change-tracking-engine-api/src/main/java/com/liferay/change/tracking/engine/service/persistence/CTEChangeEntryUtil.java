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

package com.liferay.change.tracking.engine.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.change.tracking.engine.model.CTEChangeEntry;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the cte change entry service. This utility wraps {@link com.liferay.change.tracking.engine.service.persistence.impl.CTEChangeEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CTEChangeEntryPersistence
 * @see com.liferay.change.tracking.engine.service.persistence.impl.CTEChangeEntryPersistenceImpl
 * @generated
 */
@ProviderType
public class CTEChangeEntryUtil {
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
	public static void clearCache(CTEChangeEntry cteChangeEntry) {
		getPersistence().clearCache(cteChangeEntry);
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
	public static List<CTEChangeEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CTEChangeEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CTEChangeEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CTEChangeEntry> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CTEChangeEntry update(CTEChangeEntry cteChangeEntry) {
		return getPersistence().update(cteChangeEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CTEChangeEntry update(CTEChangeEntry cteChangeEntry,
		ServiceContext serviceContext) {
		return getPersistence().update(cteChangeEntry, serviceContext);
	}

	/**
	* Returns all the cte change entries where resourcePrimKey = &#63;.
	*
	* @param resourcePrimKey the resource prim key
	* @return the matching cte change entries
	*/
	public static List<CTEChangeEntry> findByResourcePrimKey(
		long resourcePrimKey) {
		return getPersistence().findByResourcePrimKey(resourcePrimKey);
	}

	/**
	* Returns a range of all the cte change entries where resourcePrimKey = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTEChangeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param resourcePrimKey the resource prim key
	* @param start the lower bound of the range of cte change entries
	* @param end the upper bound of the range of cte change entries (not inclusive)
	* @return the range of matching cte change entries
	*/
	public static List<CTEChangeEntry> findByResourcePrimKey(
		long resourcePrimKey, int start, int end) {
		return getPersistence()
				   .findByResourcePrimKey(resourcePrimKey, start, end);
	}

	/**
	* Returns an ordered range of all the cte change entries where resourcePrimKey = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTEChangeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param resourcePrimKey the resource prim key
	* @param start the lower bound of the range of cte change entries
	* @param end the upper bound of the range of cte change entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cte change entries
	*/
	public static List<CTEChangeEntry> findByResourcePrimKey(
		long resourcePrimKey, int start, int end,
		OrderByComparator<CTEChangeEntry> orderByComparator) {
		return getPersistence()
				   .findByResourcePrimKey(resourcePrimKey, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the cte change entries where resourcePrimKey = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTEChangeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param resourcePrimKey the resource prim key
	* @param start the lower bound of the range of cte change entries
	* @param end the upper bound of the range of cte change entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching cte change entries
	*/
	public static List<CTEChangeEntry> findByResourcePrimKey(
		long resourcePrimKey, int start, int end,
		OrderByComparator<CTEChangeEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByResourcePrimKey(resourcePrimKey, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first cte change entry in the ordered set where resourcePrimKey = &#63;.
	*
	* @param resourcePrimKey the resource prim key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cte change entry
	* @throws NoSuchCTEChangeEntryException if a matching cte change entry could not be found
	*/
	public static CTEChangeEntry findByResourcePrimKey_First(
		long resourcePrimKey,
		OrderByComparator<CTEChangeEntry> orderByComparator)
		throws com.liferay.change.tracking.engine.exception.NoSuchCTEChangeEntryException {
		return getPersistence()
				   .findByResourcePrimKey_First(resourcePrimKey,
			orderByComparator);
	}

	/**
	* Returns the first cte change entry in the ordered set where resourcePrimKey = &#63;.
	*
	* @param resourcePrimKey the resource prim key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cte change entry, or <code>null</code> if a matching cte change entry could not be found
	*/
	public static CTEChangeEntry fetchByResourcePrimKey_First(
		long resourcePrimKey,
		OrderByComparator<CTEChangeEntry> orderByComparator) {
		return getPersistence()
				   .fetchByResourcePrimKey_First(resourcePrimKey,
			orderByComparator);
	}

	/**
	* Returns the last cte change entry in the ordered set where resourcePrimKey = &#63;.
	*
	* @param resourcePrimKey the resource prim key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cte change entry
	* @throws NoSuchCTEChangeEntryException if a matching cte change entry could not be found
	*/
	public static CTEChangeEntry findByResourcePrimKey_Last(
		long resourcePrimKey,
		OrderByComparator<CTEChangeEntry> orderByComparator)
		throws com.liferay.change.tracking.engine.exception.NoSuchCTEChangeEntryException {
		return getPersistence()
				   .findByResourcePrimKey_Last(resourcePrimKey,
			orderByComparator);
	}

	/**
	* Returns the last cte change entry in the ordered set where resourcePrimKey = &#63;.
	*
	* @param resourcePrimKey the resource prim key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cte change entry, or <code>null</code> if a matching cte change entry could not be found
	*/
	public static CTEChangeEntry fetchByResourcePrimKey_Last(
		long resourcePrimKey,
		OrderByComparator<CTEChangeEntry> orderByComparator) {
		return getPersistence()
				   .fetchByResourcePrimKey_Last(resourcePrimKey,
			orderByComparator);
	}

	/**
	* Returns the cte change entries before and after the current cte change entry in the ordered set where resourcePrimKey = &#63;.
	*
	* @param cteChangeEntryId the primary key of the current cte change entry
	* @param resourcePrimKey the resource prim key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cte change entry
	* @throws NoSuchCTEChangeEntryException if a cte change entry with the primary key could not be found
	*/
	public static CTEChangeEntry[] findByResourcePrimKey_PrevAndNext(
		long cteChangeEntryId, long resourcePrimKey,
		OrderByComparator<CTEChangeEntry> orderByComparator)
		throws com.liferay.change.tracking.engine.exception.NoSuchCTEChangeEntryException {
		return getPersistence()
				   .findByResourcePrimKey_PrevAndNext(cteChangeEntryId,
			resourcePrimKey, orderByComparator);
	}

	/**
	* Removes all the cte change entries where resourcePrimKey = &#63; from the database.
	*
	* @param resourcePrimKey the resource prim key
	*/
	public static void removeByResourcePrimKey(long resourcePrimKey) {
		getPersistence().removeByResourcePrimKey(resourcePrimKey);
	}

	/**
	* Returns the number of cte change entries where resourcePrimKey = &#63;.
	*
	* @param resourcePrimKey the resource prim key
	* @return the number of matching cte change entries
	*/
	public static int countByResourcePrimKey(long resourcePrimKey) {
		return getPersistence().countByResourcePrimKey(resourcePrimKey);
	}

	/**
	* Caches the cte change entry in the entity cache if it is enabled.
	*
	* @param cteChangeEntry the cte change entry
	*/
	public static void cacheResult(CTEChangeEntry cteChangeEntry) {
		getPersistence().cacheResult(cteChangeEntry);
	}

	/**
	* Caches the cte change entries in the entity cache if it is enabled.
	*
	* @param cteChangeEntries the cte change entries
	*/
	public static void cacheResult(List<CTEChangeEntry> cteChangeEntries) {
		getPersistence().cacheResult(cteChangeEntries);
	}

	/**
	* Creates a new cte change entry with the primary key. Does not add the cte change entry to the database.
	*
	* @param cteChangeEntryId the primary key for the new cte change entry
	* @return the new cte change entry
	*/
	public static CTEChangeEntry create(long cteChangeEntryId) {
		return getPersistence().create(cteChangeEntryId);
	}

	/**
	* Removes the cte change entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cteChangeEntryId the primary key of the cte change entry
	* @return the cte change entry that was removed
	* @throws NoSuchCTEChangeEntryException if a cte change entry with the primary key could not be found
	*/
	public static CTEChangeEntry remove(long cteChangeEntryId)
		throws com.liferay.change.tracking.engine.exception.NoSuchCTEChangeEntryException {
		return getPersistence().remove(cteChangeEntryId);
	}

	public static CTEChangeEntry updateImpl(CTEChangeEntry cteChangeEntry) {
		return getPersistence().updateImpl(cteChangeEntry);
	}

	/**
	* Returns the cte change entry with the primary key or throws a {@link NoSuchCTEChangeEntryException} if it could not be found.
	*
	* @param cteChangeEntryId the primary key of the cte change entry
	* @return the cte change entry
	* @throws NoSuchCTEChangeEntryException if a cte change entry with the primary key could not be found
	*/
	public static CTEChangeEntry findByPrimaryKey(long cteChangeEntryId)
		throws com.liferay.change.tracking.engine.exception.NoSuchCTEChangeEntryException {
		return getPersistence().findByPrimaryKey(cteChangeEntryId);
	}

	/**
	* Returns the cte change entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param cteChangeEntryId the primary key of the cte change entry
	* @return the cte change entry, or <code>null</code> if a cte change entry with the primary key could not be found
	*/
	public static CTEChangeEntry fetchByPrimaryKey(long cteChangeEntryId) {
		return getPersistence().fetchByPrimaryKey(cteChangeEntryId);
	}

	public static java.util.Map<java.io.Serializable, CTEChangeEntry> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the cte change entries.
	*
	* @return the cte change entries
	*/
	public static List<CTEChangeEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the cte change entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTEChangeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cte change entries
	* @param end the upper bound of the range of cte change entries (not inclusive)
	* @return the range of cte change entries
	*/
	public static List<CTEChangeEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the cte change entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTEChangeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cte change entries
	* @param end the upper bound of the range of cte change entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cte change entries
	*/
	public static List<CTEChangeEntry> findAll(int start, int end,
		OrderByComparator<CTEChangeEntry> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the cte change entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTEChangeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cte change entries
	* @param end the upper bound of the range of cte change entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of cte change entries
	*/
	public static List<CTEChangeEntry> findAll(int start, int end,
		OrderByComparator<CTEChangeEntry> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the cte change entries from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of cte change entries.
	*
	* @return the number of cte change entries
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	* Returns the primaryKeys of cte change collections associated with the cte change entry.
	*
	* @param pk the primary key of the cte change entry
	* @return long[] of the primaryKeys of cte change collections associated with the cte change entry
	*/
	public static long[] getCTEChangeCollectionPrimaryKeys(long pk) {
		return getPersistence().getCTEChangeCollectionPrimaryKeys(pk);
	}

	/**
	* Returns all the cte change collections associated with the cte change entry.
	*
	* @param pk the primary key of the cte change entry
	* @return the cte change collections associated with the cte change entry
	*/
	public static List<com.liferay.change.tracking.engine.model.CTEChangeCollection> getCTEChangeCollections(
		long pk) {
		return getPersistence().getCTEChangeCollections(pk);
	}

	/**
	* Returns a range of all the cte change collections associated with the cte change entry.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTEChangeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the cte change entry
	* @param start the lower bound of the range of cte change entries
	* @param end the upper bound of the range of cte change entries (not inclusive)
	* @return the range of cte change collections associated with the cte change entry
	*/
	public static List<com.liferay.change.tracking.engine.model.CTEChangeCollection> getCTEChangeCollections(
		long pk, int start, int end) {
		return getPersistence().getCTEChangeCollections(pk, start, end);
	}

	/**
	* Returns an ordered range of all the cte change collections associated with the cte change entry.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTEChangeEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the cte change entry
	* @param start the lower bound of the range of cte change entries
	* @param end the upper bound of the range of cte change entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cte change collections associated with the cte change entry
	*/
	public static List<com.liferay.change.tracking.engine.model.CTEChangeCollection> getCTEChangeCollections(
		long pk, int start, int end,
		OrderByComparator<com.liferay.change.tracking.engine.model.CTEChangeCollection> orderByComparator) {
		return getPersistence()
				   .getCTEChangeCollections(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of cte change collections associated with the cte change entry.
	*
	* @param pk the primary key of the cte change entry
	* @return the number of cte change collections associated with the cte change entry
	*/
	public static int getCTEChangeCollectionsSize(long pk) {
		return getPersistence().getCTEChangeCollectionsSize(pk);
	}

	/**
	* Returns <code>true</code> if the cte change collection is associated with the cte change entry.
	*
	* @param pk the primary key of the cte change entry
	* @param cteChangeCollectionPK the primary key of the cte change collection
	* @return <code>true</code> if the cte change collection is associated with the cte change entry; <code>false</code> otherwise
	*/
	public static boolean containsCTEChangeCollection(long pk,
		long cteChangeCollectionPK) {
		return getPersistence()
				   .containsCTEChangeCollection(pk, cteChangeCollectionPK);
	}

	/**
	* Returns <code>true</code> if the cte change entry has any cte change collections associated with it.
	*
	* @param pk the primary key of the cte change entry to check for associations with cte change collections
	* @return <code>true</code> if the cte change entry has any cte change collections associated with it; <code>false</code> otherwise
	*/
	public static boolean containsCTEChangeCollections(long pk) {
		return getPersistence().containsCTEChangeCollections(pk);
	}

	/**
	* Adds an association between the cte change entry and the cte change collection. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change entry
	* @param cteChangeCollectionPK the primary key of the cte change collection
	*/
	public static void addCTEChangeCollection(long pk,
		long cteChangeCollectionPK) {
		getPersistence().addCTEChangeCollection(pk, cteChangeCollectionPK);
	}

	/**
	* Adds an association between the cte change entry and the cte change collection. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change entry
	* @param cteChangeCollection the cte change collection
	*/
	public static void addCTEChangeCollection(long pk,
		com.liferay.change.tracking.engine.model.CTEChangeCollection cteChangeCollection) {
		getPersistence().addCTEChangeCollection(pk, cteChangeCollection);
	}

	/**
	* Adds an association between the cte change entry and the cte change collections. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change entry
	* @param cteChangeCollectionPKs the primary keys of the cte change collections
	*/
	public static void addCTEChangeCollections(long pk,
		long[] cteChangeCollectionPKs) {
		getPersistence().addCTEChangeCollections(pk, cteChangeCollectionPKs);
	}

	/**
	* Adds an association between the cte change entry and the cte change collections. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change entry
	* @param cteChangeCollections the cte change collections
	*/
	public static void addCTEChangeCollections(long pk,
		List<com.liferay.change.tracking.engine.model.CTEChangeCollection> cteChangeCollections) {
		getPersistence().addCTEChangeCollections(pk, cteChangeCollections);
	}

	/**
	* Clears all associations between the cte change entry and its cte change collections. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change entry to clear the associated cte change collections from
	*/
	public static void clearCTEChangeCollections(long pk) {
		getPersistence().clearCTEChangeCollections(pk);
	}

	/**
	* Removes the association between the cte change entry and the cte change collection. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change entry
	* @param cteChangeCollectionPK the primary key of the cte change collection
	*/
	public static void removeCTEChangeCollection(long pk,
		long cteChangeCollectionPK) {
		getPersistence().removeCTEChangeCollection(pk, cteChangeCollectionPK);
	}

	/**
	* Removes the association between the cte change entry and the cte change collection. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change entry
	* @param cteChangeCollection the cte change collection
	*/
	public static void removeCTEChangeCollection(long pk,
		com.liferay.change.tracking.engine.model.CTEChangeCollection cteChangeCollection) {
		getPersistence().removeCTEChangeCollection(pk, cteChangeCollection);
	}

	/**
	* Removes the association between the cte change entry and the cte change collections. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change entry
	* @param cteChangeCollectionPKs the primary keys of the cte change collections
	*/
	public static void removeCTEChangeCollections(long pk,
		long[] cteChangeCollectionPKs) {
		getPersistence().removeCTEChangeCollections(pk, cteChangeCollectionPKs);
	}

	/**
	* Removes the association between the cte change entry and the cte change collections. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change entry
	* @param cteChangeCollections the cte change collections
	*/
	public static void removeCTEChangeCollections(long pk,
		List<com.liferay.change.tracking.engine.model.CTEChangeCollection> cteChangeCollections) {
		getPersistence().removeCTEChangeCollections(pk, cteChangeCollections);
	}

	/**
	* Sets the cte change collections associated with the cte change entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change entry
	* @param cteChangeCollectionPKs the primary keys of the cte change collections to be associated with the cte change entry
	*/
	public static void setCTEChangeCollections(long pk,
		long[] cteChangeCollectionPKs) {
		getPersistence().setCTEChangeCollections(pk, cteChangeCollectionPKs);
	}

	/**
	* Sets the cte change collections associated with the cte change entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change entry
	* @param cteChangeCollections the cte change collections to be associated with the cte change entry
	*/
	public static void setCTEChangeCollections(long pk,
		List<com.liferay.change.tracking.engine.model.CTEChangeCollection> cteChangeCollections) {
		getPersistence().setCTEChangeCollections(pk, cteChangeCollections);
	}

	public static CTEChangeEntryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CTEChangeEntryPersistence, CTEChangeEntryPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CTEChangeEntryPersistence.class);

		ServiceTracker<CTEChangeEntryPersistence, CTEChangeEntryPersistence> serviceTracker =
			new ServiceTracker<CTEChangeEntryPersistence, CTEChangeEntryPersistence>(bundle.getBundleContext(),
				CTEChangeEntryPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}