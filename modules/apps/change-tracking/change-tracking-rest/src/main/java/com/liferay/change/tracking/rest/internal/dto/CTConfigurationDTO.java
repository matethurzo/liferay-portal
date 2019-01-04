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

package com.liferay.change.tracking.rest.internal.dto;

import javax.xml.bind.annotation.XmlElement;

/**
 * @author Máté Thurzó
 */
public class CTConfigurationDTO {

	public static CTConfigurationDTO.Builder forCompany(long companyId) {
		return new Builder(companyId);
	}

	@XmlElement(name = "changeTrackingEnabled")
	public boolean isChangeTrackingEnabled() {
		return _changeTrackingEnabled;
	}

	public static class Builder {

		public CTConfigurationDTO build() {
			return _ctConfigurationDTO;
		}

		public Builder setChangeTrackingEnabled(boolean changeTrackingEnabled) {
			_ctConfigurationDTO._changeTrackingEnabled = changeTrackingEnabled;

			return this;
		}

		private Builder(long companyId) {
			_ctConfigurationDTO = new CTConfigurationDTO();

			_ctConfigurationDTO._companyId = companyId;
		}

		private final CTConfigurationDTO _ctConfigurationDTO;

	}

	private CTConfigurationDTO() {
	}

	private boolean _changeTrackingEnabled;
	private long _companyId;

}