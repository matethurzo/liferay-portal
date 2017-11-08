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

package com.liferay.exportimport.kernel.staging;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.util.ServiceProxyFactory;

/**
 * @author Akos Thurzo
 */
@ProviderType
public class StagingGroupUtil {

	public static Group getLiveGroup(Group group) throws PortalException {
		return _stagingGroup.getLiveGroup(group);
	}

	public static Group getLiveGroup(long groupId) throws PortalException {
		return _stagingGroup.getLiveGroup(groupId);
	}

	public static Group getLocalLiveGroup(Group group) throws PortalException {
		return _stagingGroup.getLocalLiveGroup(group);
	}

	public static Group getLocalLiveGroup(long groupId) throws PortalException {
		return _stagingGroup.getLocalLiveGroup(groupId);
	}

	public static Group getLocalStagingGroup(Group group)
		throws PortalException {

		return _stagingGroup.getLocalStagingGroup(group);
	}

	public static Group getLocalStagingGroup(long groupId)
		throws PortalException {

		return _stagingGroup.getLocalStagingGroup(groupId);
	}

	public static Group getRemoteLiveGroup(Group group) throws PortalException {
		return _stagingGroup.getRemoteLiveGroup(group);
	}

	public static Group getRemoteLiveGroup(long groupId)
		throws PortalException {

		return _stagingGroup.getRemoteLiveGroup(groupId);
	}

	public static boolean isLiveGroup(Group group) {
		return _stagingGroup.isLiveGroup(group);
	}

	public static boolean isLiveGroup(long groupId) throws PortalException {
		return _stagingGroup.isLiveGroup(groupId);
	}

	public static boolean isLocalLiveGroup(Group group) {
		return _stagingGroup.isLocalLiveGroup(group);
	}

	public static boolean isLocalLiveGroup(long groupId)
		throws PortalException {

		return _stagingGroup.isLocalLiveGroup(groupId);
	}

	public static boolean isLocalStagingGroup(Group group) {
		return _stagingGroup.isLocalStagingGroup(group);
	}

	public static boolean isLocalStagingGroup(long groupId)
		throws PortalException {

		return _stagingGroup.isLocalStagingGroup(groupId);
	}

	public static boolean isLocalStagingOrLocalLiveGroup(Group group) {
		return _stagingGroup.isLocalStagingOrLocalLiveGroup(group);
	}

	public static boolean isLocalStagingOrLocalLiveGroup(long groupId)
		throws PortalException {

		return _stagingGroup.isLocalStagingOrLocalLiveGroup(groupId);
	}

	public static boolean isRemoteLiveGroup(Group group) {
		return _stagingGroup.isRemoteLiveGroup(group);
	}

	public static boolean isRemoteLiveGroup(long groupId)
		throws PortalException {

		return _stagingGroup.isRemoteLiveGroup(groupId);
	}

	public static boolean isRemoteStagingGroup(Group group) {
		return _stagingGroup.isRemoteStagingGroup(group);
	}

	public static boolean isRemoteStagingGroup(long groupId)
		throws PortalException {

		return _stagingGroup.isRemoteStagingGroup(groupId);
	}

	public static boolean isRemoteStagingOrRemoteLiveGroup(Group group) {
		return _stagingGroup.isRemoteStagingOrRemoteLiveGroup(group);
	}

	public static boolean isRemoteStagingOrRemoteLiveGroup(long groupId)
		throws PortalException {

		return _stagingGroup.isRemoteStagingOrRemoteLiveGroup(groupId);
	}

	public static boolean isStagingGroup(Group group) {
		return _stagingGroup.isStagingGroup(group);
	}

	public static boolean isStagingGroup(long groupId) throws PortalException {
		return _stagingGroup.isStagingGroup(groupId);
	}

	public static boolean isStagingOrLiveGroup(Group group) {
		return _stagingGroup.isStagingOrLiveGroup(group);
	}

	public static boolean isStagingOrLiveGroup(long groupId)
		throws PortalException {

		return _stagingGroup.isStagingOrLiveGroup(groupId);
	}

	private static volatile StagingGroup _stagingGroup =
		ServiceProxyFactory.newServiceTrackedInstance(
			StagingGroup.class, StagingGroupUtil.class, "_stagingGroup", false);

}