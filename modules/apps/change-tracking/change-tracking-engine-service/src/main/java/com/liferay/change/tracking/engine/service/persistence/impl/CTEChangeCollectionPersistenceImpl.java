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

package com.liferay.change.tracking.engine.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.change.tracking.engine.exception.NoSuchCTEChangeCollectionException;
import com.liferay.change.tracking.engine.model.CTEChangeCollection;
import com.liferay.change.tracking.engine.model.impl.CTEChangeCollectionImpl;
import com.liferay.change.tracking.engine.model.impl.CTEChangeCollectionModelImpl;
import com.liferay.change.tracking.engine.service.persistence.CTEChangeCollectionPersistence;
import com.liferay.change.tracking.engine.service.persistence.CTEChangeEntryPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.service.persistence.impl.TableMapper;
import com.liferay.portal.kernel.service.persistence.impl.TableMapperFactory;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the cte change collection service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CTEChangeCollectionPersistence
 * @see com.liferay.change.tracking.engine.service.persistence.CTEChangeCollectionUtil
 * @generated
 */
@ProviderType
public class CTEChangeCollectionPersistenceImpl extends BasePersistenceImpl<CTEChangeCollection>
	implements CTEChangeCollectionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CTEChangeCollectionUtil} to access the cte change collection persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CTEChangeCollectionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CTEChangeCollectionModelImpl.ENTITY_CACHE_ENABLED,
			CTEChangeCollectionModelImpl.FINDER_CACHE_ENABLED,
			CTEChangeCollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CTEChangeCollectionModelImpl.ENTITY_CACHE_ENABLED,
			CTEChangeCollectionModelImpl.FINDER_CACHE_ENABLED,
			CTEChangeCollectionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CTEChangeCollectionModelImpl.ENTITY_CACHE_ENABLED,
			CTEChangeCollectionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public CTEChangeCollectionPersistenceImpl() {
		setModelClass(CTEChangeCollection.class);
	}

	/**
	 * Caches the cte change collection in the entity cache if it is enabled.
	 *
	 * @param cteChangeCollection the cte change collection
	 */
	@Override
	public void cacheResult(CTEChangeCollection cteChangeCollection) {
		entityCache.putResult(CTEChangeCollectionModelImpl.ENTITY_CACHE_ENABLED,
			CTEChangeCollectionImpl.class, cteChangeCollection.getPrimaryKey(),
			cteChangeCollection);

		cteChangeCollection.resetOriginalValues();
	}

	/**
	 * Caches the cte change collections in the entity cache if it is enabled.
	 *
	 * @param cteChangeCollections the cte change collections
	 */
	@Override
	public void cacheResult(List<CTEChangeCollection> cteChangeCollections) {
		for (CTEChangeCollection cteChangeCollection : cteChangeCollections) {
			if (entityCache.getResult(
						CTEChangeCollectionModelImpl.ENTITY_CACHE_ENABLED,
						CTEChangeCollectionImpl.class,
						cteChangeCollection.getPrimaryKey()) == null) {
				cacheResult(cteChangeCollection);
			}
			else {
				cteChangeCollection.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cte change collections.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CTEChangeCollectionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cte change collection.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CTEChangeCollection cteChangeCollection) {
		entityCache.removeResult(CTEChangeCollectionModelImpl.ENTITY_CACHE_ENABLED,
			CTEChangeCollectionImpl.class, cteChangeCollection.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CTEChangeCollection> cteChangeCollections) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CTEChangeCollection cteChangeCollection : cteChangeCollections) {
			entityCache.removeResult(CTEChangeCollectionModelImpl.ENTITY_CACHE_ENABLED,
				CTEChangeCollectionImpl.class,
				cteChangeCollection.getPrimaryKey());
		}
	}

	/**
	 * Creates a new cte change collection with the primary key. Does not add the cte change collection to the database.
	 *
	 * @param cteChangeCollectionId the primary key for the new cte change collection
	 * @return the new cte change collection
	 */
	@Override
	public CTEChangeCollection create(long cteChangeCollectionId) {
		CTEChangeCollection cteChangeCollection = new CTEChangeCollectionImpl();

		cteChangeCollection.setNew(true);
		cteChangeCollection.setPrimaryKey(cteChangeCollectionId);

		cteChangeCollection.setCompanyId(companyProvider.getCompanyId());

		return cteChangeCollection;
	}

	/**
	 * Removes the cte change collection with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cteChangeCollectionId the primary key of the cte change collection
	 * @return the cte change collection that was removed
	 * @throws NoSuchCTEChangeCollectionException if a cte change collection with the primary key could not be found
	 */
	@Override
	public CTEChangeCollection remove(long cteChangeCollectionId)
		throws NoSuchCTEChangeCollectionException {
		return remove((Serializable)cteChangeCollectionId);
	}

	/**
	 * Removes the cte change collection with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cte change collection
	 * @return the cte change collection that was removed
	 * @throws NoSuchCTEChangeCollectionException if a cte change collection with the primary key could not be found
	 */
	@Override
	public CTEChangeCollection remove(Serializable primaryKey)
		throws NoSuchCTEChangeCollectionException {
		Session session = null;

		try {
			session = openSession();

			CTEChangeCollection cteChangeCollection = (CTEChangeCollection)session.get(CTEChangeCollectionImpl.class,
					primaryKey);

			if (cteChangeCollection == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCTEChangeCollectionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(cteChangeCollection);
		}
		catch (NoSuchCTEChangeCollectionException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected CTEChangeCollection removeImpl(
		CTEChangeCollection cteChangeCollection) {
		cteChangeCollectionToCTEChangeEntryTableMapper.deleteLeftPrimaryKeyTableMappings(cteChangeCollection.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cteChangeCollection)) {
				cteChangeCollection = (CTEChangeCollection)session.get(CTEChangeCollectionImpl.class,
						cteChangeCollection.getPrimaryKeyObj());
			}

			if (cteChangeCollection != null) {
				session.delete(cteChangeCollection);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (cteChangeCollection != null) {
			clearCache(cteChangeCollection);
		}

		return cteChangeCollection;
	}

	@Override
	public CTEChangeCollection updateImpl(
		CTEChangeCollection cteChangeCollection) {
		boolean isNew = cteChangeCollection.isNew();

		if (!(cteChangeCollection instanceof CTEChangeCollectionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(cteChangeCollection.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(cteChangeCollection);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in cteChangeCollection proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CTEChangeCollection implementation " +
				cteChangeCollection.getClass());
		}

		CTEChangeCollectionModelImpl cteChangeCollectionModelImpl = (CTEChangeCollectionModelImpl)cteChangeCollection;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (cteChangeCollection.getCreateDate() == null)) {
			if (serviceContext == null) {
				cteChangeCollection.setCreateDate(now);
			}
			else {
				cteChangeCollection.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!cteChangeCollectionModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				cteChangeCollection.setModifiedDate(now);
			}
			else {
				cteChangeCollection.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (cteChangeCollection.isNew()) {
				session.save(cteChangeCollection);

				cteChangeCollection.setNew(false);
			}
			else {
				cteChangeCollection = (CTEChangeCollection)session.merge(cteChangeCollection);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(CTEChangeCollectionModelImpl.ENTITY_CACHE_ENABLED,
			CTEChangeCollectionImpl.class, cteChangeCollection.getPrimaryKey(),
			cteChangeCollection, false);

		cteChangeCollection.resetOriginalValues();

		return cteChangeCollection;
	}

	/**
	 * Returns the cte change collection with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the cte change collection
	 * @return the cte change collection
	 * @throws NoSuchCTEChangeCollectionException if a cte change collection with the primary key could not be found
	 */
	@Override
	public CTEChangeCollection findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCTEChangeCollectionException {
		CTEChangeCollection cteChangeCollection = fetchByPrimaryKey(primaryKey);

		if (cteChangeCollection == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCTEChangeCollectionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return cteChangeCollection;
	}

	/**
	 * Returns the cte change collection with the primary key or throws a {@link NoSuchCTEChangeCollectionException} if it could not be found.
	 *
	 * @param cteChangeCollectionId the primary key of the cte change collection
	 * @return the cte change collection
	 * @throws NoSuchCTEChangeCollectionException if a cte change collection with the primary key could not be found
	 */
	@Override
	public CTEChangeCollection findByPrimaryKey(long cteChangeCollectionId)
		throws NoSuchCTEChangeCollectionException {
		return findByPrimaryKey((Serializable)cteChangeCollectionId);
	}

	/**
	 * Returns the cte change collection with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cte change collection
	 * @return the cte change collection, or <code>null</code> if a cte change collection with the primary key could not be found
	 */
	@Override
	public CTEChangeCollection fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(CTEChangeCollectionModelImpl.ENTITY_CACHE_ENABLED,
				CTEChangeCollectionImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		CTEChangeCollection cteChangeCollection = (CTEChangeCollection)serializable;

		if (cteChangeCollection == null) {
			Session session = null;

			try {
				session = openSession();

				cteChangeCollection = (CTEChangeCollection)session.get(CTEChangeCollectionImpl.class,
						primaryKey);

				if (cteChangeCollection != null) {
					cacheResult(cteChangeCollection);
				}
				else {
					entityCache.putResult(CTEChangeCollectionModelImpl.ENTITY_CACHE_ENABLED,
						CTEChangeCollectionImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CTEChangeCollectionModelImpl.ENTITY_CACHE_ENABLED,
					CTEChangeCollectionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return cteChangeCollection;
	}

	/**
	 * Returns the cte change collection with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cteChangeCollectionId the primary key of the cte change collection
	 * @return the cte change collection, or <code>null</code> if a cte change collection with the primary key could not be found
	 */
	@Override
	public CTEChangeCollection fetchByPrimaryKey(long cteChangeCollectionId) {
		return fetchByPrimaryKey((Serializable)cteChangeCollectionId);
	}

	@Override
	public Map<Serializable, CTEChangeCollection> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CTEChangeCollection> map = new HashMap<Serializable, CTEChangeCollection>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CTEChangeCollection cteChangeCollection = fetchByPrimaryKey(primaryKey);

			if (cteChangeCollection != null) {
				map.put(primaryKey, cteChangeCollection);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(CTEChangeCollectionModelImpl.ENTITY_CACHE_ENABLED,
					CTEChangeCollectionImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (CTEChangeCollection)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CTECHANGECOLLECTION_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (CTEChangeCollection cteChangeCollection : (List<CTEChangeCollection>)q.list()) {
				map.put(cteChangeCollection.getPrimaryKeyObj(),
					cteChangeCollection);

				cacheResult(cteChangeCollection);

				uncachedPrimaryKeys.remove(cteChangeCollection.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CTEChangeCollectionModelImpl.ENTITY_CACHE_ENABLED,
					CTEChangeCollectionImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the cte change collections.
	 *
	 * @return the cte change collections
	 */
	@Override
	public List<CTEChangeCollection> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CTEChangeCollection> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<CTEChangeCollection> findAll(int start, int end,
		OrderByComparator<CTEChangeCollection> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<CTEChangeCollection> findAll(int start, int end,
		OrderByComparator<CTEChangeCollection> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<CTEChangeCollection> list = null;

		if (retrieveFromCache) {
			list = (List<CTEChangeCollection>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CTECHANGECOLLECTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CTECHANGECOLLECTION;

				if (pagination) {
					sql = sql.concat(CTEChangeCollectionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CTEChangeCollection>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CTEChangeCollection>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the cte change collections from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CTEChangeCollection cteChangeCollection : findAll()) {
			remove(cteChangeCollection);
		}
	}

	/**
	 * Returns the number of cte change collections.
	 *
	 * @return the number of cte change collections
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CTECHANGECOLLECTION);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the primaryKeys of cte change entries associated with the cte change collection.
	 *
	 * @param pk the primary key of the cte change collection
	 * @return long[] of the primaryKeys of cte change entries associated with the cte change collection
	 */
	@Override
	public long[] getCTEChangeEntryPrimaryKeys(long pk) {
		long[] pks = cteChangeCollectionToCTEChangeEntryTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the cte change entries associated with the cte change collection.
	 *
	 * @param pk the primary key of the cte change collection
	 * @return the cte change entries associated with the cte change collection
	 */
	@Override
	public List<com.liferay.change.tracking.engine.model.CTEChangeEntry> getCTEChangeEntries(
		long pk) {
		return getCTEChangeEntries(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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
	@Override
	public List<com.liferay.change.tracking.engine.model.CTEChangeEntry> getCTEChangeEntries(
		long pk, int start, int end) {
		return getCTEChangeEntries(pk, start, end, null);
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
	@Override
	public List<com.liferay.change.tracking.engine.model.CTEChangeEntry> getCTEChangeEntries(
		long pk, int start, int end,
		OrderByComparator<com.liferay.change.tracking.engine.model.CTEChangeEntry> orderByComparator) {
		return cteChangeCollectionToCTEChangeEntryTableMapper.getRightBaseModels(pk,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of cte change entries associated with the cte change collection.
	 *
	 * @param pk the primary key of the cte change collection
	 * @return the number of cte change entries associated with the cte change collection
	 */
	@Override
	public int getCTEChangeEntriesSize(long pk) {
		long[] pks = cteChangeCollectionToCTEChangeEntryTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the cte change entry is associated with the cte change collection.
	 *
	 * @param pk the primary key of the cte change collection
	 * @param cteChangeEntryPK the primary key of the cte change entry
	 * @return <code>true</code> if the cte change entry is associated with the cte change collection; <code>false</code> otherwise
	 */
	@Override
	public boolean containsCTEChangeEntry(long pk, long cteChangeEntryPK) {
		return cteChangeCollectionToCTEChangeEntryTableMapper.containsTableMapping(pk,
			cteChangeEntryPK);
	}

	/**
	 * Returns <code>true</code> if the cte change collection has any cte change entries associated with it.
	 *
	 * @param pk the primary key of the cte change collection to check for associations with cte change entries
	 * @return <code>true</code> if the cte change collection has any cte change entries associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsCTEChangeEntries(long pk) {
		if (getCTEChangeEntriesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the cte change collection and the cte change entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the cte change collection
	 * @param cteChangeEntryPK the primary key of the cte change entry
	 */
	@Override
	public void addCTEChangeEntry(long pk, long cteChangeEntryPK) {
		CTEChangeCollection cteChangeCollection = fetchByPrimaryKey(pk);

		if (cteChangeCollection == null) {
			cteChangeCollectionToCTEChangeEntryTableMapper.addTableMapping(companyProvider.getCompanyId(),
				pk, cteChangeEntryPK);
		}
		else {
			cteChangeCollectionToCTEChangeEntryTableMapper.addTableMapping(cteChangeCollection.getCompanyId(),
				pk, cteChangeEntryPK);
		}
	}

	/**
	 * Adds an association between the cte change collection and the cte change entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the cte change collection
	 * @param cteChangeEntry the cte change entry
	 */
	@Override
	public void addCTEChangeEntry(long pk,
		com.liferay.change.tracking.engine.model.CTEChangeEntry cteChangeEntry) {
		CTEChangeCollection cteChangeCollection = fetchByPrimaryKey(pk);

		if (cteChangeCollection == null) {
			cteChangeCollectionToCTEChangeEntryTableMapper.addTableMapping(companyProvider.getCompanyId(),
				pk, cteChangeEntry.getPrimaryKey());
		}
		else {
			cteChangeCollectionToCTEChangeEntryTableMapper.addTableMapping(cteChangeCollection.getCompanyId(),
				pk, cteChangeEntry.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the cte change collection and the cte change entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the cte change collection
	 * @param cteChangeEntryPKs the primary keys of the cte change entries
	 */
	@Override
	public void addCTEChangeEntries(long pk, long[] cteChangeEntryPKs) {
		long companyId = 0;

		CTEChangeCollection cteChangeCollection = fetchByPrimaryKey(pk);

		if (cteChangeCollection == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = cteChangeCollection.getCompanyId();
		}

		cteChangeCollectionToCTEChangeEntryTableMapper.addTableMappings(companyId,
			pk, cteChangeEntryPKs);
	}

	/**
	 * Adds an association between the cte change collection and the cte change entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the cte change collection
	 * @param cteChangeEntries the cte change entries
	 */
	@Override
	public void addCTEChangeEntries(long pk,
		List<com.liferay.change.tracking.engine.model.CTEChangeEntry> cteChangeEntries) {
		addCTEChangeEntries(pk,
			ListUtil.toLongArray(cteChangeEntries,
				com.liferay.change.tracking.engine.model.CTEChangeEntry.CTE_CHANGE_ENTRY_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the cte change collection and its cte change entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the cte change collection to clear the associated cte change entries from
	 */
	@Override
	public void clearCTEChangeEntries(long pk) {
		cteChangeCollectionToCTEChangeEntryTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the cte change collection and the cte change entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the cte change collection
	 * @param cteChangeEntryPK the primary key of the cte change entry
	 */
	@Override
	public void removeCTEChangeEntry(long pk, long cteChangeEntryPK) {
		cteChangeCollectionToCTEChangeEntryTableMapper.deleteTableMapping(pk,
			cteChangeEntryPK);
	}

	/**
	 * Removes the association between the cte change collection and the cte change entry. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the cte change collection
	 * @param cteChangeEntry the cte change entry
	 */
	@Override
	public void removeCTEChangeEntry(long pk,
		com.liferay.change.tracking.engine.model.CTEChangeEntry cteChangeEntry) {
		cteChangeCollectionToCTEChangeEntryTableMapper.deleteTableMapping(pk,
			cteChangeEntry.getPrimaryKey());
	}

	/**
	 * Removes the association between the cte change collection and the cte change entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the cte change collection
	 * @param cteChangeEntryPKs the primary keys of the cte change entries
	 */
	@Override
	public void removeCTEChangeEntries(long pk, long[] cteChangeEntryPKs) {
		cteChangeCollectionToCTEChangeEntryTableMapper.deleteTableMappings(pk,
			cteChangeEntryPKs);
	}

	/**
	 * Removes the association between the cte change collection and the cte change entries. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the cte change collection
	 * @param cteChangeEntries the cte change entries
	 */
	@Override
	public void removeCTEChangeEntries(long pk,
		List<com.liferay.change.tracking.engine.model.CTEChangeEntry> cteChangeEntries) {
		removeCTEChangeEntries(pk,
			ListUtil.toLongArray(cteChangeEntries,
				com.liferay.change.tracking.engine.model.CTEChangeEntry.CTE_CHANGE_ENTRY_ID_ACCESSOR));
	}

	/**
	 * Sets the cte change entries associated with the cte change collection, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the cte change collection
	 * @param cteChangeEntryPKs the primary keys of the cte change entries to be associated with the cte change collection
	 */
	@Override
	public void setCTEChangeEntries(long pk, long[] cteChangeEntryPKs) {
		Set<Long> newCTEChangeEntryPKsSet = SetUtil.fromArray(cteChangeEntryPKs);
		Set<Long> oldCTEChangeEntryPKsSet = SetUtil.fromArray(cteChangeCollectionToCTEChangeEntryTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeCTEChangeEntryPKsSet = new HashSet<Long>(oldCTEChangeEntryPKsSet);

		removeCTEChangeEntryPKsSet.removeAll(newCTEChangeEntryPKsSet);

		cteChangeCollectionToCTEChangeEntryTableMapper.deleteTableMappings(pk,
			ArrayUtil.toLongArray(removeCTEChangeEntryPKsSet));

		newCTEChangeEntryPKsSet.removeAll(oldCTEChangeEntryPKsSet);

		long companyId = 0;

		CTEChangeCollection cteChangeCollection = fetchByPrimaryKey(pk);

		if (cteChangeCollection == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = cteChangeCollection.getCompanyId();
		}

		cteChangeCollectionToCTEChangeEntryTableMapper.addTableMappings(companyId,
			pk, ArrayUtil.toLongArray(newCTEChangeEntryPKsSet));
	}

	/**
	 * Sets the cte change entries associated with the cte change collection, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the cte change collection
	 * @param cteChangeEntries the cte change entries to be associated with the cte change collection
	 */
	@Override
	public void setCTEChangeEntries(long pk,
		List<com.liferay.change.tracking.engine.model.CTEChangeEntry> cteChangeEntries) {
		try {
			long[] cteChangeEntryPKs = new long[cteChangeEntries.size()];

			for (int i = 0; i < cteChangeEntries.size(); i++) {
				com.liferay.change.tracking.engine.model.CTEChangeEntry cteChangeEntry =
					cteChangeEntries.get(i);

				cteChangeEntryPKs[i] = cteChangeEntry.getPrimaryKey();
			}

			setCTEChangeEntries(pk, cteChangeEntryPKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CTEChangeCollectionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cte change collection persistence.
	 */
	public void afterPropertiesSet() {
		cteChangeCollectionToCTEChangeEntryTableMapper = TableMapperFactory.getTableMapper("Collections_Entries",
				"companyId", "cteChangeCollectionId", "cteChangeEntryId", this,
				cteChangeEntryPersistence);
	}

	public void destroy() {
		entityCache.removeCache(CTEChangeCollectionImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		TableMapperFactory.removeTableMapper("Collections_Entries");
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	@BeanReference(type = CTEChangeEntryPersistence.class)
	protected CTEChangeEntryPersistence cteChangeEntryPersistence;
	protected TableMapper<CTEChangeCollection, com.liferay.change.tracking.engine.model.CTEChangeEntry> cteChangeCollectionToCTEChangeEntryTableMapper;
	private static final String _SQL_SELECT_CTECHANGECOLLECTION = "SELECT cteChangeCollection FROM CTEChangeCollection cteChangeCollection";
	private static final String _SQL_SELECT_CTECHANGECOLLECTION_WHERE_PKS_IN = "SELECT cteChangeCollection FROM CTEChangeCollection cteChangeCollection WHERE cteChangeCollectionId IN (";
	private static final String _SQL_COUNT_CTECHANGECOLLECTION = "SELECT COUNT(cteChangeCollection) FROM CTEChangeCollection cteChangeCollection";
	private static final String _ORDER_BY_ENTITY_ALIAS = "cteChangeCollection.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CTEChangeCollection exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(CTEChangeCollectionPersistenceImpl.class);
}