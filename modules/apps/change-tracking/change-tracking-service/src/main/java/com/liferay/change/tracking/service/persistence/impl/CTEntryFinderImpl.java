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
import com.liferay.change.tracking.model.impl.CTEntryImpl;
import com.liferay.change.tracking.service.persistence.CTEntryFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryDefinition;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.util.List;

/**
 * @author Daniel Kocsis
 */
public class CTEntryFinderImpl
	extends CTEntryFinderBaseImpl implements CTEntryFinder {

	public static final String FIND_BY_CT_COLLECTION_ID =
		CTEntryFinder.class.getName() + ".findByCTCollectionId";

	@Override
	@SuppressWarnings("unchecked")
	public List<CTEntry> findByCTCollectionId(
		long ctCollectionId, QueryDefinition<CTEntry> queryDefinition) {

		Session session = null;

		try {
			session = openSession();

			String sql = _customSQL.get(getClass(), FIND_BY_CT_COLLECTION_ID);

			if (queryDefinition.isExcludeStatus()) {
				sql = _customSQL.appendCriteria(
					sql, "AND (CTEntry.status != ?)");
			}
			else {
				sql = _customSQL.appendCriteria(
					sql, "AND (CTEntry.status = ?)");
			}

			sql = _customSQL.replaceOrderBy(
				sql, queryDefinition.getOrderByComparator());

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addEntity("CTEntry", CTEntryImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(ctCollectionId);
			qPos.add(queryDefinition.getStatus());

			return (List<CTEntry>)QueryUtil.list(
				q, getDialect(), queryDefinition.getStart(),
				queryDefinition.getEnd());
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<CTEntry> findByC_R(
		long ctCollectionId, long resourcePrimKey,
		QueryDefinition<CTEntry> queryDefinition) {

		Session session = null;

		try {
			session = openSession();

			String sql = _customSQL.get(getClass(), FIND_BY_CT_COLLECTION_ID);

			if (resourcePrimKey > 0) {
				sql = _customSQL.appendCriteria(
					sql, "AND (CTEntry.resourcePrimKey = ?)");
			}

			sql = _customSQL.replaceOrderBy(
				sql, queryDefinition.getOrderByComparator());

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addEntity("CTEntry", CTEntryImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(ctCollectionId);

			if (resourcePrimKey > 0) {
				qPos.add(resourcePrimKey);
			}

			return (List<CTEntry>)QueryUtil.list(
				q, getDialect(), queryDefinition.getStart(),
				queryDefinition.getEnd());
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public CTEntry findByC_C_C(
		long ctCollectionId, long classNameId, long classPK) {

		Session session = null;

		try {
			session = openSession();

			String sql = _customSQL.get(getClass(), FIND_BY_CT_COLLECTION_ID);

			sql = _customSQL.appendCriteria(
				sql, "AND (CTEntry.classNameId = ?)");

			sql = _customSQL.appendCriteria(sql, "AND (CTEntry.classPK = ?)");

			SQLQuery q = session.createSynchronizedSQLQuery(sql);

			q.addEntity("CTEntry", CTEntryImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(ctCollectionId);

			qPos.add(classNameId);

			qPos.add(classPK);

			List<CTEntry> ctEntries = q.list();

			if (!ctEntries.isEmpty()) {
				return ctEntries.get(0);
			}

			return null;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@ServiceReference(type = CustomSQL.class)
	private CustomSQL _customSQL;

}