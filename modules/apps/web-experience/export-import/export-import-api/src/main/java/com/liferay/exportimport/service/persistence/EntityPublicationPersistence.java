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

package com.liferay.exportimport.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.exportimport.exception.NoSuchEntityPublicationException;
import com.liferay.exportimport.model.EntityPublication;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the entity publication service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.exportimport.service.persistence.impl.EntityPublicationPersistenceImpl
 * @see EntityPublicationUtil
 * @generated
 */
@ProviderType
public interface EntityPublicationPersistence extends BasePersistence<EntityPublication> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EntityPublicationUtil} to access the entity publication persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the entity publication where classNameId = &#63; and classPK = &#63; or throws a {@link NoSuchEntityPublicationException} if it could not be found.
	*
	* @param classNameId the class name ID
	* @param classPK the class pk
	* @return the matching entity publication
	* @throws NoSuchEntityPublicationException if a matching entity publication could not be found
	*/
	public EntityPublication findByC_C(long classNameId, long classPK)
		throws NoSuchEntityPublicationException;

	/**
	* Returns the entity publication where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param classNameId the class name ID
	* @param classPK the class pk
	* @return the matching entity publication, or <code>null</code> if a matching entity publication could not be found
	*/
	public EntityPublication fetchByC_C(long classNameId, long classPK);

	/**
	* Returns the entity publication where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param classNameId the class name ID
	* @param classPK the class pk
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching entity publication, or <code>null</code> if a matching entity publication could not be found
	*/
	public EntityPublication fetchByC_C(long classNameId, long classPK,
		boolean retrieveFromCache);

	/**
	* Removes the entity publication where classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param classNameId the class name ID
	* @param classPK the class pk
	* @return the entity publication that was removed
	*/
	public EntityPublication removeByC_C(long classNameId, long classPK)
		throws NoSuchEntityPublicationException;

	/**
	* Returns the number of entity publications where classNameId = &#63; and classPK = &#63;.
	*
	* @param classNameId the class name ID
	* @param classPK the class pk
	* @return the number of matching entity publications
	*/
	public int countByC_C(long classNameId, long classPK);

	/**
	* Caches the entity publication in the entity cache if it is enabled.
	*
	* @param entityPublication the entity publication
	*/
	public void cacheResult(EntityPublication entityPublication);

	/**
	* Caches the entity publications in the entity cache if it is enabled.
	*
	* @param entityPublications the entity publications
	*/
	public void cacheResult(
		java.util.List<EntityPublication> entityPublications);

	/**
	* Creates a new entity publication with the primary key. Does not add the entity publication to the database.
	*
	* @param id the primary key for the new entity publication
	* @return the new entity publication
	*/
	public EntityPublication create(long id);

	/**
	* Removes the entity publication with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the entity publication
	* @return the entity publication that was removed
	* @throws NoSuchEntityPublicationException if a entity publication with the primary key could not be found
	*/
	public EntityPublication remove(long id)
		throws NoSuchEntityPublicationException;

	public EntityPublication updateImpl(EntityPublication entityPublication);

	/**
	* Returns the entity publication with the primary key or throws a {@link NoSuchEntityPublicationException} if it could not be found.
	*
	* @param id the primary key of the entity publication
	* @return the entity publication
	* @throws NoSuchEntityPublicationException if a entity publication with the primary key could not be found
	*/
	public EntityPublication findByPrimaryKey(long id)
		throws NoSuchEntityPublicationException;

	/**
	* Returns the entity publication with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the entity publication
	* @return the entity publication, or <code>null</code> if a entity publication with the primary key could not be found
	*/
	public EntityPublication fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, EntityPublication> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the entity publications.
	*
	* @return the entity publications
	*/
	public java.util.List<EntityPublication> findAll();

	/**
	* Returns a range of all the entity publications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EntityPublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of entity publications
	* @param end the upper bound of the range of entity publications (not inclusive)
	* @return the range of entity publications
	*/
	public java.util.List<EntityPublication> findAll(int start, int end);

	/**
	* Returns an ordered range of all the entity publications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EntityPublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of entity publications
	* @param end the upper bound of the range of entity publications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of entity publications
	*/
	public java.util.List<EntityPublication> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EntityPublication> orderByComparator);

	/**
	* Returns an ordered range of all the entity publications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EntityPublicationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of entity publications
	* @param end the upper bound of the range of entity publications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of entity publications
	*/
	public java.util.List<EntityPublication> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<EntityPublication> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the entity publications from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of entity publications.
	*
	* @return the number of entity publications
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}