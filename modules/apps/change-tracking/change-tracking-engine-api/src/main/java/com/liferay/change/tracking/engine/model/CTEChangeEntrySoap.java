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

package com.liferay.change.tracking.engine.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class CTEChangeEntrySoap implements Serializable {
	public static CTEChangeEntrySoap toSoapModel(CTEChangeEntry model) {
		CTEChangeEntrySoap soapModel = new CTEChangeEntrySoap();

		soapModel.setCteChangeEntryId(model.getCteChangeEntryId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setClassNameId(model.getClassNameId());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setResourcePrimKey(model.getResourcePrimKey());

		return soapModel;
	}

	public static CTEChangeEntrySoap[] toSoapModels(CTEChangeEntry[] models) {
		CTEChangeEntrySoap[] soapModels = new CTEChangeEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CTEChangeEntrySoap[][] toSoapModels(CTEChangeEntry[][] models) {
		CTEChangeEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CTEChangeEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new CTEChangeEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CTEChangeEntrySoap[] toSoapModels(List<CTEChangeEntry> models) {
		List<CTEChangeEntrySoap> soapModels = new ArrayList<CTEChangeEntrySoap>(models.size());

		for (CTEChangeEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CTEChangeEntrySoap[soapModels.size()]);
	}

	public CTEChangeEntrySoap() {
	}

	public long getPrimaryKey() {
		return _cteChangeEntryId;
	}

	public void setPrimaryKey(long pk) {
		setCteChangeEntryId(pk);
	}

	public long getCteChangeEntryId() {
		return _cteChangeEntryId;
	}

	public void setCteChangeEntryId(long cteChangeEntryId) {
		_cteChangeEntryId = cteChangeEntryId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getClassNameId() {
		return _classNameId;
	}

	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;
	}

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	public long getResourcePrimKey() {
		return _resourcePrimKey;
	}

	public void setResourcePrimKey(long resourcePrimKey) {
		_resourcePrimKey = resourcePrimKey;
	}

	private long _cteChangeEntryId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _classNameId;
	private long _classPK;
	private long _resourcePrimKey;
}