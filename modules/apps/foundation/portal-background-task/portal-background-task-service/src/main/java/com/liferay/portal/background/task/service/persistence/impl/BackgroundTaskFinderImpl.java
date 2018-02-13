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

package com.liferay.portal.background.task.service.persistence.impl;

import com.liferay.portal.background.task.model.BackgroundTask;
import com.liferay.portal.background.task.model.impl.BackgroundTaskImpl;
import com.liferay.portal.background.task.service.persistence.BackgroundTaskFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQLUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Iterator;
import java.util.List;

/**
 * @author Zoltan Csaszi
 */
public class BackgroundTaskFinderImpl
	extends BackgroundTaskFinderBaseImpl implements BackgroundTaskFinder {

	public static final String COUNT_BY_G_T_C =
		BackgroundTaskFinder.class.getName() + ".countByG_T_C";

	public static final String FIND_BY_G_T_C =
		BackgroundTaskFinder.class.getName() + ".findByG_T_C";

	@Override
	public int countByG_T_C(
		long[] groupIds, String[] taskExecutorClassNames, Boolean completed) {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(getClass(), COUNT_BY_G_T_C);

			sql = _replaceWhereConditions(
				groupIds, taskExecutorClassNames, sql, completed);

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			for (long groupId : groupIds) {
				qPos.add(groupId);
			}

			for (String taskExecutorClassName : taskExecutorClassNames) {
				qPos.add(taskExecutorClassName);
			}

			if (completed != null) {
				qPos.add(completed.booleanValue());
			}

			Iterator<Long> itr = q.iterate();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}

			return 0;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	public List<BackgroundTask> findByG_T_C(
		long[] groupIds, String[] taskExecutorClassNames, Boolean completed,
		int start, int end,
		OrderByComparator<BackgroundTask> orderByComparator) {

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(getClass(), FIND_BY_G_T_C);

			sql = _replaceWhereConditions(
				groupIds, taskExecutorClassNames, sql, completed);

			sql = CustomSQLUtil.replaceOrderBy(sql, orderByComparator);

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addEntity("BackgroundTask", BackgroundTaskImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			for (long groupId : groupIds) {
				qPos.add(groupId);
			}

			for (String taskExecutorClassName : taskExecutorClassNames) {
				qPos.add(taskExecutorClassName);
			}

			if (completed != null) {
				qPos.add(completed.booleanValue());
			}

			return (List<BackgroundTask>)
				QueryUtil.list(q, getDialect(), start, end);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	private void _appendIfTrue(
		boolean condition, StringBundler sb, String text) {

		if (condition) {
			sb.append(text);
		}
	}

	private String _getGroupCriteria(long[] groupIds) {
		StringBundler groupCriteriasSB = new StringBundler();

		String result = StringPool.BLANK;

		if (groupIds.length > 0) {
			groupCriteriasSB.append(StringPool.OPEN_PARENTHESIS);

			for (long groupId : groupIds) {
				groupCriteriasSB.append("(BackgroundTask.groupId = ? ) OR ");
			}

			groupCriteriasSB.append(StringPool.CLOSE_PARENTHESIS);

			result = groupCriteriasSB.toString();

			result = StringUtil.replaceLast(result, " OR ", StringPool.BLANK);
		}

		return result;
	}

	private String _getTaskExecutorClassNameCriteria(String[] classNames) {
		StringBundler taskExecutorCriteriasSB = new StringBundler();

		String result = StringPool.BLANK;

		if (classNames.length > 0) {
			taskExecutorCriteriasSB.append(StringPool.OPEN_PARENTHESIS);

			for (String className : classNames) {
				taskExecutorCriteriasSB.append(
					"(BackgroundTask.taskExecutorClassName = ? ) OR ");
			}

			taskExecutorCriteriasSB.append(StringPool.CLOSE_PARENTHESIS);

			result = taskExecutorCriteriasSB.toString();

			result = StringUtil.replaceLast(result, " OR ", StringPool.BLANK);
		}

		return result;
	}

	private String _replaceWhereConditions(
		long[] groupIds, String[] taskExecutorClassNames, String sql,
		Boolean completed) {

		StringBundler innerSqlSB = new StringBundler(5);

		String groupCriteria = GetterUtil.getString(
			_getGroupCriteria(groupIds));
		String taskExecutorCriteria = GetterUtil.getString(
			_getTaskExecutorClassNameCriteria(taskExecutorClassNames));

		innerSqlSB.append(groupCriteria);

		_appendIfTrue(
			!groupCriteria.isEmpty() && !taskExecutorCriteria.isEmpty(),
			innerSqlSB, " AND ");

		innerSqlSB.append(taskExecutorCriteria);

		if (completed != null) {
			_appendIfTrue(
				Validator.isNotNull(groupCriteria + taskExecutorCriteria),
				innerSqlSB, " AND ");

			innerSqlSB.append("(BackgroundTask.completed = ?)");
		}

		if (Validator.isNotNull(innerSqlSB.toString())) {
			sql = StringUtil.replace(
				sql, "[$WHERE_CONDITIONS$]", "WHERE " + innerSqlSB.toString());
		}
		else {
			sql = StringUtil.replace(
				sql, "[$WHERE_CONDITIONS$]", StringPool.BLANK);
		}

		return sql;
	}

}