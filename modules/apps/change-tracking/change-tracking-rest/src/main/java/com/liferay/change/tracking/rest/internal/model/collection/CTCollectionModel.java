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

package com.liferay.change.tracking.rest.internal.model.collection;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Zoltan Csaszi
 */
@XmlRootElement
public class CTCollectionModel {

	public static CTCollectionModel.Builder forCompany(long companyId) {
		return new Builder(companyId);
	}

	@XmlElement
	public long getCompanyId() {
		return _companyId;
	}

	@XmlElement
	public String getDescription() {
		return _description;
	}

	@XmlElement
	public String getName() {
		return _name;
	}

	@XmlElement
	public String getStatusByUserName() {
		return _statusByUserName;
	}

	@XmlElement
	public Date getStatusDate() {
		return _statusDate;
	}

	public static class Builder {

		public CTCollectionModel build() {
			return _ctCollectionModel;
		}

		public Builder setDescription(String description) {
			_ctCollectionModel._description = description;

			return this;
		}

		public Builder setName(String name) {
			_ctCollectionModel._name = name;

			return this;
		}

		public Builder setStatusByUserName(String statusByUserName) {
			_ctCollectionModel._statusByUserName = statusByUserName;

			return this;
		}

		public Builder setStatusDate(Date statusDate) {
			_ctCollectionModel._statusDate = statusDate;

			return this;
		}

		private Builder(long companyId) {
			_ctCollectionModel = new CTCollectionModel();

			_ctCollectionModel._companyId = companyId;
		}

		private final CTCollectionModel _ctCollectionModel;

	}

	private CTCollectionModel() {
	}

	private long _companyId;
	private String _description;
	private String _name;
	private String _statusByUserName;
	private Date _statusDate;

}