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

package com.liferay.bulk.rest.internal.graphql.mutation.v1_0;

import com.liferay.bulk.rest.dto.v1_0.BulkActionResponseModel;
import com.liferay.bulk.rest.dto.v1_0.BulkAssetEntryActionModel;
import com.liferay.bulk.rest.dto.v1_0.BulkAssetEntryCommonCategoriesModel;
import com.liferay.bulk.rest.dto.v1_0.BulkAssetEntryCommonTagsModel;
import com.liferay.bulk.rest.dto.v1_0.BulkAssetEntryUpdateCategoriesActionModel;
import com.liferay.bulk.rest.dto.v1_0.BulkAssetEntryUpdateTagsActionModel;
import com.liferay.bulk.rest.internal.resource.v1_0.BulkActionResponseModelResourceImpl;
import com.liferay.bulk.rest.resource.v1_0.BulkActionResponseModelResource;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLInvokeDetached;
import graphql.annotations.annotationTypes.GraphQLName;

import javax.annotation.Generated;

/**
 * @author Javier Gamarra
 * @generated
 */
@Generated("")
public class Mutation {

	@GraphQLField
	@GraphQLInvokeDetached
	public BulkActionResponseModel postCategoryClassName(
			@GraphQLName("category-class-name-id") Long categoryClassNameId,
			@GraphQLName("BulkAssetEntryUpdateCategoriesActionModel")
				BulkAssetEntryUpdateCategoriesActionModel
					bulkAssetEntryUpdateCategoriesActionModel)
		throws Exception {

		BulkActionResponseModelResource bulkActionResponseModelResource =
			_createBulkActionResponseModelResource();

		return bulkActionResponseModelResource.postCategoryClassName(
			categoryClassNameId, bulkAssetEntryUpdateCategoriesActionModel);
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public BulkAssetEntryCommonCategoriesModel
			postCategoryGroupCategoryClassName(
				@GraphQLName("category-group-id") Long categoryGroupId,
				@GraphQLName("category-class-name-id") Long categoryClassNameId,
				@GraphQLName("BulkAssetEntryActionModel")
					BulkAssetEntryActionModel bulkAssetEntryActionModel)
		throws Exception {

		BulkActionResponseModelResource bulkActionResponseModelResource =
			_createBulkActionResponseModelResource();

		return bulkActionResponseModelResource.
			postCategoryGroupCategoryClassName(
				categoryGroupId, categoryClassNameId,
				bulkAssetEntryActionModel);
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public BulkActionResponseModel postTagClassName(
			@GraphQLName("tag-class-name-id") Long tagClassNameId,
			@GraphQLName("BulkAssetEntryUpdateTagsActionModel")
				BulkAssetEntryUpdateTagsActionModel
					bulkAssetEntryUpdateTagsActionModel)
		throws Exception {

		BulkActionResponseModelResource bulkActionResponseModelResource =
			_createBulkActionResponseModelResource();

		return bulkActionResponseModelResource.postTagClassName(
			tagClassNameId, bulkAssetEntryUpdateTagsActionModel);
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public BulkAssetEntryCommonTagsModel postTagGroupTagClassName(
			@GraphQLName("tag-group-id") Long tagGroupId,
			@GraphQLName("tag-class-name-id") Long tagClassNameId,
			@GraphQLName("BulkAssetEntryActionModel") BulkAssetEntryActionModel
				bulkAssetEntryActionModel)
		throws Exception {

		BulkActionResponseModelResource bulkActionResponseModelResource =
			_createBulkActionResponseModelResource();

		return bulkActionResponseModelResource.postTagGroupTagClassName(
			tagGroupId, tagClassNameId, bulkAssetEntryActionModel);
	}

	private static BulkActionResponseModelResource
		_createBulkActionResponseModelResource() {

		return new BulkActionResponseModelResourceImpl();
	}

}