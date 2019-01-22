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

package com.liferay.change.tracking.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.change.tracking.model.CTProcess;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CTProcess in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CTProcess
 * @generated
 */
@ProviderType
public class CTProcessCacheModel implements CacheModel<CTProcess>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CTProcessCacheModel)) {
			return false;
		}

		CTProcessCacheModel ctProcessCacheModel = (CTProcessCacheModel)obj;

		if (ctProcessId == ctProcessCacheModel.ctProcessId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ctProcessId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{ctProcessId=");
		sb.append(ctProcessId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", backgroundTaskId=");
		sb.append(backgroundTaskId);
		sb.append(", ctCollectionId=");
		sb.append(ctCollectionId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CTProcess toEntityModel() {
		CTProcessImpl ctProcessImpl = new CTProcessImpl();

		ctProcessImpl.setCtProcessId(ctProcessId);
		ctProcessImpl.setCompanyId(companyId);
		ctProcessImpl.setUserId(userId);

		if (userName == null) {
			ctProcessImpl.setUserName("");
		}
		else {
			ctProcessImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			ctProcessImpl.setCreateDate(null);
		}
		else {
			ctProcessImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			ctProcessImpl.setModifiedDate(null);
		}
		else {
			ctProcessImpl.setModifiedDate(new Date(modifiedDate));
		}

		ctProcessImpl.setBackgroundTaskId(backgroundTaskId);
		ctProcessImpl.setCtCollectionId(ctCollectionId);

		ctProcessImpl.resetOriginalValues();

		return ctProcessImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ctProcessId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		backgroundTaskId = objectInput.readLong();

		ctCollectionId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(ctProcessId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(backgroundTaskId);

		objectOutput.writeLong(ctCollectionId);
	}

	public long ctProcessId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long backgroundTaskId;
	public long ctCollectionId;
}