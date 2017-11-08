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

package com.liferay.staging.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.exportimport.kernel.service.StagingLocalServiceUtil;
import com.liferay.exportimport.kernel.staging.StagingGroupUtil;
import com.liferay.portal.kernel.exception.NoSuchGroupException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.persistence.GroupUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.Sync;
import com.liferay.portal.kernel.test.rule.SynchronousDestinationTestRule;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.service.test.ServiceTestUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.util.PropsValues;
import com.liferay.portal.util.test.LayoutTestUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Akos Thurzo
 */
@RunWith(Arquillian.class)
@Sync(cleanTransaction = true)
public class StagingGroupTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(),
			SynchronousDestinationTestRule.INSTANCE);

	@Before
	public void setUp() throws Exception {
		_addLocalStagingGroups();

		_addRemoteStagingGroups();

		_localLiveScopeGroup = _addScopeGroup(_localLiveGroup);
		_localStagingScopeGroup = _addScopeGroup(_localStagingGroup);
		_remoteLiveScopeGroup = _addScopeGroup(_remoteLiveGroup);
		_remoteStagingScopeGroup = _addScopeGroup(_remoteStagingGroup);

		_regularGroup = GroupTestUtil.addGroup();
	}

	@After
	public void tearDown() throws Exception {
		try {
			GroupLocalServiceUtil.deleteGroup(_localLiveGroup.getGroupId());
		}
		catch (NoSuchGroupException nsge) {
		}

		try {
			GroupLocalServiceUtil.deleteGroup(_localStagingGroup.getGroupId());
		}
		catch (NoSuchGroupException nsge) {
		}

		try {
			GroupLocalServiceUtil.deleteGroup(_regularGroup.getGroupId());
		}
		catch (NoSuchGroupException nsge) {
		}

		try {
			GroupLocalServiceUtil.deleteGroup(_remoteLiveGroup.getGroupId());
		}
		catch (NoSuchGroupException nsge) {
		}

		try {
			GroupLocalServiceUtil.deleteGroup(_remoteStagingGroup.getGroupId());
		}
		catch (NoSuchGroupException nsge) {
		}
	}

	@Test
	public void testGetLiveGroup() throws Exception {
		Assert.assertEquals(
			_localLiveGroup, StagingGroupUtil.getLiveGroup(_localStagingGroup));
		Assert.assertEquals(
			_localLiveGroup,
			StagingGroupUtil.getLiveGroup(_localStagingScopeGroup));

		Assert.assertNull(StagingGroupUtil.getLiveGroup(_localLiveGroup));
		Assert.assertNull(StagingGroupUtil.getLiveGroup(_localLiveScopeGroup));

		Assert.assertEquals(
			_remoteLiveGroup,
			StagingGroupUtil.getLiveGroup(_remoteStagingGroup));
		Assert.assertEquals(
			_remoteLiveGroup,
			StagingGroupUtil.getLiveGroup(_remoteStagingScopeGroup));

		Assert.assertNull(StagingGroupUtil.getLiveGroup(_remoteLiveGroup));
		Assert.assertNull(StagingGroupUtil.getLiveGroup(_remoteLiveScopeGroup));

		Assert.assertNull(StagingGroupUtil.getLiveGroup(_regularGroup));
	}

	@Test
	public void testGetLocalLiveGroup() throws Exception {
		Assert.assertEquals(
			_localLiveGroup,
			StagingGroupUtil.getLocalLiveGroup(_localStagingGroup));
		Assert.assertEquals(
			_localLiveGroup,
			StagingGroupUtil.getLocalLiveGroup(_localStagingScopeGroup));

		Assert.assertNull(StagingGroupUtil.getLocalLiveGroup(_localLiveGroup));
		Assert.assertNull(
			StagingGroupUtil.getLocalLiveGroup(_localLiveScopeGroup));

		Assert.assertNull(
			StagingGroupUtil.getLocalLiveGroup(_remoteStagingGroup));
		Assert.assertNull(
			StagingGroupUtil.getLocalLiveGroup(_remoteStagingScopeGroup));

		Assert.assertNull(StagingGroupUtil.getLocalLiveGroup(_remoteLiveGroup));
		Assert.assertNull(
			StagingGroupUtil.getLocalLiveGroup(_remoteLiveScopeGroup));

		Assert.assertNull(StagingGroupUtil.getLocalLiveGroup(_regularGroup));
	}

	@Test
	public void testGetLocalStagingGroup() throws Exception {
		Assert.assertNull(
			StagingGroupUtil.getLocalStagingGroup(_localStagingGroup));
		Assert.assertNull(
			StagingGroupUtil.getLocalStagingGroup(_localStagingScopeGroup));

		Assert.assertEquals(
			_localStagingGroup,
			StagingGroupUtil.getLocalStagingGroup(_localLiveGroup));
		Assert.assertEquals(
			_localStagingGroup,
			StagingGroupUtil.getLocalStagingGroup(_localLiveScopeGroup));

		Assert.assertNull(
			StagingGroupUtil.getLocalStagingGroup(_remoteStagingGroup));
		Assert.assertNull(
			StagingGroupUtil.getLocalStagingGroup(_remoteStagingScopeGroup));

		Assert.assertNull(
			StagingGroupUtil.getLocalStagingGroup(_remoteLiveGroup));
		Assert.assertNull(
			StagingGroupUtil.getLocalStagingGroup(_remoteLiveScopeGroup));

		Assert.assertNull(StagingGroupUtil.getLocalStagingGroup(_regularGroup));
	}

	@Test
	public void testGetRemoteLiveGroup() throws Exception {
		Assert.assertNull(
			StagingGroupUtil.getRemoteLiveGroup(_localStagingGroup));
		Assert.assertNull(
			StagingGroupUtil.getRemoteLiveGroup(_localStagingScopeGroup));

		Assert.assertNull(StagingGroupUtil.getRemoteLiveGroup(_localLiveGroup));
		Assert.assertNull(
			StagingGroupUtil.getRemoteLiveGroup(_localLiveScopeGroup));

		Assert.assertEquals(
			_remoteLiveGroup,
			StagingGroupUtil.getRemoteLiveGroup(_remoteStagingGroup));
		Assert.assertEquals(
			_remoteLiveGroup,
			StagingGroupUtil.getRemoteLiveGroup(_remoteStagingScopeGroup));

		Assert.assertNull(
			StagingGroupUtil.getRemoteLiveGroup(_remoteLiveGroup));
		Assert.assertNull(
			StagingGroupUtil.getRemoteLiveGroup(_remoteLiveScopeGroup));

		Assert.assertNull(StagingGroupUtil.getRemoteLiveGroup(_regularGroup));
	}

	@Test
	public void testIsLiveGroup() {
		Assert.assertFalse(StagingGroupUtil.isLiveGroup(_localStagingGroup));
		Assert.assertFalse(
			StagingGroupUtil.isLiveGroup(_localStagingScopeGroup));

		Assert.assertTrue(StagingGroupUtil.isLiveGroup(_localLiveGroup));
		Assert.assertTrue(StagingGroupUtil.isLiveGroup(_localLiveScopeGroup));

		Assert.assertFalse(StagingGroupUtil.isLiveGroup(_remoteStagingGroup));
		Assert.assertFalse(
			StagingGroupUtil.isLiveGroup(_remoteStagingScopeGroup));

		Assert.assertTrue(StagingGroupUtil.isLiveGroup(_remoteLiveGroup));
		Assert.assertTrue(StagingGroupUtil.isLiveGroup(_remoteLiveScopeGroup));

		Assert.assertFalse(StagingGroupUtil.isLiveGroup(_regularGroup));
	}

	@Test
	public void testIsLocalLiveGroup() {
		Assert.assertFalse(
			StagingGroupUtil.isLocalLiveGroup(_localStagingGroup));
		Assert.assertFalse(
			StagingGroupUtil.isLocalLiveGroup(_localStagingScopeGroup));

		Assert.assertTrue(StagingGroupUtil.isLocalLiveGroup(_localLiveGroup));
		Assert.assertTrue(
			StagingGroupUtil.isLocalLiveGroup(_localLiveScopeGroup));

		Assert.assertFalse(
			StagingGroupUtil.isLocalLiveGroup(_remoteStagingGroup));
		Assert.assertFalse(
			StagingGroupUtil.isLocalLiveGroup(_remoteStagingScopeGroup));

		Assert.assertFalse(StagingGroupUtil.isLocalLiveGroup(_remoteLiveGroup));
		Assert.assertFalse(
			StagingGroupUtil.isLocalLiveGroup(_remoteLiveScopeGroup));

		Assert.assertFalse(StagingGroupUtil.isLocalLiveGroup(_regularGroup));
	}

	@Test
	public void testIsLocalStagingGroup() {
		Assert.assertTrue(
			StagingGroupUtil.isLocalStagingGroup(_localStagingGroup));
		Assert.assertTrue(
			StagingGroupUtil.isLocalStagingGroup(_localStagingScopeGroup));

		Assert.assertFalse(
			StagingGroupUtil.isLocalStagingGroup(_localLiveGroup));
		Assert.assertFalse(
			StagingGroupUtil.isLocalStagingGroup(_localLiveScopeGroup));

		Assert.assertFalse(
			StagingGroupUtil.isLocalStagingGroup(_remoteStagingGroup));
		Assert.assertFalse(
			StagingGroupUtil.isLocalStagingGroup(_remoteStagingScopeGroup));

		Assert.assertFalse(
			StagingGroupUtil.isLocalStagingGroup(_remoteLiveGroup));
		Assert.assertFalse(
			StagingGroupUtil.isLocalStagingGroup(_remoteLiveScopeGroup));

		Assert.assertFalse(StagingGroupUtil.isLocalStagingGroup(_regularGroup));
	}

	@Test
	public void testIsLocalStagingOrLocalLiveGroup() {
		Assert.assertTrue(
			StagingGroupUtil.isLocalStagingOrLocalLiveGroup(
				_localStagingGroup));
		Assert.assertTrue(
			StagingGroupUtil.isLocalStagingOrLocalLiveGroup(
				_localStagingScopeGroup));

		Assert.assertTrue(
			StagingGroupUtil.isLocalStagingOrLocalLiveGroup(_localLiveGroup));
		Assert.assertTrue(
			StagingGroupUtil.isLocalStagingOrLocalLiveGroup(
				_localLiveScopeGroup));

		Assert.assertFalse(
			StagingGroupUtil.isLocalStagingOrLocalLiveGroup(
				_remoteStagingGroup));
		Assert.assertFalse(
			StagingGroupUtil.isLocalStagingOrLocalLiveGroup(
				_remoteStagingScopeGroup));

		Assert.assertFalse(
			StagingGroupUtil.isLocalStagingOrLocalLiveGroup(_remoteLiveGroup));
		Assert.assertFalse(
			StagingGroupUtil.isLocalStagingOrLocalLiveGroup(
				_remoteLiveScopeGroup));

		Assert.assertFalse(
			StagingGroupUtil.isLocalStagingOrLocalLiveGroup(_regularGroup));
	}

	@Test
	public void testIsRemoteLiveGroup() {
		Assert.assertFalse(
			StagingGroupUtil.isRemoteLiveGroup(_localStagingGroup));
		Assert.assertFalse(
			StagingGroupUtil.isRemoteLiveGroup(_localStagingScopeGroup));

		Assert.assertFalse(StagingGroupUtil.isRemoteLiveGroup(_localLiveGroup));
		Assert.assertFalse(
			StagingGroupUtil.isRemoteLiveGroup(_localLiveScopeGroup));

		Assert.assertFalse(
			StagingGroupUtil.isRemoteLiveGroup(_remoteStagingGroup));
		Assert.assertFalse(
			StagingGroupUtil.isRemoteLiveGroup(_remoteStagingScopeGroup));

		Assert.assertTrue(StagingGroupUtil.isRemoteLiveGroup(_remoteLiveGroup));
		Assert.assertTrue(
			StagingGroupUtil.isRemoteLiveGroup(_remoteLiveScopeGroup));

		Assert.assertFalse(StagingGroupUtil.isRemoteLiveGroup(_regularGroup));
	}

	@Test
	public void testIsRemoteStagingGroup() {
		Assert.assertFalse(
			StagingGroupUtil.isRemoteStagingGroup(_localStagingGroup));
		Assert.assertFalse(
			StagingGroupUtil.isRemoteStagingGroup(_localStagingScopeGroup));

		Assert.assertFalse(
			StagingGroupUtil.isRemoteStagingGroup(_localLiveGroup));
		Assert.assertFalse(
			StagingGroupUtil.isRemoteStagingGroup(_localLiveScopeGroup));

		Assert.assertTrue(
			StagingGroupUtil.isRemoteStagingGroup(_remoteStagingGroup));
		Assert.assertTrue(
			StagingGroupUtil.isRemoteStagingGroup(_remoteStagingScopeGroup));

		Assert.assertFalse(
			StagingGroupUtil.isRemoteStagingGroup(_remoteLiveGroup));
		Assert.assertFalse(
			StagingGroupUtil.isRemoteStagingGroup(_remoteLiveScopeGroup));

		Assert.assertFalse(
			StagingGroupUtil.isRemoteStagingGroup(_regularGroup));
	}

	@Test
	public void testIsRemoteStagingOrRemoteLiveGroup() {
		Assert.assertFalse(
			StagingGroupUtil.isRemoteStagingOrRemoteLiveGroup(
				_localStagingGroup));
		Assert.assertFalse(
			StagingGroupUtil.isRemoteStagingOrRemoteLiveGroup(
				_localStagingScopeGroup));

		Assert.assertFalse(
			StagingGroupUtil.isRemoteStagingOrRemoteLiveGroup(_localLiveGroup));
		Assert.assertFalse(
			StagingGroupUtil.isRemoteStagingOrRemoteLiveGroup(
				_localLiveScopeGroup));

		Assert.assertTrue(
			StagingGroupUtil.isRemoteStagingOrRemoteLiveGroup(
				_remoteStagingGroup));
		Assert.assertTrue(
			StagingGroupUtil.isRemoteStagingOrRemoteLiveGroup(
				_remoteStagingScopeGroup));

		Assert.assertTrue(
			StagingGroupUtil.isRemoteStagingOrRemoteLiveGroup(
				_remoteLiveGroup));
		Assert.assertTrue(
			StagingGroupUtil.isRemoteStagingOrRemoteLiveGroup(
				_remoteLiveScopeGroup));

		Assert.assertFalse(
			StagingGroupUtil.isRemoteStagingOrRemoteLiveGroup(_regularGroup));
	}

	@Test
	public void testIsStagingGroup() {
		Assert.assertTrue(StagingGroupUtil.isStagingGroup(_localStagingGroup));
		Assert.assertTrue(
			StagingGroupUtil.isStagingGroup(_localStagingScopeGroup));

		Assert.assertFalse(StagingGroupUtil.isStagingGroup(_localLiveGroup));
		Assert.assertFalse(
			StagingGroupUtil.isStagingGroup(_localLiveScopeGroup));

		Assert.assertTrue(StagingGroupUtil.isStagingGroup(_remoteStagingGroup));
		Assert.assertTrue(
			StagingGroupUtil.isStagingGroup(_remoteStagingScopeGroup));

		Assert.assertFalse(StagingGroupUtil.isStagingGroup(_remoteLiveGroup));
		Assert.assertFalse(
			StagingGroupUtil.isStagingGroup(_remoteLiveScopeGroup));

		Assert.assertFalse(StagingGroupUtil.isStagingGroup(_regularGroup));
	}

	@Test
	public void testIsStagingOrLiveGroup() {
		Assert.assertTrue(
			StagingGroupUtil.isStagingOrLiveGroup(_localStagingGroup));
		Assert.assertTrue(
			StagingGroupUtil.isStagingOrLiveGroup(_localStagingScopeGroup));

		Assert.assertTrue(
			StagingGroupUtil.isStagingOrLiveGroup(_localLiveGroup));
		Assert.assertTrue(
			StagingGroupUtil.isStagingOrLiveGroup(_localLiveScopeGroup));

		Assert.assertTrue(
			StagingGroupUtil.isStagingOrLiveGroup(_remoteStagingGroup));
		Assert.assertTrue(
			StagingGroupUtil.isStagingOrLiveGroup(_remoteStagingScopeGroup));

		Assert.assertTrue(
			StagingGroupUtil.isStagingOrLiveGroup(_remoteLiveGroup));
		Assert.assertTrue(
			StagingGroupUtil.isStagingOrLiveGroup(_remoteLiveScopeGroup));

		Assert.assertFalse(
			StagingGroupUtil.isStagingOrLiveGroup(_regularGroup));
	}

	private void _addLocalStagingGroups() throws Exception {
		_localLiveGroup = GroupTestUtil.addGroup();

		StagingLocalServiceUtil.enableLocalStaging(
			TestPropsValues.getUserId(), _localLiveGroup, false, false,
			new ServiceContext());

		_localStagingGroup = GroupLocalServiceUtil.getStagingGroup(
			_localLiveGroup.getGroupId());

		Assert.assertTrue(_localStagingGroup != null);
	}

	private void _addRemoteStagingGroups() throws Exception {
		_remoteLiveGroup = GroupTestUtil.addGroup();
		_remoteStagingGroup = GroupTestUtil.addGroup();

		_setPortalProperty(
			"TUNNELING_SERVLET_SHARED_SECRET",
			"F0E1D2C3B4A5968778695A4B3C2D1E0F");

		_setPortalProperty("TUNNELING_SERVLET_SHARED_SECRET_HEX", true);

		int serverPort = PortalUtil.getPortalServerPort(false);
		String pathContext = PortalUtil.getPathContext();

		ServiceTestUtil.setUser(TestPropsValues.getUser());

		StagingLocalServiceUtil.enableRemoteStaging(
			TestPropsValues.getUserId(), _remoteStagingGroup, false, false,
			"localhost", serverPort, pathContext, false,
			_remoteLiveGroup.getGroupId(), new ServiceContext());

		GroupUtil.clearCache();

		_remoteLiveGroup = GroupLocalServiceUtil.getGroup(
			_remoteLiveGroup.getGroupId());
	}

	private Group _addScopeGroup(Group group) throws Exception {
		Layout layout = LayoutTestUtil.addLayout(group);

		Map<Locale, String> nameMap = new HashMap<>();

		nameMap.put(LocaleUtil.getDefault(), String.valueOf(layout.getPlid()));

		return GroupLocalServiceUtil.addGroup(
			TestPropsValues.getUserId(), GroupConstants.DEFAULT_PARENT_GROUP_ID,
			Layout.class.getName(), layout.getPlid(),
			GroupConstants.DEFAULT_LIVE_GROUP_ID, nameMap, null, 0, true,
			GroupConstants.DEFAULT_MEMBERSHIP_RESTRICTION, null, false, true,
			null);
	}

	private void _setPortalProperty(String propertyName, Object value)
		throws Exception {

		Field field = ReflectionUtil.getDeclaredField(
			PropsValues.class, propertyName);

		field.setAccessible(true);

		Field modifiersField = Field.class.getDeclaredField("modifiers");

		modifiersField.setAccessible(true);
		modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

		field.set(null, value);
	}

	private Group _localLiveGroup;
	private Group _localLiveScopeGroup;
	private Group _localStagingGroup;
	private Group _localStagingScopeGroup;
	private Group _regularGroup;
	private Group _remoteLiveGroup;
	private Group _remoteLiveScopeGroup;
	private Group _remoteStagingGroup;
	private Group _remoteStagingScopeGroup;

}