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

import com.liferay.change.tracking.engine.exception.NoSuchCTEChangeEntryException;
import com.liferay.change.tracking.engine.model.CTEChangeEntry;
import com.liferay.change.tracking.engine.model.impl.CTEChangeEntryImpl;
import com.liferay.change.tracking.engine.model.impl.CTEChangeEntryModelImpl;
import com.liferay.change.tracking.engine.service.persistence.CTEChangeCollectionPersistence;
import com.liferay.change.tracking.engine.service.persistence.CTEChangeEntryPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
 * The persistence implementation for the cte change entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CTEChangeEntryPersistence
 * @see com.liferay.change.tracking.engine.service.persistence.CTEChangeEntryUtil
 * @generated
 */
@ProviderType
public class CTEChangeEntryPersistenceImpl extends BasePersistenceImpl<CTEChangeEntry>
	implements CTEChangeEntryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CTEChangeEntryUtil} to access the cte change entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CTEChangeEntryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CTEChangeEntryModelImpl.ENTITY_CACHE_ENABLED,
			CTEChangeEntryModelImpl.FINDER_CACHE_ENABLED,
			CTEChangeEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CTEChangeEntryModelImpl.ENTITY_CACHE_ENABLED,
			CTEChangeEntryModelImpl.FINDER_CACHE_ENABLED,
			CTEChangeEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CTEChangeEntryModelImpl.ENTITY_CACHE_ENABLED,
			CTEChangeEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RESOURCEPRIMKEY =
		new FinderPath(CTEChangeEntryModelImpl.ENTITY_CACHE_ENABLED,
			CTEChangeEntryModelImpl.FINDER_CACHE_ENABLED,
			CTEChangeEntryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByResourcePrimKey",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESOURCEPRIMKEY =
		new FinderPath(CTEChangeEntryModelImpl.ENTITY_CACHE_ENABLED,
			CTEChangeEntryModelImpl.FINDER_CACHE_ENABLED,
			CTEChangeEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByResourcePrimKey",
			new String[] { Long.class.getName() },
			CTEChangeEntryModelImpl.RESOURCEPRIMKEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RESOURCEPRIMKEY = new FinderPath(CTEChangeEntryModelImpl.ENTITY_CACHE_ENABLED,
			CTEChangeEntryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByResourcePrimKey", new String[] { Long.class.getName() });

	/**
	 * Returns all the cte change entries where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the matching cte change entries
	 */
	@Override
	public List<CTEChangeEntry> findByResourcePrimKey(long resourcePrimKey) {
		return findByResourcePrimKey(resourcePrimKey, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<CTEChangeEntry> findByResourcePrimKey(long resourcePrimKey,
		int start, int end) {
		return findByResourcePrimKey(resourcePrimKey, start, end, null);
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
	@Override
	public List<CTEChangeEntry> findByResourcePrimKey(long resourcePrimKey,
		int start, int end, OrderByComparator<CTEChangeEntry> orderByComparator) {
		return findByResourcePrimKey(resourcePrimKey, start, end,
			orderByComparator, true);
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
	@Override
	public List<CTEChangeEntry> findByResourcePrimKey(long resourcePrimKey,
		int start, int end,
		OrderByComparator<CTEChangeEntry> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESOURCEPRIMKEY;
			finderArgs = new Object[] { resourcePrimKey };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RESOURCEPRIMKEY;
			finderArgs = new Object[] {
					resourcePrimKey,
					
					start, end, orderByComparator
				};
		}

		List<CTEChangeEntry> list = null;

		if (retrieveFromCache) {
			list = (List<CTEChangeEntry>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CTEChangeEntry cteChangeEntry : list) {
					if ((resourcePrimKey != cteChangeEntry.getResourcePrimKey())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CTECHANGEENTRY_WHERE);

			query.append(_FINDER_COLUMN_RESOURCEPRIMKEY_RESOURCEPRIMKEY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CTEChangeEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(resourcePrimKey);

				if (!pagination) {
					list = (List<CTEChangeEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CTEChangeEntry>)QueryUtil.list(q,
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
	 * Returns the first cte change entry in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cte change entry
	 * @throws NoSuchCTEChangeEntryException if a matching cte change entry could not be found
	 */
	@Override
	public CTEChangeEntry findByResourcePrimKey_First(long resourcePrimKey,
		OrderByComparator<CTEChangeEntry> orderByComparator)
		throws NoSuchCTEChangeEntryException {
		CTEChangeEntry cteChangeEntry = fetchByResourcePrimKey_First(resourcePrimKey,
				orderByComparator);

		if (cteChangeEntry != null) {
			return cteChangeEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("resourcePrimKey=");
		msg.append(resourcePrimKey);

		msg.append("}");

		throw new NoSuchCTEChangeEntryException(msg.toString());
	}

	/**
	 * Returns the first cte change entry in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching cte change entry, or <code>null</code> if a matching cte change entry could not be found
	 */
	@Override
	public CTEChangeEntry fetchByResourcePrimKey_First(long resourcePrimKey,
		OrderByComparator<CTEChangeEntry> orderByComparator) {
		List<CTEChangeEntry> list = findByResourcePrimKey(resourcePrimKey, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last cte change entry in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cte change entry
	 * @throws NoSuchCTEChangeEntryException if a matching cte change entry could not be found
	 */
	@Override
	public CTEChangeEntry findByResourcePrimKey_Last(long resourcePrimKey,
		OrderByComparator<CTEChangeEntry> orderByComparator)
		throws NoSuchCTEChangeEntryException {
		CTEChangeEntry cteChangeEntry = fetchByResourcePrimKey_Last(resourcePrimKey,
				orderByComparator);

		if (cteChangeEntry != null) {
			return cteChangeEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("resourcePrimKey=");
		msg.append(resourcePrimKey);

		msg.append("}");

		throw new NoSuchCTEChangeEntryException(msg.toString());
	}

	/**
	 * Returns the last cte change entry in the ordered set where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching cte change entry, or <code>null</code> if a matching cte change entry could not be found
	 */
	@Override
	public CTEChangeEntry fetchByResourcePrimKey_Last(long resourcePrimKey,
		OrderByComparator<CTEChangeEntry> orderByComparator) {
		int count = countByResourcePrimKey(resourcePrimKey);

		if (count == 0) {
			return null;
		}

		List<CTEChangeEntry> list = findByResourcePrimKey(resourcePrimKey,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CTEChangeEntry[] findByResourcePrimKey_PrevAndNext(
		long cteChangeEntryId, long resourcePrimKey,
		OrderByComparator<CTEChangeEntry> orderByComparator)
		throws NoSuchCTEChangeEntryException {
		CTEChangeEntry cteChangeEntry = findByPrimaryKey(cteChangeEntryId);

		Session session = null;

		try {
			session = openSession();

			CTEChangeEntry[] array = new CTEChangeEntryImpl[3];

			array[0] = getByResourcePrimKey_PrevAndNext(session,
					cteChangeEntry, resourcePrimKey, orderByComparator, true);

			array[1] = cteChangeEntry;

			array[2] = getByResourcePrimKey_PrevAndNext(session,
					cteChangeEntry, resourcePrimKey, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CTEChangeEntry getByResourcePrimKey_PrevAndNext(Session session,
		CTEChangeEntry cteChangeEntry, long resourcePrimKey,
		OrderByComparator<CTEChangeEntry> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CTECHANGEENTRY_WHERE);

		query.append(_FINDER_COLUMN_RESOURCEPRIMKEY_RESOURCEPRIMKEY_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CTEChangeEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(resourcePrimKey);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(cteChangeEntry);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CTEChangeEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cte change entries where resourcePrimKey = &#63; from the database.
	 *
	 * @param resourcePrimKey the resource prim key
	 */
	@Override
	public void removeByResourcePrimKey(long resourcePrimKey) {
		for (CTEChangeEntry cteChangeEntry : findByResourcePrimKey(
				resourcePrimKey, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(cteChangeEntry);
		}
	}

	/**
	 * Returns the number of cte change entries where resourcePrimKey = &#63;.
	 *
	 * @param resourcePrimKey the resource prim key
	 * @return the number of matching cte change entries
	 */
	@Override
	public int countByResourcePrimKey(long resourcePrimKey) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RESOURCEPRIMKEY;

		Object[] finderArgs = new Object[] { resourcePrimKey };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CTECHANGEENTRY_WHERE);

			query.append(_FINDER_COLUMN_RESOURCEPRIMKEY_RESOURCEPRIMKEY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(resourcePrimKey);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_RESOURCEPRIMKEY_RESOURCEPRIMKEY_2 =
		"cteChangeEntry.resourcePrimKey = ?";

	public CTEChangeEntryPersistenceImpl() {
		setModelClass(CTEChangeEntry.class);
	}

	/**
	 * Caches the cte change entry in the entity cache if it is enabled.
	 *
	 * @param cteChangeEntry the cte change entry
	 */
	@Override
	public void cacheResult(CTEChangeEntry cteChangeEntry) {
		entityCache.putResult(CTEChangeEntryModelImpl.ENTITY_CACHE_ENABLED,
			CTEChangeEntryImpl.class, cteChangeEntry.getPrimaryKey(),
			cteChangeEntry);

		cteChangeEntry.resetOriginalValues();
	}

	/**
	 * Caches the cte change entries in the entity cache if it is enabled.
	 *
	 * @param cteChangeEntries the cte change entries
	 */
	@Override
	public void cacheResult(List<CTEChangeEntry> cteChangeEntries) {
		for (CTEChangeEntry cteChangeEntry : cteChangeEntries) {
			if (entityCache.getResult(
						CTEChangeEntryModelImpl.ENTITY_CACHE_ENABLED,
						CTEChangeEntryImpl.class, cteChangeEntry.getPrimaryKey()) == null) {
				cacheResult(cteChangeEntry);
			}
			else {
				cteChangeEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cte change entries.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CTEChangeEntryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the cte change entry.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CTEChangeEntry cteChangeEntry) {
		entityCache.removeResult(CTEChangeEntryModelImpl.ENTITY_CACHE_ENABLED,
			CTEChangeEntryImpl.class, cteChangeEntry.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CTEChangeEntry> cteChangeEntries) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CTEChangeEntry cteChangeEntry : cteChangeEntries) {
			entityCache.removeResult(CTEChangeEntryModelImpl.ENTITY_CACHE_ENABLED,
				CTEChangeEntryImpl.class, cteChangeEntry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new cte change entry with the primary key. Does not add the cte change entry to the database.
	 *
	 * @param cteChangeEntryId the primary key for the new cte change entry
	 * @return the new cte change entry
	 */
	@Override
	public CTEChangeEntry create(long cteChangeEntryId) {
		CTEChangeEntry cteChangeEntry = new CTEChangeEntryImpl();

		cteChangeEntry.setNew(true);
		cteChangeEntry.setPrimaryKey(cteChangeEntryId);

		cteChangeEntry.setCompanyId(companyProvider.getCompanyId());

		return cteChangeEntry;
	}

	/**
	 * Removes the cte change entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cteChangeEntryId the primary key of the cte change entry
	 * @return the cte change entry that was removed
	 * @throws NoSuchCTEChangeEntryException if a cte change entry with the primary key could not be found
	 */
	@Override
	public CTEChangeEntry remove(long cteChangeEntryId)
		throws NoSuchCTEChangeEntryException {
		return remove((Serializable)cteChangeEntryId);
	}

	/**
	 * Removes the cte change entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the cte change entry
	 * @return the cte change entry that was removed
	 * @throws NoSuchCTEChangeEntryException if a cte change entry with the primary key could not be found
	 */
	@Override
	public CTEChangeEntry remove(Serializable primaryKey)
		throws NoSuchCTEChangeEntryException {
		Session session = null;

		try {
			session = openSession();

			CTEChangeEntry cteChangeEntry = (CTEChangeEntry)session.get(CTEChangeEntryImpl.class,
					primaryKey);

			if (cteChangeEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCTEChangeEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(cteChangeEntry);
		}
		catch (NoSuchCTEChangeEntryException nsee) {
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
	protected CTEChangeEntry removeImpl(CTEChangeEntry cteChangeEntry) {
		cteChangeEntryToCTEChangeCollectionTableMapper.deleteLeftPrimaryKeyTableMappings(cteChangeEntry.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(cteChangeEntry)) {
				cteChangeEntry = (CTEChangeEntry)session.get(CTEChangeEntryImpl.class,
						cteChangeEntry.getPrimaryKeyObj());
			}

			if (cteChangeEntry != null) {
				session.delete(cteChangeEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (cteChangeEntry != null) {
			clearCache(cteChangeEntry);
		}

		return cteChangeEntry;
	}

	@Override
	public CTEChangeEntry updateImpl(CTEChangeEntry cteChangeEntry) {
		boolean isNew = cteChangeEntry.isNew();

		if (!(cteChangeEntry instanceof CTEChangeEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(cteChangeEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(cteChangeEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in cteChangeEntry proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CTEChangeEntry implementation " +
				cteChangeEntry.getClass());
		}

		CTEChangeEntryModelImpl cteChangeEntryModelImpl = (CTEChangeEntryModelImpl)cteChangeEntry;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (cteChangeEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				cteChangeEntry.setCreateDate(now);
			}
			else {
				cteChangeEntry.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!cteChangeEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				cteChangeEntry.setModifiedDate(now);
			}
			else {
				cteChangeEntry.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (cteChangeEntry.isNew()) {
				session.save(cteChangeEntry);

				cteChangeEntry.setNew(false);
			}
			else {
				cteChangeEntry = (CTEChangeEntry)session.merge(cteChangeEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!CTEChangeEntryModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] {
					cteChangeEntryModelImpl.getResourcePrimKey()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_RESOURCEPRIMKEY, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESOURCEPRIMKEY,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((cteChangeEntryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESOURCEPRIMKEY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cteChangeEntryModelImpl.getOriginalResourcePrimKey()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_RESOURCEPRIMKEY,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESOURCEPRIMKEY,
					args);

				args = new Object[] { cteChangeEntryModelImpl.getResourcePrimKey() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_RESOURCEPRIMKEY,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RESOURCEPRIMKEY,
					args);
			}
		}

		entityCache.putResult(CTEChangeEntryModelImpl.ENTITY_CACHE_ENABLED,
			CTEChangeEntryImpl.class, cteChangeEntry.getPrimaryKey(),
			cteChangeEntry, false);

		cteChangeEntry.resetOriginalValues();

		return cteChangeEntry;
	}

	/**
	 * Returns the cte change entry with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the cte change entry
	 * @return the cte change entry
	 * @throws NoSuchCTEChangeEntryException if a cte change entry with the primary key could not be found
	 */
	@Override
	public CTEChangeEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCTEChangeEntryException {
		CTEChangeEntry cteChangeEntry = fetchByPrimaryKey(primaryKey);

		if (cteChangeEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCTEChangeEntryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return cteChangeEntry;
	}

	/**
	 * Returns the cte change entry with the primary key or throws a {@link NoSuchCTEChangeEntryException} if it could not be found.
	 *
	 * @param cteChangeEntryId the primary key of the cte change entry
	 * @return the cte change entry
	 * @throws NoSuchCTEChangeEntryException if a cte change entry with the primary key could not be found
	 */
	@Override
	public CTEChangeEntry findByPrimaryKey(long cteChangeEntryId)
		throws NoSuchCTEChangeEntryException {
		return findByPrimaryKey((Serializable)cteChangeEntryId);
	}

	/**
	 * Returns the cte change entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the cte change entry
	 * @return the cte change entry, or <code>null</code> if a cte change entry with the primary key could not be found
	 */
	@Override
	public CTEChangeEntry fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(CTEChangeEntryModelImpl.ENTITY_CACHE_ENABLED,
				CTEChangeEntryImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		CTEChangeEntry cteChangeEntry = (CTEChangeEntry)serializable;

		if (cteChangeEntry == null) {
			Session session = null;

			try {
				session = openSession();

				cteChangeEntry = (CTEChangeEntry)session.get(CTEChangeEntryImpl.class,
						primaryKey);

				if (cteChangeEntry != null) {
					cacheResult(cteChangeEntry);
				}
				else {
					entityCache.putResult(CTEChangeEntryModelImpl.ENTITY_CACHE_ENABLED,
						CTEChangeEntryImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(CTEChangeEntryModelImpl.ENTITY_CACHE_ENABLED,
					CTEChangeEntryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return cteChangeEntry;
	}

	/**
	 * Returns the cte change entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cteChangeEntryId the primary key of the cte change entry
	 * @return the cte change entry, or <code>null</code> if a cte change entry with the primary key could not be found
	 */
	@Override
	public CTEChangeEntry fetchByPrimaryKey(long cteChangeEntryId) {
		return fetchByPrimaryKey((Serializable)cteChangeEntryId);
	}

	@Override
	public Map<Serializable, CTEChangeEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, CTEChangeEntry> map = new HashMap<Serializable, CTEChangeEntry>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			CTEChangeEntry cteChangeEntry = fetchByPrimaryKey(primaryKey);

			if (cteChangeEntry != null) {
				map.put(primaryKey, cteChangeEntry);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(CTEChangeEntryModelImpl.ENTITY_CACHE_ENABLED,
					CTEChangeEntryImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (CTEChangeEntry)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_CTECHANGEENTRY_WHERE_PKS_IN);

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

			for (CTEChangeEntry cteChangeEntry : (List<CTEChangeEntry>)q.list()) {
				map.put(cteChangeEntry.getPrimaryKeyObj(), cteChangeEntry);

				cacheResult(cteChangeEntry);

				uncachedPrimaryKeys.remove(cteChangeEntry.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(CTEChangeEntryModelImpl.ENTITY_CACHE_ENABLED,
					CTEChangeEntryImpl.class, primaryKey, nullModel);
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
	 * Returns all the cte change entries.
	 *
	 * @return the cte change entries
	 */
	@Override
	public List<CTEChangeEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CTEChangeEntry> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<CTEChangeEntry> findAll(int start, int end,
		OrderByComparator<CTEChangeEntry> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<CTEChangeEntry> findAll(int start, int end,
		OrderByComparator<CTEChangeEntry> orderByComparator,
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

		List<CTEChangeEntry> list = null;

		if (retrieveFromCache) {
			list = (List<CTEChangeEntry>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_CTECHANGEENTRY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CTECHANGEENTRY;

				if (pagination) {
					sql = sql.concat(CTEChangeEntryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CTEChangeEntry>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<CTEChangeEntry>)QueryUtil.list(q,
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
	 * Removes all the cte change entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CTEChangeEntry cteChangeEntry : findAll()) {
			remove(cteChangeEntry);
		}
	}

	/**
	 * Returns the number of cte change entries.
	 *
	 * @return the number of cte change entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CTECHANGEENTRY);

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
	 * Returns the primaryKeys of cte change collections associated with the cte change entry.
	 *
	 * @param pk the primary key of the cte change entry
	 * @return long[] of the primaryKeys of cte change collections associated with the cte change entry
	 */
	@Override
	public long[] getCTEChangeCollectionPrimaryKeys(long pk) {
		long[] pks = cteChangeEntryToCTEChangeCollectionTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the cte change collections associated with the cte change entry.
	 *
	 * @param pk the primary key of the cte change entry
	 * @return the cte change collections associated with the cte change entry
	 */
	@Override
	public List<com.liferay.change.tracking.engine.model.CTEChangeCollection> getCTEChangeCollections(
		long pk) {
		return getCTEChangeCollections(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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
	@Override
	public List<com.liferay.change.tracking.engine.model.CTEChangeCollection> getCTEChangeCollections(
		long pk, int start, int end) {
		return getCTEChangeCollections(pk, start, end, null);
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
	@Override
	public List<com.liferay.change.tracking.engine.model.CTEChangeCollection> getCTEChangeCollections(
		long pk, int start, int end,
		OrderByComparator<com.liferay.change.tracking.engine.model.CTEChangeCollection> orderByComparator) {
		return cteChangeEntryToCTEChangeCollectionTableMapper.getRightBaseModels(pk,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of cte change collections associated with the cte change entry.
	 *
	 * @param pk the primary key of the cte change entry
	 * @return the number of cte change collections associated with the cte change entry
	 */
	@Override
	public int getCTEChangeCollectionsSize(long pk) {
		long[] pks = cteChangeEntryToCTEChangeCollectionTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the cte change collection is associated with the cte change entry.
	 *
	 * @param pk the primary key of the cte change entry
	 * @param cteChangeCollectionPK the primary key of the cte change collection
	 * @return <code>true</code> if the cte change collection is associated with the cte change entry; <code>false</code> otherwise
	 */
	@Override
	public boolean containsCTEChangeCollection(long pk,
		long cteChangeCollectionPK) {
		return cteChangeEntryToCTEChangeCollectionTableMapper.containsTableMapping(pk,
			cteChangeCollectionPK);
	}

	/**
	 * Returns <code>true</code> if the cte change entry has any cte change collections associated with it.
	 *
	 * @param pk the primary key of the cte change entry to check for associations with cte change collections
	 * @return <code>true</code> if the cte change entry has any cte change collections associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsCTEChangeCollections(long pk) {
		if (getCTEChangeCollectionsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the cte change entry and the cte change collection. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the cte change entry
	 * @param cteChangeCollectionPK the primary key of the cte change collection
	 */
	@Override
	public void addCTEChangeCollection(long pk, long cteChangeCollectionPK) {
		CTEChangeEntry cteChangeEntry = fetchByPrimaryKey(pk);

		if (cteChangeEntry == null) {
			cteChangeEntryToCTEChangeCollectionTableMapper.addTableMapping(companyProvider.getCompanyId(),
				pk, cteChangeCollectionPK);
		}
		else {
			cteChangeEntryToCTEChangeCollectionTableMapper.addTableMapping(cteChangeEntry.getCompanyId(),
				pk, cteChangeCollectionPK);
		}
	}

	/**
	 * Adds an association between the cte change entry and the cte change collection. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the cte change entry
	 * @param cteChangeCollection the cte change collection
	 */
	@Override
	public void addCTEChangeCollection(long pk,
		com.liferay.change.tracking.engine.model.CTEChangeCollection cteChangeCollection) {
		CTEChangeEntry cteChangeEntry = fetchByPrimaryKey(pk);

		if (cteChangeEntry == null) {
			cteChangeEntryToCTEChangeCollectionTableMapper.addTableMapping(companyProvider.getCompanyId(),
				pk, cteChangeCollection.getPrimaryKey());
		}
		else {
			cteChangeEntryToCTEChangeCollectionTableMapper.addTableMapping(cteChangeEntry.getCompanyId(),
				pk, cteChangeCollection.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the cte change entry and the cte change collections. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the cte change entry
	 * @param cteChangeCollectionPKs the primary keys of the cte change collections
	 */
	@Override
	public void addCTEChangeCollections(long pk, long[] cteChangeCollectionPKs) {
		long companyId = 0;

		CTEChangeEntry cteChangeEntry = fetchByPrimaryKey(pk);

		if (cteChangeEntry == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = cteChangeEntry.getCompanyId();
		}

		cteChangeEntryToCTEChangeCollectionTableMapper.addTableMappings(companyId,
			pk, cteChangeCollectionPKs);
	}

	/**
	 * Adds an association between the cte change entry and the cte change collections. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the cte change entry
	 * @param cteChangeCollections the cte change collections
	 */
	@Override
	public void addCTEChangeCollections(long pk,
		List<com.liferay.change.tracking.engine.model.CTEChangeCollection> cteChangeCollections) {
		addCTEChangeCollections(pk,
			ListUtil.toLongArray(cteChangeCollections,
				com.liferay.change.tracking.engine.model.CTEChangeCollection.CTE_CHANGE_COLLECTION_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the cte change entry and its cte change collections. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the cte change entry to clear the associated cte change collections from
	 */
	@Override
	public void clearCTEChangeCollections(long pk) {
		cteChangeEntryToCTEChangeCollectionTableMapper.deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the cte change entry and the cte change collection. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the cte change entry
	 * @param cteChangeCollectionPK the primary key of the cte change collection
	 */
	@Override
	public void removeCTEChangeCollection(long pk, long cteChangeCollectionPK) {
		cteChangeEntryToCTEChangeCollectionTableMapper.deleteTableMapping(pk,
			cteChangeCollectionPK);
	}

	/**
	 * Removes the association between the cte change entry and the cte change collection. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the cte change entry
	 * @param cteChangeCollection the cte change collection
	 */
	@Override
	public void removeCTEChangeCollection(long pk,
		com.liferay.change.tracking.engine.model.CTEChangeCollection cteChangeCollection) {
		cteChangeEntryToCTEChangeCollectionTableMapper.deleteTableMapping(pk,
			cteChangeCollection.getPrimaryKey());
	}

	/**
	 * Removes the association between the cte change entry and the cte change collections. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the cte change entry
	 * @param cteChangeCollectionPKs the primary keys of the cte change collections
	 */
	@Override
	public void removeCTEChangeCollections(long pk,
		long[] cteChangeCollectionPKs) {
		cteChangeEntryToCTEChangeCollectionTableMapper.deleteTableMappings(pk,
			cteChangeCollectionPKs);
	}

	/**
	 * Removes the association between the cte change entry and the cte change collections. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the cte change entry
	 * @param cteChangeCollections the cte change collections
	 */
	@Override
	public void removeCTEChangeCollections(long pk,
		List<com.liferay.change.tracking.engine.model.CTEChangeCollection> cteChangeCollections) {
		removeCTEChangeCollections(pk,
			ListUtil.toLongArray(cteChangeCollections,
				com.liferay.change.tracking.engine.model.CTEChangeCollection.CTE_CHANGE_COLLECTION_ID_ACCESSOR));
	}

	/**
	 * Sets the cte change collections associated with the cte change entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the cte change entry
	 * @param cteChangeCollectionPKs the primary keys of the cte change collections to be associated with the cte change entry
	 */
	@Override
	public void setCTEChangeCollections(long pk, long[] cteChangeCollectionPKs) {
		Set<Long> newCTEChangeCollectionPKsSet = SetUtil.fromArray(cteChangeCollectionPKs);
		Set<Long> oldCTEChangeCollectionPKsSet = SetUtil.fromArray(cteChangeEntryToCTEChangeCollectionTableMapper.getRightPrimaryKeys(
					pk));

		Set<Long> removeCTEChangeCollectionPKsSet = new HashSet<Long>(oldCTEChangeCollectionPKsSet);

		removeCTEChangeCollectionPKsSet.removeAll(newCTEChangeCollectionPKsSet);

		cteChangeEntryToCTEChangeCollectionTableMapper.deleteTableMappings(pk,
			ArrayUtil.toLongArray(removeCTEChangeCollectionPKsSet));

		newCTEChangeCollectionPKsSet.removeAll(oldCTEChangeCollectionPKsSet);

		long companyId = 0;

		CTEChangeEntry cteChangeEntry = fetchByPrimaryKey(pk);

		if (cteChangeEntry == null) {
			companyId = companyProvider.getCompanyId();
		}
		else {
			companyId = cteChangeEntry.getCompanyId();
		}

		cteChangeEntryToCTEChangeCollectionTableMapper.addTableMappings(companyId,
			pk, ArrayUtil.toLongArray(newCTEChangeCollectionPKsSet));
	}

	/**
	 * Sets the cte change collections associated with the cte change entry, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the cte change entry
	 * @param cteChangeCollections the cte change collections to be associated with the cte change entry
	 */
	@Override
	public void setCTEChangeCollections(long pk,
		List<com.liferay.change.tracking.engine.model.CTEChangeCollection> cteChangeCollections) {
		try {
			long[] cteChangeCollectionPKs = new long[cteChangeCollections.size()];

			for (int i = 0; i < cteChangeCollections.size(); i++) {
				com.liferay.change.tracking.engine.model.CTEChangeCollection cteChangeCollection =
					cteChangeCollections.get(i);

				cteChangeCollectionPKs[i] = cteChangeCollection.getPrimaryKey();
			}

			setCTEChangeCollections(pk, cteChangeCollectionPKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CTEChangeEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the cte change entry persistence.
	 */
	public void afterPropertiesSet() {
		cteChangeEntryToCTEChangeCollectionTableMapper = TableMapperFactory.getTableMapper("Collections_Entries",
				"companyId", "cteChangeEntryId", "cteChangeCollectionId", this,
				cteChangeCollectionPersistence);
	}

	public void destroy() {
		entityCache.removeCache(CTEChangeEntryImpl.class.getName());
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
	@BeanReference(type = CTEChangeCollectionPersistence.class)
	protected CTEChangeCollectionPersistence cteChangeCollectionPersistence;
	protected TableMapper<CTEChangeEntry, com.liferay.change.tracking.engine.model.CTEChangeCollection> cteChangeEntryToCTEChangeCollectionTableMapper;
	private static final String _SQL_SELECT_CTECHANGEENTRY = "SELECT cteChangeEntry FROM CTEChangeEntry cteChangeEntry";
	private static final String _SQL_SELECT_CTECHANGEENTRY_WHERE_PKS_IN = "SELECT cteChangeEntry FROM CTEChangeEntry cteChangeEntry WHERE cteChangeEntryId IN (";
	private static final String _SQL_SELECT_CTECHANGEENTRY_WHERE = "SELECT cteChangeEntry FROM CTEChangeEntry cteChangeEntry WHERE ";
	private static final String _SQL_COUNT_CTECHANGEENTRY = "SELECT COUNT(cteChangeEntry) FROM CTEChangeEntry cteChangeEntry";
	private static final String _SQL_COUNT_CTECHANGEENTRY_WHERE = "SELECT COUNT(cteChangeEntry) FROM CTEChangeEntry cteChangeEntry WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "cteChangeEntry.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CTEChangeEntry exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CTEChangeEntry exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(CTEChangeEntryPersistenceImpl.class);
}