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

package com.liferay.change.tracking.rest.internal.dto.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author Máté Thurzó
 */
@JsonRootName("configuration")
public class CTConfigurationGetDTO {

	public static CTConfigurationGetDTO.Builder forCompany(long companyId) {
		return new Builder(companyId);
	}

	public long getCompanyId() {
		return _companyId;
	}

	public boolean isChangeTrackingEnabled() {
		return _changeTrackingEnabled;
	}

	public static class Builder {

		public CTConfigurationGetDTO build() {
			return _ctConfigurationGetDTO;
		}

		public Builder setChangeTrackingEnabled(boolean changeTrackingEnabled) {
			_ctConfigurationGetDTO._changeTrackingEnabled =
				changeTrackingEnabled;

			return this;
		}

		private Builder(long companyId) {
			_ctConfigurationGetDTO = new CTConfigurationGetDTO();

			_ctConfigurationGetDTO._companyId = companyId;
		}

		private final CTConfigurationGetDTO _ctConfigurationGetDTO;

	}

	private CTConfigurationGetDTO() {
	}

	@JsonProperty("changeTrackingEnabled")
	private boolean _changeTrackingEnabled;

	@JsonProperty("companyId")
	private long _companyId;

}