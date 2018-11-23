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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link CTEChangeEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CTEChangeEntry
 * @generated
 */
@ProviderType
public class CTEChangeEntryWrapper implements CTEChangeEntry,
	ModelWrapper<CTEChangeEntry> {
	public CTEChangeEntryWrapper(CTEChangeEntry cteChangeEntry) {
		_cteChangeEntry = cteChangeEntry;
	}

	@Override
	public Class<?> getModelClass() {
		return CTEChangeEntry.class;
	}

	@Override
	public String getModelClassName() {
		return CTEChangeEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cteChangeEntryId", getCteChangeEntryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
		attributes.put("resourcePrimKey", getResourcePrimKey());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long cteChangeEntryId = (Long)attributes.get("cteChangeEntryId");

		if (cteChangeEntryId != null) {
			setCteChangeEntryId(cteChangeEntryId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		Long resourcePrimKey = (Long)attributes.get("resourcePrimKey");

		if (resourcePrimKey != null) {
			setResourcePrimKey(resourcePrimKey);
		}
	}

	@Override
	public Object clone() {
		return new CTEChangeEntryWrapper((CTEChangeEntry)_cteChangeEntry.clone());
	}

	@Override
	public int compareTo(CTEChangeEntry cteChangeEntry) {
		return _cteChangeEntry.compareTo(cteChangeEntry);
	}

	/**
	* Returns the fully qualified class name of this cte change entry.
	*
	* @return the fully qualified class name of this cte change entry
	*/
	@Override
	public String getClassName() {
		return _cteChangeEntry.getClassName();
	}

	/**
	* Returns the class name ID of this cte change entry.
	*
	* @return the class name ID of this cte change entry
	*/
	@Override
	public long getClassNameId() {
		return _cteChangeEntry.getClassNameId();
	}

	/**
	* Returns the class pk of this cte change entry.
	*
	* @return the class pk of this cte change entry
	*/
	@Override
	public long getClassPK() {
		return _cteChangeEntry.getClassPK();
	}

	/**
	* Returns the company ID of this cte change entry.
	*
	* @return the company ID of this cte change entry
	*/
	@Override
	public long getCompanyId() {
		return _cteChangeEntry.getCompanyId();
	}

	/**
	* Returns the create date of this cte change entry.
	*
	* @return the create date of this cte change entry
	*/
	@Override
	public Date getCreateDate() {
		return _cteChangeEntry.getCreateDate();
	}

	/**
	* Returns the cte change entry ID of this cte change entry.
	*
	* @return the cte change entry ID of this cte change entry
	*/
	@Override
	public long getCteChangeEntryId() {
		return _cteChangeEntry.getCteChangeEntryId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _cteChangeEntry.getExpandoBridge();
	}

	/**
	* Returns the modified date of this cte change entry.
	*
	* @return the modified date of this cte change entry
	*/
	@Override
	public Date getModifiedDate() {
		return _cteChangeEntry.getModifiedDate();
	}

	/**
	* Returns the primary key of this cte change entry.
	*
	* @return the primary key of this cte change entry
	*/
	@Override
	public long getPrimaryKey() {
		return _cteChangeEntry.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cteChangeEntry.getPrimaryKeyObj();
	}

	/**
	* Returns the resource prim key of this cte change entry.
	*
	* @return the resource prim key of this cte change entry
	*/
	@Override
	public long getResourcePrimKey() {
		return _cteChangeEntry.getResourcePrimKey();
	}

	/**
	* Returns the user ID of this cte change entry.
	*
	* @return the user ID of this cte change entry
	*/
	@Override
	public long getUserId() {
		return _cteChangeEntry.getUserId();
	}

	/**
	* Returns the user name of this cte change entry.
	*
	* @return the user name of this cte change entry
	*/
	@Override
	public String getUserName() {
		return _cteChangeEntry.getUserName();
	}

	/**
	* Returns the user uuid of this cte change entry.
	*
	* @return the user uuid of this cte change entry
	*/
	@Override
	public String getUserUuid() {
		return _cteChangeEntry.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _cteChangeEntry.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _cteChangeEntry.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _cteChangeEntry.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _cteChangeEntry.isNew();
	}

	@Override
	public boolean isResourceMain() {
		return _cteChangeEntry.isResourceMain();
	}

	@Override
	public void persist() {
		_cteChangeEntry.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_cteChangeEntry.setCachedModel(cachedModel);
	}

	@Override
	public void setClassName(String className) {
		_cteChangeEntry.setClassName(className);
	}

	/**
	* Sets the class name ID of this cte change entry.
	*
	* @param classNameId the class name ID of this cte change entry
	*/
	@Override
	public void setClassNameId(long classNameId) {
		_cteChangeEntry.setClassNameId(classNameId);
	}

	/**
	* Sets the class pk of this cte change entry.
	*
	* @param classPK the class pk of this cte change entry
	*/
	@Override
	public void setClassPK(long classPK) {
		_cteChangeEntry.setClassPK(classPK);
	}

	/**
	* Sets the company ID of this cte change entry.
	*
	* @param companyId the company ID of this cte change entry
	*/
	@Override
	public void setCompanyId(long companyId) {
		_cteChangeEntry.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this cte change entry.
	*
	* @param createDate the create date of this cte change entry
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_cteChangeEntry.setCreateDate(createDate);
	}

	/**
	* Sets the cte change entry ID of this cte change entry.
	*
	* @param cteChangeEntryId the cte change entry ID of this cte change entry
	*/
	@Override
	public void setCteChangeEntryId(long cteChangeEntryId) {
		_cteChangeEntry.setCteChangeEntryId(cteChangeEntryId);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_cteChangeEntry.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_cteChangeEntry.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_cteChangeEntry.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified date of this cte change entry.
	*
	* @param modifiedDate the modified date of this cte change entry
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_cteChangeEntry.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_cteChangeEntry.setNew(n);
	}

	/**
	* Sets the primary key of this cte change entry.
	*
	* @param primaryKey the primary key of this cte change entry
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_cteChangeEntry.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_cteChangeEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the resource prim key of this cte change entry.
	*
	* @param resourcePrimKey the resource prim key of this cte change entry
	*/
	@Override
	public void setResourcePrimKey(long resourcePrimKey) {
		_cteChangeEntry.setResourcePrimKey(resourcePrimKey);
	}

	/**
	* Sets the user ID of this cte change entry.
	*
	* @param userId the user ID of this cte change entry
	*/
	@Override
	public void setUserId(long userId) {
		_cteChangeEntry.setUserId(userId);
	}

	/**
	* Sets the user name of this cte change entry.
	*
	* @param userName the user name of this cte change entry
	*/
	@Override
	public void setUserName(String userName) {
		_cteChangeEntry.setUserName(userName);
	}

	/**
	* Sets the user uuid of this cte change entry.
	*
	* @param userUuid the user uuid of this cte change entry
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_cteChangeEntry.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<CTEChangeEntry> toCacheModel() {
		return _cteChangeEntry.toCacheModel();
	}

	@Override
	public CTEChangeEntry toEscapedModel() {
		return new CTEChangeEntryWrapper(_cteChangeEntry.toEscapedModel());
	}

	@Override
	public String toString() {
		return _cteChangeEntry.toString();
	}

	@Override
	public CTEChangeEntry toUnescapedModel() {
		return new CTEChangeEntryWrapper(_cteChangeEntry.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _cteChangeEntry.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CTEChangeEntryWrapper)) {
			return false;
		}

		CTEChangeEntryWrapper cteChangeEntryWrapper = (CTEChangeEntryWrapper)obj;

		if (Objects.equals(_cteChangeEntry,
					cteChangeEntryWrapper._cteChangeEntry)) {
			return true;
		}

		return false;
	}

	@Override
	public CTEChangeEntry getWrappedModel() {
		return _cteChangeEntry;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _cteChangeEntry.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _cteChangeEntry.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_cteChangeEntry.resetOriginalValues();
	}

	private final CTEChangeEntry _cteChangeEntry;
}