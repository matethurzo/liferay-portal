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

package com.liferay.exportimport.model;

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
 * This class is a wrapper for {@link EntityPublication}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EntityPublication
 * @generated
 */
@ProviderType
public class EntityPublicationWrapper implements EntityPublication,
	ModelWrapper<EntityPublication> {
	public EntityPublicationWrapper(EntityPublication entityPublication) {
		_entityPublication = entityPublication;
	}

	@Override
	public Class<?> getModelClass() {
		return EntityPublication.class;
	}

	@Override
	public String getModelClassName() {
		return EntityPublication.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("id", getId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
		attributes.put("publicationDate", getPublicationDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
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

		Date publicationDate = (Date)attributes.get("publicationDate");

		if (publicationDate != null) {
			setPublicationDate(publicationDate);
		}
	}

	@Override
	public java.lang.Object clone() {
		return new EntityPublicationWrapper((EntityPublication)_entityPublication.clone());
	}

	@Override
	public int compareTo(EntityPublication entityPublication) {
		return _entityPublication.compareTo(entityPublication);
	}

	/**
	* Returns the fully qualified class name of this entity publication.
	*
	* @return the fully qualified class name of this entity publication
	*/
	@Override
	public java.lang.String getClassName() {
		return _entityPublication.getClassName();
	}

	/**
	* Returns the class name ID of this entity publication.
	*
	* @return the class name ID of this entity publication
	*/
	@Override
	public long getClassNameId() {
		return _entityPublication.getClassNameId();
	}

	/**
	* Returns the class pk of this entity publication.
	*
	* @return the class pk of this entity publication
	*/
	@Override
	public long getClassPK() {
		return _entityPublication.getClassPK();
	}

	/**
	* Returns the company ID of this entity publication.
	*
	* @return the company ID of this entity publication
	*/
	@Override
	public long getCompanyId() {
		return _entityPublication.getCompanyId();
	}

	/**
	* Returns the create date of this entity publication.
	*
	* @return the create date of this entity publication
	*/
	@Override
	public Date getCreateDate() {
		return _entityPublication.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _entityPublication.getExpandoBridge();
	}

	/**
	* Returns the ID of this entity publication.
	*
	* @return the ID of this entity publication
	*/
	@Override
	public long getId() {
		return _entityPublication.getId();
	}

	/**
	* Returns the modified date of this entity publication.
	*
	* @return the modified date of this entity publication
	*/
	@Override
	public Date getModifiedDate() {
		return _entityPublication.getModifiedDate();
	}

	/**
	* Returns the mvcc version of this entity publication.
	*
	* @return the mvcc version of this entity publication
	*/
	@Override
	public long getMvccVersion() {
		return _entityPublication.getMvccVersion();
	}

	/**
	* Returns the primary key of this entity publication.
	*
	* @return the primary key of this entity publication
	*/
	@Override
	public long getPrimaryKey() {
		return _entityPublication.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _entityPublication.getPrimaryKeyObj();
	}

	/**
	* Returns the publication date of this entity publication.
	*
	* @return the publication date of this entity publication
	*/
	@Override
	public Date getPublicationDate() {
		return _entityPublication.getPublicationDate();
	}

	/**
	* Returns the user ID of this entity publication.
	*
	* @return the user ID of this entity publication
	*/
	@Override
	public long getUserId() {
		return _entityPublication.getUserId();
	}

	/**
	* Returns the user name of this entity publication.
	*
	* @return the user name of this entity publication
	*/
	@Override
	public java.lang.String getUserName() {
		return _entityPublication.getUserName();
	}

	/**
	* Returns the user uuid of this entity publication.
	*
	* @return the user uuid of this entity publication
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _entityPublication.getUserUuid();
	}

	@Override
	public int hashCode() {
		return _entityPublication.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _entityPublication.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _entityPublication.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _entityPublication.isNew();
	}

	@Override
	public void persist() {
		_entityPublication.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_entityPublication.setCachedModel(cachedModel);
	}

	@Override
	public void setClassName(java.lang.String className) {
		_entityPublication.setClassName(className);
	}

	/**
	* Sets the class name ID of this entity publication.
	*
	* @param classNameId the class name ID of this entity publication
	*/
	@Override
	public void setClassNameId(long classNameId) {
		_entityPublication.setClassNameId(classNameId);
	}

	/**
	* Sets the class pk of this entity publication.
	*
	* @param classPK the class pk of this entity publication
	*/
	@Override
	public void setClassPK(long classPK) {
		_entityPublication.setClassPK(classPK);
	}

	/**
	* Sets the company ID of this entity publication.
	*
	* @param companyId the company ID of this entity publication
	*/
	@Override
	public void setCompanyId(long companyId) {
		_entityPublication.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this entity publication.
	*
	* @param createDate the create date of this entity publication
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_entityPublication.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_entityPublication.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_entityPublication.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_entityPublication.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this entity publication.
	*
	* @param id the ID of this entity publication
	*/
	@Override
	public void setId(long id) {
		_entityPublication.setId(id);
	}

	/**
	* Sets the modified date of this entity publication.
	*
	* @param modifiedDate the modified date of this entity publication
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_entityPublication.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the mvcc version of this entity publication.
	*
	* @param mvccVersion the mvcc version of this entity publication
	*/
	@Override
	public void setMvccVersion(long mvccVersion) {
		_entityPublication.setMvccVersion(mvccVersion);
	}

	@Override
	public void setNew(boolean n) {
		_entityPublication.setNew(n);
	}

	/**
	* Sets the primary key of this entity publication.
	*
	* @param primaryKey the primary key of this entity publication
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_entityPublication.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_entityPublication.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the publication date of this entity publication.
	*
	* @param publicationDate the publication date of this entity publication
	*/
	@Override
	public void setPublicationDate(Date publicationDate) {
		_entityPublication.setPublicationDate(publicationDate);
	}

	/**
	* Sets the user ID of this entity publication.
	*
	* @param userId the user ID of this entity publication
	*/
	@Override
	public void setUserId(long userId) {
		_entityPublication.setUserId(userId);
	}

	/**
	* Sets the user name of this entity publication.
	*
	* @param userName the user name of this entity publication
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_entityPublication.setUserName(userName);
	}

	/**
	* Sets the user uuid of this entity publication.
	*
	* @param userUuid the user uuid of this entity publication
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_entityPublication.setUserUuid(userUuid);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<EntityPublication> toCacheModel() {
		return _entityPublication.toCacheModel();
	}

	@Override
	public EntityPublication toEscapedModel() {
		return new EntityPublicationWrapper(_entityPublication.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _entityPublication.toString();
	}

	@Override
	public EntityPublication toUnescapedModel() {
		return new EntityPublicationWrapper(_entityPublication.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _entityPublication.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EntityPublicationWrapper)) {
			return false;
		}

		EntityPublicationWrapper entityPublicationWrapper = (EntityPublicationWrapper)obj;

		if (Objects.equals(_entityPublication,
					entityPublicationWrapper._entityPublication)) {
			return true;
		}

		return false;
	}

	@Override
	public EntityPublication getWrappedModel() {
		return _entityPublication;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityPublication.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _entityPublication.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_entityPublication.resetOriginalValues();
	}

	private final EntityPublication _entityPublication;
}