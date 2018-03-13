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

package com.liferay.exportimport.web.internal.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPNavigationItemList;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.NavigationItem;
import com.liferay.portal.kernel.language.LanguageUtil;

import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

/**
 * @author Péter Alius
 */
public class ExportTemplatesDisplayContext {

	public static JSPNavigationItemList exportImportJSPNavigationItemList(
		RenderResponse renderResponse, HttpServletRequest request,
		PageContext pageContext) {

		_exportTemplatesNavigationItem = new NavigationItem();

		_exportTemplatesNavigationItem.setActive(true);
		_exportTemplatesNavigationItem.setHref(
			renderResponse.createRenderURL());
		_exportTemplatesNavigationItem.setLabel(
			LanguageUtil.get(request, "export-templates"));

		return new JSPNavigationItemList(pageContext) {
			{
				add(_exportTemplatesNavigationItem);
			}
		};
	}

	private static NavigationItem _exportTemplatesNavigationItem;

}