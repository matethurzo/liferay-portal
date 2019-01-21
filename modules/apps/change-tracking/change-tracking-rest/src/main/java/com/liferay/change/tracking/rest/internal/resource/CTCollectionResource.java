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
import com.liferay.change.tracking.model.CTCollection;
import com.liferay.change.tracking.rest.internal.exception.NoSuchProductionCTCollectionException;
import com.liferay.change.tracking.rest.internal.model.collection.CTCollectionModel;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.CompanyLocalService;

import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Zoltan Csaszi
 */
@Component(
	property = {
		"osgi.jaxrs.application.select=(osgi.jaxrs.name=change-tracking-application)",
		"osgi.jaxrs.resource=true"
	},
	scope = ServiceScope.PROTOTYPE, service = CTCollectionResource.class
)
@Path("/collections")
public class CTCollectionResource {

	@GET
	@Path("/production/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	public CTCollectionModel getProductionCtCollection(
			@PathParam("companyId") long companyId)
		throws PortalException {

		_companyLocalService.getCompany(companyId);

		return _getProductionCTCollectionModel(companyId);
	}

	private CTCollectionModel _getProductionCTCollectionModel(long companyId)
		throws PortalException {

		Optional<CTCollection> ctCollectionOptional =
			_ctEngineManager.getProductionCTCollectionOptional(companyId);

		if (!ctCollectionOptional.isPresent()) {
			throw new NoSuchProductionCTCollectionException();
		}

		CTCollectionModel.Builder builder = CTCollectionModel.forCompany(
			companyId);

		CTCollection ctCollection = ctCollectionOptional.get();

		return builder.setName(
			ctCollection.getName()
		).setDescription(
			ctCollection.getDescription()
		).setStatusByUserName(
			ctCollection.getStatusByUserName()
		).setStatusDate(
			ctCollection.getStatusDate()
		).build();
	}

	@Reference
	private CompanyLocalService _companyLocalService;

	@Reference
	private CTEngineManager _ctEngineManager;

}