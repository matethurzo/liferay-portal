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

package com.liferay.portal.kernel.search;

import aQute.bnd.annotation.ProviderType;
import com.liferay.portal.kernel.util.AutoResetThreadLocal;

/**
 * @author Daniel Kocsis
 */
@ProviderType
public class IndexingThreadLocal {

	public static boolean isIndexingDisabled() {
		return !isIndexingEnabled();
	}

	public static boolean isIndexingEnabled() {
		return _indexingEnabled.get();
	}

	public static void setIndexingEnabled(boolean indexingEnabled) {
		_indexingEnabled.set(indexingEnabled);
	}

	private static final ThreadLocal<Boolean> _indexingEnabled =
		new AutoResetThreadLocal<>(
			IndexingThreadLocal.class + "._indexingEnabled",
			() -> Boolean.TRUE);

}