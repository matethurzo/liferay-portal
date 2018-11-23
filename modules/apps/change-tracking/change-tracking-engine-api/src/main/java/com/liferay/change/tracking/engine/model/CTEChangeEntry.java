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

package com.liferay.change.tracking.engine.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the CTEChangeEntry service. Represents a row in the &quot;CTEChangeEntry&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see CTEChangeEntryModel
 * @see com.liferay.change.tracking.engine.model.impl.CTEChangeEntryImpl
 * @see com.liferay.change.tracking.engine.model.impl.CTEChangeEntryModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.change.tracking.engine.model.impl.CTEChangeEntryImpl")
@ProviderType
public interface CTEChangeEntry extends CTEChangeEntryModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.change.tracking.engine.model.impl.CTEChangeEntryImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<CTEChangeEntry, Long> CTE_CHANGE_ENTRY_ID_ACCESSOR =
		new Accessor<CTEChangeEntry, Long>() {
			@Override
			public Long get(CTEChangeEntry cteChangeEntry) {
				return cteChangeEntry.getCteChangeEntryId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<CTEChangeEntry> getTypeClass() {
				return CTEChangeEntry.class;
			}
		};
}