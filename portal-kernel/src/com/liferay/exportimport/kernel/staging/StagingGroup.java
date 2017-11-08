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

/**
 * @author Akos Thurzo
 */
@ProviderType
public interface StagingGroup {

	public Group getLiveGroup(Group group) throws PortalException;

	public Group getLiveGroup(long groupId) throws PortalException;

	public Group getLocalLiveGroup(Group group) throws PortalException;

	public Group getLocalLiveGroup(long groupId) throws PortalException;

	public Group getLocalStagingGroup(Group group) throws PortalException;

	public Group getLocalStagingGroup(long groupId) throws PortalException;

	public Group getRemoteLiveGroup(Group group) throws PortalException;

	public Group getRemoteLiveGroup(long groupId) throws PortalException;

	public boolean isLiveGroup(Group group);

	public boolean isLiveGroup(long groupId) throws PortalException;

	public boolean isLocalLiveGroup(Group group);

	public boolean isLocalLiveGroup(long groupId) throws PortalException;

	public boolean isLocalStagingGroup(Group group);

	public boolean isLocalStagingGroup(long groupId) throws PortalException;

	public boolean isLocalStagingOrLocalLiveGroup(Group group);

	public boolean isLocalStagingOrLocalLiveGroup(long groupId)
		throws PortalException;

	public boolean isRemoteLiveGroup(Group group);

	public boolean isRemoteLiveGroup(long groupId) throws PortalException;

	public boolean isRemoteStagingGroup(Group group);

	public boolean isRemoteStagingGroup(long groupId) throws PortalException;

	public boolean isRemoteStagingOrRemoteLiveGroup(Group group);

	public boolean isRemoteStagingOrRemoteLiveGroup(long groupId)
		throws PortalException;

	public boolean isStagingGroup(Group group);

	public boolean isStagingGroup(long groupId) throws PortalException;

	public boolean isStagingOrLiveGroup(Group group);

	public boolean isStagingOrLiveGroup(long groupId) throws PortalException;

}