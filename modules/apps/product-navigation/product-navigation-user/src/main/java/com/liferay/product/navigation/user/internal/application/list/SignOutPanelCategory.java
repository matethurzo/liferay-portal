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

package com.liferay.product.navigation.user.internal.application.list;

import com.liferay.application.list.BaseJSPPanelCategory;
import com.liferay.application.list.PanelCategory;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.language.LanguageUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.ServletContext;
import java.util.Locale;

/**
 * @author Mate Thurzo
 */
@Component(
	immediate = true,
	property = {
		"panel.category.key=" + PanelCategoryKeys.USER,
		"panel.category.order:Integer=900"
	},
	service = PanelCategory.class
)
public class SignOutPanelCategory extends BaseJSPPanelCategory {

	@Override
	public String getJspPath() {
		return "/sign_out.jsp";
	}

	@Override
	public String getKey() {
		return PanelCategoryKeys.USER_SIGN_OUT;
	}

	@Override
	public String getLabel(Locale locale) {
		return LanguageUtil.get(locale, "sign-out");
	}

	@Override
	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.product.navigation.user)",
		unbind = "-"
	)
	public void setServletContext(ServletContext servletContext) {
		super.setServletContext(servletContext);
	}

}
