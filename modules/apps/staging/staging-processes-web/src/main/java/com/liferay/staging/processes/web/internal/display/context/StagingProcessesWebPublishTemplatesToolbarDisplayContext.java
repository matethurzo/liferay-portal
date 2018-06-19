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

import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.BaseManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.util.ParamUtil;

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
		HttpServletRequest request, long stagingGroupId) {

		super(liferayPortletRequest, liferayPortletResponse, request);

		_stagingGroupId = stagingGroupId;
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

	public String getSearchActionURL() {
		PortletURL searchActionURL = getRenderURL();

		return searchActionURL.toString();
	}

	protected PortletURL getRenderURL() {
		return liferayPortletResponse.createRenderURL();
	}

	private final long _stagingGroupId;

}