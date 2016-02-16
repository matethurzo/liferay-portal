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

package com.liferay.exportimport.lifecycle;

import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLFileEntryTypeLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.Validator;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;

import org.osgi.service.component.annotations.Reference;

/**
 * @author Adorjan Nagy
 * @author Gergely Mathe
 */
public class CascadeFileEntryTypesCallable implements Callable<Void> {

	public CascadeFileEntryTypesCallable(Collection<Long> folderIds) {
		_folderIds = folderIds;
	}

	@Override
	public Void call() throws PortalException {
		for (Long newFolderId : _folderIds) {
			DLFolder newFolder = DLFolderLocalServiceUtil.fetchDLFolder(
				newFolderId);

			DLFolder rootFolder = getProcessableRootFolder(newFolder);

			if (Validator.isNotNull(rootFolder)) {
				DLFileEntryTypeLocalServiceUtil.cascadeFileEntryTypes(
					rootFolder.getUserId(), rootFolder);
			}
		}

		return null;
	}

	protected DLFolder getProcessableRootFolder(DLFolder folder)
		throws PortalException {

		if (_processedFolderIds.contains(folder.getFolderId())) {
			return null;
		}

		_processedFolderIds.add(folder.getFolderId());

		DLFolder parentFolder = folder.getParentFolder();

		if (Validator.isNull(parentFolder)) {
			return folder;
		}

		return getProcessableRootFolder(parentFolder);
	}

	private final Collection<Long> _folderIds;
	private final Set<Long> _processedFolderIds = new HashSet<>();

}