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

package com.liferay.asset.categories.admin.web.internal.exportimport.data.handler;

import com.liferay.asset.categories.admin.web.internal.exportimport.staged.model.repository.StagedAssetLinkStagedModelRepository;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.adapter.StagedAssetLink;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.exportimport.data.handler.base.BaseStagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandler;
import com.liferay.exportimport.staged.model.repository.StagedModelRepository;
import com.liferay.portal.kernel.model.StagedModel;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Mate Thurzo
 */
@Component(immediate = true, service = StagedModelDataHandler.class)
public class StagedAssetLinkStagedModelDataHandler
	extends BaseStagedModelDataHandler<StagedAssetLink> {

	public static final String[] CLASS_NAMES =
		{StagedAssetLink.class.getName()};

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	protected void addAssetReference(
		PortletDataContext portletDataContext, StagedAssetLink stagedAssetLink,
		AssetEntry assetEntry) {

		AssetRenderer<? extends StagedModel> assetRenderer = null;
		StagedModel stagedModel = null;

		try {
			assetRenderer =
				(AssetRenderer<? extends StagedModel>)
					assetEntry.getAssetRenderer();

			stagedModel = assetRenderer.getAssetObject();
		}
		catch (Exception e) {
			return;
		}

		if (stagedModel == null) {
			return;
		}

		portletDataContext.addReference(
			stagedAssetLink, stagedModel,
			PortletDataContext.REFERENCE_TYPE_DEPENDENCY_DISPOSABLE, true);
	}

	@Override
	protected void doExportStagedModel(
			PortletDataContext portletDataContext,
			StagedAssetLink stagedAssetLink)
		throws Exception {

		portletDataContext.startStagedModelExport(stagedAssetLink);

		AssetEntry assetEntry1 = _assetEntryLocalService.fetchEntry(
			stagedAssetLink.getEntryId1());

		addAssetReference(portletDataContext, stagedAssetLink, assetEntry1);

		AssetEntry assetEntry2 = _assetEntryLocalService.fetchEntry(
			stagedAssetLink.getEntryId2());

		addAssetReference(portletDataContext, stagedAssetLink, assetEntry2);

		portletDataContext.addStagedModel(stagedAssetLink);

		portletDataContext.endStagedModelExport(stagedAssetLink);
	}

	@Override
	protected void doImportStagedModel(
			PortletDataContext portletDataContext,
			StagedAssetLink stagedAssetLink)
		throws Exception {

		StagedAssetLink existingStagedAssetLink =
			_stagedAssetLinkStagedModelRepository.fetchExistingAssetLink(
				portletDataContext.getScopeGroupId(),
				stagedAssetLink.getEntry1Uuid(),
				stagedAssetLink.getEntry2Uuid());

		if ((existingStagedAssetLink == null) ||
			!portletDataContext.isDataStrategyMirror()) {

			_stagedAssetLinkStagedModelRepository.addStagedModel(
				portletDataContext, stagedAssetLink);
		}
		else {
			_stagedAssetLinkStagedModelRepository.updateStagedModel(
				portletDataContext, existingStagedAssetLink);
		}
	}

	@Override
	protected StagedModelRepository<StagedAssetLink>
		getStagedModelRepository() {

		return _stagedAssetLinkStagedModelRepository;
	}

	@Reference(unbind = "-")
	protected void setAssetEntryLocalService(
		AssetEntryLocalService assetEntryLocalService) {

		_assetEntryLocalService = assetEntryLocalService;
	}

	@Reference(
		target = "(model.class.name=com.liferay.asset.kernel.model.adapter.StagedAssetLink)",
		unbind = "-"
	)
	protected void setStagedAssetLinkStagedModelRepository(
		StagedAssetLinkStagedModelRepository
			stagedAssetLinkStagedModelRepository) {

		_stagedAssetLinkStagedModelRepository =
			stagedAssetLinkStagedModelRepository;
	}

	private AssetEntryLocalService _assetEntryLocalService;
	private StagedAssetLinkStagedModelRepository
		_stagedAssetLinkStagedModelRepository;

}