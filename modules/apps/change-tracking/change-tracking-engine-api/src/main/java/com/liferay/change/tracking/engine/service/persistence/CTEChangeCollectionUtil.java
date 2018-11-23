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

import com.liferay.change.tracking.engine.model.CTEChangeCollection;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the cte change collection service. This utility wraps {@link com.liferay.change.tracking.engine.service.persistence.impl.CTEChangeCollectionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CTEChangeCollectionPersistence
 * @see com.liferay.change.tracking.engine.service.persistence.impl.CTEChangeCollectionPersistenceImpl
 * @generated
 */
@ProviderType
public class CTEChangeCollectionUtil {
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
	public static void clearCache(CTEChangeCollection cteChangeCollection) {
		getPersistence().clearCache(cteChangeCollection);
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
	public static List<CTEChangeCollection> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CTEChangeCollection> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CTEChangeCollection> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CTEChangeCollection> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CTEChangeCollection update(
		CTEChangeCollection cteChangeCollection) {
		return getPersistence().update(cteChangeCollection);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CTEChangeCollection update(
		CTEChangeCollection cteChangeCollection, ServiceContext serviceContext) {
		return getPersistence().update(cteChangeCollection, serviceContext);
	}

	/**
	* Caches the cte change collection in the entity cache if it is enabled.
	*
	* @param cteChangeCollection the cte change collection
	*/
	public static void cacheResult(CTEChangeCollection cteChangeCollection) {
		getPersistence().cacheResult(cteChangeCollection);
	}

	/**
	* Caches the cte change collections in the entity cache if it is enabled.
	*
	* @param cteChangeCollections the cte change collections
	*/
	public static void cacheResult(
		List<CTEChangeCollection> cteChangeCollections) {
		getPersistence().cacheResult(cteChangeCollections);
	}

	/**
	* Creates a new cte change collection with the primary key. Does not add the cte change collection to the database.
	*
	* @param cteChangeCollectionId the primary key for the new cte change collection
	* @return the new cte change collection
	*/
	public static CTEChangeCollection create(long cteChangeCollectionId) {
		return getPersistence().create(cteChangeCollectionId);
	}

	/**
	* Removes the cte change collection with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cteChangeCollectionId the primary key of the cte change collection
	* @return the cte change collection that was removed
	* @throws NoSuchCTEChangeCollectionException if a cte change collection with the primary key could not be found
	*/
	public static CTEChangeCollection remove(long cteChangeCollectionId)
		throws com.liferay.change.tracking.engine.exception.NoSuchCTEChangeCollectionException {
		return getPersistence().remove(cteChangeCollectionId);
	}

	public static CTEChangeCollection updateImpl(
		CTEChangeCollection cteChangeCollection) {
		return getPersistence().updateImpl(cteChangeCollection);
	}

	/**
	* Returns the cte change collection with the primary key or throws a {@link NoSuchCTEChangeCollectionException} if it could not be found.
	*
	* @param cteChangeCollectionId the primary key of the cte change collection
	* @return the cte change collection
	* @throws NoSuchCTEChangeCollectionException if a cte change collection with the primary key could not be found
	*/
	public static CTEChangeCollection findByPrimaryKey(
		long cteChangeCollectionId)
		throws com.liferay.change.tracking.engine.exception.NoSuchCTEChangeCollectionException {
		return getPersistence().findByPrimaryKey(cteChangeCollectionId);
	}

	/**
	* Returns the cte change collection with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param cteChangeCollectionId the primary key of the cte change collection
	* @return the cte change collection, or <code>null</code> if a cte change collection with the primary key could not be found
	*/
	public static CTEChangeCollection fetchByPrimaryKey(
		long cteChangeCollectionId) {
		return getPersistence().fetchByPrimaryKey(cteChangeCollectionId);
	}

	public static java.util.Map<java.io.Serializable, CTEChangeCollection> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the cte change collections.
	*
	* @return the cte change collections
	*/
	public static List<CTEChangeCollection> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<CTEChangeCollection> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<CTEChangeCollection> findAll(int start, int end,
		OrderByComparator<CTEChangeCollection> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<CTEChangeCollection> findAll(int start, int end,
		OrderByComparator<CTEChangeCollection> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the cte change collections from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of cte change collections.
	*
	* @return the number of cte change collections
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	* Returns the primaryKeys of cte change entries associated with the cte change collection.
	*
	* @param pk the primary key of the cte change collection
	* @return long[] of the primaryKeys of cte change entries associated with the cte change collection
	*/
	public static long[] getCTEChangeEntryPrimaryKeys(long pk) {
		return getPersistence().getCTEChangeEntryPrimaryKeys(pk);
	}

	/**
	* Returns all the cte change entries associated with the cte change collection.
	*
	* @param pk the primary key of the cte change collection
	* @return the cte change entries associated with the cte change collection
	*/
	public static List<com.liferay.change.tracking.engine.model.CTEChangeEntry> getCTEChangeEntries(
		long pk) {
		return getPersistence().getCTEChangeEntries(pk);
	}

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
	public static List<com.liferay.change.tracking.engine.model.CTEChangeEntry> getCTEChangeEntries(
		long pk, int start, int end) {
		return getPersistence().getCTEChangeEntries(pk, start, end);
	}

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
	public static List<com.liferay.change.tracking.engine.model.CTEChangeEntry> getCTEChangeEntries(
		long pk, int start, int end,
		OrderByComparator<com.liferay.change.tracking.engine.model.CTEChangeEntry> orderByComparator) {
		return getPersistence()
				   .getCTEChangeEntries(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of cte change entries associated with the cte change collection.
	*
	* @param pk the primary key of the cte change collection
	* @return the number of cte change entries associated with the cte change collection
	*/
	public static int getCTEChangeEntriesSize(long pk) {
		return getPersistence().getCTEChangeEntriesSize(pk);
	}

	/**
	* Returns <code>true</code> if the cte change entry is associated with the cte change collection.
	*
	* @param pk the primary key of the cte change collection
	* @param cteChangeEntryPK the primary key of the cte change entry
	* @return <code>true</code> if the cte change entry is associated with the cte change collection; <code>false</code> otherwise
	*/
	public static boolean containsCTEChangeEntry(long pk, long cteChangeEntryPK) {
		return getPersistence().containsCTEChangeEntry(pk, cteChangeEntryPK);
	}

	/**
	* Returns <code>true</code> if the cte change collection has any cte change entries associated with it.
	*
	* @param pk the primary key of the cte change collection to check for associations with cte change entries
	* @return <code>true</code> if the cte change collection has any cte change entries associated with it; <code>false</code> otherwise
	*/
	public static boolean containsCTEChangeEntries(long pk) {
		return getPersistence().containsCTEChangeEntries(pk);
	}

	/**
	* Adds an association between the cte change collection and the cte change entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change collection
	* @param cteChangeEntryPK the primary key of the cte change entry
	*/
	public static void addCTEChangeEntry(long pk, long cteChangeEntryPK) {
		getPersistence().addCTEChangeEntry(pk, cteChangeEntryPK);
	}

	/**
	* Adds an association between the cte change collection and the cte change entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change collection
	* @param cteChangeEntry the cte change entry
	*/
	public static void addCTEChangeEntry(long pk,
		com.liferay.change.tracking.engine.model.CTEChangeEntry cteChangeEntry) {
		getPersistence().addCTEChangeEntry(pk, cteChangeEntry);
	}

	/**
	* Adds an association between the cte change collection and the cte change entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change collection
	* @param cteChangeEntryPKs the primary keys of the cte change entries
	*/
	public static void addCTEChangeEntries(long pk, long[] cteChangeEntryPKs) {
		getPersistence().addCTEChangeEntries(pk, cteChangeEntryPKs);
	}

	/**
	* Adds an association between the cte change collection and the cte change entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change collection
	* @param cteChangeEntries the cte change entries
	*/
	public static void addCTEChangeEntries(long pk,
		List<com.liferay.change.tracking.engine.model.CTEChangeEntry> cteChangeEntries) {
		getPersistence().addCTEChangeEntries(pk, cteChangeEntries);
	}

	/**
	* Clears all associations between the cte change collection and its cte change entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change collection to clear the associated cte change entries from
	*/
	public static void clearCTEChangeEntries(long pk) {
		getPersistence().clearCTEChangeEntries(pk);
	}

	/**
	* Removes the association between the cte change collection and the cte change entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change collection
	* @param cteChangeEntryPK the primary key of the cte change entry
	*/
	public static void removeCTEChangeEntry(long pk, long cteChangeEntryPK) {
		getPersistence().removeCTEChangeEntry(pk, cteChangeEntryPK);
	}

	/**
	* Removes the association between the cte change collection and the cte change entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change collection
	* @param cteChangeEntry the cte change entry
	*/
	public static void removeCTEChangeEntry(long pk,
		com.liferay.change.tracking.engine.model.CTEChangeEntry cteChangeEntry) {
		getPersistence().removeCTEChangeEntry(pk, cteChangeEntry);
	}

	/**
	* Removes the association between the cte change collection and the cte change entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change collection
	* @param cteChangeEntryPKs the primary keys of the cte change entries
	*/
	public static void removeCTEChangeEntries(long pk, long[] cteChangeEntryPKs) {
		getPersistence().removeCTEChangeEntries(pk, cteChangeEntryPKs);
	}

	/**
	* Removes the association between the cte change collection and the cte change entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change collection
	* @param cteChangeEntries the cte change entries
	*/
	public static void removeCTEChangeEntries(long pk,
		List<com.liferay.change.tracking.engine.model.CTEChangeEntry> cteChangeEntries) {
		getPersistence().removeCTEChangeEntries(pk, cteChangeEntries);
	}

	/**
	* Sets the cte change entries associated with the cte change collection, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change collection
	* @param cteChangeEntryPKs the primary keys of the cte change entries to be associated with the cte change collection
	*/
	public static void setCTEChangeEntries(long pk, long[] cteChangeEntryPKs) {
		getPersistence().setCTEChangeEntries(pk, cteChangeEntryPKs);
	}

	/**
	* Sets the cte change entries associated with the cte change collection, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	*
	* @param pk the primary key of the cte change collection
	* @param cteChangeEntries the cte change entries to be associated with the cte change collection
	*/
	public static void setCTEChangeEntries(long pk,
		List<com.liferay.change.tracking.engine.model.CTEChangeEntry> cteChangeEntries) {
		getPersistence().setCTEChangeEntries(pk, cteChangeEntries);
	}

	public static CTEChangeCollectionPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CTEChangeCollectionPersistence, CTEChangeCollectionPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CTEChangeCollectionPersistence.class);

		ServiceTracker<CTEChangeCollectionPersistence, CTEChangeCollectionPersistence> serviceTracker =
			new ServiceTracker<CTEChangeCollectionPersistence, CTEChangeCollectionPersistence>(bundle.getBundleContext(),
				CTEChangeCollectionPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}