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

package com.liferay.portal.background.task.internal.comparator;

import com.liferay.portal.background.task.model.BackgroundTask;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.util.Date;

/**
 * @author Eduardo Garcia
 */
public class BackgroundTaskDurationComparator
	extends OrderByComparator<BackgroundTask> {

	public static final String ORDER_BY_ASC = "duration ASC";

	public static final String ORDER_BY_DESC = "duration DESC";

	public static final String[] ORDER_BY_FIELDS = {"duration"};

	public BackgroundTaskDurationComparator() {
		this(false);
	}

	public BackgroundTaskDurationComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(
		BackgroundTask backgroundTask1, BackgroundTask backgroundTask2) {

		Date completionDate1 = backgroundTask1.getCompletionDate();
		Date completionDate2 = backgroundTask2.getCompletionDate();
		Date startDate1 = backgroundTask1.getCreateDate();
		Date startDate2 = backgroundTask2.getCreateDate();

		long duration1 = 0;
		long duration2 = 0;

		if ((startDate1 != null) && (completionDate1 != null)) {
			duration1 = completionDate1.getTime() - startDate1.getTime();
		}

		if ((startDate2 != null) && (completionDate2 != null)) {
			duration2 = completionDate2.getTime() - startDate2.getTime();
		}

		int value = Long.compare(duration1, duration2);

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private final boolean _ascending;

}