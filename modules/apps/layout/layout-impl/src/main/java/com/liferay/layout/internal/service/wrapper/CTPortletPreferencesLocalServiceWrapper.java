/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.layout.internal.service.wrapper;

import com.liferay.portal.kernel.model.LayoutVersion;
import com.liferay.portal.kernel.model.PortletPreferences;
import com.liferay.portal.kernel.service.PortletPreferencesLocalService;
import com.liferay.portal.kernel.service.PortletPreferencesLocalServiceWrapper;
import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.LayoutVersionPersistence;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mate Thurzo
 */
@Component(immediate = true, service = ServiceWrapper.class)
public class CTPortletPreferencesLocalServiceWrapper
	extends PortletPreferencesLocalServiceWrapper {

	public CTPortletPreferencesLocalServiceWrapper() {
		super(null);
	}

	public CTPortletPreferencesLocalServiceWrapper(
		PortletPreferencesLocalService portletPreferencesLocalService) {
		super(portletPreferencesLocalService);
	}

	@Reference(unbind = "-")
	protected void setPortletPreferencesLocalService(PortletPreferencesLocalService portletPreferencesLocalService) {

		// Needed for synchronization

	}

	@Override
	public List<PortletPreferences> getPortletPreferences(
		long ownerId, int ownerType, long plid) {

		boolean override = true;
		int version = 11;

		if (override && plid == 161) {
			return new ArrayList<>(super.getLayoutVersionPortletPreferences(version));
		}

		return super.getPortletPreferences(ownerId, ownerType, plid);
	}

	@Reference
	private LayoutVersionPersistence _layoutVersionPersistence;

}
