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

package com.liferay.journal.change.tracking.internal.util;

import com.liferay.change.tracking.CTEngineManager;
import com.liferay.change.tracking.CTManager;
import com.liferay.change.tracking.model.CTCollection;
import com.liferay.change.tracking.model.CTEntry;
import com.liferay.journal.util.JournalChangeTrackingHelper;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.Optional;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Zoltan Csaszi
 */
@Component(immediate = true, service = JournalChangeTrackingHelper.class)
public class JournalChangeTrackingHelperImpl
	implements JournalChangeTrackingHelper {

	@Override
	public boolean isActiveChangeTracking(long companyId, long userId) {
		if (!_ctEngineManager.isChangeTrackingEnabled(companyId)) {
			return false;
		}

		Optional<CTCollection> productionCTCollectionOptional =
			_ctEngineManager.getProductionCTCollectionOptional(companyId);

		Optional<CTCollection> activeCTCollectionOptional =
			_ctEngineManager.getActiveCTCollectionOptional(userId);

		if (!productionCTCollectionOptional.isPresent() ||
			!activeCTCollectionOptional.isPresent()) {

			return false;
		}

		return !productionCTCollectionOptional.equals(
			activeCTCollectionOptional);
	}

	@Override
	public boolean isInChangeList(long userId, long classNameId, long classPK) {
		Optional<CTEntry> ctEntryOptional =
			_ctManager.getActiveCTCollectionCTEntryOptional(
				userId, classNameId, classPK);

		if (!ctEntryOptional.isPresent()) {
			return false;
		}

		CTEntry ctEntry = ctEntryOptional.get();

		if (ctEntry.getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}

		return false;
	}

	@Reference
	private CTEngineManager _ctEngineManager;

	@Reference
	private CTManager _ctManager;

}