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

package com.liferay.exportimport.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.exportimport.model.EntityPublication;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EntityPublication in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see EntityPublication
 * @generated
 */
@ProviderType
public class EntityPublicationCacheModel implements CacheModel<EntityPublication>,
	Externalizable, MVCCModel {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EntityPublicationCacheModel)) {
			return false;
		}

		EntityPublicationCacheModel entityPublicationCacheModel = (EntityPublicationCacheModel)obj;

		if ((id == entityPublicationCacheModel.id) &&
				(mvccVersion == entityPublicationCacheModel.mvccVersion)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, id);

		return HashUtil.hash(hashCode, mvccVersion);
	}

	@Override
	public long getMvccVersion() {
		return mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", id=");
		sb.append(id);
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
		sb.append(", publicationDate=");
		sb.append(publicationDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EntityPublication toEntityModel() {
		EntityPublicationImpl entityPublicationImpl = new EntityPublicationImpl();

		entityPublicationImpl.setMvccVersion(mvccVersion);
		entityPublicationImpl.setId(id);
		entityPublicationImpl.setCompanyId(companyId);
		entityPublicationImpl.setUserId(userId);

		if (userName == null) {
			entityPublicationImpl.setUserName("");
		}
		else {
			entityPublicationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			entityPublicationImpl.setCreateDate(null);
		}
		else {
			entityPublicationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			entityPublicationImpl.setModifiedDate(null);
		}
		else {
			entityPublicationImpl.setModifiedDate(new Date(modifiedDate));
		}

		entityPublicationImpl.setClassNameId(classNameId);
		entityPublicationImpl.setClassPK(classPK);

		if (publicationDate == Long.MIN_VALUE) {
			entityPublicationImpl.setPublicationDate(null);
		}
		else {
			entityPublicationImpl.setPublicationDate(new Date(publicationDate));
		}

		entityPublicationImpl.resetOriginalValues();

		return entityPublicationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();

		id = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		classNameId = objectInput.readLong();

		classPK = objectInput.readLong();
		publicationDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(mvccVersion);

		objectOutput.writeLong(id);

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
		objectOutput.writeLong(publicationDate);
	}

	public long mvccVersion;
	public long id;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long classNameId;
	public long classPK;
	public long publicationDate;
}