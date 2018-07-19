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

package com.liferay.portal.model.adapter.impl;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ClassName;
import com.liferay.portal.kernel.model.WorkflowDefinitionLink;
import com.liferay.portal.kernel.model.adapter.StagedWorkflowDefinitionLink;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.model.impl.WorkflowDefinitionLinkImpl;

import java.util.Date;

/**
 * @author Zoltan Csaszi
 */
public class StagedWorkflowDefinitionLinkImpl
	extends WorkflowDefinitionLinkImpl implements StagedWorkflowDefinitionLink {

	public StagedWorkflowDefinitionLinkImpl(
		WorkflowDefinitionLink workflowDefinitionLink) {

		_workflowDefinitionLink = workflowDefinitionLink;

		_workflowDefinitionLinkId =
			workflowDefinitionLink.getWorkflowDefinitionLinkId();
		_groupId = workflowDefinitionLink.getGroupId();
		_classNameId = workflowDefinitionLink.getClassNameId();
		_classPK = workflowDefinitionLink.getClassPK();
		_companyId = workflowDefinitionLink.getCompanyId();
		_createDate = workflowDefinitionLink.getCreateDate();
		_modifiedDate = workflowDefinitionLink.getModifiedDate();
		_typePK = workflowDefinitionLink.getTypePK();
		_userId = workflowDefinitionLink.getUserId();
		_userName = workflowDefinitionLink.getUserName();
		_workflowDefinitionName =
			workflowDefinitionLink.getWorkflowDefinitionName();
		_workflowDefinitionVersion =
			workflowDefinitionLink.getWorkflowDefinitionVersion();
	}

	@Override
	public Object clone() {
		return new StagedWorkflowDefinitionLinkImpl(_workflowDefinitionLink);
	}

	@Override
	public String getClassName() {
		ClassName className = ClassNameLocalServiceUtil.fetchClassName(
			_classNameId);

		if (className != null) {
			return className.getClassName();
		}

		return null;
	}

	@Override
	public long getClassNameId() {
		return _classNameId;
	}

	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(StagedWorkflowDefinitionLink.class);
	}

	@Override
	public String getUuid() {
		return "";
	}

	@Override
	public String getWorkflowDefinitionName() {
		return _workflowDefinitionName;
	}

	@Override
	public int getWorkflowDefinitionVersion() {
		return _workflowDefinitionVersion;
	}

	@Override
	public void setUuid(String uuid) {
		throw new UnsupportedOperationException();
	}

	private final long _classNameId;
	private final long _classPK;
	private final long _companyId;
	private final Date _createDate;
	private final long _groupId;
	private final Date _modifiedDate;
	private final long _typePK;
	private final long _userId;
	private final String _userName;
	private final WorkflowDefinitionLink _workflowDefinitionLink;
	private final long _workflowDefinitionLinkId;
	private final String _workflowDefinitionName;
	private final int _workflowDefinitionVersion;

}