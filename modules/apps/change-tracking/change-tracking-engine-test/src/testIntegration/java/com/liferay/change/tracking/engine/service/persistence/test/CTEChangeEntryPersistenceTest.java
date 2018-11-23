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

import com.liferay.change.tracking.engine.exception.NoSuchCTEChangeEntryException;
import com.liferay.change.tracking.engine.model.CTEChangeEntry;
import com.liferay.change.tracking.engine.service.CTEChangeEntryLocalServiceUtil;
import com.liferay.change.tracking.engine.service.persistence.CTEChangeEntryPersistence;
import com.liferay.change.tracking.engine.service.persistence.CTEChangeEntryUtil;

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
public class CTEChangeEntryPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED,
				"com.liferay.change.tracking.engine.service"));

	@Before
	public void setUp() {
		_persistence = CTEChangeEntryUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<CTEChangeEntry> iterator = _cteChangeEntries.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CTEChangeEntry cteChangeEntry = _persistence.create(pk);

		Assert.assertNotNull(cteChangeEntry);

		Assert.assertEquals(cteChangeEntry.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		CTEChangeEntry newCTEChangeEntry = addCTEChangeEntry();

		_persistence.remove(newCTEChangeEntry);

		CTEChangeEntry existingCTEChangeEntry = _persistence.fetchByPrimaryKey(newCTEChangeEntry.getPrimaryKey());

		Assert.assertNull(existingCTEChangeEntry);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCTEChangeEntry();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CTEChangeEntry newCTEChangeEntry = _persistence.create(pk);

		newCTEChangeEntry.setCompanyId(RandomTestUtil.nextLong());

		newCTEChangeEntry.setUserId(RandomTestUtil.nextLong());

		newCTEChangeEntry.setUserName(RandomTestUtil.randomString());

		newCTEChangeEntry.setCreateDate(RandomTestUtil.nextDate());

		newCTEChangeEntry.setModifiedDate(RandomTestUtil.nextDate());

		newCTEChangeEntry.setClassNameId(RandomTestUtil.nextLong());

		newCTEChangeEntry.setClassPK(RandomTestUtil.nextLong());

		newCTEChangeEntry.setResourcePrimKey(RandomTestUtil.nextLong());

		_cteChangeEntries.add(_persistence.update(newCTEChangeEntry));

		CTEChangeEntry existingCTEChangeEntry = _persistence.findByPrimaryKey(newCTEChangeEntry.getPrimaryKey());

		Assert.assertEquals(existingCTEChangeEntry.getCteChangeEntryId(),
			newCTEChangeEntry.getCteChangeEntryId());
		Assert.assertEquals(existingCTEChangeEntry.getCompanyId(),
			newCTEChangeEntry.getCompanyId());
		Assert.assertEquals(existingCTEChangeEntry.getUserId(),
			newCTEChangeEntry.getUserId());
		Assert.assertEquals(existingCTEChangeEntry.getUserName(),
			newCTEChangeEntry.getUserName());
		Assert.assertEquals(Time.getShortTimestamp(
				existingCTEChangeEntry.getCreateDate()),
			Time.getShortTimestamp(newCTEChangeEntry.getCreateDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingCTEChangeEntry.getModifiedDate()),
			Time.getShortTimestamp(newCTEChangeEntry.getModifiedDate()));
		Assert.assertEquals(existingCTEChangeEntry.getClassNameId(),
			newCTEChangeEntry.getClassNameId());
		Assert.assertEquals(existingCTEChangeEntry.getClassPK(),
			newCTEChangeEntry.getClassPK());
		Assert.assertEquals(existingCTEChangeEntry.getResourcePrimKey(),
			newCTEChangeEntry.getResourcePrimKey());
	}

	@Test
	public void testCountByResourcePrimKey() throws Exception {
		_persistence.countByResourcePrimKey(RandomTestUtil.nextLong());

		_persistence.countByResourcePrimKey(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		CTEChangeEntry newCTEChangeEntry = addCTEChangeEntry();

		CTEChangeEntry existingCTEChangeEntry = _persistence.findByPrimaryKey(newCTEChangeEntry.getPrimaryKey());

		Assert.assertEquals(existingCTEChangeEntry, newCTEChangeEntry);
	}

	@Test(expected = NoSuchCTEChangeEntryException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<CTEChangeEntry> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("CTEChangeEntry",
			"cteChangeEntryId", true, "companyId", true, "userId", true,
			"userName", true, "createDate", true, "modifiedDate", true,
			"classNameId", true, "classPK", true, "resourcePrimKey", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		CTEChangeEntry newCTEChangeEntry = addCTEChangeEntry();

		CTEChangeEntry existingCTEChangeEntry = _persistence.fetchByPrimaryKey(newCTEChangeEntry.getPrimaryKey());

		Assert.assertEquals(existingCTEChangeEntry, newCTEChangeEntry);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CTEChangeEntry missingCTEChangeEntry = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCTEChangeEntry);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		CTEChangeEntry newCTEChangeEntry1 = addCTEChangeEntry();
		CTEChangeEntry newCTEChangeEntry2 = addCTEChangeEntry();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCTEChangeEntry1.getPrimaryKey());
		primaryKeys.add(newCTEChangeEntry2.getPrimaryKey());

		Map<Serializable, CTEChangeEntry> cteChangeEntries = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, cteChangeEntries.size());
		Assert.assertEquals(newCTEChangeEntry1,
			cteChangeEntries.get(newCTEChangeEntry1.getPrimaryKey()));
		Assert.assertEquals(newCTEChangeEntry2,
			cteChangeEntries.get(newCTEChangeEntry2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, CTEChangeEntry> cteChangeEntries = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(cteChangeEntries.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		CTEChangeEntry newCTEChangeEntry = addCTEChangeEntry();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCTEChangeEntry.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, CTEChangeEntry> cteChangeEntries = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, cteChangeEntries.size());
		Assert.assertEquals(newCTEChangeEntry,
			cteChangeEntries.get(newCTEChangeEntry.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, CTEChangeEntry> cteChangeEntries = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(cteChangeEntries.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		CTEChangeEntry newCTEChangeEntry = addCTEChangeEntry();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCTEChangeEntry.getPrimaryKey());

		Map<Serializable, CTEChangeEntry> cteChangeEntries = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, cteChangeEntries.size());
		Assert.assertEquals(newCTEChangeEntry,
			cteChangeEntries.get(newCTEChangeEntry.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = CTEChangeEntryLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<CTEChangeEntry>() {
				@Override
				public void performAction(CTEChangeEntry cteChangeEntry) {
					Assert.assertNotNull(cteChangeEntry);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		CTEChangeEntry newCTEChangeEntry = addCTEChangeEntry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(CTEChangeEntry.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("cteChangeEntryId",
				newCTEChangeEntry.getCteChangeEntryId()));

		List<CTEChangeEntry> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		CTEChangeEntry existingCTEChangeEntry = result.get(0);

		Assert.assertEquals(existingCTEChangeEntry, newCTEChangeEntry);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(CTEChangeEntry.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("cteChangeEntryId",
				RandomTestUtil.nextLong()));

		List<CTEChangeEntry> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		CTEChangeEntry newCTEChangeEntry = addCTEChangeEntry();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(CTEChangeEntry.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"cteChangeEntryId"));

		Object newCteChangeEntryId = newCTEChangeEntry.getCteChangeEntryId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("cteChangeEntryId",
				new Object[] { newCteChangeEntryId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCteChangeEntryId = result.get(0);

		Assert.assertEquals(existingCteChangeEntryId, newCteChangeEntryId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(CTEChangeEntry.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property(
				"cteChangeEntryId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("cteChangeEntryId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected CTEChangeEntry addCTEChangeEntry() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CTEChangeEntry cteChangeEntry = _persistence.create(pk);

		cteChangeEntry.setCompanyId(RandomTestUtil.nextLong());

		cteChangeEntry.setUserId(RandomTestUtil.nextLong());

		cteChangeEntry.setUserName(RandomTestUtil.randomString());

		cteChangeEntry.setCreateDate(RandomTestUtil.nextDate());

		cteChangeEntry.setModifiedDate(RandomTestUtil.nextDate());

		cteChangeEntry.setClassNameId(RandomTestUtil.nextLong());

		cteChangeEntry.setClassPK(RandomTestUtil.nextLong());

		cteChangeEntry.setResourcePrimKey(RandomTestUtil.nextLong());

		_cteChangeEntries.add(_persistence.update(cteChangeEntry));

		return cteChangeEntry;
	}

	private List<CTEChangeEntry> _cteChangeEntries = new ArrayList<CTEChangeEntry>();
	private CTEChangeEntryPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}