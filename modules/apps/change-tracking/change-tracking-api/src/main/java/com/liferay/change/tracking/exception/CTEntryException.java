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

package com.liferay.change.tracking.exception;

/**
 * @author Gergely Mathe
 */
public class CTEntryException extends CTException {

	public CTEntryException(
		long ctEntryId, long companyId, long userId, long classNameId,
		long classPK, long resourcePrimKey, long ctCollectionId) {

		super(companyId);

		_ctEntryId = ctEntryId;
		_userId = userId;
		_classNameId = classNameId;
		_classPK = classPK;
		_resourcePrimKey = resourcePrimKey;
		_ctCollectionId = ctCollectionId;
	}

	public CTEntryException(
		long ctEntryId, long companyId, long userId, long classNameId,
		long classPK, long resourcePrimKey, long ctCollectionId, String msg) {

		super(companyId, msg);

		_ctEntryId = ctEntryId;
		_userId = userId;
		_classNameId = classNameId;
		_classPK = classPK;
		_resourcePrimKey = resourcePrimKey;
		_ctCollectionId = ctCollectionId;
	}

	public CTEntryException(
		long ctEntryId, long companyId, long userId, long classNameId,
		long classPK, long resourcePrimKey, long ctCollectionId, String msg,
		Throwable cause) {

		super(companyId, msg, cause);

		_ctEntryId = ctEntryId;
		_userId = userId;
		_classNameId = classNameId;
		_classPK = classPK;
		_resourcePrimKey = resourcePrimKey;
		_ctCollectionId = ctCollectionId;
	}

	public CTEntryException(
		long ctEntryId, long companyId, long userId, long classNameId,
		long classPK, long resourcePrimKey, long ctCollectionId,
		Throwable cause) {

		super(companyId, cause);

		_ctEntryId = ctEntryId;
		_userId = userId;
		_classNameId = classNameId;
		_classPK = classPK;
		_resourcePrimKey = resourcePrimKey;
		_ctCollectionId = ctCollectionId;
	}

	public long getClassNameId() {
		return _classNameId;
	}

	public long getClassPK() {
		return _classPK;
	}

	public long getCtCollectionId() {
		return _ctCollectionId;
	}

	public long getCtEntryId() {
		return _ctEntryId;
	}

	public long getResourcePrimKey() {
		return _resourcePrimKey;
	}

	public long getUserId() {
		return _userId;
	}

	private final long _classNameId;
	private final long _classPK;
	private final long _ctCollectionId;
	private final long _ctEntryId;
	private final long _resourcePrimKey;
	private final long _userId;

}