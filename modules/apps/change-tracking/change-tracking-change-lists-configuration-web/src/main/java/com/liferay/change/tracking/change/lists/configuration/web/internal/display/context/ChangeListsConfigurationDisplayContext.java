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

package com.liferay.change.tracking.change.lists.configuration.web.internal.display.context;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.template.soy.util.SoyContext;
import com.liferay.portal.template.soy.util.SoyContextFactoryUtil;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Máté Thurzó
 */
public class ChangeListsConfigurationDisplayContext {

	public ChangeListsConfigurationDisplayContext(
		RenderResponse renderResponse, HttpServletRequest request) {

		_renderResponse = renderResponse;
		_request = request;

		_themeDisplay = (ThemeDisplay)_request.getAttribute(
			WebKeys.THEME_DISPLAY);
	}

	public SoyContext getChangeListsConfigurationContext() {
		SoyContext soyContext = SoyContextFactoryUtil.createSoyContext();

		soyContext.put(
			"urlChangeTrackingConfiguration",
			_themeDisplay.getPortalURL() +
				"/o/change-tracking/configurations/" +
					_themeDisplay.getCompanyId());
		soyContext.put("portletNamespace", _renderResponse.getNamespace());
		soyContext.put("portalURL", _themeDisplay.getPortalURL());
		soyContext.put(
			"spritemap",
			_themeDisplay.getPathThemeImages() + "/lexicon/icons.svg");

		Map<String, String> translations = new HashMap<>();

		translations.put(
			"change-lists-help",
			LanguageUtil.get(_request, "change-lists-help"));
		translations.put(
			"enable-change-lists",
			LanguageUtil.get(_request, "enable-change-lists"));
		translations.put(
			"save-and-go-to-overview",
			LanguageUtil.get(_request, "save-and-go-to-overview"));
		translations.put(
			"supported-content-types",
			LanguageUtil.get(_request, "supported-content-types"));

		soyContext.put("translations", translations);

		return soyContext;
	}

	private final RenderResponse _renderResponse;
	private final HttpServletRequest _request;
	private final ThemeDisplay _themeDisplay;

}