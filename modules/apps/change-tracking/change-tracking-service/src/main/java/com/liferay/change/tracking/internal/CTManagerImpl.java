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

package com.liferay.change.tracking.internal;

import com.liferay.change.tracking.CTManager;
import com.liferay.change.tracking.model.CTEntry;
import com.liferay.portal.kernel.dao.orm.QueryDefinition;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.osgi.service.component.annotations.Component;

/**
 * @author Daniel Kocsis
 */
@Component(immediate = true, service = CTManager.class)
public class CTManagerImpl implements CTManager {

	@Override
	public Optional<CTEntry> registerChange(
		long userId, long classNameId, long classPK, long resourcePrimKey) {

		return Optional.empty();
	}

	@Override
	public List<CTEntry> retrieveAllChanges(long userId, long resourcePrimKey) {
		return Collections.emptyList();
	}

	@Override
	public List<CTEntry> retrieveAllChanges(
		long userId, long resourcePrimKey,
		QueryDefinition<CTEntry> queryDefinition) {

		return Collections.emptyList();
	}

	@Override
	public Optional<CTEntry> retrieveChange(
		long userId, long classNameId, long classPK) {

		return Optional.empty();
	}

	@Override
	public Optional<CTEntry> retrieveLatestChange(
		long userId, long resourcePrimKey) {

		return Optional.empty();
	}

}