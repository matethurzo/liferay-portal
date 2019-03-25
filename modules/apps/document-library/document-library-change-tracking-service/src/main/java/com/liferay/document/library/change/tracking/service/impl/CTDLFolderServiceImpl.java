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

package com.liferay.document.library.change.tracking.service.impl;

import com.liferay.document.library.change.tracking.service.base.CTDLFolderServiceBaseImpl;
import com.liferay.document.library.change.tracking.service.persistence.CTDLFolderFinderOverride;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryDefinition;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionHelper;

import java.util.Collections;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Luiz Marins
 */
@Component(
	property = {
		"json.web.service.context.name=ct",
		"json.web.service.context.path=CTDLFolder"
	},
	service = AopService.class
)
public class CTDLFolderServiceImpl extends CTDLFolderServiceBaseImpl {

	@Override
	public List<Object> getFoldersAndFileEntriesAndFileShortcuts(
			long groupId, long folderId, String[] mimeTypes,
			boolean includeMountFolders, QueryDefinition<?> queryDefinition)
		throws PortalException {

		if (queryDefinition.isIncludeOwner() &&
			(queryDefinition.getOwnerUserId() != 0)) {

			queryDefinition.setOwnerUserId(getUserId());
		}

		if (!ModelResourcePermissionHelper.contains(
				_dlFolderModelResourcePermission, getPermissionChecker(),
				groupId, folderId, ActionKeys.VIEW)) {

			return Collections.emptyList();
		}

		return _dlFolderFinder.filterFindF_FE_FS_ByG_F_M_M(
			groupId, folderId, mimeTypes, includeMountFolders, queryDefinition);
	}

	@Override
	public int getFoldersAndFileEntriesAndFileShortcutsCount(
			long groupId, long folderId, String[] mimeTypes,
			boolean includeMountFolders, QueryDefinition<?> queryDefinition)
		throws PortalException {

		if (!ModelResourcePermissionHelper.contains(
				_dlFolderModelResourcePermission, getPermissionChecker(),
				groupId, folderId, ActionKeys.VIEW)) {

			return 0;
		}

		if (queryDefinition.isIncludeOwner() &&
			(queryDefinition.getOwnerUserId() != 0)) {

			queryDefinition.setOwnerUserId(getUserId());
		}

		return _dlFolderFinder.filterCountF_FE_FS_ByG_F_M_M(
			groupId, folderId, mimeTypes, includeMountFolders, queryDefinition);
	}

	private static volatile ModelResourcePermission<DLFolder>
		_dlFolderModelResourcePermission =
			ModelResourcePermissionFactory.getInstance(
				CTDLFolderServiceImpl.class, "_dlFolderModelResourcePermission",
				DLFolder.class);

	@Reference
	private CTDLFolderFinderOverride _dlFolderFinder;

}