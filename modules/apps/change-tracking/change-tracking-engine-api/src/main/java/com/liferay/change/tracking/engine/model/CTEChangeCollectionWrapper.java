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
 * This class is a wrapper for {@link CTEChangeCollection}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CTEChangeCollection
 * @generated
 */
@ProviderType
public class CTEChangeCollectionWrapper implements CTEChangeCollection,
	ModelWrapper<CTEChangeCollection> {
	public CTEChangeCollectionWrapper(CTEChangeCollection cteChangeCollection) {
		_cteChangeCollection = cteChangeCollection;
	}

	@Override
	public Class<?> getModelClass() {
		return CTEChangeCollection.class;
	}

	@Override
	public String getModelClassName() {
		return CTEChangeCollection.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cteChangeCollectionId", getCteChangeCollectionId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long cteChangeCollectionId = (Long)attributes.get(
				"cteChangeCollectionId");

		if (cteChangeCollectionId != null) {
			setCteChangeCollectionId(cteChangeCollectionId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public Object clone() {
		return new CTEChangeCollectionWrapper((CTEChangeCollection)_cteChangeCollection.clone());
	}

	@Override
	public int compareTo(CTEChangeCollection cteChangeCollection) {
		return _cteChangeCollection.compareTo(cteChangeCollection);
	}

	/**
	* Returns the company ID of this cte change collection.
	*
	* @return the company ID of this cte change collection
	*/
	@Override
	public long getCompanyId() {
		return _cteChangeCollection.getCompanyId();
	}

	/**
	* Returns the create date of this cte change collection.
	*
	* @return the create date of this cte change collection
	*/
	@Override
	public Date getCreateDate() {
		return _cteChangeCollection.getCreateDate();
	}

	/**
	* Returns the cte change collection ID of this cte change collection.
	*
	* @return the cte change collection ID of this cte change collection
	*/
	@Override
	public long getCteChangeCollectionId() {
		return _cteChangeCollection.getCteChangeCollectionId();
	}

	/**
	* Returns the description of this cte change collection.
	*
	* @return the description of this cte change collection
	*/
	@Override
	public String getDescription() {
		return _cteChangeCollection.getDescription();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _cteChangeCollection.getExpandoBridge();
	}

	/**
	* Returns the modified date of this cte change collection.
	*
	* @return the modified date of this cte change collection
	*/
	@Override
	public Date getModifiedDate() {
		return _cteChangeCollection.getModifiedDate();
	}

	/**
	* Returns the name of this cte change collection.
	*
	* @return the name of this cte change collection
	*/
	@Override
	public String getName() {
		return _cteChangeCollection.getName();
	}

	/**
	* Returns the primary key of this cte change collection.
	*
	* @return the primary key of this cte change collection
	*/
	@Override
	public long getPrimaryKey() {
		return _cteChangeCollection.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cteChangeCollection.getPrimaryKeyObj();
	}

	/**
	* Returns the user ID of this cte change collection.
	*
	* @return the user ID of this cte change collection
	*/
	@Override
	public long getUserId() {
		return _cteChangeCollection.getUserId();
	}

	/**
	* Returns the user name of this cte change collection.
	*
	* @return the user name of this cte change collection
	*/
	@Override
	public String getUserName() {
		return _cteChangeCollection.getUserName();
	}

	/**
	* Returns the user uuid of this cte change collection.
	*
	* @return the user uuid of this cte change collection
	*/
	@Override
	public String getUserUuid() {
		return _cteChangeCollection.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _cteChangeCollection.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _cteChangeCollection.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _cteChangeCollection.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _cteChangeCollection.isNew();
	}

	@Override
	public void persist() {
		_cteChangeCollection.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_cteChangeCollection.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this cte change collection.
	*
	* @param companyId the company ID of this cte change collection
	*/
	@Override
	public void setCompanyId(long companyId) {
		_cteChangeCollection.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this cte change collection.
	*
	* @param createDate the create date of this cte change collection
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_cteChangeCollection.setCreateDate(createDate);
	}

	/**
	* Sets the cte change collection ID of this cte change collection.
	*
	* @param cteChangeCollectionId the cte change collection ID of this cte change collection
	*/
	@Override
	public void setCteChangeCollectionId(long cteChangeCollectionId) {
		_cteChangeCollection.setCteChangeCollectionId(cteChangeCollectionId);
	}

	/**
	* Sets the description of this cte change collection.
	*
	* @param description the description of this cte change collection
	*/
	@Override
	public void setDescription(String description) {
		_cteChangeCollection.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_cteChangeCollection.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_cteChangeCollection.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_cteChangeCollection.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified date of this cte change collection.
	*
	* @param modifiedDate the modified date of this cte change collection
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_cteChangeCollection.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this cte change collection.
	*
	* @param name the name of this cte change collection
	*/
	@Override
	public void setName(String name) {
		_cteChangeCollection.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_cteChangeCollection.setNew(n);
	}

	/**
	* Sets the primary key of this cte change collection.
	*
	* @param primaryKey the primary key of this cte change collection
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_cteChangeCollection.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_cteChangeCollection.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this cte change collection.
	*
	* @param userId the user ID of this cte change collection
	*/
	@Override
	public void setUserId(long userId) {
		_cteChangeCollection.setUserId(userId);
	}

	/**
	* Sets the user name of this cte change collection.
	*
	* @param userName the user name of this cte change collection
	*/
	@Override
	public void setUserName(String userName) {
		_cteChangeCollection.setUserName(userName);
	}

	/**
	* Sets the user uuid of this cte change collection.
	*
	* @param userUuid the user uuid of this cte change collection
	*/
	@Override
	public void setUserUuid(String userUuid) {
		_cteChangeCollection.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<CTEChangeCollection> toCacheModel() {
		return _cteChangeCollection.toCacheModel();
	}

	@Override
	public CTEChangeCollection toEscapedModel() {
		return new CTEChangeCollectionWrapper(_cteChangeCollection.toEscapedModel());
	}

	@Override
	public String toString() {
		return _cteChangeCollection.toString();
	}

	@Override
	public CTEChangeCollection toUnescapedModel() {
		return new CTEChangeCollectionWrapper(_cteChangeCollection.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _cteChangeCollection.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CTEChangeCollectionWrapper)) {
			return false;
		}

		CTEChangeCollectionWrapper cteChangeCollectionWrapper = (CTEChangeCollectionWrapper)obj;

		if (Objects.equals(_cteChangeCollection,
					cteChangeCollectionWrapper._cteChangeCollection)) {
			return true;
		}

		return false;
	}

	@Override
	public CTEChangeCollection getWrappedModel() {
		return _cteChangeCollection;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _cteChangeCollection.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _cteChangeCollection.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_cteChangeCollection.resetOriginalValues();
	}

	private final CTEChangeCollection _cteChangeCollection;
}