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

import com.liferay.change.tracking.model.CTEntry;
import com.liferay.change.tracking.service.persistence.CTEntryPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CTEntryFinderBaseImpl extends BasePersistenceImpl<CTEntry> {
	public CTEntryFinderBaseImpl() {
		setModelClass(CTEntry.class);
	}

	/**
	 * Returns the ct entry persistence.
	 *
	 * @return the ct entry persistence
	 */
	public CTEntryPersistence getCTEntryPersistence() {
		return ctEntryPersistence;
	}

	/**
	 * Sets the ct entry persistence.
	 *
	 * @param ctEntryPersistence the ct entry persistence
	 */
	public void setCTEntryPersistence(CTEntryPersistence ctEntryPersistence) {
		this.ctEntryPersistence = ctEntryPersistence;
	}

	@BeanReference(type = CTEntryPersistence.class)
	protected CTEntryPersistence ctEntryPersistence;
}