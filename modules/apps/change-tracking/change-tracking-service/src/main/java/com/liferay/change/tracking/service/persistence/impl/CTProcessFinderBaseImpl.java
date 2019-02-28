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

package com.liferay.change.tracking.service.persistence.impl;

import com.liferay.change.tracking.model.CTProcess;
import com.liferay.change.tracking.service.persistence.CTProcessPersistence;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CTProcessFinderBaseImpl extends BasePersistenceImpl<CTProcess> {

	public CTProcessFinderBaseImpl() {
		setModelClass(CTProcess.class);
	}

	/**
	 * Returns the ct process persistence.
	 *
	 * @return the ct process persistence
	 */
	public CTProcessPersistence getCTProcessPersistence() {
		return ctProcessPersistence;
	}

	/**
	 * Sets the ct process persistence.
	 *
	 * @param ctProcessPersistence the ct process persistence
	 */
	public void setCTProcessPersistence(
		CTProcessPersistence ctProcessPersistence) {

		this.ctProcessPersistence = ctProcessPersistence;
	}

	@BeanReference(type = CTProcessPersistence.class)
	protected CTProcessPersistence ctProcessPersistence;

}