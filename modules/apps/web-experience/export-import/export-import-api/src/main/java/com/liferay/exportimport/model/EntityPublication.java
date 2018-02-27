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

package com.liferay.exportimport.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the EntityPublication service. Represents a row in the &quot;EntityPublication&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see EntityPublicationModel
 * @see com.liferay.exportimport.model.impl.EntityPublicationImpl
 * @see com.liferay.exportimport.model.impl.EntityPublicationModelImpl
 * @generated
 */
@ImplementationClassName("com.liferay.exportimport.model.impl.EntityPublicationImpl")
@ProviderType
public interface EntityPublication extends EntityPublicationModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.exportimport.model.impl.EntityPublicationImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<EntityPublication, Long> ID_ACCESSOR = new Accessor<EntityPublication, Long>() {
			@Override
			public Long get(EntityPublication entityPublication) {
				return entityPublication.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<EntityPublication> getTypeClass() {
				return EntityPublication.class;
			}
		};
}