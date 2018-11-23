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

import com.liferay.change.tracking.engine.model.CTEChangeCollection;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CTEChangeCollection in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see CTEChangeCollection
 * @generated
 */
@ProviderType
public class CTEChangeCollectionCacheModel implements CacheModel<CTEChangeCollection>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CTEChangeCollectionCacheModel)) {
			return false;
		}

		CTEChangeCollectionCacheModel cteChangeCollectionCacheModel = (CTEChangeCollectionCacheModel)obj;

		if (cteChangeCollectionId == cteChangeCollectionCacheModel.cteChangeCollectionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, cteChangeCollectionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{cteChangeCollectionId=");
		sb.append(cteChangeCollectionId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CTEChangeCollection toEntityModel() {
		CTEChangeCollectionImpl cteChangeCollectionImpl = new CTEChangeCollectionImpl();

		cteChangeCollectionImpl.setCteChangeCollectionId(cteChangeCollectionId);
		cteChangeCollectionImpl.setCompanyId(companyId);
		cteChangeCollectionImpl.setUserId(userId);

		if (userName == null) {
			cteChangeCollectionImpl.setUserName("");
		}
		else {
			cteChangeCollectionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			cteChangeCollectionImpl.setCreateDate(null);
		}
		else {
			cteChangeCollectionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			cteChangeCollectionImpl.setModifiedDate(null);
		}
		else {
			cteChangeCollectionImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			cteChangeCollectionImpl.setName("");
		}
		else {
			cteChangeCollectionImpl.setName(name);
		}

		if (description == null) {
			cteChangeCollectionImpl.setDescription("");
		}
		else {
			cteChangeCollectionImpl.setDescription(description);
		}

		cteChangeCollectionImpl.resetOriginalValues();

		return cteChangeCollectionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		cteChangeCollectionId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(cteChangeCollectionId);

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

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long cteChangeCollectionId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String description;
}