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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutVersion;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.LayoutLocalServiceWrapper;
import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.LayoutVersionPersistence;
import com.liferay.portal.model.impl.LayoutImpl;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Mate Thurzo
 */
@Component(immediate = true, service = ServiceWrapper.class)
public class CTLayoutLocalServiceWrapper
	extends LayoutLocalServiceWrapper {

	public CTLayoutLocalServiceWrapper() {
		super(null);
	}

	public CTLayoutLocalServiceWrapper(LayoutLocalService layoutLocalService) {
		super(layoutLocalService);
	}

	@Reference(unbind = "-")
	protected void setLayoutLocalService(LayoutLocalService layoutLocalService) {

		// Needed for synchronization

	}

	@Override
	public Layout getLayout(long plid) throws PortalException {

		boolean override = true;
		int version = 11;

		if (override && plid == 161) {
			LayoutVersion layoutVersion =
				_layoutVersionPersistence.fetchByPlid_Version(plid, version);

			return layoutVersion.toVersionedModel();
		}

		return super.getLayout(plid);
	}

	@Override
	public Layout getLayout(long groupId, boolean privateLayout, long layoutId)
		throws PortalException {

		boolean override = true;
		int version = 11;

		if (override && groupId == 20123 && !privateLayout && layoutId == 3) {

			LayoutVersion layoutVersion =
				_layoutVersionPersistence.fetchByG_P_L_Version(groupId,
					privateLayout, layoutId, version);

			return layoutVersion.toVersionedModel();
		}

		return super.getLayout(groupId, privateLayout, layoutId);
	}

	@Reference
	private LayoutVersionPersistence _layoutVersionPersistence;

}
