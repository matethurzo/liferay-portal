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

package com.liferay.exportimport.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.exportimport.exception.NoSuchEntityPublicationException;
import com.liferay.exportimport.model.EntityPublication;
import com.liferay.exportimport.model.impl.EntityPublicationImpl;
import com.liferay.exportimport.model.impl.EntityPublicationModelImpl;
import com.liferay.exportimport.service.persistence.EntityPublicationPersistence;

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
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the entity publication service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EntityPublicationPersistence
 * @see com.liferay.exportimport.service.persistence.EntityPublicationUtil
 * @generated
 */
@ProviderType
public class EntityPublicationPersistenceImpl extends BasePersistenceImpl<EntityPublication>
	implements EntityPublicationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EntityPublicationUtil} to access the entity publication persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EntityPublicationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EntityPublicationModelImpl.ENTITY_CACHE_ENABLED,
			EntityPublicationModelImpl.FINDER_CACHE_ENABLED,
			EntityPublicationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EntityPublicationModelImpl.ENTITY_CACHE_ENABLED,
			EntityPublicationModelImpl.FINDER_CACHE_ENABLED,
			EntityPublicationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EntityPublicationModelImpl.ENTITY_CACHE_ENABLED,
			EntityPublicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_C_C = new FinderPath(EntityPublicationModelImpl.ENTITY_CACHE_ENABLED,
			EntityPublicationModelImpl.FINDER_CACHE_ENABLED,
			EntityPublicationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByC_C",
			new String[] { Long.class.getName(), Long.class.getName() },
			EntityPublicationModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			EntityPublicationModelImpl.CLASSPK_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_C_C = new FinderPath(EntityPublicationModelImpl.ENTITY_CACHE_ENABLED,
			EntityPublicationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the entity publication where classNameId = &#63; and classPK = &#63; or throws a {@link NoSuchEntityPublicationException} if it could not be found.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @return the matching entity publication
	 * @throws NoSuchEntityPublicationException if a matching entity publication could not be found
	 */
	@Override
	public EntityPublication findByC_C(long classNameId, long classPK)
		throws NoSuchEntityPublicationException {
		EntityPublication entityPublication = fetchByC_C(classNameId, classPK);

		if (entityPublication == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("classNameId=");
			msg.append(classNameId);

			msg.append(", classPK=");
			msg.append(classPK);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchEntityPublicationException(msg.toString());
		}

		return entityPublication;
	}

	/**
	 * Returns the entity publication where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @return the matching entity publication, or <code>null</code> if a matching entity publication could not be found
	 */
	@Override
	public EntityPublication fetchByC_C(long classNameId, long classPK) {
		return fetchByC_C(classNameId, classPK, true);
	}

	/**
	 * Returns the entity publication where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching entity publication, or <code>null</code> if a matching entity publication could not be found
	 */
	@Override
	public EntityPublication fetchByC_C(long classNameId, long classPK,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { classNameId, classPK };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_C_C,
					finderArgs, this);
		}

		if (result instanceof EntityPublication) {
			EntityPublication entityPublication = (EntityPublication)result;

			if ((classNameId != entityPublication.getClassNameId()) ||
					(classPK != entityPublication.getClassPK())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ENTITYPUBLICATION_WHERE);

			query.append(_FINDER_COLUMN_C_C_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_C_C_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classNameId);

				qPos.add(classPK);

				List<EntityPublication> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_C_C, finderArgs,
						list);
				}
				else {
					EntityPublication entityPublication = list.get(0);

					result = entityPublication;

					cacheResult(entityPublication);

					if ((entityPublication.getClassNameId() != classNameId) ||
							(entityPublication.getClassPK() != classPK)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_C_C,
							finderArgs, entityPublication);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_C_C, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (EntityPublication)result;
		}
	}

	/**
	 * Removes the entity publication where classNameId = &#63; and classPK = &#63; from the database.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @return the entity publication that was removed
	 */
	@Override
	public EntityPublication removeByC_C(long classNameId, long classPK)
		throws NoSuchEntityPublicationException {
		EntityPublication entityPublication = findByC_C(classNameId, classPK);

		return remove(entityPublication);
	}

	/**
	 * Returns the number of entity publications where classNameId = &#63; and classPK = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @return the number of matching entity publications
	 */
	@Override
	public int countByC_C(long classNameId, long classPK) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_C_C;

		Object[] finderArgs = new Object[] { classNameId, classPK };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ENTITYPUBLICATION_WHERE);

			query.append(_FINDER_COLUMN_C_C_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_C_C_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classNameId);

				qPos.add(classPK);

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

	private static final String _FINDER_COLUMN_C_C_CLASSNAMEID_2 = "entityPublication.classNameId = ? AND ";
	private static final String _FINDER_COLUMN_C_C_CLASSPK_2 = "entityPublication.classPK = ?";

	public EntityPublicationPersistenceImpl() {
		setModelClass(EntityPublication.class);

		try {
			Field field = BasePersistenceImpl.class.getDeclaredField(
					"_dbColumnNames");

			field.setAccessible(true);

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("id", "id_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the entity publication in the entity cache if it is enabled.
	 *
	 * @param entityPublication the entity publication
	 */
	@Override
	public void cacheResult(EntityPublication entityPublication) {
		entityCache.putResult(EntityPublicationModelImpl.ENTITY_CACHE_ENABLED,
			EntityPublicationImpl.class, entityPublication.getPrimaryKey(),
			entityPublication);

		finderCache.putResult(FINDER_PATH_FETCH_BY_C_C,
			new Object[] {
				entityPublication.getClassNameId(),
				entityPublication.getClassPK()
			}, entityPublication);

		entityPublication.resetOriginalValues();
	}

	/**
	 * Caches the entity publications in the entity cache if it is enabled.
	 *
	 * @param entityPublications the entity publications
	 */
	@Override
	public void cacheResult(List<EntityPublication> entityPublications) {
		for (EntityPublication entityPublication : entityPublications) {
			if (entityCache.getResult(
						EntityPublicationModelImpl.ENTITY_CACHE_ENABLED,
						EntityPublicationImpl.class,
						entityPublication.getPrimaryKey()) == null) {
				cacheResult(entityPublication);
			}
			else {
				entityPublication.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all entity publications.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EntityPublicationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the entity publication.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EntityPublication entityPublication) {
		entityCache.removeResult(EntityPublicationModelImpl.ENTITY_CACHE_ENABLED,
			EntityPublicationImpl.class, entityPublication.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((EntityPublicationModelImpl)entityPublication,
			true);
	}

	@Override
	public void clearCache(List<EntityPublication> entityPublications) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EntityPublication entityPublication : entityPublications) {
			entityCache.removeResult(EntityPublicationModelImpl.ENTITY_CACHE_ENABLED,
				EntityPublicationImpl.class, entityPublication.getPrimaryKey());

			clearUniqueFindersCache((EntityPublicationModelImpl)entityPublication,
				true);
		}
	}

	protected void cacheUniqueFindersCache(
		EntityPublicationModelImpl entityPublicationModelImpl) {
		Object[] args = new Object[] {
				entityPublicationModelImpl.getClassNameId(),
				entityPublicationModelImpl.getClassPK()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_C_C, args, Long.valueOf(1),
			false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_C_C, args,
			entityPublicationModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		EntityPublicationModelImpl entityPublicationModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					entityPublicationModelImpl.getClassNameId(),
					entityPublicationModelImpl.getClassPK()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_C_C, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_C_C, args);
		}

		if ((entityPublicationModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_C_C.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					entityPublicationModelImpl.getOriginalClassNameId(),
					entityPublicationModelImpl.getOriginalClassPK()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_C_C, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_C_C, args);
		}
	}

	/**
	 * Creates a new entity publication with the primary key. Does not add the entity publication to the database.
	 *
	 * @param id the primary key for the new entity publication
	 * @return the new entity publication
	 */
	@Override
	public EntityPublication create(long id) {
		EntityPublication entityPublication = new EntityPublicationImpl();

		entityPublication.setNew(true);
		entityPublication.setPrimaryKey(id);

		entityPublication.setCompanyId(companyProvider.getCompanyId());

		return entityPublication;
	}

	/**
	 * Removes the entity publication with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the entity publication
	 * @return the entity publication that was removed
	 * @throws NoSuchEntityPublicationException if a entity publication with the primary key could not be found
	 */
	@Override
	public EntityPublication remove(long id)
		throws NoSuchEntityPublicationException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the entity publication with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the entity publication
	 * @return the entity publication that was removed
	 * @throws NoSuchEntityPublicationException if a entity publication with the primary key could not be found
	 */
	@Override
	public EntityPublication remove(Serializable primaryKey)
		throws NoSuchEntityPublicationException {
		Session session = null;

		try {
			session = openSession();

			EntityPublication entityPublication = (EntityPublication)session.get(EntityPublicationImpl.class,
					primaryKey);

			if (entityPublication == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEntityPublicationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(entityPublication);
		}
		catch (NoSuchEntityPublicationException nsee) {
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
	protected EntityPublication removeImpl(EntityPublication entityPublication) {
		entityPublication = toUnwrappedModel(entityPublication);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(entityPublication)) {
				entityPublication = (EntityPublication)session.get(EntityPublicationImpl.class,
						entityPublication.getPrimaryKeyObj());
			}

			if (entityPublication != null) {
				session.delete(entityPublication);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (entityPublication != null) {
			clearCache(entityPublication);
		}

		return entityPublication;
	}

	@Override
	public EntityPublication updateImpl(EntityPublication entityPublication) {
		entityPublication = toUnwrappedModel(entityPublication);

		boolean isNew = entityPublication.isNew();

		EntityPublicationModelImpl entityPublicationModelImpl = (EntityPublicationModelImpl)entityPublication;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (entityPublication.getCreateDate() == null)) {
			if (serviceContext == null) {
				entityPublication.setCreateDate(now);
			}
			else {
				entityPublication.setCreateDate(serviceContext.getCreateDate(
						now));
			}
		}

		if (!entityPublicationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				entityPublication.setModifiedDate(now);
			}
			else {
				entityPublication.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (entityPublication.isNew()) {
				session.save(entityPublication);

				entityPublication.setNew(false);
			}
			else {
				entityPublication = (EntityPublication)session.merge(entityPublication);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!EntityPublicationModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(EntityPublicationModelImpl.ENTITY_CACHE_ENABLED,
			EntityPublicationImpl.class, entityPublication.getPrimaryKey(),
			entityPublication, false);

		clearUniqueFindersCache(entityPublicationModelImpl, false);
		cacheUniqueFindersCache(entityPublicationModelImpl);

		entityPublication.resetOriginalValues();

		return entityPublication;
	}

	protected EntityPublication toUnwrappedModel(
		EntityPublication entityPublication) {
		if (entityPublication instanceof EntityPublicationImpl) {
			return entityPublication;
		}

		EntityPublicationImpl entityPublicationImpl = new EntityPublicationImpl();

		entityPublicationImpl.setNew(entityPublication.isNew());
		entityPublicationImpl.setPrimaryKey(entityPublication.getPrimaryKey());

		entityPublicationImpl.setMvccVersion(entityPublication.getMvccVersion());
		entityPublicationImpl.setId(entityPublication.getId());
		entityPublicationImpl.setCompanyId(entityPublication.getCompanyId());
		entityPublicationImpl.setUserId(entityPublication.getUserId());
		entityPublicationImpl.setUserName(entityPublication.getUserName());
		entityPublicationImpl.setCreateDate(entityPublication.getCreateDate());
		entityPublicationImpl.setModifiedDate(entityPublication.getModifiedDate());
		entityPublicationImpl.setClassNameId(entityPublication.getClassNameId());
		entityPublicationImpl.setClassPK(entityPublication.getClassPK());
		entityPublicationImpl.setPublicationDate(entityPublication.getPublicationDate());

		return entityPublicationImpl;
	}

	/**
	 * Returns the entity publication with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the entity publication
	 * @return the entity publication
	 * @throws NoSuchEntityPublicationException if a entity publication with the primary key could not be found
	 */
	@Override
	public EntityPublication findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEntityPublicationException {
		EntityPublication entityPublication = fetchByPrimaryKey(primaryKey);

		if (entityPublication == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEntityPublicationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return entityPublication;
	}

	/**
	 * Returns the entity publication with the primary key or throws a {@link NoSuchEntityPublicationException} if it could not be found.
	 *
	 * @param id the primary key of the entity publication
	 * @return the entity publication
	 * @throws NoSuchEntityPublicationException if a entity publication with the primary key could not be found
	 */
	@Override
	public EntityPublication findByPrimaryKey(long id)
		throws NoSuchEntityPublicationException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the entity publication with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the entity publication
	 * @return the entity publication, or <code>null</code> if a entity publication with the primary key could not be found
	 */
	@Override
	public EntityPublication fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(EntityPublicationModelImpl.ENTITY_CACHE_ENABLED,
				EntityPublicationImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		EntityPublication entityPublication = (EntityPublication)serializable;

		if (entityPublication == null) {
			Session session = null;

			try {
				session = openSession();

				entityPublication = (EntityPublication)session.get(EntityPublicationImpl.class,
						primaryKey);

				if (entityPublication != null) {
					cacheResult(entityPublication);
				}
				else {
					entityCache.putResult(EntityPublicationModelImpl.ENTITY_CACHE_ENABLED,
						EntityPublicationImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(EntityPublicationModelImpl.ENTITY_CACHE_ENABLED,
					EntityPublicationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return entityPublication;
	}

	/**
	 * Returns the entity publication with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the entity publication
	 * @return the entity publication, or <code>null</code> if a entity publication with the primary key could not be found
	 */
	@Override
	public EntityPublication fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, EntityPublication> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, EntityPublication> map = new HashMap<Serializable, EntityPublication>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			EntityPublication entityPublication = fetchByPrimaryKey(primaryKey);

			if (entityPublication != null) {
				map.put(primaryKey, entityPublication);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(EntityPublicationModelImpl.ENTITY_CACHE_ENABLED,
					EntityPublicationImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (EntityPublication)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_ENTITYPUBLICATION_WHERE_PKS_IN);

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

			for (EntityPublication entityPublication : (List<EntityPublication>)q.list()) {
				map.put(entityPublication.getPrimaryKeyObj(), entityPublication);

				cacheResult(entityPublication);

				uncachedPrimaryKeys.remove(entityPublication.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(EntityPublicationModelImpl.ENTITY_CACHE_ENABLED,
					EntityPublicationImpl.class, primaryKey, nullModel);
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
	 * Returns all the entity publications.
	 *
	 * @return the entity publications
	 */
	@Override
	public List<EntityPublication> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the entity publications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EntityPublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of entity publications
	 * @param end the upper bound of the range of entity publications (not inclusive)
	 * @return the range of entity publications
	 */
	@Override
	public List<EntityPublication> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the entity publications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EntityPublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of entity publications
	 * @param end the upper bound of the range of entity publications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of entity publications
	 */
	@Override
	public List<EntityPublication> findAll(int start, int end,
		OrderByComparator<EntityPublication> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the entity publications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EntityPublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of entity publications
	 * @param end the upper bound of the range of entity publications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of entity publications
	 */
	@Override
	public List<EntityPublication> findAll(int start, int end,
		OrderByComparator<EntityPublication> orderByComparator,
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

		List<EntityPublication> list = null;

		if (retrieveFromCache) {
			list = (List<EntityPublication>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ENTITYPUBLICATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ENTITYPUBLICATION;

				if (pagination) {
					sql = sql.concat(EntityPublicationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EntityPublication>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<EntityPublication>)QueryUtil.list(q,
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
	 * Removes all the entity publications from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (EntityPublication entityPublication : findAll()) {
			remove(entityPublication);
		}
	}

	/**
	 * Returns the number of entity publications.
	 *
	 * @return the number of entity publications
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ENTITYPUBLICATION);

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

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return EntityPublicationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the entity publication persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(EntityPublicationImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_ENTITYPUBLICATION = "SELECT entityPublication FROM EntityPublication entityPublication";
	private static final String _SQL_SELECT_ENTITYPUBLICATION_WHERE_PKS_IN = "SELECT entityPublication FROM EntityPublication entityPublication WHERE id_ IN (";
	private static final String _SQL_SELECT_ENTITYPUBLICATION_WHERE = "SELECT entityPublication FROM EntityPublication entityPublication WHERE ";
	private static final String _SQL_COUNT_ENTITYPUBLICATION = "SELECT COUNT(entityPublication) FROM EntityPublication entityPublication";
	private static final String _SQL_COUNT_ENTITYPUBLICATION_WHERE = "SELECT COUNT(entityPublication) FROM EntityPublication entityPublication WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "entityPublication.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EntityPublication exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EntityPublication exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(EntityPublicationPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
}