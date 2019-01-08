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
import com.liferay.change.tracking.rest.internal.dto.configuration.CTConfigurationGetDTO;
import com.liferay.change.tracking.rest.internal.dto.configuration.CTConfigurationUpdateDTO;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.CompanyLocalService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
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
@Path("/configurations")
public class CTConfigurationResource {

	@GET
	@Path("/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	public CTConfigurationGetDTO getCtConfiguration(
			@PathParam("companyId") long companyId)
		throws PortalException {

		_companyLocalService.getCompany(companyId);

		return _getCTConfigurationDTO(companyId);
	}

	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@PUT
	public CTConfigurationGetDTO updateCtConfiguration(
			@PathParam("companyId") long companyId,
			CTConfigurationUpdateDTO ctConfigurationUpdateDTO)
		throws PortalException {

		_companyLocalService.getCompany(companyId);

		_updateChangeTrackingEnabled(companyId, ctConfigurationUpdateDTO);

		return _getCTConfigurationDTO(companyId);
	}

	private CTConfigurationGetDTO _getCTConfigurationDTO(long companyId)
		throws PortalException {

		CTConfigurationGetDTO.Builder builder =
			CTConfigurationGetDTO.forCompany(companyId);

		return builder.setChangeTrackingEnabled(
			_ctEngineManager.isChangeTrackingEnabled(companyId)
		).build();
	}

	private void _updateChangeTrackingEnabled(
		long companyId, CTConfigurationUpdateDTO ctConfigurationUpdateDTO) {

		boolean changeTrackingEnabled =
			_ctEngineManager.isChangeTrackingEnabled(companyId);

		boolean setChangeTrackingEnabled =
			ctConfigurationUpdateDTO.isChangeTrackingEnabled();

		if (changeTrackingEnabled && !setChangeTrackingEnabled) {

			// enabled - should disable

			_ctEngineManager.disableChangeTracking(companyId);
		}
		else if (!changeTrackingEnabled && setChangeTrackingEnabled) {

			// disabled - should enable

			_ctEngineManager.enableChangeTracking(
				companyId, ctConfigurationUpdateDTO.getUserId());
		}
	}

	@Reference
	private CompanyLocalService _companyLocalService;

	@Reference
	private CTEngineManager _ctEngineManager;

}