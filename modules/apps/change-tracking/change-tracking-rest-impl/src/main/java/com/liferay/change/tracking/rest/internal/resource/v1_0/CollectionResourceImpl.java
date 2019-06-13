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

package com.liferay.change.tracking.rest.internal.resource.v1_0;

import com.liferay.change.tracking.constants.CTConstants;
import com.liferay.change.tracking.engine.CTEngineManager;
import com.liferay.change.tracking.engine.exception.CTCollectionDescriptionCTEngineException;
import com.liferay.change.tracking.engine.exception.CTCollectionNameCTEngineException;
import com.liferay.change.tracking.model.CTCollection;
import com.liferay.change.tracking.rest.dto.v1_0.Collection;
import com.liferay.change.tracking.rest.dto.v1_0.CollectionUpdate;
import com.liferay.change.tracking.rest.internal.jaxrs.exception.CannotCreateCollectionException;
import com.liferay.change.tracking.rest.internal.jaxrs.exception.CannotDeleteCollectionException;
import com.liferay.change.tracking.rest.internal.jaxrs.exception.ChangeTrackingDisabledException;
import com.liferay.change.tracking.rest.internal.jaxrs.exception.CollectionDescriptionTooLongException;
import com.liferay.change.tracking.rest.internal.jaxrs.exception.CollectionNameTooLongException;
import com.liferay.change.tracking.rest.internal.jaxrs.exception.CollectionNameTooShortException;
import com.liferay.change.tracking.rest.resource.v1_0.CollectionResource;
import com.liferay.portal.kernel.exception.NoSuchModelException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Validator;

import java.util.Map;
import java.util.Optional;

import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Máté Thurzó
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/collection.properties",
	scope = ServiceScope.PROTOTYPE, service = CollectionResource.class
)
public class CollectionResourceImpl extends BaseCollectionResourceImpl {

	@Override
	public Response deleteCollection(Long collectionId) throws Exception {
		Optional<CTCollection> ctCollectionOptional =
			_ctEngineManager.getCTCollectionOptional(collectionId);

		if (!ctCollectionOptional.isPresent()) {
			return Response.status(
				Response.Status.NOT_FOUND
			).build();
		}

		_ctEngineManager.deleteCTCollection(collectionId);

		ctCollectionOptional = _ctEngineManager.getCTCollectionOptional(
			collectionId);

		if (ctCollectionOptional.isPresent()) {
			throw new CannotDeleteCollectionException(
				"Unable to delete collection " + collectionId);
		}

		Response.ResponseBuilder responseBuilder = Response.noContent();

		return responseBuilder.build();
	}

	@Override
	public Collection getCollection(Long collectionId) throws Exception {
		Optional<CTCollection> ctCollectionOptional =
			_ctEngineManager.getCTCollectionOptional(collectionId);

		return _toCollection(
			ctCollectionOptional.orElseThrow(
				() -> new NoSuchModelException(
					"Unable to get collection " + collectionId)));
	}

	@Override
	public Collection postCollection(
			Long companyId, Long userId, CollectionUpdate collectionUpdate)
		throws Exception {

		_companyLocalService.getCompany(companyId);
		_userLocalService.getUser(userId);

		if (!_ctEngineManager.isChangeTrackingEnabled(companyId)) {
			throw new ChangeTrackingDisabledException(
				"Change tracking is disabled for company " + companyId);
		}

		try {
			Optional<CTCollection> ctCollectionOptional =
				_ctEngineManager.createCTCollection(
					userId, collectionUpdate.getName(),
					collectionUpdate.getDescription());

			return ctCollectionOptional.map(
				this::_toCollection
			).orElseThrow(
				() -> new CannotCreateCollectionException(
					"Unable to create collection")
			);
		}
		catch (PortalException pe) {
			if (pe instanceof CTCollectionDescriptionCTEngineException) {
				throw new CollectionDescriptionTooLongException(
					"The collection description is too long");
			}
			else if (pe instanceof CTCollectionNameCTEngineException) {
				if (Validator.isNull(pe.getMessage())) {
					throw new CollectionNameTooShortException(
						"The collection name is too short");
				}

				throw new CollectionNameTooLongException(
					"The collection name is too long");
			}
			else {
				throw new CannotCreateCollectionException(
					"Unable to create collection");
			}
		}
	}

	@Override
	public Response postCollectionCheckout(Long collectionId, Long userId)
		throws Exception {

		_userLocalService.getUser(userId);

		_ctEngineManager.checkoutCTCollection(userId, collectionId);

		Response.ResponseBuilder responseBuilder = Response.accepted();

		return responseBuilder.build();
	}

	@Override
	public Response postCollectionPublish(
			Long collectionId, Boolean ignoreCollision, Long userId)
		throws Exception {

		_userLocalService.getUser(userId);

		_ctEngineManager.publishCTCollection(
			userId, collectionId, ignoreCollision);

		Response.ResponseBuilder responseBuilder = Response.accepted();

		return responseBuilder.build();
	}

	private Collection _toCollection(CTCollection ctCollection) {
		Map<Integer, Long> ctEntriesChangeTypes =
			_ctEngineManager.getCTCollectionChangeTypeCounts(
				ctCollection.getCtCollectionId());

		return new Collection() {
			{
				additionCount = ctEntriesChangeTypes.getOrDefault(
					CTConstants.CT_CHANGE_TYPE_ADDITION, 0L);
				collectionId = ctCollection.getCtCollectionId();
				companyId = ctCollection.getCompanyId();
				deletionCount = ctEntriesChangeTypes.getOrDefault(
					CTConstants.CT_CHANGE_TYPE_DELETION, 0L);
				description = ctCollection.getDescription();
				modificationCount = ctEntriesChangeTypes.getOrDefault(
					CTConstants.CT_CHANGE_TYPE_MODIFICATION, 0L);
				name = ctCollection.getName();
				statusByUserName = ctCollection.getStatusByUserName();
				statusDate = ctCollection.getStatusDate();
			}
		};
	}

	@Reference
	private CompanyLocalService _companyLocalService;

	@Reference
	private CTEngineManager _ctEngineManager;

	@Reference
	private UserLocalService _userLocalService;

}