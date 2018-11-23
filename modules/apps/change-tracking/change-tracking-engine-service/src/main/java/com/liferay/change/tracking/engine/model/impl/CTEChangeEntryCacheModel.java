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

package com.liferay.change.tracking.engine.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.change.tracking.engine.model.CTEChangeEntry;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CTEChangeEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CTEChangeEntry
 * @generated
 */
@ProviderType
public class CTEChangeEntryCacheModel implements CacheModel<CTEChangeEntry>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CTEChangeEntryCacheModel)) {
			return false;
		}

		CTEChangeEntryCacheModel cteChangeEntryCacheModel = (CTEChangeEntryCacheModel)obj;

		if (cteChangeEntryId == cteChangeEntryCacheModel.cteChangeEntryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, cteChangeEntryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{cteChangeEntryId=");
		sb.append(cteChangeEntryId);
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
		sb.append(", classNameId=");
		sb.append(classNameId);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", resourcePrimKey=");
		sb.append(resourcePrimKey);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CTEChangeEntry toEntityModel() {
		CTEChangeEntryImpl cteChangeEntryImpl = new CTEChangeEntryImpl();

		cteChangeEntryImpl.setCteChangeEntryId(cteChangeEntryId);
		cteChangeEntryImpl.setCompanyId(companyId);
		cteChangeEntryImpl.setUserId(userId);

		if (userName == null) {
			cteChangeEntryImpl.setUserName("");
		}
		else {
			cteChangeEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			cteChangeEntryImpl.setCreateDate(null);
		}
		else {
			cteChangeEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			cteChangeEntryImpl.setModifiedDate(null);
		}
		else {
			cteChangeEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		cteChangeEntryImpl.setClassNameId(classNameId);
		cteChangeEntryImpl.setClassPK(classPK);
		cteChangeEntryImpl.setResourcePrimKey(resourcePrimKey);

		cteChangeEntryImpl.resetOriginalValues();

		return cteChangeEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		cteChangeEntryId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		classNameId = objectInput.readLong();

		classPK = objectInput.readLong();

		resourcePrimKey = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(cteChangeEntryId);

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

		objectOutput.writeLong(classNameId);

		objectOutput.writeLong(classPK);

		objectOutput.writeLong(resourcePrimKey);
	}

	public long cteChangeEntryId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long classNameId;
	public long classPK;
	public long resourcePrimKey;
}