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

package com.liferay.document.library.opener.google.drive.internal.servlet.taglib.ui;

import com.liferay.document.library.opener.google.drive.internal.configuration.DLOpenerGoogleDriveCompanyConfiguration;
import com.liferay.document.library.opener.google.drive.internal.constants.DLOpenerGoogleDriveConstants;
import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.servlet.taglib.ui.BaseJSPFormNavigatorEntry;
import com.liferay.portal.kernel.servlet.taglib.ui.FormNavigatorConstants;
import com.liferay.portal.kernel.servlet.taglib.ui.FormNavigatorEntry;
import com.liferay.portal.kernel.settings.CompanyServiceSettingsLocator;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alejandro Tardín
 */
@Component(immediate = true, service = FormNavigatorEntry.class)
public class DLOpenerGoogleDriveCompanySettingsFormNavigatorEntry
	extends BaseJSPFormNavigatorEntry<Company>
	implements FormNavigatorEntry<Company> {

	@Override
	public String getCategoryKey() {
		return FormNavigatorConstants.
			CATEGORY_KEY_COMPANY_SETTINGS_MISCELLANEOUS;
	}

	@Override
	public String getFormNavigatorId() {
		return FormNavigatorConstants.FORM_NAVIGATOR_ID_COMPANY_SETTINGS;
	}

	@Override
	public String getKey() {
		return "google-drive-opener-configuration-name";
	}

	@Override
	public String getLabel(Locale locale) {
		ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
			locale, DLOpenerGoogleDriveCompanySettingsFormNavigatorEntry.class);

		return _language.get(resourceBundle, getKey());
	}

	@Override
	public void include(
			HttpServletRequest request, HttpServletResponse response)
		throws IOException {

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
			WebKeys.THEME_DISPLAY);

		try {
			request.setAttribute(
				DLOpenerGoogleDriveCompanyConfiguration.class.getName(),
				_configurationProvider.getConfiguration(
					DLOpenerGoogleDriveCompanyConfiguration.class,
					new CompanyServiceSettingsLocator(
						themeDisplay.getCompanyId(),
						DLOpenerGoogleDriveConstants.SERVICE_NAME)));

			super.include(request, response);
		}
		catch (ConfigurationException ce) {
			throw new IOException(ce);
		}
	}

	@Override
	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.document.library.opener.google.drive.impl)",
		unbind = "-"
	)
	public void setServletContext(ServletContext servletContext) {
		super.setServletContext(servletContext);
	}

	@Override
	protected String getJspPath() {
		return "/portal_settings/document_library_opener_google_drive.jsp";
	}

	@Reference
	private ConfigurationProvider _configurationProvider;

	@Reference
	private Language _language;

}