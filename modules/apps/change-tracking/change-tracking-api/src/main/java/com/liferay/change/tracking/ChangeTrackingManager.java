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

package com.liferay.change.tracking;

import aQute.bnd.annotation.ProviderType;

import com.liferay.change.tracking.model.ChangeTrackingCollection;
import com.liferay.change.tracking.model.ChangeTrackingEntry;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.List;
import java.util.Optional;

/**
 * Provides the main internal manager interface to interact with the Change
 * Tracking framework.
 *
 * @author Daniel Kocsis
 */
@ProviderType
public interface ChangeTrackingManager {

	/**
	 * Changes the selected change collection for the given user.
	 *
	 * @param companyId the primary key of the company
	 * @param userId the primary key of the user
	 * @param ctCollectionId the primary key of the selected change
	 *        collection
	 */
	public void checkoutCTCollection(
		long companyId, long userId, long ctCollectionId);

	/**
	 * Creates a new change collection.
	 *
	 * @param  companyId the primary key of the company
	 * @param  userId the primary key of the user who initiated the action
	 * @param  name the name of the change collection
	 * @param  description the description of the change collection
	 * @return the newly created change collection
	 */
	public Optional<ChangeTrackingCollection> createCTCollection(
		long companyId, long userId, String name, String description);

	/**
	 * Deletes a change collection.
	 *
	 * @param userId the primary key of the user who initiated the action
	 * @param ctCollectionId the primary key of the change
	 *        collection
	 */
	public void deleteCTCollection(long userId, long ctCollectionId);

	/**
	 * Disables the change tracking functionality in the scope of the given
	 * company. As a side effect it deletes all the related change collections
	 * and entries.
	 *
	 * @param companyId the primary key of the company
	 * @param userId the primary key of the user who initiated the action
	 */
	public void disableChangeTracking(long companyId, long userId);

	/**
	 * Enables the change tracking feature in the scope of the given company.
	 *
	 * @param companyId the primary key of the company
	 * @param userId the primary key of the user who initiated the action
	 */
	public void enableChangeTracking(long companyId, long userId);

	/**
	 * Returns the active change collection associated with the given user in
	 * the scope of the given company.
	 *
	 * @param  companyId the primary key of the company
	 * @param  userId the primary key of the user
	 * @return the selected change collection
	 */
	public Optional<ChangeTrackingCollection> getActiveCTCollectionOptional(
		long companyId, long userId);

	/**
	 * Returns the change collection identified by the primary key.
	 *
	 * @param  ctCollectionId the primary key of the change
	 *         collection
	 * @return the change collection
	 */
	public Optional<ChangeTrackingCollection> getCTCollectionOptional(
		long ctCollectionId);

	/**
	 * Returns all the change collection associated with the given company.
	 *
	 * @param  companyId the primary key of the company
	 * @return the list of change collections
	 */
	public List<ChangeTrackingCollection> getCTCollections(long companyId);

	/**
	 * Returns all the change entries associated with the given change
	 * collection.
	 *
	 * @param  ctCollectionId the primary key of the change
	 *         collection
	 * @return the list of change entries
	 */
	public List<ChangeTrackingEntry> getCTEntries(long ctCollectionId);

	/**
	 * Returns the special change collection which is called production and
	 * contains all the changes published before.
	 *
	 * @param  companyId the primary key of the company
	 * @return the production change collection
	 */
	public Optional<ChangeTrackingCollection> getProductionCTCollectionOptional(
		long companyId);

	/**
	 * Returns <code>true</code> if the change tracking is enabled in the scope
	 * of the given company or <code>false</code> if not.
	 *
	 * @param  companyId the primary key of the company
	 * @return <code>true</code> if change tracking is enabled in the scope of
	 *         the given company; <code>false</code> otherwise.
	 */
	public boolean isChangeTrackingEnabled(long companyId);

	/**
	 * Returns <code>true</code> if the given base model supports change
	 * tracking or <code>false</code> if not.
	 *
	 * @param  companyId the primary key of the company
	 * @param  clazz the class object
	 * @return <code>true</code> if the given base model supports change
	 *         tracking; <code>false</code> otherwise.
	 */
	public boolean isChangeTrackingSupported(
		long companyId, Class<BaseModel> clazz);

	/**
	 * Publishes all the change entries from the given change collection to the
	 * production change collection.
	 *
	 * @param companyId the primary key of the company
	 * @param userId the primary key of the user
	 * @param ctCollectionId the primary key of the change
	 *        collection
	 */
	public void publishCTCollection(
		long companyId, long userId, long ctCollectionId);

}