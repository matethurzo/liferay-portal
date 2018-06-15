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

package com.liferay.journal.internal.model.listener;

import com.liferay.changeset.model.ChangesetCollection;
import com.liferay.changeset.model.ChangesetEntry;
import com.liferay.changeset.service.ChangesetCollectionLocalService;
import com.liferay.changeset.service.ChangesetEntryLocalService;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerRegistryUtil;
import com.liferay.exportimport.kernel.staging.Staging;
import com.liferay.exportimport.kernel.staging.StagingConstants;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalArticleResource;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.service.ClassNameLocalService;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.staging.model.listener.StagingModelListener;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Akos Thurzo
 */
@Component(immediate = true, service = ModelListener.class)
public class JournalArticleStagingModelListener
	extends BaseModelListener<JournalArticle> {

	@Override
	public void onAfterCreate(JournalArticle journalArticle)
		throws ModelListenerException {

		_stagingModelListener.onAfterCreate(journalArticle);

		_addResourceEntityToChangeset(journalArticle);
	}

	@Override
	public void onAfterRemove(JournalArticle journalArticle)
		throws ModelListenerException {

		_stagingModelListener.onAfterRemove(journalArticle);

		long articleClassNameId = _classNameLocalService.getClassNameId(
			journalArticle.getModelClass());

		try {
			ChangesetCollection changesetCollection =
				_changesetCollectionLocalService.fetchOrAddChangesetCollection(
					journalArticle.getGroupId(),
					StagingConstants.
						RANGE_FROM_LAST_PUBLISH_DATE_CHANGESET_NAME);

			long articleResourceClassNameId =
				_classNameLocalService.getClassNameId(
					JournalArticleResource.class);

			_deleteUnnecessaryResourceEntity(
				changesetCollection, articleClassNameId,
				journalArticle.getResourcePrimKey(),
				articleResourceClassNameId);
		}
		catch (PortalException pe) {
			_log.error(pe.getMessage(), pe);
		}
	}

	@Override
	public void onAfterUpdate(JournalArticle journalArticle)
		throws ModelListenerException {

		_stagingModelListener.onAfterUpdate(journalArticle);

		_addResourceEntityToChangeset(journalArticle);
	}

	private void _addResourceEntityToChangeset(JournalArticle journalArticle) {
		try {
			ChangesetCollection changesetCollection =
				_changesetCollectionLocalService.fetchOrAddChangesetCollection(
					journalArticle.getGroupId(),
					StagingConstants.
						RANGE_FROM_LAST_PUBLISH_DATE_CHANGESET_NAME);

			long articleClassNameId = _classNameLocalService.getClassNameId(
				journalArticle.getModelClass());

			ChangesetEntry changesetEntry =
				_changesetEntryLocalService.fetchChangesetEntry(
					changesetCollection.getChangesetCollectionId(),
					articleClassNameId, journalArticle.getId());

			JournalArticleResource journalArticleResource =
				journalArticle.getArticleResource();

			long articleResourceClassNameId =
				_classNameLocalService.getClassNameId(
					journalArticleResource.getModelClass());

			_deleteUnnecessaryResourceEntity(
				changesetCollection, articleClassNameId,
				journalArticleResource.getResourcePrimKey(),
				articleResourceClassNameId);

			if (changesetEntry == null) {
				return;
			}

			if (journalArticle.getStatus() !=
					WorkflowConstants.STATUS_IN_TRASH) {

				_changesetEntryLocalService.fetchOrAddChangesetEntry(
					changesetCollection.getChangesetCollectionId(),
					articleResourceClassNameId,
					journalArticleResource.getPrimaryKey());
			}
		}
		catch (PortalException pe) {
			_log.error(pe.getMessage(), pe);
		}
	}

	private void _deleteUnnecessaryResourceEntity(
		ChangesetCollection changesetCollection, long articleClassNameId,
		long journalArticleResourcePrimKey, long articleResourceClassNameId) {

		List<JournalArticle> articlesVersions =
			_journalArticleLocalService.getArticlesByResourcePrimKey(
				journalArticleResourcePrimKey);

		Set<Long> classPKs = new HashSet<>();

		StagedModelDataHandler stagedModelDataHandler =
			StagedModelDataHandlerRegistryUtil.getStagedModelDataHandler(
				JournalArticle.class.getName());

		for (JournalArticle articleVersion : articlesVersions) {
			if (ArrayUtil.contains(
					stagedModelDataHandler.getExportableStatuses(),
					articleVersion.getStatus())) {

				classPKs.add(articleVersion.getId());
			}
		}

		long journalChangetEntriesCount =
			_changesetEntryLocalService.getChangesetEntriesCount(
				changesetCollection.getChangesetCollectionId(),
				articleClassNameId, classPKs);

		if (journalChangetEntriesCount == 0) {
			_changesetEntryLocalService.deleteEntry(
				changesetCollection.getChangesetCollectionId(),
				articleResourceClassNameId, journalArticleResourcePrimKey);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		JournalArticleStagingModelListener.class);

	@Reference
	private ChangesetCollectionLocalService _changesetCollectionLocalService;

	@Reference
	private ChangesetEntryLocalService _changesetEntryLocalService;

	@Reference
	private ClassNameLocalService _classNameLocalService;

	@Reference
	private JournalArticleLocalService _journalArticleLocalService;

	@Reference
	private Staging _staging;

	@Reference
	private StagingModelListener<JournalArticle> _stagingModelListener;

}