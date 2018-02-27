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

package com.liferay.exportimport.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;

import com.liferay.exportimport.exception.NoSuchEntityPublicationException;
import com.liferay.exportimport.model.EntityPublication;
import com.liferay.exportimport.service.EntityPublicationLocalServiceUtil;
import com.liferay.exportimport.service.persistence.EntityPublicationPersistence;
import com.liferay.exportimport.service.persistence.EntityPublicationUtil;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import org.junit.runner.RunWith;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class EntityPublicationPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED,
				"com.liferay.exportimport.service"));

	@Before
	public void setUp() {
		_persistence = EntityPublicationUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<EntityPublication> iterator = _entityPublications.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EntityPublication entityPublication = _persistence.create(pk);

		Assert.assertNotNull(entityPublication);

		Assert.assertEquals(entityPublication.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		EntityPublication newEntityPublication = addEntityPublication();

		_persistence.remove(newEntityPublication);

		EntityPublication existingEntityPublication = _persistence.fetchByPrimaryKey(newEntityPublication.getPrimaryKey());

		Assert.assertNull(existingEntityPublication);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addEntityPublication();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EntityPublication newEntityPublication = _persistence.create(pk);

		newEntityPublication.setMvccVersion(RandomTestUtil.nextLong());

		newEntityPublication.setCompanyId(RandomTestUtil.nextLong());

		newEntityPublication.setUserId(RandomTestUtil.nextLong());

		newEntityPublication.setUserName(RandomTestUtil.randomString());

		newEntityPublication.setCreateDate(RandomTestUtil.nextDate());

		newEntityPublication.setModifiedDate(RandomTestUtil.nextDate());

		newEntityPublication.setClassNameId(RandomTestUtil.nextLong());

		newEntityPublication.setClassPK(RandomTestUtil.nextLong());

		newEntityPublication.setPublicationDate(RandomTestUtil.nextDate());

		_entityPublications.add(_persistence.update(newEntityPublication));

		EntityPublication existingEntityPublication = _persistence.findByPrimaryKey(newEntityPublication.getPrimaryKey());

		Assert.assertEquals(existingEntityPublication.getMvccVersion(),
			newEntityPublication.getMvccVersion());
		Assert.assertEquals(existingEntityPublication.getId(),
			newEntityPublication.getId());
		Assert.assertEquals(existingEntityPublication.getCompanyId(),
			newEntityPublication.getCompanyId());
		Assert.assertEquals(existingEntityPublication.getUserId(),
			newEntityPublication.getUserId());
		Assert.assertEquals(existingEntityPublication.getUserName(),
			newEntityPublication.getUserName());
		Assert.assertEquals(Time.getShortTimestamp(
				existingEntityPublication.getCreateDate()),
			Time.getShortTimestamp(newEntityPublication.getCreateDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingEntityPublication.getModifiedDate()),
			Time.getShortTimestamp(newEntityPublication.getModifiedDate()));
		Assert.assertEquals(existingEntityPublication.getClassNameId(),
			newEntityPublication.getClassNameId());
		Assert.assertEquals(existingEntityPublication.getClassPK(),
			newEntityPublication.getClassPK());
		Assert.assertEquals(Time.getShortTimestamp(
				existingEntityPublication.getPublicationDate()),
			Time.getShortTimestamp(newEntityPublication.getPublicationDate()));
	}

	@Test
	public void testCountByC_C() throws Exception {
		_persistence.countByC_C(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByC_C(0L, 0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		EntityPublication newEntityPublication = addEntityPublication();

		EntityPublication existingEntityPublication = _persistence.findByPrimaryKey(newEntityPublication.getPrimaryKey());

		Assert.assertEquals(existingEntityPublication, newEntityPublication);
	}

	@Test(expected = NoSuchEntityPublicationException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<EntityPublication> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("EntityPublication",
			"mvccVersion", true, "id", true, "companyId", true, "userId", true,
			"userName", true, "createDate", true, "modifiedDate", true,
			"classNameId", true, "classPK", true, "publicationDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		EntityPublication newEntityPublication = addEntityPublication();

		EntityPublication existingEntityPublication = _persistence.fetchByPrimaryKey(newEntityPublication.getPrimaryKey());

		Assert.assertEquals(existingEntityPublication, newEntityPublication);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		EntityPublication missingEntityPublication = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingEntityPublication);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		EntityPublication newEntityPublication1 = addEntityPublication();
		EntityPublication newEntityPublication2 = addEntityPublication();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEntityPublication1.getPrimaryKey());
		primaryKeys.add(newEntityPublication2.getPrimaryKey());

		Map<Serializable, EntityPublication> entityPublications = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, entityPublications.size());
		Assert.assertEquals(newEntityPublication1,
			entityPublications.get(newEntityPublication1.getPrimaryKey()));
		Assert.assertEquals(newEntityPublication2,
			entityPublications.get(newEntityPublication2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, EntityPublication> entityPublications = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(entityPublications.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		EntityPublication newEntityPublication = addEntityPublication();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEntityPublication.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, EntityPublication> entityPublications = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, entityPublications.size());
		Assert.assertEquals(newEntityPublication,
			entityPublications.get(newEntityPublication.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, EntityPublication> entityPublications = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(entityPublications.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		EntityPublication newEntityPublication = addEntityPublication();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEntityPublication.getPrimaryKey());

		Map<Serializable, EntityPublication> entityPublications = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, entityPublications.size());
		Assert.assertEquals(newEntityPublication,
			entityPublications.get(newEntityPublication.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = EntityPublicationLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<EntityPublication>() {
				@Override
				public void performAction(EntityPublication entityPublication) {
					Assert.assertNotNull(entityPublication);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		EntityPublication newEntityPublication = addEntityPublication();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(EntityPublication.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id",
				newEntityPublication.getId()));

		List<EntityPublication> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		EntityPublication existingEntityPublication = result.get(0);

		Assert.assertEquals(existingEntityPublication, newEntityPublication);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(EntityPublication.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id",
				RandomTestUtil.nextLong()));

		List<EntityPublication> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		EntityPublication newEntityPublication = addEntityPublication();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(EntityPublication.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newEntityPublication.getId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("id", new Object[] { newId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingId = result.get(0);

		Assert.assertEquals(existingId, newId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(EntityPublication.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("id",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		EntityPublication newEntityPublication = addEntityPublication();

		_persistence.clearCache();

		EntityPublication existingEntityPublication = _persistence.findByPrimaryKey(newEntityPublication.getPrimaryKey());

		Assert.assertEquals(Long.valueOf(
				existingEntityPublication.getClassNameId()),
			ReflectionTestUtil.<Long>invoke(existingEntityPublication,
				"getOriginalClassNameId", new Class<?>[0]));
		Assert.assertEquals(Long.valueOf(existingEntityPublication.getClassPK()),
			ReflectionTestUtil.<Long>invoke(existingEntityPublication,
				"getOriginalClassPK", new Class<?>[0]));
	}

	protected EntityPublication addEntityPublication()
		throws Exception {
		long pk = RandomTestUtil.nextLong();

		EntityPublication entityPublication = _persistence.create(pk);

		entityPublication.setMvccVersion(RandomTestUtil.nextLong());

		entityPublication.setCompanyId(RandomTestUtil.nextLong());

		entityPublication.setUserId(RandomTestUtil.nextLong());

		entityPublication.setUserName(RandomTestUtil.randomString());

		entityPublication.setCreateDate(RandomTestUtil.nextDate());

		entityPublication.setModifiedDate(RandomTestUtil.nextDate());

		entityPublication.setClassNameId(RandomTestUtil.nextLong());

		entityPublication.setClassPK(RandomTestUtil.nextLong());

		entityPublication.setPublicationDate(RandomTestUtil.nextDate());

		_entityPublications.add(_persistence.update(entityPublication));

		return entityPublication;
	}

	private List<EntityPublication> _entityPublications = new ArrayList<EntityPublication>();
	private EntityPublicationPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}