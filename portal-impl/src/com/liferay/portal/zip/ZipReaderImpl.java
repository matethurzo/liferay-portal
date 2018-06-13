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

package com.liferay.portal.zip;

import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.SortedArrayList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.zip.ZipReader;

import de.schlichtherle.io.File;

import java.io.IOException;
import java.io.InputStream;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @author Raymond Augé
 */
public class ZipReaderImpl implements ZipReader {

	public ZipReaderImpl(InputStream inputStream) throws IOException {
		java.io.File tempFile = FileUtil.createTempFile(inputStream);

		_zipFile = new ZipFile(tempFile);
	}

	public ZipReaderImpl(java.io.File file) {
		try {
			_zipFile = new ZipFile(file);
		}
		catch (IOException ioe) {
			_log.error(ioe, ioe);
		}
	}

	@Override
	public void close() {
		try {
			_zipFile.close();
		}
		catch (IOException ioe) {
			if (_log.isWarnEnabled()) {
				_log.warn(ioe, ioe);
			}
		}
	}

	@Override
	public List<String> getEntries() {
		_initEntriesByFolder();

		List<String> allEntries = new SortedArrayList<>();

		for (List<String> folderEntries : _entriesByFolder.values()) {
			allEntries.addAll(folderEntries);
		}

		return allEntries;
	}

	@Override
	public byte[] getEntryAsByteArray(String name) {
		if (Validator.isNull(name)) {
			return null;
		}

		byte[] bytes = null;

		try {
			InputStream is = getEntryAsInputStream(name);

			if (is != null) {
				bytes = FileUtil.getBytes(is);
			}
		}
		catch (IOException ioe) {
			_log.error(ioe, ioe);
		}

		return bytes;
	}

	@Override
	public InputStream getEntryAsInputStream(String name) {
		if ((_zipFile == null) || Validator.isNull(name)) {
			return null;
		}

		if (name.startsWith(StringPool.SLASH)) {
			name = name.substring(1);
		}

		ZipEntry zipEntry = _zipFile.getEntry(name);

		try {
			if ((zipEntry != null) && !zipEntry.isDirectory()) {
				if (_log.isDebugEnabled()) {
					_log.debug("Extracting " + name);
				}

				return _zipFile.getInputStream(zipEntry);
			}
		}
		catch (IOException ioe) {
			_log.error(ioe, ioe);
		}

		return null;
	}

	@Override
	public String getEntryAsString(String name) {
		if ((_zipFile == null) || Validator.isNull(name)) {
			return null;
		}

		byte[] bytes = getEntryAsByteArray(name);

		if (bytes != null) {
			return new String(bytes);
		}

		return null;
	}

	@Override
	public List<String> getFolderEntries(String path) {
		if ((_zipFile == null) || Validator.isNull(path)) {
			return Collections.emptyList();
		}

		_initEntriesByFolder();

		while (path.startsWith(StringPool.SLASH)) {
			path = path.substring(1);
		}

		Path javaPath = Paths.get(path);

		javaPath = javaPath.normalize();

		path = javaPath.toString();

		List<String> folderEntries = _entriesByFolder.get(path);

		if (folderEntries == null) {
			return Collections.emptyList();
		}

		return ListUtil.copy(folderEntries);
	}

	protected void processDirectory(
		File directory, List<String> folderEntries) {

		File[] files = (File[])directory.listFiles();

		for (File file : files) {
			if (!file.isDirectory()) {
				folderEntries.add(file.getEnclEntryName());
			}
			else {
				processDirectory(file, folderEntries);
			}
		}
	}

	private void _initEntriesByFolder() {
		if (_entriesByFolder != null) {
			return;
		}

		_entriesByFolder = new HashMap<>();

		Enumeration<? extends ZipEntry> zipEntries = _zipFile.entries();

		while (zipEntries.hasMoreElements()) {
			ZipEntry zipEntry = zipEntries.nextElement();

			if (zipEntry.isDirectory()) {
				continue;
			}

			String fileName = zipEntry.getName();

			int pos = fileName.lastIndexOf(CharPool.SLASH);

			String folderName = StringPool.BLANK;

			if (pos > 0) {
				folderName = fileName.substring(0, pos);
			}

			List<String> folderZipEntries = _entriesByFolder.get(folderName);

			if (folderZipEntries == null) {
				folderZipEntries = new SortedArrayList<>();

				_entriesByFolder.put(folderName, folderZipEntries);
			}

			folderZipEntries.add(fileName);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(ZipReaderImpl.class);

	private Map<String, List<String>> _entriesByFolder;
	private ZipFile _zipFile;

}