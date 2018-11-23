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

package com.liferay.change.tracking.engine.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;

import com.liferay.change.tracking.engine.exception.NoSuchCTEChangeCollectionException;
import com.liferay.change.tracking.engine.model.CTEChangeCollection;
import com.liferay.change.tracking.engine.service.CTEChangeCollectionLocalServiceUtil;
import com.liferay.change.tracking.engine.service.persistence.CTEChangeCollectionPersistence;
import com.liferay.change.tracking.engine.service.persistence.CTEChangeCollectionUtil;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
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
public class CTEChangeCollectionPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED,
				"com.liferay.change.tracking.engine.service"));

	@Before
	public void setUp() {
		_persistence = CTEChangeCollectionUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<CTEChangeCollection> iterator = _cteChangeCollections.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CTEChangeCollection cteChangeCollection = _persistence.create(pk);

		Assert.assertNotNull(cteChangeCollection);

		Assert.assertEquals(cteChangeCollection.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		CTEChangeCollection newCTEChangeCollection = addCTEChangeCollection();

		_persistence.remove(newCTEChangeCollection);

		CTEChangeCollection existingCTEChangeCollection = _persistence.fetchByPrimaryKey(newCTEChangeCollection.getPrimaryKey());

		Assert.assertNull(existingCTEChangeCollection);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCTEChangeCollection();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CTEChangeCollection newCTEChangeCollection = _persistence.create(pk);

		newCTEChangeCollection.setCompanyId(RandomTestUtil.nextLong());

		newCTEChangeCollection.setUserId(RandomTestUtil.nextLong());

		newCTEChangeCollection.setUserName(RandomTestUtil.randomString());

		newCTEChangeCollection.setCreateDate(RandomTestUtil.nextDate());

		newCTEChangeCollection.setModifiedDate(RandomTestUtil.nextDate());

		newCTEChangeCollection.setName(RandomTestUtil.randomString());

		newCTEChangeCollection.setDescription(RandomTestUtil.randomString());

		_cteChangeCollections.add(_persistence.update(newCTEChangeCollection));

		CTEChangeCollection existingCTEChangeCollection = _persistence.findByPrimaryKey(newCTEChangeCollection.getPrimaryKey());

		Assert.assertEquals(existingCTEChangeCollection.getCteChangeCollectionId(),
			newCTEChangeCollection.getCteChangeCollectionId());
		Assert.assertEquals(existingCTEChangeCollection.getCompanyId(),
			newCTEChangeCollection.getCompanyId());
		Assert.assertEquals(existingCTEChangeCollection.getUserId(),
			newCTEChangeCollection.getUserId());
		Assert.assertEquals(existingCTEChangeCollection.getUserName(),
			newCTEChangeCollection.getUserName());
		Assert.assertEquals(Time.getShortTimestamp(
				existingCTEChangeCollection.getCreateDate()),
			Time.getShortTimestamp(newCTEChangeCollection.getCreateDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingCTEChangeCollection.getModifiedDate()),
			Time.getShortTimestamp(newCTEChangeCollection.getModifiedDate()));
		Assert.assertEquals(existingCTEChangeCollection.getName(),
			newCTEChangeCollection.getName());
		Assert.assertEquals(existingCTEChangeCollection.getDescription(),
			newCTEChangeCollection.getDescription());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		CTEChangeCollection newCTEChangeCollection = addCTEChangeCollection();

		CTEChangeCollection existingCTEChangeCollection = _persistence.findByPrimaryKey(newCTEChangeCollection.getPrimaryKey());

		Assert.assertEquals(existingCTEChangeCollection, newCTEChangeCollection);
	}

	@Test(expected = NoSuchCTEChangeCollectionException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<CTEChangeCollection> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("CTEChangeCollection",
			"cteChangeCollectionId", true, "companyId", true, "userId", true,
			"userName", true, "createDate", true, "modifiedDate", true, "name",
			true, "description", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		CTEChangeCollection newCTEChangeCollection = addCTEChangeCollection();

		CTEChangeCollection existingCTEChangeCollection = _persistence.fetchByPrimaryKey(newCTEChangeCollection.getPrimaryKey());

		Assert.assertEquals(existingCTEChangeCollection, newCTEChangeCollection);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CTEChangeCollection missingCTEChangeCollection = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCTEChangeCollection);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		CTEChangeCollection newCTEChangeCollection1 = addCTEChangeCollection();
		CTEChangeCollection newCTEChangeCollection2 = addCTEChangeCollection();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCTEChangeCollection1.getPrimaryKey());
		primaryKeys.add(newCTEChangeCollection2.getPrimaryKey());

		Map<Serializable, CTEChangeCollection> cteChangeCollections = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, cteChangeCollections.size());
		Assert.assertEquals(newCTEChangeCollection1,
			cteChangeCollections.get(newCTEChangeCollection1.getPrimaryKey()));
		Assert.assertEquals(newCTEChangeCollection2,
			cteChangeCollections.get(newCTEChangeCollection2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, CTEChangeCollection> cteChangeCollections = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(cteChangeCollections.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		CTEChangeCollection newCTEChangeCollection = addCTEChangeCollection();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCTEChangeCollection.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, CTEChangeCollection> cteChangeCollections = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, cteChangeCollections.size());
		Assert.assertEquals(newCTEChangeCollection,
			cteChangeCollections.get(newCTEChangeCollection.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, CTEChangeCollection> cteChangeCollections = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(cteChangeCollections.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		CTEChangeCollection newCTEChangeCollection = addCTEChangeCollection();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCTEChangeCollection.getPrimaryKey());

		Map<Serializable, CTEChangeCollection> cteChangeCollections = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, cteChangeCollections.size());
		Assert.assertEquals(newCTEChangeCollection,
			cteChangeCollections.get(newCTEChangeCollection.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = CTEChangeCollectionLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<CTEChangeCollection>() {
				@Override
				public void performAction(
					CTEChangeCollection cteChangeCollection) {
					Assert.assertNotNull(cteChangeCollection);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		CTEChangeCollection newCTEChangeCollection = addCTEChangeCollection();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(CTEChangeCollection.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("cteChangeCollectionId",
				newCTEChangeCollection.getCteChangeCollectionId()));

		List<CTEChangeCollection> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		CTEChangeCollection existingCTEChangeCollection = result.get(0);

		Assert.assertEquals(existingCTEChangeCollection, newCTEChangeCollection);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(CTEChangeCollection.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("cteChangeCollectionId",
				RandomTestUtil.nextLong()));

		List<CTEChangeCollection> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		CTEChangeCollection newCTEChangeCollection = addCTEChangeCollection();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(CTEChangeCollection.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"cteChangeCollectionId"));

		Object newCteChangeCollectionId = newCTEChangeCollection.getCteChangeCollectionId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("cteChangeCollectionId",
				new Object[] { newCteChangeCollectionId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCteChangeCollectionId = result.get(0);

		Assert.assertEquals(existingCteChangeCollectionId,
			newCteChangeCollectionId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(CTEChangeCollection.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"cteChangeCollectionId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("cteChangeCollectionId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected CTEChangeCollection addCTEChangeCollection()
		throws Exception {
		long pk = RandomTestUtil.nextLong();

		CTEChangeCollection cteChangeCollection = _persistence.create(pk);

		cteChangeCollection.setCompanyId(RandomTestUtil.nextLong());

		cteChangeCollection.setUserId(RandomTestUtil.nextLong());

		cteChangeCollection.setUserName(RandomTestUtil.randomString());

		cteChangeCollection.setCreateDate(RandomTestUtil.nextDate());

		cteChangeCollection.setModifiedDate(RandomTestUtil.nextDate());

		cteChangeCollection.setName(RandomTestUtil.randomString());

		cteChangeCollection.setDescription(RandomTestUtil.randomString());

		_cteChangeCollections.add(_persistence.update(cteChangeCollection));

		return cteChangeCollection;
	}

	private List<CTEChangeCollection> _cteChangeCollections = new ArrayList<CTEChangeCollection>();
	private CTEChangeCollectionPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}