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

import com.liferay.change.tracking.engine.exception.NoSuchCTEChangeCollectionException;
import com.liferay.change.tracking.engine.model.CTEChangeCollection;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the cte change collection service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.change.tracking.engine.service.persistence.impl.CTEChangeCollectionPersistenceImpl
 * @see CTEChangeCollectionUtil
 * @generated
 */
@ProviderType
public interface CTEChangeCollectionPersistence extends BasePersistence<CTEChangeCollection> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CTEChangeCollectionUtil} to access the cte change collection persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the cte change collection in the entity cache if it is enabled.
	*
	* @param cteChangeCollection the cte change collection
	*/
	public void cacheResult(CTEChangeCollection cteChangeCollection);

	/**
	* Caches the cte change collections in the entity cache if it is enabled.
	*
	* @param cteChangeCollections the cte change collections
	*/
	public void cacheResult(
		java.util.List<CTEChangeCollection> cteChangeCollections);

	/**
	* Creates a new cte change collection with the primary key. Does not add the cte change collection to the database.
	*
	* @param cteChangeCollectionId the primary key for the new cte change collection
	* @return the new cte change collection
	*/
	public CTEChangeCollection create(long cteChangeCollectionId);

	/**
	* Removes the cte change collection with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cteChangeCollectionId the primary key of the cte change collection
	* @return the cte change collection that was removed
	* @throws NoSuchCTEChangeCollectionException if a cte change collection with the primary key could not be found
	*/
	public CTEChangeCollection remove(long cteChangeCollectionId)
		throws NoSuchCTEChangeCollectionException;

	public CTEChangeCollection updateImpl(
		CTEChangeCollection cteChangeCollection);

	/**
	* Returns the cte change collection with the primary key or throws a {@link NoSuchCTEChangeCollectionException} if it could not be found.
	*
	* @param cteChangeCollectionId the primary key of the cte change collection
	* @return the cte change collection
	* @throws NoSuchCTEChangeCollectionException if a cte change collection with the primary key could not be found
	*/
	public CTEChangeCollection findByPrimaryKey(long cteChangeCollectionId)
		throws NoSuchCTEChangeCollectionException;

	/**
	* Returns the cte change collection with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param cteChangeCollectionId the primary key of the cte change collection
	* @return the cte change collection, or <code>null</code> if a cte change collection with the primary key could not be found
	*/
	public CTEChangeCollection fetchByPrimaryKey(long cteChangeCollectionId);

	@Override
	public java.util.Map<java.io.Serializable, CTEChangeCollection> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the cte change collections.
	*
	* @return the cte change collections
	*/
	public java.util.List<CTEChangeCollection> findAll();

	/**
	* Returns a range of all the cte change collections.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTEChangeCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cte change collections
	* @param end the upper bound of the range of cte change collections (not inclusive)
	* @return the range of cte change collections
	*/
	public java.util.List<CTEChangeCollection> findAll(int start, int end);

	/**
	* Returns an ordered range of all the cte change collections.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTEChangeCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cte change collections
	* @param end the upper bound of the range of cte change collections (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cte change collections
	*/
	public java.util.List<CTEChangeCollection> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CTEChangeCollection> orderByComparator);

	/**
	* Returns an ordered range of all the cte change collections.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTEChangeCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cte change collections
	* @param end the upper bound of the range of cte change collections (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of cte change collections
	*/
	public java.util.List<CTEChangeCollection> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CTEChangeCollection> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the cte change collections from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of cte change collections.
	*
	* @return the number of cte change collections
	*/
	public int countAll();

	/**
	* Returns the primaryKeys of cte change entries associated with the cte change collection.
	*
	* @param pk the primary key of the cte change collection
	* @return long[] of the primaryKeys of cte change entries associated with the cte change collection
	*/
	public long[] getCTEChangeEntryPrimaryKeys(long pk);

	/**
	* Returns all the cte change entries associated with the cte change collection.
	*
	* @param pk the primary key of the cte change collection
	* @return the cte change entries associated with the cte change collection
	*/
	public java.util.List<com.liferay.change.tracking.engine.model.CTEChangeEntry> getCTEChangeEntries(
		long pk);

	/**
	* Returns a range of all the cte change entries associated with the cte change collection.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTEChangeCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the cte change collection
	* @param start the lower bound of the range of cte change collections
	* @param end the upper bound of the range of cte change collections (not inclusive)
	* @return the range of cte change entries associated with the cte change collection
	*/
	public java.util.List<com.liferay.change.tracking.engine.model.CTEChangeEntry> getCTEChangeEntries(
		long pk, int start, int end);

	/**
	* Returns an ordered range of all the cte change entries associated with the cte change collection.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CTEChangeCollectionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pk the primary key of the cte change collection
	* @param start the lower bound of the range of cte change collections
	* @param end the upper bound of the range of cte change collections (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cte change entries associated with the cte change collection
	*/
	public java.util.List<com.liferay.change.tracking.engine.model.CTEChangeEntry> getCTEChangeEntries(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.liferay.change.tracking.engine.model.CTEChangeEntry> orderByComparator);

	/**
	* Returns the number of cte change entries associated with the cte change collection.
	*
	* @param pk the primary key of the cte change collection
	* @return the number of cte change entries associated with the cte change collection
	*/
	public int getCTEChangeEntriesSize(long pk);

	/**
	* Returns <code>true</code> if the cte change entry is associated with the cte change collection.
	*
	* @param pk the primary key of the cte change collection
	* @param cteChangeEntryPK the primary key of the cte change entry
	* @return <code>true</code> if the cte change entry is associated with the cte change collection; <code>false</code> otherwise
	*/
	public boolean containsCTEChangeEntry(long pk, long cteChangeEntryPK);

	/**
	* Returns <code>true</code> if the cte change collection has any cte change entries associated with it.
	*
	* @param pk the primary key of the cte change collection to check for associations with cte change entries
	* @return <code>true</code> if the cte change collection has any cte change entries associated with it; <code>false</code> otherwise
	*/
	public boolean containsCTEChangeEntries(long pk);

	/**
	* Adds an association between the cte change collection and the cte change entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change collection
	* @param cteChangeEntryPK the primary key of the cte change entry
	*/
	public void addCTEChangeEntry(long pk, long cteChangeEntryPK);

	/**
	* Adds an association between the cte change collection and the cte change entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change collection
	* @param cteChangeEntry the cte change entry
	*/
	public void addCTEChangeEntry(long pk,
		com.liferay.change.tracking.engine.model.CTEChangeEntry cteChangeEntry);

	/**
	* Adds an association between the cte change collection and the cte change entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change collection
	* @param cteChangeEntryPKs the primary keys of the cte change entries
	*/
	public void addCTEChangeEntries(long pk, long[] cteChangeEntryPKs);

	/**
	* Adds an association between the cte change collection and the cte change entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change collection
	* @param cteChangeEntries the cte change entries
	*/
	public void addCTEChangeEntries(long pk,
		java.util.List<com.liferay.change.tracking.engine.model.CTEChangeEntry> cteChangeEntries);

	/**
	* Clears all associations between the cte change collection and its cte change entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change collection to clear the associated cte change entries from
	*/
	public void clearCTEChangeEntries(long pk);

	/**
	* Removes the association between the cte change collection and the cte change entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change collection
	* @param cteChangeEntryPK the primary key of the cte change entry
	*/
	public void removeCTEChangeEntry(long pk, long cteChangeEntryPK);

	/**
	* Removes the association between the cte change collection and the cte change entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change collection
	* @param cteChangeEntry the cte change entry
	*/
	public void removeCTEChangeEntry(long pk,
		com.liferay.change.tracking.engine.model.CTEChangeEntry cteChangeEntry);

	/**
	* Removes the association between the cte change collection and the cte change entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change collection
	* @param cteChangeEntryPKs the primary keys of the cte change entries
	*/
	public void removeCTEChangeEntries(long pk, long[] cteChangeEntryPKs);

	/**
	* Removes the association between the cte change collection and the cte change entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change collection
	* @param cteChangeEntries the cte change entries
	*/
	public void removeCTEChangeEntries(long pk,
		java.util.List<com.liferay.change.tracking.engine.model.CTEChangeEntry> cteChangeEntries);

	/**
	* Sets the cte change entries associated with the cte change collection, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change collection
	* @param cteChangeEntryPKs the primary keys of the cte change entries to be associated with the cte change collection
	*/
	public void setCTEChangeEntries(long pk, long[] cteChangeEntryPKs);

	/**
	* Sets the cte change entries associated with the cte change collection, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change collection
	* @param cteChangeEntries the cte change entries to be associated with the cte change collection
	*/
	public void setCTEChangeEntries(long pk,
		java.util.List<com.liferay.change.tracking.engine.model.CTEChangeEntry> cteChangeEntries);
}