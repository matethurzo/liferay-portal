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

package com.liferay.change.tracking.my.change.lists.web.internal.application.list;

import com.liferay.application.list.BaseJSPPanelCategory;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.PanelAppRegistry;
import com.liferay.application.list.PanelCategory;
import com.liferay.application.list.constants.ApplicationListWebKeys;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.change.tracking.constants.ChangeTrackingPanelCategoryKeys;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ListUtil;

import java.io.IOException;

import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Mate Thurzo
 */
@Component(
	immediate = true,
	property = {
		"panel.category.key=" + PanelCategoryKeys.USER,
		"panel.category.order:Integer=200"
	},
	service = PanelCategory.class
)
public class MyChangeListsPanelCategory extends BaseJSPPanelCategory {

	@Override
	public String getJspPath() {
		return "/application_list/my_change_lists.jsp";
	}

	@Override
	public String getKey() {
		return ChangeTrackingPanelCategoryKeys.USER_MY_CHANGE_LISTS;
	}

	@Override
	public String getLabel(Locale locale) {
		return LanguageUtil.get(locale, "my-change-lists");
	}

	@Override
	public boolean include(
			HttpServletRequest request, HttpServletResponse response)
		throws IOException {

		PanelApp panelApp = _getPanelApp();

		request.setAttribute(ApplicationListWebKeys.PANEL_APP, panelApp);

		return super.include(request, response);
	}

	@Override
	public boolean includeHeader(
			HttpServletRequest request, HttpServletResponse response)
		throws IOException {

		PanelApp panelApp = _getPanelApp();

		request.setAttribute(ApplicationListWebKeys.PANEL_APP, panelApp);

		return super.includeHeader(request, response);
	}

	@Override
	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.change.tracking.my.change.lists.web)",
		unbind = "-"
	)
	public void setServletContext(ServletContext servletContext) {
		super.setServletContext(servletContext);
	}

	private PanelApp _getPanelApp() {
		List<PanelApp> panelApps = _panelAppRegistry.getPanelApps(
			ChangeTrackingPanelCategoryKeys.USER_MY_CHANGE_LISTS);

		if (ListUtil.isNotEmpty(panelApps)) {
			return panelApps.get(0);
		}

		return null;
	}

	@Reference
	private PanelAppRegistry _panelAppRegistry;

}