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

import com.liferay.change.tracking.engine.exception.NoSuchCTEChangeEntryException;
import com.liferay.change.tracking.engine.model.CTEChangeEntry;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the cte change entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.change.tracking.engine.service.persistence.impl.CTEChangeEntryPersistenceImpl
 * @see CTEChangeEntryUtil
 * @generated
 */
@ProviderType
public interface CTEChangeEntryPersistence extends BasePersistence<CTEChangeEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CTEChangeEntryUtil} to access the cte change entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the cte change entries where resourcePrimKey = &#63;.
	*
	* @param resourcePrimKey the resource prim key
	* @return the matching cte change entries
	*/
	public java.util.List<CTEChangeEntry> findByResourcePrimKey(
		long resourcePrimKey);

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
	public java.util.List<CTEChangeEntry> findByResourcePrimKey(
		long resourcePrimKey, int start, int end);

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
	public java.util.List<CTEChangeEntry> findByResourcePrimKey(
		long resourcePrimKey, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CTEChangeEntry> orderByComparator);

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
	public java.util.List<CTEChangeEntry> findByResourcePrimKey(
		long resourcePrimKey, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CTEChangeEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first cte change entry in the ordered set where resourcePrimKey = &#63;.
	*
	* @param resourcePrimKey the resource prim key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cte change entry
	* @throws NoSuchCTEChangeEntryException if a matching cte change entry could not be found
	*/
	public CTEChangeEntry findByResourcePrimKey_First(long resourcePrimKey,
		com.liferay.portal.kernel.util.OrderByComparator<CTEChangeEntry> orderByComparator)
		throws NoSuchCTEChangeEntryException;

	/**
	* Returns the first cte change entry in the ordered set where resourcePrimKey = &#63;.
	*
	* @param resourcePrimKey the resource prim key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching cte change entry, or <code>null</code> if a matching cte change entry could not be found
	*/
	public CTEChangeEntry fetchByResourcePrimKey_First(long resourcePrimKey,
		com.liferay.portal.kernel.util.OrderByComparator<CTEChangeEntry> orderByComparator);

	/**
	* Returns the last cte change entry in the ordered set where resourcePrimKey = &#63;.
	*
	* @param resourcePrimKey the resource prim key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cte change entry
	* @throws NoSuchCTEChangeEntryException if a matching cte change entry could not be found
	*/
	public CTEChangeEntry findByResourcePrimKey_Last(long resourcePrimKey,
		com.liferay.portal.kernel.util.OrderByComparator<CTEChangeEntry> orderByComparator)
		throws NoSuchCTEChangeEntryException;

	/**
	* Returns the last cte change entry in the ordered set where resourcePrimKey = &#63;.
	*
	* @param resourcePrimKey the resource prim key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching cte change entry, or <code>null</code> if a matching cte change entry could not be found
	*/
	public CTEChangeEntry fetchByResourcePrimKey_Last(long resourcePrimKey,
		com.liferay.portal.kernel.util.OrderByComparator<CTEChangeEntry> orderByComparator);

	/**
	* Returns the cte change entries before and after the current cte change entry in the ordered set where resourcePrimKey = &#63;.
	*
	* @param cteChangeEntryId the primary key of the current cte change entry
	* @param resourcePrimKey the resource prim key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next cte change entry
	* @throws NoSuchCTEChangeEntryException if a cte change entry with the primary key could not be found
	*/
	public CTEChangeEntry[] findByResourcePrimKey_PrevAndNext(
		long cteChangeEntryId, long resourcePrimKey,
		com.liferay.portal.kernel.util.OrderByComparator<CTEChangeEntry> orderByComparator)
		throws NoSuchCTEChangeEntryException;

	/**
	* Removes all the cte change entries where resourcePrimKey = &#63; from the database.
	*
	* @param resourcePrimKey the resource prim key
	*/
	public void removeByResourcePrimKey(long resourcePrimKey);

	/**
	* Returns the number of cte change entries where resourcePrimKey = &#63;.
	*
	* @param resourcePrimKey the resource prim key
	* @return the number of matching cte change entries
	*/
	public int countByResourcePrimKey(long resourcePrimKey);

	/**
	* Caches the cte change entry in the entity cache if it is enabled.
	*
	* @param cteChangeEntry the cte change entry
	*/
	public void cacheResult(CTEChangeEntry cteChangeEntry);

	/**
	* Caches the cte change entries in the entity cache if it is enabled.
	*
	* @param cteChangeEntries the cte change entries
	*/
	public void cacheResult(java.util.List<CTEChangeEntry> cteChangeEntries);

	/**
	* Creates a new cte change entry with the primary key. Does not add the cte change entry to the database.
	*
	* @param cteChangeEntryId the primary key for the new cte change entry
	* @return the new cte change entry
	*/
	public CTEChangeEntry create(long cteChangeEntryId);

	/**
	* Removes the cte change entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cteChangeEntryId the primary key of the cte change entry
	* @return the cte change entry that was removed
	* @throws NoSuchCTEChangeEntryException if a cte change entry with the primary key could not be found
	*/
	public CTEChangeEntry remove(long cteChangeEntryId)
		throws NoSuchCTEChangeEntryException;

	public CTEChangeEntry updateImpl(CTEChangeEntry cteChangeEntry);

	/**
	* Returns the cte change entry with the primary key or throws a {@link NoSuchCTEChangeEntryException} if it could not be found.
	*
	* @param cteChangeEntryId the primary key of the cte change entry
	* @return the cte change entry
	* @throws NoSuchCTEChangeEntryException if a cte change entry with the primary key could not be found
	*/
	public CTEChangeEntry findByPrimaryKey(long cteChangeEntryId)
		throws NoSuchCTEChangeEntryException;

	/**
	* Returns the cte change entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param cteChangeEntryId the primary key of the cte change entry
	* @return the cte change entry, or <code>null</code> if a cte change entry with the primary key could not be found
	*/
	public CTEChangeEntry fetchByPrimaryKey(long cteChangeEntryId);

	@Override
	public java.util.Map<java.io.Serializable, CTEChangeEntry> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the cte change entries.
	*
	* @return the cte change entries
	*/
	public java.util.List<CTEChangeEntry> findAll();

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
	public java.util.List<CTEChangeEntry> findAll(int start, int end);

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
	public java.util.List<CTEChangeEntry> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CTEChangeEntry> orderByComparator);

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
	public java.util.List<CTEChangeEntry> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CTEChangeEntry> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the cte change entries from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of cte change entries.
	*
	* @return the number of cte change entries
	*/
	public int countAll();

	/**
	* Returns the primaryKeys of cte change collections associated with the cte change entry.
	*
	* @param pk the primary key of the cte change entry
	* @return long[] of the primaryKeys of cte change collections associated with the cte change entry
	*/
	public long[] getCTEChangeCollectionPrimaryKeys(long pk);

	/**
	* Returns all the cte change collections associated with the cte change entry.
	*
	* @param pk the primary key of the cte change entry
	* @return the cte change collections associated with the cte change entry
	*/
	public java.util.List<com.liferay.change.tracking.engine.model.CTEChangeCollection> getCTEChangeCollections(
		long pk);

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
	public java.util.List<com.liferay.change.tracking.engine.model.CTEChangeCollection> getCTEChangeCollections(
		long pk, int start, int end);

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
	public java.util.List<com.liferay.change.tracking.engine.model.CTEChangeCollection> getCTEChangeCollections(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.change.tracking.engine.model.CTEChangeCollection> orderByComparator);

	/**
	* Returns the number of cte change collections associated with the cte change entry.
	*
	* @param pk the primary key of the cte change entry
	* @return the number of cte change collections associated with the cte change entry
	*/
	public int getCTEChangeCollectionsSize(long pk);

	/**
	* Returns <code>true</code> if the cte change collection is associated with the cte change entry.
	*
	* @param pk the primary key of the cte change entry
	* @param cteChangeCollectionPK the primary key of the cte change collection
	* @return <code>true</code> if the cte change collection is associated with the cte change entry; <code>false</code> otherwise
	*/
	public boolean containsCTEChangeCollection(long pk,
		long cteChangeCollectionPK);

	/**
	* Returns <code>true</code> if the cte change entry has any cte change collections associated with it.
	*
	* @param pk the primary key of the cte change entry to check for associations with cte change collections
	* @return <code>true</code> if the cte change entry has any cte change collections associated with it; <code>false</code> otherwise
	*/
	public boolean containsCTEChangeCollections(long pk);

	/**
	* Adds an association between the cte change entry and the cte change collection. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change entry
	* @param cteChangeCollectionPK the primary key of the cte change collection
	*/
	public void addCTEChangeCollection(long pk, long cteChangeCollectionPK);

	/**
	* Adds an association between the cte change entry and the cte change collection. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change entry
	* @param cteChangeCollection the cte change collection
	*/
	public void addCTEChangeCollection(long pk,
		com.liferay.change.tracking.engine.model.CTEChangeCollection cteChangeCollection);

	/**
	* Adds an association between the cte change entry and the cte change collections. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change entry
	* @param cteChangeCollectionPKs the primary keys of the cte change collections
	*/
	public void addCTEChangeCollections(long pk, long[] cteChangeCollectionPKs);

	/**
	* Adds an association between the cte change entry and the cte change collections. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change entry
	* @param cteChangeCollections the cte change collections
	*/
	public void addCTEChangeCollections(long pk,
		java.util.List<com.liferay.change.tracking.engine.model.CTEChangeCollection> cteChangeCollections);

	/**
	* Clears all associations between the cte change entry and its cte change collections. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change entry to clear the associated cte change collections from
	*/
	public void clearCTEChangeCollections(long pk);

	/**
	* Removes the association between the cte change entry and the cte change collection. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change entry
	* @param cteChangeCollectionPK the primary key of the cte change collection
	*/
	public void removeCTEChangeCollection(long pk, long cteChangeCollectionPK);

	/**
	* Removes the association between the cte change entry and the cte change collection. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change entry
	* @param cteChangeCollection the cte change collection
	*/
	public void removeCTEChangeCollection(long pk,
		com.liferay.change.tracking.engine.model.CTEChangeCollection cteChangeCollection);

	/**
	* Removes the association between the cte change entry and the cte change collections. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change entry
	* @param cteChangeCollectionPKs the primary keys of the cte change collections
	*/
	public void removeCTEChangeCollections(long pk,
		long[] cteChangeCollectionPKs);

	/**
	* Removes the association between the cte change entry and the cte change collections. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change entry
	* @param cteChangeCollections the cte change collections
	*/
	public void removeCTEChangeCollections(long pk,
		java.util.List<com.liferay.change.tracking.engine.model.CTEChangeCollection> cteChangeCollections);

	/**
	* Sets the cte change collections associated with the cte change entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change entry
	* @param cteChangeCollectionPKs the primary keys of the cte change collections to be associated with the cte change entry
	*/
	public void setCTEChangeCollections(long pk, long[] cteChangeCollectionPKs);

	/**
	* Sets the cte change collections associated with the cte change entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change entry
	* @param cteChangeCollections the cte change collections to be associated with the cte change entry
	*/
	public void setCTEChangeCollections(long pk,
		java.util.List<com.liferay.change.tracking.engine.model.CTEChangeCollection> cteChangeCollections);
}