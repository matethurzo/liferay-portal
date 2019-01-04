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

package com.liferay.change.tracking.rest.internal.resource;

import com.liferay.change.tracking.CTEngineManager;
import com.liferay.change.tracking.rest.internal.dto.CTConfigurationDTO;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.CompanyLocalService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

/**
 * @author Máté Thurzó
 */
@Component(
	immediate = true,
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_SELECT + "=(osgi.jaxrs.name=ChangeTracking.Rest)",
		JaxrsWhiteboardConstants.JAX_RS_RESOURCE + "=true"
	},
	service = Object.class
)
@Path("/configuration")
public class CTConfigurationResource {

	@GET
	@Path("/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	public CTConfigurationDTO getCtConfiguration(
			@PathParam("companyId") long companyId)
		throws PortalException {

		_companyLocalService.getCompany(companyId);

		CTConfigurationDTO.Builder builder = CTConfigurationDTO.forCompany(
			companyId);

		return builder.setChangeTrackingEnabled(
			_ctEngineManager.isChangeTrackingEnabled(companyId)
		).build();
	}

	@Reference
	private CompanyLocalService _companyLocalService;

	@Reference
	private CTEngineManager _ctEngineManager;

}