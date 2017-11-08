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

package com.liferay.exportimport.staging;

import aQute.bnd.annotation.ProviderType;

import com.liferay.exportimport.kernel.staging.Staging;
import com.liferay.exportimport.kernel.staging.StagingGroup;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.service.http.GroupServiceHttp;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Akos Thurzo
 */
@Component(immediate = true)
@ProviderType
public class StagingGroupImpl implements StagingGroup {

	@Override
	public Group getLiveGroup(Group group) throws PortalException {
		if (isLocalStagingGroup(group)) {
			return getLocalLiveGroup(group);
		}

		if (isRemoteStagingGroup(group)) {
			return getRemoteLiveGroup(group);
		}

		return null;
	}

	@Override
	public Group getLiveGroup(long groupId) throws PortalException {
		return getLiveGroup(_getGroup(groupId));
	}

	@Override
	public Group getLocalLiveGroup(Group group) throws PortalException {
		if (!isLocalStagingGroup(group)) {
			return null;
		}

		group = _getParentGroupForScopeGroup(group);

		return _groupLocalService.getGroup(group.getLiveGroupId());
	}

	@Override
	public Group getLocalLiveGroup(long groupId) throws PortalException {
		return getLocalLiveGroup(_getGroup(groupId));
	}

	@Override
	public Group getLocalStagingGroup(Group group) throws PortalException {
		if (!isLocalLiveGroup(group)) {
			return null;
		}

		group = _getParentGroupForScopeGroup(group);

		return _groupLocalService.getStagingGroup(group.getGroupId());
	}

	@Override
	public Group getLocalStagingGroup(long groupId) throws PortalException {
		return getLocalStagingGroup(_getGroup(groupId));
	}

	@Override
	public Group getRemoteLiveGroup(Group group) throws PortalException {
		if (!isRemoteStagingGroup(group)) {
			return null;
		}

		group = _getParentGroupForScopeGroup(group);

		PermissionChecker permissionChecker =
			PermissionThreadLocal.getPermissionChecker();

		User user = permissionChecker.getUser();

		String remoteURL = _staging.buildRemoteURL(
			group.getTypeSettingsProperties());

		HttpPrincipal httpPrincipal = new HttpPrincipal(
			remoteURL, user.getLogin(), user.getPassword(),
			user.getPasswordEncrypted());

		long remoteGroupId = GetterUtil.getLong(
			_getTypeSettingsProperty(group, "remoteGroupId"));

		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		try {
			currentThread.setContextClassLoader(
				PortalClassLoaderUtil.getClassLoader());

			return GroupServiceHttp.getGroup(httpPrincipal, remoteGroupId);
		}
		finally {
			currentThread.setContextClassLoader(contextClassLoader);
		}
	}

	@Override
	public Group getRemoteLiveGroup(long groupId) throws PortalException {
		return getRemoteLiveGroup(_getGroup(groupId));
	}

	@Override
	public boolean isLiveGroup(Group group) {
		if (isLocalLiveGroup(group) || isRemoteLiveGroup(group)) {
			return true;
		}

		return false;
	}

	@Override
	public boolean isLiveGroup(long groupId) throws PortalException {
		return isLiveGroup(_getGroup(groupId));
	}

	@Override
	public boolean isLocalLiveGroup(Group group) {
		group = _getParentGroupForScopeGroup(group);

		Group stagingGroup = _groupLocalService.fetchStagingGroup(
			group.getGroupId());

		if (stagingGroup == null) {
			return false;
		}

		return true;
	}

	@Override
	public boolean isLocalLiveGroup(long groupId) throws PortalException {
		return isLocalLiveGroup(_getGroup(groupId));
	}

	@Override
	public boolean isLocalStagingGroup(Group group) {
		group = _getParentGroupForScopeGroup(group);

		if (group.getLiveGroupId() == GroupConstants.DEFAULT_LIVE_GROUP_ID) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean isLocalStagingGroup(long groupId) throws PortalException {
		return isLocalStagingGroup(_getGroup(groupId));
	}

	@Override
	public boolean isLocalStagingOrLocalLiveGroup(Group group) {
		if (isLocalStagingGroup(group) || isLocalLiveGroup(group)) {
			return true;
		}

		return false;
	}

	@Override
	public boolean isLocalStagingOrLocalLiveGroup(long groupId)
		throws PortalException {

		return isLocalStagingOrLocalLiveGroup(_getGroup(groupId));
	}

	@Override
	public boolean isRemoteLiveGroup(Group group) {
		group = _getParentGroupForScopeGroup(group);

		if (group.getRemoteStagingGroupCount() > 0) {
			return true;
		}

		return false;
	}

	@Override
	public boolean isRemoteLiveGroup(long groupId) throws PortalException {
		return isRemoteLiveGroup(_getGroup(groupId));
	}

	@Override
	public boolean isRemoteStagingGroup(Group group) {
		group = _getParentGroupForScopeGroup(group);

		return GetterUtil.getBoolean(
			_getTypeSettingsProperty(group, "stagedRemotely"));
	}

	@Override
	public boolean isRemoteStagingGroup(long groupId) throws PortalException {
		return isRemoteStagingGroup(_getGroup(groupId));
	}

	@Override
	public boolean isRemoteStagingOrRemoteLiveGroup(Group group) {
		if (isRemoteStagingGroup(group) || isRemoteLiveGroup(group)) {
			return true;
		}

		return false;
	}

	@Override
	public boolean isRemoteStagingOrRemoteLiveGroup(long groupId)
		throws PortalException {

		return isRemoteStagingOrRemoteLiveGroup(_getGroup(groupId));
	}

	@Override
	public boolean isStagingGroup(Group group) {
		if (isLocalStagingGroup(group) || isRemoteStagingGroup(group)) {
			return true;
		}

		return false;
	}

	@Override
	public boolean isStagingGroup(long groupId) throws PortalException {
		return isStagingGroup(_getGroup(groupId));
	}

	@Override
	public boolean isStagingOrLiveGroup(Group group) {
		if (isStagingGroup(group) || isLiveGroup(group)) {
			return true;
		}

		return false;
	}

	@Override
	public boolean isStagingOrLiveGroup(long groupId) throws PortalException {
		return isStagingOrLiveGroup(_getGroup(groupId));
	}

	private Group _getGroup(long groupId) throws PortalException {
		return _groupLocalService.getGroup(groupId);
	}

	private Group _getParentGroupForScopeGroup(Group group) {
		if (group.isLayout()) {
			return group.getParentGroup();
		}

		return group;
	}

	private String _getTypeSettingsProperty(Group group, String key) {
		UnicodeProperties typeSettingsProperties =
			group.getTypeSettingsProperties();

		return typeSettingsProperties.getProperty(key);
	}

	@Reference
	private GroupLocalService _groupLocalService;

	@Reference
	private Staging _staging;

}