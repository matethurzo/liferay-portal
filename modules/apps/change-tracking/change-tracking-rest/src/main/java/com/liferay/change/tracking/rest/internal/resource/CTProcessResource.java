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

import com.liferay.change.tracking.model.CTCollection;
import com.liferay.change.tracking.model.CTProcess;
import com.liferay.change.tracking.rest.internal.model.process.CTProcessModel;
import com.liferay.change.tracking.rest.internal.util.CTJaxRsUtil;
import com.liferay.change.tracking.service.CTCollectionLocalService;
import com.liferay.change.tracking.service.CTProcessLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskConstants;
import com.liferay.portal.kernel.dao.orm.QueryDefinition;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserConstants;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Máté Thurzó
 */
@Component(
	property = {
		"osgi.jaxrs.application.select=(osgi.jaxrs.name=change-tracking-application)",
		"osgi.jaxrs.resource=true"
	},
	scope = ServiceScope.PROTOTYPE, service = CTProcessResource.class
)
@Path("/processes")
public class CTProcessResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CTProcessModel> getCtProcessModels(
			@QueryParam("companyId") long companyId,
			@DefaultValue(_TYPE_ALL) @QueryParam("type") String type,
			@QueryParam("offset") int offset, @QueryParam("limit") int limit,
			@QueryParam("sort") String sort)
		throws PortalException {

		CTJaxRsUtil.checkCompany(companyId);

		if (_TYPE_ALL.equals(type)) {
			List<CTProcess> ctProcesses = _ctProcessLocalService.getCTProcesses(
				companyId, _getQueryDefinition(offset, limit, sort));

			return _getCTProcessModels(ctProcesses);
		}
		else if (_TYPE_FAILED.equals(type)) {
			List<CTProcess> ctProcesses = _ctProcessLocalService.getCTProcesses(
				companyId, BackgroundTaskConstants.STATUS_FAILED,
				_getQueryDefinition(offset, limit, sort));

			return _getCTProcessModels(ctProcesses);
		}
		else if (_TYPE_IN_PROGRESS.equals(type)) {
			List<CTProcess> ctProcesses = _ctProcessLocalService.getCTProcesses(
				companyId, BackgroundTaskConstants.STATUS_IN_PROGRESS,
				_getQueryDefinition(offset, limit, sort));

			return _getCTProcessModels(ctProcesses);
		}
		else if (_TYPE_PUBLISHED.equals(type)) {
			List<CTProcess> ctProcesses = _ctProcessLocalService.getCTProcesses(
				companyId, BackgroundTaskConstants.STATUS_SUCCESSFUL,
				_getQueryDefinition(offset, limit, sort));

			return _getCTProcessModels(ctProcesses);
		}
		else if (_TYPE_PUBLISHED_LATEST.equals(type)) {
			CTProcessModel ctProcessModel = _getPublishedCTProcessModel(
				companyId);

			return Collections.singletonList(ctProcessModel);
		}

		return Collections.emptyList();
	}

	private CTProcessModel _getCTProcessModel(CTProcess ctProcess) {
		CTCollection ctCollection = _ctCollectionLocalService.fetchCTCollection(
			ctProcess.getCtCollectionId());

		User user = _userLocalService.fetchUser(ctProcess.getUserId());

		Optional<User> userOptional = Optional.ofNullable(user);

		CTProcessModel.Builder builder = CTProcessModel.forCompany(
			ctProcess.getCompanyId());

		return builder.setCTCollection(
			ctCollection
		).setDate(
			ctProcess.getCreateDate()
		).setUserInitials(
			userOptional.map(
				User::getInitials
			).orElse(
				StringPool.BLANK
			)
		).setUserName(
			userOptional.map(
				User::getFullName
			).orElse(
				StringPool.BLANK
			)
		).setUserPortraitURL(
			userOptional.map(
				this::_getPortraitURL
			).orElse(
				StringPool.BLANK
			)
		).build();
	}

	private List<CTProcessModel> _getCTProcessModels(
		List<CTProcess> ctProcesses) {

		Stream<CTProcess> stream = ctProcesses.stream();

		return stream.map(
			this::_getCTProcessModel
		).collect(
			Collectors.toList()
		);
	}

	private String _getPortraitURL(User user) {
		ThemeDisplay themeDisplay =
			(ThemeDisplay)_httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		if (themeDisplay == null) {
			return StringPool.BLANK;
		}

		if (user != null) {
			return user.fetchPortraitURL(themeDisplay);
		}

		return UserConstants.getPortraitURL(
			themeDisplay.getPathImage(), true, 0, StringPool.BLANK);
	}

	private CTProcessModel _getPublishedCTProcessModel(long companyId)
		throws PortalException {

		CTJaxRsUtil.checkCompany(companyId);

		CTProcess ctProcess = _ctProcessLocalService.fetchLatestCTProcess(
			companyId);

		if (ctProcess == null) {
			return CTProcessModel.emptyCTProcessModel();
		}

		return _getCTProcessModel(ctProcess);
	}

	private QueryDefinition _getQueryDefinition(
		int offset, int limit, String sort) {

		QueryDefinition queryDefinition = new QueryDefinition();

		int end = CTJaxRsUtil.checkLimit(limit);

		if (end > 0) {
			queryDefinition.setEnd(CTJaxRsUtil.checkLimit(limit));
		}

		int start = CTJaxRsUtil.checkLimit(offset);

		if (start > 0) {
			queryDefinition.setStart(start);
		}

		Object[] sortColumns = CTJaxRsUtil.checkSortColumns(
			sort, _orderByColumnNames);

		OrderByComparator orderByComparator = null;

		if (ArrayUtil.isNotEmpty(sortColumns)) {
			String sortColumn = GetterUtil.getString(sortColumns[0]);

			if ("name".equals(sortColumn)) {
				orderByComparator = OrderByComparatorFactoryUtil.create(
					"CTCollection", sortColumns);
			}
			else if ("publishDate".equals(sortColumn)) {
				orderByComparator = OrderByComparatorFactoryUtil.create(
					"CTProcess", "createDate", sortColumns[1]);
			}
		}

		queryDefinition.setOrderByComparator(orderByComparator);

		return queryDefinition;
	}

	private static final String _TYPE_ALL = "all";

	private static final String _TYPE_FAILED = "failed";

	private static final String _TYPE_IN_PROGRESS = "in-progress";

	private static final String _TYPE_PUBLISHED = "published";

	private static final String _TYPE_PUBLISHED_LATEST = "published-latest";

	private static final Set<String> _orderByColumnNames = new HashSet<>(
		Arrays.asList("publishDate", "name"));

	@Reference
	private CompanyLocalService _companyLocalService;

	@Reference
	private CTCollectionLocalService _ctCollectionLocalService;

	@Reference
	private CTProcessLocalService _ctProcessLocalService;

	@Context
	private HttpServletRequest _httpServletRequest;

	@Reference
	private UserLocalService _userLocalService;

}