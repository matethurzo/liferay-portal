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

package com.liferay.change.tracking.kernel.util;

import com.liferay.petra.lang.CentralizedThreadLocal;

/**
 * @author Daniel Kocsis
 */
public class ChangeTrackingThreadLocal {

	public static boolean isLayoutTrackingEnabled() {
		return _layoutTrackingEnabled.get();
	}

	public static boolean isLayoutUpdateInProgress() {
		return _layoutUpdateInProgress.get();
	}

	public static boolean isModelUpdateInProgress() {
		return _modelUpdateInProgress.get();
	}

	public static void setLayoutTrackingDefaultEnabled(
		boolean layoutTrackingDefaultEnabled) {

		_layoutTrackingDefaultEnabled = layoutTrackingDefaultEnabled;
	}

	public static void setLayoutTrackingEnabled(boolean enabled) {
		_layoutTrackingEnabled.set(enabled);
	}

	public static void setLayoutUpdateInProgress(
		boolean layoutUpgradeInProgress) {

		_layoutUpdateInProgress.set(layoutUpgradeInProgress);
	}

	public static void setModelUpdateInProgress(boolean modelUpdateInProgress) {
		_modelUpdateInProgress.set(modelUpdateInProgress);
	}

	private static boolean _layoutTrackingDefaultEnabled;
	private static final ThreadLocal<Boolean> _layoutTrackingEnabled =
		new CentralizedThreadLocal<>(
			ChangeTrackingThreadLocal.class + "._layoutTrackingEnabled",
			() -> _layoutTrackingDefaultEnabled);
	private static final ThreadLocal<Boolean> _layoutUpdateInProgress =
		new CentralizedThreadLocal<>(
			ChangeTrackingThreadLocal.class + "._layoutUpdateInProgress",
			() -> Boolean.FALSE);
	private static final ThreadLocal<Boolean> _modelUpdateInProgress =
		new CentralizedThreadLocal<>(
			ChangeTrackingThreadLocal.class + "_modelUpdateInProgress",
			() -> Boolean.FALSE);

}