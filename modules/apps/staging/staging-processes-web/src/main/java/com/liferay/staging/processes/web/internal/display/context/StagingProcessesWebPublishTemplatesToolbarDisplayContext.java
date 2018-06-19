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

package com.liferay.staging.processes.web.internal.display.context;

import com.liferay.exportimport.kernel.configuration.ExportImportConfigurationConstants;
import com.liferay.exportimport.kernel.model.ExportImportConfiguration;
import com.liferay.exportimport.kernel.service.ExportImportConfigurationLocalServiceUtil;
import com.liferay.exportimport.util.comparator.ExportImportConfigurationNameComparator;
import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.BaseManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.staging.processes.web.internal.search.PublishConfigurationDisplayTerms;
import com.liferay.staging.processes.web.internal.search.PublishConfigurationSearchTerms;

import java.util.List;

import javax.portlet.PortletURL;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Péter Alius
 * @author Péter Borkuti
 */
public class StagingProcessesWebPublishTemplatesToolbarDisplayContext
	extends BaseManagementToolbarDisplayContext {

	public StagingProcessesWebPublishTemplatesToolbarDisplayContext(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse,
		HttpServletRequest request, long stagingGroupId, long groupId,
		Company company, PortletURL iteratorURL, boolean stagedRemotely) {

		super(liferayPortletRequest, liferayPortletResponse, request);

		_stagingGroupId = stagingGroupId;

		searchContainer = _createSearchContainer(
			groupId, company, iteratorURL, stagedRemotely);
	}

	@Override
	public String getClearResultsURL() {
		PortletURL clearResultsURL = getRenderURL();

		clearResultsURL.setParameter("mvcPath", "/publish_templates/view.jsp");

		return clearResultsURL.toString();
	}

	public CreationMenu getCreationMenu() {
		return new CreationMenu() {
			{
				addPrimaryDropdownItem(
					dropdownItem -> {
						dropdownItem.setHref(
							getRenderURL(), "mvcRenderCommandName",
							"editPublishConfiguration", "groupId",
							String.valueOf(_stagingGroupId),
							"layoutSetBranchId",
							ParamUtil.getString(request, "layoutSetBranchId"),
							"layoutSetBranchName",
							ParamUtil.getString(request, "layoutSetBranchName"),
							"privateLayout", Boolean.FALSE.toString());

						dropdownItem.setLabel(LanguageUtil.get(request, "new"));
					});
			}
		};
	}

	@Override
	public int getItemsTotal() {
		return searchContainer.getTotal();
	}

	@Override
	public String getSearchActionURL() {
		PortletURL searchActionURL = getRenderURL();

		searchActionURL.setParameter(
			"mvcRenderCommandName", "viewPublishConfigurations");

		return searchActionURL.toString();
	}

	public SearchContainer getSearchContainer() {
		return searchContainer;
	}

	protected PortletURL getRenderURL() {
		return liferayPortletResponse.createRenderURL();
	}

	protected SearchContainer searchContainer;

	private SearchContainer _createSearchContainer(
		long groupId, Company company, PortletURL iteratorURL,
		boolean stagedRemotely) {

		SearchContainer searchContainer = new SearchContainer(
			liferayPortletRequest,
			new PublishConfigurationDisplayTerms(liferayPortletRequest),
			new PublishConfigurationSearchTerms(liferayPortletRequest),
			SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA,
			iteratorURL, null, "there-are-no-saved-publish-templates");

		searchContainer.setOrderByCol("name");
		searchContainer.setOrderByComparator(
			new ExportImportConfigurationNameComparator(
				"asc".equals(getOrderByType())));
		searchContainer.setOrderByType(getOrderByType());

		int exportImportConfigurationType =
			ExportImportConfigurationConstants.TYPE_PUBLISH_LAYOUT_LOCAL;

		if (stagedRemotely) {
			exportImportConfigurationType =
				ExportImportConfigurationConstants.TYPE_PUBLISH_LAYOUT_REMOTE;
		}

		PublishConfigurationSearchTerms searchTerms =
			(PublishConfigurationSearchTerms)searchContainer.getSearchTerms();

		List<ExportImportConfiguration> results =
			ExportImportConfigurationLocalServiceUtil.
				getExportImportConfigurations(
					company.getCompanyId(), groupId, searchTerms.getKeywords(),
					exportImportConfigurationType, searchContainer.getStart(),
					searchContainer.getEnd(),
					searchContainer.getOrderByComparator());
		int total =
			ExportImportConfigurationLocalServiceUtil.
				getExportImportConfigurationsCount(
					company.getCompanyId(), groupId, searchTerms.getKeywords(),
					exportImportConfigurationType);

		searchContainer.setResults(results);
		searchContainer.setTotal(total);

		return searchContainer;
	}

	private final long _stagingGroupId;

}