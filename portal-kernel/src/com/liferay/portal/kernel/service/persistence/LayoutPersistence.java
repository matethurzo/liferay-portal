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

package com.liferay.portal.kernel.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.exception.NoSuchLayoutException;
import com.liferay.portal.kernel.model.Layout;

import java.io.Serializable;

import java.util.Map;
import java.util.Set;

/**
 * The persistence interface for the layout service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.portal.service.persistence.impl.LayoutPersistenceImpl
 * @see LayoutUtil
 * @generated
 */
@ProviderType
public interface LayoutPersistence extends BasePersistence<Layout> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LayoutUtil} to access the layout persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */
	@Override
	public Map<Serializable, Layout> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys);

	/**
	* Returns all the layouts where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching layouts
	*/
	public java.util.List<Layout> findByUuid(String uuid);

	/**
	* Returns a range of all the layouts where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @return the range of matching layouts
	*/
	public java.util.List<Layout> findByUuid(String uuid, int start, int end);

	/**
	* Returns an ordered range of all the layouts where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching layouts
	*/
	public java.util.List<Layout> findByUuid(String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns an ordered range of all the layouts where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching layouts
	*/
	public java.util.List<Layout> findByUuid(String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first layout in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching layout
	* @throws NoSuchLayoutException if a matching layout could not be found
	*/
	public Layout findByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns the first layout in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByUuid_First(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns the last layout in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching layout
	* @throws NoSuchLayoutException if a matching layout could not be found
	*/
	public Layout findByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns the last layout in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByUuid_Last(String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns the layouts before and after the current layout in the ordered set where uuid = &#63;.
	*
	* @param plid the primary key of the current layout
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next layout
	* @throws NoSuchLayoutException if a layout with the primary key could not be found
	*/
	public Layout[] findByUuid_PrevAndNext(long plid, String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Removes all the layouts where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(String uuid);

	/**
	* Returns the number of layouts where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching layouts
	*/
	public int countByUuid(String uuid);

	/**
	* Returns the layout where uuid = &#63; and groupId = &#63; and privateLayout = &#63; or throws a {@link NoSuchLayoutException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @return the matching layout
	* @throws NoSuchLayoutException if a matching layout could not be found
	*/
	public Layout findByUUID_G_P(String uuid, long groupId,
		boolean privateLayout) throws NoSuchLayoutException;

	/**
	* Returns the layout where uuid = &#63; and groupId = &#63; and privateLayout = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @return the matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByUUID_G_P(String uuid, long groupId,
		boolean privateLayout);

	/**
	* Returns the layout where uuid = &#63; and groupId = &#63; and privateLayout = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByUUID_G_P(String uuid, long groupId,
		boolean privateLayout, boolean retrieveFromCache);

	/**
	* Removes the layout where uuid = &#63; and groupId = &#63; and privateLayout = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @return the layout that was removed
	*/
	public Layout removeByUUID_G_P(String uuid, long groupId,
		boolean privateLayout) throws NoSuchLayoutException;

	/**
	* Returns the number of layouts where uuid = &#63; and groupId = &#63; and privateLayout = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @return the number of matching layouts
	*/
	public int countByUUID_G_P(String uuid, long groupId, boolean privateLayout);

	/**
	* Returns all the layouts where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching layouts
	*/
	public java.util.List<Layout> findByUuid_C(String uuid, long companyId);

	/**
	* Returns a range of all the layouts where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @return the range of matching layouts
	*/
	public java.util.List<Layout> findByUuid_C(String uuid, long companyId,
		int start, int end);

	/**
	* Returns an ordered range of all the layouts where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching layouts
	*/
	public java.util.List<Layout> findByUuid_C(String uuid, long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns an ordered range of all the layouts where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching layouts
	*/
	public java.util.List<Layout> findByUuid_C(String uuid, long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first layout in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching layout
	* @throws NoSuchLayoutException if a matching layout could not be found
	*/
	public Layout findByUuid_C_First(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns the first layout in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByUuid_C_First(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns the last layout in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching layout
	* @throws NoSuchLayoutException if a matching layout could not be found
	*/
	public Layout findByUuid_C_Last(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns the last layout in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByUuid_C_Last(String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns the layouts before and after the current layout in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param plid the primary key of the current layout
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next layout
	* @throws NoSuchLayoutException if a layout with the primary key could not be found
	*/
	public Layout[] findByUuid_C_PrevAndNext(long plid, String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Removes all the layouts where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(String uuid, long companyId);

	/**
	* Returns the number of layouts where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching layouts
	*/
	public int countByUuid_C(String uuid, long companyId);

	/**
	* Returns all the layouts where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching layouts
	*/
	public java.util.List<Layout> findByGroupId(long groupId);

	/**
	* Returns a range of all the layouts where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @return the range of matching layouts
	*/
	public java.util.List<Layout> findByGroupId(long groupId, int start, int end);

	/**
	* Returns an ordered range of all the layouts where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching layouts
	*/
	public java.util.List<Layout> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns an ordered range of all the layouts where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching layouts
	*/
	public java.util.List<Layout> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first layout in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching layout
	* @throws NoSuchLayoutException if a matching layout could not be found
	*/
	public Layout findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns the first layout in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns the last layout in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching layout
	* @throws NoSuchLayoutException if a matching layout could not be found
	*/
	public Layout findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns the last layout in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns the layouts before and after the current layout in the ordered set where groupId = &#63;.
	*
	* @param plid the primary key of the current layout
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next layout
	* @throws NoSuchLayoutException if a layout with the primary key could not be found
	*/
	public Layout[] findByGroupId_PrevAndNext(long plid, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns all the layouts that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching layouts that the user has permission to view
	*/
	public java.util.List<Layout> filterFindByGroupId(long groupId);

	/**
	* Returns a range of all the layouts that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @return the range of matching layouts that the user has permission to view
	*/
	public java.util.List<Layout> filterFindByGroupId(long groupId, int start,
		int end);

	/**
	* Returns an ordered range of all the layouts that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching layouts that the user has permission to view
	*/
	public java.util.List<Layout> filterFindByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns the layouts before and after the current layout in the ordered set of layouts that the user has permission to view where groupId = &#63;.
	*
	* @param plid the primary key of the current layout
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next layout
	* @throws NoSuchLayoutException if a layout with the primary key could not be found
	*/
	public Layout[] filterFindByGroupId_PrevAndNext(long plid, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Removes all the layouts where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroupId(long groupId);

	/**
	* Returns the number of layouts where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching layouts
	*/
	public int countByGroupId(long groupId);

	/**
	* Returns the number of layouts that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching layouts that the user has permission to view
	*/
	public int filterCountByGroupId(long groupId);

	/**
	* Returns all the layouts where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching layouts
	*/
	public java.util.List<Layout> findByCompanyId(long companyId);

	/**
	* Returns a range of all the layouts where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @return the range of matching layouts
	*/
	public java.util.List<Layout> findByCompanyId(long companyId, int start,
		int end);

	/**
	* Returns an ordered range of all the layouts where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching layouts
	*/
	public java.util.List<Layout> findByCompanyId(long companyId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns an ordered range of all the layouts where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching layouts
	*/
	public java.util.List<Layout> findByCompanyId(long companyId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first layout in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching layout
	* @throws NoSuchLayoutException if a matching layout could not be found
	*/
	public Layout findByCompanyId_First(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns the first layout in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByCompanyId_First(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns the last layout in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching layout
	* @throws NoSuchLayoutException if a matching layout could not be found
	*/
	public Layout findByCompanyId_Last(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns the last layout in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByCompanyId_Last(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns the layouts before and after the current layout in the ordered set where companyId = &#63;.
	*
	* @param plid the primary key of the current layout
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next layout
	* @throws NoSuchLayoutException if a layout with the primary key could not be found
	*/
	public Layout[] findByCompanyId_PrevAndNext(long plid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Removes all the layouts where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	*/
	public void removeByCompanyId(long companyId);

	/**
	* Returns the number of layouts where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching layouts
	*/
	public int countByCompanyId(long companyId);

	/**
	* Returns all the layouts where parentPlid = &#63;.
	*
	* @param parentPlid the parent plid
	* @return the matching layouts
	*/
	public java.util.List<Layout> findByParentPlid(long parentPlid);

	/**
	* Returns a range of all the layouts where parentPlid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentPlid the parent plid
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @return the range of matching layouts
	*/
	public java.util.List<Layout> findByParentPlid(long parentPlid, int start,
		int end);

	/**
	* Returns an ordered range of all the layouts where parentPlid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentPlid the parent plid
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching layouts
	*/
	public java.util.List<Layout> findByParentPlid(long parentPlid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns an ordered range of all the layouts where parentPlid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param parentPlid the parent plid
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching layouts
	*/
	public java.util.List<Layout> findByParentPlid(long parentPlid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first layout in the ordered set where parentPlid = &#63;.
	*
	* @param parentPlid the parent plid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching layout
	* @throws NoSuchLayoutException if a matching layout could not be found
	*/
	public Layout findByParentPlid_First(long parentPlid,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns the first layout in the ordered set where parentPlid = &#63;.
	*
	* @param parentPlid the parent plid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByParentPlid_First(long parentPlid,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns the last layout in the ordered set where parentPlid = &#63;.
	*
	* @param parentPlid the parent plid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching layout
	* @throws NoSuchLayoutException if a matching layout could not be found
	*/
	public Layout findByParentPlid_Last(long parentPlid,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns the last layout in the ordered set where parentPlid = &#63;.
	*
	* @param parentPlid the parent plid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByParentPlid_Last(long parentPlid,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns the layouts before and after the current layout in the ordered set where parentPlid = &#63;.
	*
	* @param plid the primary key of the current layout
	* @param parentPlid the parent plid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next layout
	* @throws NoSuchLayoutException if a layout with the primary key could not be found
	*/
	public Layout[] findByParentPlid_PrevAndNext(long plid, long parentPlid,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Removes all the layouts where parentPlid = &#63; from the database.
	*
	* @param parentPlid the parent plid
	*/
	public void removeByParentPlid(long parentPlid);

	/**
	* Returns the number of layouts where parentPlid = &#63;.
	*
	* @param parentPlid the parent plid
	* @return the number of matching layouts
	*/
	public int countByParentPlid(long parentPlid);

	/**
	* Returns the layout where iconImageId = &#63; or throws a {@link NoSuchLayoutException} if it could not be found.
	*
	* @param iconImageId the icon image ID
	* @return the matching layout
	* @throws NoSuchLayoutException if a matching layout could not be found
	*/
	public Layout findByIconImageId(long iconImageId)
		throws NoSuchLayoutException;

	/**
	* Returns the layout where iconImageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param iconImageId the icon image ID
	* @return the matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByIconImageId(long iconImageId);

	/**
	* Returns the layout where iconImageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param iconImageId the icon image ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByIconImageId(long iconImageId, boolean retrieveFromCache);

	/**
	* Removes the layout where iconImageId = &#63; from the database.
	*
	* @param iconImageId the icon image ID
	* @return the layout that was removed
	*/
	public Layout removeByIconImageId(long iconImageId)
		throws NoSuchLayoutException;

	/**
	* Returns the number of layouts where iconImageId = &#63;.
	*
	* @param iconImageId the icon image ID
	* @return the number of matching layouts
	*/
	public int countByIconImageId(long iconImageId);

	/**
	* Returns all the layouts where layoutPrototypeUuid = &#63;.
	*
	* @param layoutPrototypeUuid the layout prototype uuid
	* @return the matching layouts
	*/
	public java.util.List<Layout> findByLayoutPrototypeUuid(
		String layoutPrototypeUuid);

	/**
	* Returns a range of all the layouts where layoutPrototypeUuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param layoutPrototypeUuid the layout prototype uuid
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @return the range of matching layouts
	*/
	public java.util.List<Layout> findByLayoutPrototypeUuid(
		String layoutPrototypeUuid, int start, int end);

	/**
	* Returns an ordered range of all the layouts where layoutPrototypeUuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param layoutPrototypeUuid the layout prototype uuid
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching layouts
	*/
	public java.util.List<Layout> findByLayoutPrototypeUuid(
		String layoutPrototypeUuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns an ordered range of all the layouts where layoutPrototypeUuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param layoutPrototypeUuid the layout prototype uuid
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching layouts
	*/
	public java.util.List<Layout> findByLayoutPrototypeUuid(
		String layoutPrototypeUuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first layout in the ordered set where layoutPrototypeUuid = &#63;.
	*
	* @param layoutPrototypeUuid the layout prototype uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching layout
	* @throws NoSuchLayoutException if a matching layout could not be found
	*/
	public Layout findByLayoutPrototypeUuid_First(String layoutPrototypeUuid,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns the first layout in the ordered set where layoutPrototypeUuid = &#63;.
	*
	* @param layoutPrototypeUuid the layout prototype uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByLayoutPrototypeUuid_First(String layoutPrototypeUuid,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns the last layout in the ordered set where layoutPrototypeUuid = &#63;.
	*
	* @param layoutPrototypeUuid the layout prototype uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching layout
	* @throws NoSuchLayoutException if a matching layout could not be found
	*/
	public Layout findByLayoutPrototypeUuid_Last(String layoutPrototypeUuid,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns the last layout in the ordered set where layoutPrototypeUuid = &#63;.
	*
	* @param layoutPrototypeUuid the layout prototype uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByLayoutPrototypeUuid_Last(String layoutPrototypeUuid,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns the layouts before and after the current layout in the ordered set where layoutPrototypeUuid = &#63;.
	*
	* @param plid the primary key of the current layout
	* @param layoutPrototypeUuid the layout prototype uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next layout
	* @throws NoSuchLayoutException if a layout with the primary key could not be found
	*/
	public Layout[] findByLayoutPrototypeUuid_PrevAndNext(long plid,
		String layoutPrototypeUuid,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Removes all the layouts where layoutPrototypeUuid = &#63; from the database.
	*
	* @param layoutPrototypeUuid the layout prototype uuid
	*/
	public void removeByLayoutPrototypeUuid(String layoutPrototypeUuid);

	/**
	* Returns the number of layouts where layoutPrototypeUuid = &#63;.
	*
	* @param layoutPrototypeUuid the layout prototype uuid
	* @return the number of matching layouts
	*/
	public int countByLayoutPrototypeUuid(String layoutPrototypeUuid);

	/**
	* Returns all the layouts where sourcePrototypeLayoutUuid = &#63;.
	*
	* @param sourcePrototypeLayoutUuid the source prototype layout uuid
	* @return the matching layouts
	*/
	public java.util.List<Layout> findBySourcePrototypeLayoutUuid(
		String sourcePrototypeLayoutUuid);

	/**
	* Returns a range of all the layouts where sourcePrototypeLayoutUuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param sourcePrototypeLayoutUuid the source prototype layout uuid
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @return the range of matching layouts
	*/
	public java.util.List<Layout> findBySourcePrototypeLayoutUuid(
		String sourcePrototypeLayoutUuid, int start, int end);

	/**
	* Returns an ordered range of all the layouts where sourcePrototypeLayoutUuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param sourcePrototypeLayoutUuid the source prototype layout uuid
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching layouts
	*/
	public java.util.List<Layout> findBySourcePrototypeLayoutUuid(
		String sourcePrototypeLayoutUuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns an ordered range of all the layouts where sourcePrototypeLayoutUuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param sourcePrototypeLayoutUuid the source prototype layout uuid
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching layouts
	*/
	public java.util.List<Layout> findBySourcePrototypeLayoutUuid(
		String sourcePrototypeLayoutUuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first layout in the ordered set where sourcePrototypeLayoutUuid = &#63;.
	*
	* @param sourcePrototypeLayoutUuid the source prototype layout uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching layout
	* @throws NoSuchLayoutException if a matching layout could not be found
	*/
	public Layout findBySourcePrototypeLayoutUuid_First(
		String sourcePrototypeLayoutUuid,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns the first layout in the ordered set where sourcePrototypeLayoutUuid = &#63;.
	*
	* @param sourcePrototypeLayoutUuid the source prototype layout uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchBySourcePrototypeLayoutUuid_First(
		String sourcePrototypeLayoutUuid,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns the last layout in the ordered set where sourcePrototypeLayoutUuid = &#63;.
	*
	* @param sourcePrototypeLayoutUuid the source prototype layout uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching layout
	* @throws NoSuchLayoutException if a matching layout could not be found
	*/
	public Layout findBySourcePrototypeLayoutUuid_Last(
		String sourcePrototypeLayoutUuid,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns the last layout in the ordered set where sourcePrototypeLayoutUuid = &#63;.
	*
	* @param sourcePrototypeLayoutUuid the source prototype layout uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchBySourcePrototypeLayoutUuid_Last(
		String sourcePrototypeLayoutUuid,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns the layouts before and after the current layout in the ordered set where sourcePrototypeLayoutUuid = &#63;.
	*
	* @param plid the primary key of the current layout
	* @param sourcePrototypeLayoutUuid the source prototype layout uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next layout
	* @throws NoSuchLayoutException if a layout with the primary key could not be found
	*/
	public Layout[] findBySourcePrototypeLayoutUuid_PrevAndNext(long plid,
		String sourcePrototypeLayoutUuid,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Removes all the layouts where sourcePrototypeLayoutUuid = &#63; from the database.
	*
	* @param sourcePrototypeLayoutUuid the source prototype layout uuid
	*/
	public void removeBySourcePrototypeLayoutUuid(
		String sourcePrototypeLayoutUuid);

	/**
	* Returns the number of layouts where sourcePrototypeLayoutUuid = &#63;.
	*
	* @param sourcePrototypeLayoutUuid the source prototype layout uuid
	* @return the number of matching layouts
	*/
	public int countBySourcePrototypeLayoutUuid(
		String sourcePrototypeLayoutUuid);

	/**
	* Returns all the layouts where groupId = &#63; and privateLayout = &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @return the matching layouts
	*/
	public java.util.List<Layout> findByG_P(long groupId, boolean privateLayout);

	/**
	* Returns a range of all the layouts where groupId = &#63; and privateLayout = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @return the range of matching layouts
	*/
	public java.util.List<Layout> findByG_P(long groupId,
		boolean privateLayout, int start, int end);

	/**
	* Returns an ordered range of all the layouts where groupId = &#63; and privateLayout = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching layouts
	*/
	public java.util.List<Layout> findByG_P(long groupId,
		boolean privateLayout, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns an ordered range of all the layouts where groupId = &#63; and privateLayout = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching layouts
	*/
	public java.util.List<Layout> findByG_P(long groupId,
		boolean privateLayout, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first layout in the ordered set where groupId = &#63; and privateLayout = &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching layout
	* @throws NoSuchLayoutException if a matching layout could not be found
	*/
	public Layout findByG_P_First(long groupId, boolean privateLayout,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns the first layout in the ordered set where groupId = &#63; and privateLayout = &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByG_P_First(long groupId, boolean privateLayout,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns the last layout in the ordered set where groupId = &#63; and privateLayout = &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching layout
	* @throws NoSuchLayoutException if a matching layout could not be found
	*/
	public Layout findByG_P_Last(long groupId, boolean privateLayout,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns the last layout in the ordered set where groupId = &#63; and privateLayout = &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByG_P_Last(long groupId, boolean privateLayout,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns the layouts before and after the current layout in the ordered set where groupId = &#63; and privateLayout = &#63;.
	*
	* @param plid the primary key of the current layout
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next layout
	* @throws NoSuchLayoutException if a layout with the primary key could not be found
	*/
	public Layout[] findByG_P_PrevAndNext(long plid, long groupId,
		boolean privateLayout,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns all the layouts that the user has permission to view where groupId = &#63; and privateLayout = &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @return the matching layouts that the user has permission to view
	*/
	public java.util.List<Layout> filterFindByG_P(long groupId,
		boolean privateLayout);

	/**
	* Returns a range of all the layouts that the user has permission to view where groupId = &#63; and privateLayout = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @return the range of matching layouts that the user has permission to view
	*/
	public java.util.List<Layout> filterFindByG_P(long groupId,
		boolean privateLayout, int start, int end);

	/**
	* Returns an ordered range of all the layouts that the user has permissions to view where groupId = &#63; and privateLayout = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching layouts that the user has permission to view
	*/
	public java.util.List<Layout> filterFindByG_P(long groupId,
		boolean privateLayout, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns the layouts before and after the current layout in the ordered set of layouts that the user has permission to view where groupId = &#63; and privateLayout = &#63;.
	*
	* @param plid the primary key of the current layout
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next layout
	* @throws NoSuchLayoutException if a layout with the primary key could not be found
	*/
	public Layout[] filterFindByG_P_PrevAndNext(long plid, long groupId,
		boolean privateLayout,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Removes all the layouts where groupId = &#63; and privateLayout = &#63; from the database.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	*/
	public void removeByG_P(long groupId, boolean privateLayout);

	/**
	* Returns the number of layouts where groupId = &#63; and privateLayout = &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @return the number of matching layouts
	*/
	public int countByG_P(long groupId, boolean privateLayout);

	/**
	* Returns the number of layouts that the user has permission to view where groupId = &#63; and privateLayout = &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @return the number of matching layouts that the user has permission to view
	*/
	public int filterCountByG_P(long groupId, boolean privateLayout);

	/**
	* Returns all the layouts where groupId = &#63; and type = &#63;.
	*
	* @param groupId the group ID
	* @param type the type
	* @return the matching layouts
	*/
	public java.util.List<Layout> findByG_T(long groupId, String type);

	/**
	* Returns a range of all the layouts where groupId = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param type the type
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @return the range of matching layouts
	*/
	public java.util.List<Layout> findByG_T(long groupId, String type,
		int start, int end);

	/**
	* Returns an ordered range of all the layouts where groupId = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param type the type
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching layouts
	*/
	public java.util.List<Layout> findByG_T(long groupId, String type,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns an ordered range of all the layouts where groupId = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param type the type
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching layouts
	*/
	public java.util.List<Layout> findByG_T(long groupId, String type,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first layout in the ordered set where groupId = &#63; and type = &#63;.
	*
	* @param groupId the group ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching layout
	* @throws NoSuchLayoutException if a matching layout could not be found
	*/
	public Layout findByG_T_First(long groupId, String type,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns the first layout in the ordered set where groupId = &#63; and type = &#63;.
	*
	* @param groupId the group ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByG_T_First(long groupId, String type,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns the last layout in the ordered set where groupId = &#63; and type = &#63;.
	*
	* @param groupId the group ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching layout
	* @throws NoSuchLayoutException if a matching layout could not be found
	*/
	public Layout findByG_T_Last(long groupId, String type,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns the last layout in the ordered set where groupId = &#63; and type = &#63;.
	*
	* @param groupId the group ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByG_T_Last(long groupId, String type,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns the layouts before and after the current layout in the ordered set where groupId = &#63; and type = &#63;.
	*
	* @param plid the primary key of the current layout
	* @param groupId the group ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next layout
	* @throws NoSuchLayoutException if a layout with the primary key could not be found
	*/
	public Layout[] findByG_T_PrevAndNext(long plid, long groupId, String type,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns all the layouts that the user has permission to view where groupId = &#63; and type = &#63;.
	*
	* @param groupId the group ID
	* @param type the type
	* @return the matching layouts that the user has permission to view
	*/
	public java.util.List<Layout> filterFindByG_T(long groupId, String type);

	/**
	* Returns a range of all the layouts that the user has permission to view where groupId = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param type the type
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @return the range of matching layouts that the user has permission to view
	*/
	public java.util.List<Layout> filterFindByG_T(long groupId, String type,
		int start, int end);

	/**
	* Returns an ordered range of all the layouts that the user has permissions to view where groupId = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param type the type
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching layouts that the user has permission to view
	*/
	public java.util.List<Layout> filterFindByG_T(long groupId, String type,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns the layouts before and after the current layout in the ordered set of layouts that the user has permission to view where groupId = &#63; and type = &#63;.
	*
	* @param plid the primary key of the current layout
	* @param groupId the group ID
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next layout
	* @throws NoSuchLayoutException if a layout with the primary key could not be found
	*/
	public Layout[] filterFindByG_T_PrevAndNext(long plid, long groupId,
		String type,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Removes all the layouts where groupId = &#63; and type = &#63; from the database.
	*
	* @param groupId the group ID
	* @param type the type
	*/
	public void removeByG_T(long groupId, String type);

	/**
	* Returns the number of layouts where groupId = &#63; and type = &#63;.
	*
	* @param groupId the group ID
	* @param type the type
	* @return the number of matching layouts
	*/
	public int countByG_T(long groupId, String type);

	/**
	* Returns the number of layouts that the user has permission to view where groupId = &#63; and type = &#63;.
	*
	* @param groupId the group ID
	* @param type the type
	* @return the number of matching layouts that the user has permission to view
	*/
	public int filterCountByG_T(long groupId, String type);

	/**
	* Returns all the layouts where companyId = &#63; and layoutPrototypeUuid = &#63;.
	*
	* @param companyId the company ID
	* @param layoutPrototypeUuid the layout prototype uuid
	* @return the matching layouts
	*/
	public java.util.List<Layout> findByC_L(long companyId,
		String layoutPrototypeUuid);

	/**
	* Returns a range of all the layouts where companyId = &#63; and layoutPrototypeUuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param layoutPrototypeUuid the layout prototype uuid
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @return the range of matching layouts
	*/
	public java.util.List<Layout> findByC_L(long companyId,
		String layoutPrototypeUuid, int start, int end);

	/**
	* Returns an ordered range of all the layouts where companyId = &#63; and layoutPrototypeUuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param layoutPrototypeUuid the layout prototype uuid
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching layouts
	*/
	public java.util.List<Layout> findByC_L(long companyId,
		String layoutPrototypeUuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns an ordered range of all the layouts where companyId = &#63; and layoutPrototypeUuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param layoutPrototypeUuid the layout prototype uuid
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching layouts
	*/
	public java.util.List<Layout> findByC_L(long companyId,
		String layoutPrototypeUuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first layout in the ordered set where companyId = &#63; and layoutPrototypeUuid = &#63;.
	*
	* @param companyId the company ID
	* @param layoutPrototypeUuid the layout prototype uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching layout
	* @throws NoSuchLayoutException if a matching layout could not be found
	*/
	public Layout findByC_L_First(long companyId, String layoutPrototypeUuid,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns the first layout in the ordered set where companyId = &#63; and layoutPrototypeUuid = &#63;.
	*
	* @param companyId the company ID
	* @param layoutPrototypeUuid the layout prototype uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByC_L_First(long companyId, String layoutPrototypeUuid,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns the last layout in the ordered set where companyId = &#63; and layoutPrototypeUuid = &#63;.
	*
	* @param companyId the company ID
	* @param layoutPrototypeUuid the layout prototype uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching layout
	* @throws NoSuchLayoutException if a matching layout could not be found
	*/
	public Layout findByC_L_Last(long companyId, String layoutPrototypeUuid,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns the last layout in the ordered set where companyId = &#63; and layoutPrototypeUuid = &#63;.
	*
	* @param companyId the company ID
	* @param layoutPrototypeUuid the layout prototype uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByC_L_Last(long companyId, String layoutPrototypeUuid,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns the layouts before and after the current layout in the ordered set where companyId = &#63; and layoutPrototypeUuid = &#63;.
	*
	* @param plid the primary key of the current layout
	* @param companyId the company ID
	* @param layoutPrototypeUuid the layout prototype uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next layout
	* @throws NoSuchLayoutException if a layout with the primary key could not be found
	*/
	public Layout[] findByC_L_PrevAndNext(long plid, long companyId,
		String layoutPrototypeUuid,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Removes all the layouts where companyId = &#63; and layoutPrototypeUuid = &#63; from the database.
	*
	* @param companyId the company ID
	* @param layoutPrototypeUuid the layout prototype uuid
	*/
	public void removeByC_L(long companyId, String layoutPrototypeUuid);

	/**
	* Returns the number of layouts where companyId = &#63; and layoutPrototypeUuid = &#63;.
	*
	* @param companyId the company ID
	* @param layoutPrototypeUuid the layout prototype uuid
	* @return the number of matching layouts
	*/
	public int countByC_L(long companyId, String layoutPrototypeUuid);

	/**
	* Returns the layout where privateLayout = &#63; and iconImageId = &#63; or throws a {@link NoSuchLayoutException} if it could not be found.
	*
	* @param privateLayout the private layout
	* @param iconImageId the icon image ID
	* @return the matching layout
	* @throws NoSuchLayoutException if a matching layout could not be found
	*/
	public Layout findByP_I(boolean privateLayout, long iconImageId)
		throws NoSuchLayoutException;

	/**
	* Returns the layout where privateLayout = &#63; and iconImageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param privateLayout the private layout
	* @param iconImageId the icon image ID
	* @return the matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByP_I(boolean privateLayout, long iconImageId);

	/**
	* Returns the layout where privateLayout = &#63; and iconImageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param privateLayout the private layout
	* @param iconImageId the icon image ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByP_I(boolean privateLayout, long iconImageId,
		boolean retrieveFromCache);

	/**
	* Removes the layout where privateLayout = &#63; and iconImageId = &#63; from the database.
	*
	* @param privateLayout the private layout
	* @param iconImageId the icon image ID
	* @return the layout that was removed
	*/
	public Layout removeByP_I(boolean privateLayout, long iconImageId)
		throws NoSuchLayoutException;

	/**
	* Returns the number of layouts where privateLayout = &#63; and iconImageId = &#63;.
	*
	* @param privateLayout the private layout
	* @param iconImageId the icon image ID
	* @return the number of matching layouts
	*/
	public int countByP_I(boolean privateLayout, long iconImageId);

	/**
	* Returns the layout where groupId = &#63; and privateLayout = &#63; and layoutId = &#63; or throws a {@link NoSuchLayoutException} if it could not be found.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param layoutId the layout ID
	* @return the matching layout
	* @throws NoSuchLayoutException if a matching layout could not be found
	*/
	public Layout findByG_P_L(long groupId, boolean privateLayout, long layoutId)
		throws NoSuchLayoutException;

	/**
	* Returns the layout where groupId = &#63; and privateLayout = &#63; and layoutId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param layoutId the layout ID
	* @return the matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByG_P_L(long groupId, boolean privateLayout,
		long layoutId);

	/**
	* Returns the layout where groupId = &#63; and privateLayout = &#63; and layoutId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param layoutId the layout ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByG_P_L(long groupId, boolean privateLayout,
		long layoutId, boolean retrieveFromCache);

	/**
	* Removes the layout where groupId = &#63; and privateLayout = &#63; and layoutId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param layoutId the layout ID
	* @return the layout that was removed
	*/
	public Layout removeByG_P_L(long groupId, boolean privateLayout,
		long layoutId) throws NoSuchLayoutException;

	/**
	* Returns the number of layouts where groupId = &#63; and privateLayout = &#63; and layoutId = &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param layoutId the layout ID
	* @return the number of matching layouts
	*/
	public int countByG_P_L(long groupId, boolean privateLayout, long layoutId);

	/**
	* Returns all the layouts where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutId the parent layout ID
	* @return the matching layouts
	*/
	public java.util.List<Layout> findByG_P_P(long groupId,
		boolean privateLayout, long parentLayoutId);

	/**
	* Returns a range of all the layouts where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutId the parent layout ID
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @return the range of matching layouts
	*/
	public java.util.List<Layout> findByG_P_P(long groupId,
		boolean privateLayout, long parentLayoutId, int start, int end);

	/**
	* Returns an ordered range of all the layouts where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutId the parent layout ID
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching layouts
	*/
	public java.util.List<Layout> findByG_P_P(long groupId,
		boolean privateLayout, long parentLayoutId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns an ordered range of all the layouts where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutId the parent layout ID
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching layouts
	*/
	public java.util.List<Layout> findByG_P_P(long groupId,
		boolean privateLayout, long parentLayoutId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first layout in the ordered set where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutId the parent layout ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching layout
	* @throws NoSuchLayoutException if a matching layout could not be found
	*/
	public Layout findByG_P_P_First(long groupId, boolean privateLayout,
		long parentLayoutId,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns the first layout in the ordered set where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutId the parent layout ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByG_P_P_First(long groupId, boolean privateLayout,
		long parentLayoutId,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns the last layout in the ordered set where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutId the parent layout ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching layout
	* @throws NoSuchLayoutException if a matching layout could not be found
	*/
	public Layout findByG_P_P_Last(long groupId, boolean privateLayout,
		long parentLayoutId,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns the last layout in the ordered set where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutId the parent layout ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByG_P_P_Last(long groupId, boolean privateLayout,
		long parentLayoutId,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns the layouts before and after the current layout in the ordered set where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63;.
	*
	* @param plid the primary key of the current layout
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutId the parent layout ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next layout
	* @throws NoSuchLayoutException if a layout with the primary key could not be found
	*/
	public Layout[] findByG_P_P_PrevAndNext(long plid, long groupId,
		boolean privateLayout, long parentLayoutId,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns all the layouts that the user has permission to view where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutId the parent layout ID
	* @return the matching layouts that the user has permission to view
	*/
	public java.util.List<Layout> filterFindByG_P_P(long groupId,
		boolean privateLayout, long parentLayoutId);

	/**
	* Returns a range of all the layouts that the user has permission to view where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutId the parent layout ID
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @return the range of matching layouts that the user has permission to view
	*/
	public java.util.List<Layout> filterFindByG_P_P(long groupId,
		boolean privateLayout, long parentLayoutId, int start, int end);

	/**
	* Returns an ordered range of all the layouts that the user has permissions to view where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutId the parent layout ID
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching layouts that the user has permission to view
	*/
	public java.util.List<Layout> filterFindByG_P_P(long groupId,
		boolean privateLayout, long parentLayoutId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns the layouts before and after the current layout in the ordered set of layouts that the user has permission to view where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63;.
	*
	* @param plid the primary key of the current layout
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutId the parent layout ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next layout
	* @throws NoSuchLayoutException if a layout with the primary key could not be found
	*/
	public Layout[] filterFindByG_P_P_PrevAndNext(long plid, long groupId,
		boolean privateLayout, long parentLayoutId,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns all the layouts that the user has permission to view where groupId = &#63; and privateLayout = &#63; and parentLayoutId = any &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutIds the parent layout IDs
	* @return the matching layouts that the user has permission to view
	*/
	public java.util.List<Layout> filterFindByG_P_P(long groupId,
		boolean privateLayout, long[] parentLayoutIds);

	/**
	* Returns a range of all the layouts that the user has permission to view where groupId = &#63; and privateLayout = &#63; and parentLayoutId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutIds the parent layout IDs
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @return the range of matching layouts that the user has permission to view
	*/
	public java.util.List<Layout> filterFindByG_P_P(long groupId,
		boolean privateLayout, long[] parentLayoutIds, int start, int end);

	/**
	* Returns an ordered range of all the layouts that the user has permission to view where groupId = &#63; and privateLayout = &#63; and parentLayoutId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutIds the parent layout IDs
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching layouts that the user has permission to view
	*/
	public java.util.List<Layout> filterFindByG_P_P(long groupId,
		boolean privateLayout, long[] parentLayoutIds, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns all the layouts where groupId = &#63; and privateLayout = &#63; and parentLayoutId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutIds the parent layout IDs
	* @return the matching layouts
	*/
	public java.util.List<Layout> findByG_P_P(long groupId,
		boolean privateLayout, long[] parentLayoutIds);

	/**
	* Returns a range of all the layouts where groupId = &#63; and privateLayout = &#63; and parentLayoutId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutIds the parent layout IDs
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @return the range of matching layouts
	*/
	public java.util.List<Layout> findByG_P_P(long groupId,
		boolean privateLayout, long[] parentLayoutIds, int start, int end);

	/**
	* Returns an ordered range of all the layouts where groupId = &#63; and privateLayout = &#63; and parentLayoutId = any &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutIds the parent layout IDs
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching layouts
	*/
	public java.util.List<Layout> findByG_P_P(long groupId,
		boolean privateLayout, long[] parentLayoutIds, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns an ordered range of all the layouts where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63;, optionally using the finder cache.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutId the parent layout ID
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching layouts
	*/
	public java.util.List<Layout> findByG_P_P(long groupId,
		boolean privateLayout, long[] parentLayoutIds, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the layouts where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutId the parent layout ID
	*/
	public void removeByG_P_P(long groupId, boolean privateLayout,
		long parentLayoutId);

	/**
	* Returns the number of layouts where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutId the parent layout ID
	* @return the number of matching layouts
	*/
	public int countByG_P_P(long groupId, boolean privateLayout,
		long parentLayoutId);

	/**
	* Returns the number of layouts where groupId = &#63; and privateLayout = &#63; and parentLayoutId = any &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutIds the parent layout IDs
	* @return the number of matching layouts
	*/
	public int countByG_P_P(long groupId, boolean privateLayout,
		long[] parentLayoutIds);

	/**
	* Returns the number of layouts that the user has permission to view where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutId the parent layout ID
	* @return the number of matching layouts that the user has permission to view
	*/
	public int filterCountByG_P_P(long groupId, boolean privateLayout,
		long parentLayoutId);

	/**
	* Returns the number of layouts that the user has permission to view where groupId = &#63; and privateLayout = &#63; and parentLayoutId = any &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutIds the parent layout IDs
	* @return the number of matching layouts that the user has permission to view
	*/
	public int filterCountByG_P_P(long groupId, boolean privateLayout,
		long[] parentLayoutIds);

	/**
	* Returns all the layouts where groupId = &#63; and privateLayout = &#63; and type = &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param type the type
	* @return the matching layouts
	*/
	public java.util.List<Layout> findByG_P_T(long groupId,
		boolean privateLayout, String type);

	/**
	* Returns a range of all the layouts where groupId = &#63; and privateLayout = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param type the type
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @return the range of matching layouts
	*/
	public java.util.List<Layout> findByG_P_T(long groupId,
		boolean privateLayout, String type, int start, int end);

	/**
	* Returns an ordered range of all the layouts where groupId = &#63; and privateLayout = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param type the type
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching layouts
	*/
	public java.util.List<Layout> findByG_P_T(long groupId,
		boolean privateLayout, String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns an ordered range of all the layouts where groupId = &#63; and privateLayout = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param type the type
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching layouts
	*/
	public java.util.List<Layout> findByG_P_T(long groupId,
		boolean privateLayout, String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first layout in the ordered set where groupId = &#63; and privateLayout = &#63; and type = &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching layout
	* @throws NoSuchLayoutException if a matching layout could not be found
	*/
	public Layout findByG_P_T_First(long groupId, boolean privateLayout,
		String type,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns the first layout in the ordered set where groupId = &#63; and privateLayout = &#63; and type = &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByG_P_T_First(long groupId, boolean privateLayout,
		String type,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns the last layout in the ordered set where groupId = &#63; and privateLayout = &#63; and type = &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching layout
	* @throws NoSuchLayoutException if a matching layout could not be found
	*/
	public Layout findByG_P_T_Last(long groupId, boolean privateLayout,
		String type,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns the last layout in the ordered set where groupId = &#63; and privateLayout = &#63; and type = &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByG_P_T_Last(long groupId, boolean privateLayout,
		String type,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns the layouts before and after the current layout in the ordered set where groupId = &#63; and privateLayout = &#63; and type = &#63;.
	*
	* @param plid the primary key of the current layout
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next layout
	* @throws NoSuchLayoutException if a layout with the primary key could not be found
	*/
	public Layout[] findByG_P_T_PrevAndNext(long plid, long groupId,
		boolean privateLayout, String type,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns all the layouts that the user has permission to view where groupId = &#63; and privateLayout = &#63; and type = &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param type the type
	* @return the matching layouts that the user has permission to view
	*/
	public java.util.List<Layout> filterFindByG_P_T(long groupId,
		boolean privateLayout, String type);

	/**
	* Returns a range of all the layouts that the user has permission to view where groupId = &#63; and privateLayout = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param type the type
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @return the range of matching layouts that the user has permission to view
	*/
	public java.util.List<Layout> filterFindByG_P_T(long groupId,
		boolean privateLayout, String type, int start, int end);

	/**
	* Returns an ordered range of all the layouts that the user has permissions to view where groupId = &#63; and privateLayout = &#63; and type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param type the type
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching layouts that the user has permission to view
	*/
	public java.util.List<Layout> filterFindByG_P_T(long groupId,
		boolean privateLayout, String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns the layouts before and after the current layout in the ordered set of layouts that the user has permission to view where groupId = &#63; and privateLayout = &#63; and type = &#63;.
	*
	* @param plid the primary key of the current layout
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next layout
	* @throws NoSuchLayoutException if a layout with the primary key could not be found
	*/
	public Layout[] filterFindByG_P_T_PrevAndNext(long plid, long groupId,
		boolean privateLayout, String type,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Removes all the layouts where groupId = &#63; and privateLayout = &#63; and type = &#63; from the database.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param type the type
	*/
	public void removeByG_P_T(long groupId, boolean privateLayout, String type);

	/**
	* Returns the number of layouts where groupId = &#63; and privateLayout = &#63; and type = &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param type the type
	* @return the number of matching layouts
	*/
	public int countByG_P_T(long groupId, boolean privateLayout, String type);

	/**
	* Returns the number of layouts that the user has permission to view where groupId = &#63; and privateLayout = &#63; and type = &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param type the type
	* @return the number of matching layouts that the user has permission to view
	*/
	public int filterCountByG_P_T(long groupId, boolean privateLayout,
		String type);

	/**
	* Returns the layout where groupId = &#63; and privateLayout = &#63; and friendlyURL = &#63; or throws a {@link NoSuchLayoutException} if it could not be found.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param friendlyURL the friendly url
	* @return the matching layout
	* @throws NoSuchLayoutException if a matching layout could not be found
	*/
	public Layout findByG_P_F(long groupId, boolean privateLayout,
		String friendlyURL) throws NoSuchLayoutException;

	/**
	* Returns the layout where groupId = &#63; and privateLayout = &#63; and friendlyURL = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param friendlyURL the friendly url
	* @return the matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByG_P_F(long groupId, boolean privateLayout,
		String friendlyURL);

	/**
	* Returns the layout where groupId = &#63; and privateLayout = &#63; and friendlyURL = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param friendlyURL the friendly url
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByG_P_F(long groupId, boolean privateLayout,
		String friendlyURL, boolean retrieveFromCache);

	/**
	* Removes the layout where groupId = &#63; and privateLayout = &#63; and friendlyURL = &#63; from the database.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param friendlyURL the friendly url
	* @return the layout that was removed
	*/
	public Layout removeByG_P_F(long groupId, boolean privateLayout,
		String friendlyURL) throws NoSuchLayoutException;

	/**
	* Returns the number of layouts where groupId = &#63; and privateLayout = &#63; and friendlyURL = &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param friendlyURL the friendly url
	* @return the number of matching layouts
	*/
	public int countByG_P_F(long groupId, boolean privateLayout,
		String friendlyURL);

	/**
	* Returns the layout where groupId = &#63; and privateLayout = &#63; and sourcePrototypeLayoutUuid = &#63; or throws a {@link NoSuchLayoutException} if it could not be found.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param sourcePrototypeLayoutUuid the source prototype layout uuid
	* @return the matching layout
	* @throws NoSuchLayoutException if a matching layout could not be found
	*/
	public Layout findByG_P_SPLU(long groupId, boolean privateLayout,
		String sourcePrototypeLayoutUuid) throws NoSuchLayoutException;

	/**
	* Returns the layout where groupId = &#63; and privateLayout = &#63; and sourcePrototypeLayoutUuid = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param sourcePrototypeLayoutUuid the source prototype layout uuid
	* @return the matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByG_P_SPLU(long groupId, boolean privateLayout,
		String sourcePrototypeLayoutUuid);

	/**
	* Returns the layout where groupId = &#63; and privateLayout = &#63; and sourcePrototypeLayoutUuid = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param sourcePrototypeLayoutUuid the source prototype layout uuid
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByG_P_SPLU(long groupId, boolean privateLayout,
		String sourcePrototypeLayoutUuid, boolean retrieveFromCache);

	/**
	* Removes the layout where groupId = &#63; and privateLayout = &#63; and sourcePrototypeLayoutUuid = &#63; from the database.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param sourcePrototypeLayoutUuid the source prototype layout uuid
	* @return the layout that was removed
	*/
	public Layout removeByG_P_SPLU(long groupId, boolean privateLayout,
		String sourcePrototypeLayoutUuid) throws NoSuchLayoutException;

	/**
	* Returns the number of layouts where groupId = &#63; and privateLayout = &#63; and sourcePrototypeLayoutUuid = &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param sourcePrototypeLayoutUuid the source prototype layout uuid
	* @return the number of matching layouts
	*/
	public int countByG_P_SPLU(long groupId, boolean privateLayout,
		String sourcePrototypeLayoutUuid);

	/**
	* Returns all the layouts where groupId = &#63; and leftPlid &gt; &#63; and rightPlid &lt; &#63; and privateLayout = &#63;.
	*
	* @param groupId the group ID
	* @param leftPlid the left plid
	* @param rightPlid the right plid
	* @param privateLayout the private layout
	* @return the matching layouts
	*/
	public java.util.List<Layout> findByG_P_GtLP_LtRP(long groupId,
		long leftPlid, long rightPlid, boolean privateLayout);

	/**
	* Returns a range of all the layouts where groupId = &#63; and leftPlid &gt; &#63; and rightPlid &lt; &#63; and privateLayout = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param leftPlid the left plid
	* @param rightPlid the right plid
	* @param privateLayout the private layout
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @return the range of matching layouts
	*/
	public java.util.List<Layout> findByG_P_GtLP_LtRP(long groupId,
		long leftPlid, long rightPlid, boolean privateLayout, int start, int end);

	/**
	* Returns an ordered range of all the layouts where groupId = &#63; and leftPlid &gt; &#63; and rightPlid &lt; &#63; and privateLayout = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param leftPlid the left plid
	* @param rightPlid the right plid
	* @param privateLayout the private layout
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching layouts
	*/
	public java.util.List<Layout> findByG_P_GtLP_LtRP(long groupId,
		long leftPlid, long rightPlid, boolean privateLayout, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns an ordered range of all the layouts where groupId = &#63; and leftPlid &gt; &#63; and rightPlid &lt; &#63; and privateLayout = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param leftPlid the left plid
	* @param rightPlid the right plid
	* @param privateLayout the private layout
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching layouts
	*/
	public java.util.List<Layout> findByG_P_GtLP_LtRP(long groupId,
		long leftPlid, long rightPlid, boolean privateLayout, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first layout in the ordered set where groupId = &#63; and leftPlid &gt; &#63; and rightPlid &lt; &#63; and privateLayout = &#63;.
	*
	* @param groupId the group ID
	* @param leftPlid the left plid
	* @param rightPlid the right plid
	* @param privateLayout the private layout
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching layout
	* @throws NoSuchLayoutException if a matching layout could not be found
	*/
	public Layout findByG_P_GtLP_LtRP_First(long groupId, long leftPlid,
		long rightPlid, boolean privateLayout,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns the first layout in the ordered set where groupId = &#63; and leftPlid &gt; &#63; and rightPlid &lt; &#63; and privateLayout = &#63;.
	*
	* @param groupId the group ID
	* @param leftPlid the left plid
	* @param rightPlid the right plid
	* @param privateLayout the private layout
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByG_P_GtLP_LtRP_First(long groupId, long leftPlid,
		long rightPlid, boolean privateLayout,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns the last layout in the ordered set where groupId = &#63; and leftPlid &gt; &#63; and rightPlid &lt; &#63; and privateLayout = &#63;.
	*
	* @param groupId the group ID
	* @param leftPlid the left plid
	* @param rightPlid the right plid
	* @param privateLayout the private layout
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching layout
	* @throws NoSuchLayoutException if a matching layout could not be found
	*/
	public Layout findByG_P_GtLP_LtRP_Last(long groupId, long leftPlid,
		long rightPlid, boolean privateLayout,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns the last layout in the ordered set where groupId = &#63; and leftPlid &gt; &#63; and rightPlid &lt; &#63; and privateLayout = &#63;.
	*
	* @param groupId the group ID
	* @param leftPlid the left plid
	* @param rightPlid the right plid
	* @param privateLayout the private layout
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByG_P_GtLP_LtRP_Last(long groupId, long leftPlid,
		long rightPlid, boolean privateLayout,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns the layouts before and after the current layout in the ordered set where groupId = &#63; and leftPlid &gt; &#63; and rightPlid &lt; &#63; and privateLayout = &#63;.
	*
	* @param plid the primary key of the current layout
	* @param groupId the group ID
	* @param leftPlid the left plid
	* @param rightPlid the right plid
	* @param privateLayout the private layout
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next layout
	* @throws NoSuchLayoutException if a layout with the primary key could not be found
	*/
	public Layout[] findByG_P_GtLP_LtRP_PrevAndNext(long plid, long groupId,
		long leftPlid, long rightPlid, boolean privateLayout,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns all the layouts that the user has permission to view where groupId = &#63; and leftPlid &gt; &#63; and rightPlid &lt; &#63; and privateLayout = &#63;.
	*
	* @param groupId the group ID
	* @param leftPlid the left plid
	* @param rightPlid the right plid
	* @param privateLayout the private layout
	* @return the matching layouts that the user has permission to view
	*/
	public java.util.List<Layout> filterFindByG_P_GtLP_LtRP(long groupId,
		long leftPlid, long rightPlid, boolean privateLayout);

	/**
	* Returns a range of all the layouts that the user has permission to view where groupId = &#63; and leftPlid &gt; &#63; and rightPlid &lt; &#63; and privateLayout = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param leftPlid the left plid
	* @param rightPlid the right plid
	* @param privateLayout the private layout
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @return the range of matching layouts that the user has permission to view
	*/
	public java.util.List<Layout> filterFindByG_P_GtLP_LtRP(long groupId,
		long leftPlid, long rightPlid, boolean privateLayout, int start, int end);

	/**
	* Returns an ordered range of all the layouts that the user has permissions to view where groupId = &#63; and leftPlid &gt; &#63; and rightPlid &lt; &#63; and privateLayout = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param leftPlid the left plid
	* @param rightPlid the right plid
	* @param privateLayout the private layout
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching layouts that the user has permission to view
	*/
	public java.util.List<Layout> filterFindByG_P_GtLP_LtRP(long groupId,
		long leftPlid, long rightPlid, boolean privateLayout, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns the layouts before and after the current layout in the ordered set of layouts that the user has permission to view where groupId = &#63; and leftPlid &gt; &#63; and rightPlid &lt; &#63; and privateLayout = &#63;.
	*
	* @param plid the primary key of the current layout
	* @param groupId the group ID
	* @param leftPlid the left plid
	* @param rightPlid the right plid
	* @param privateLayout the private layout
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next layout
	* @throws NoSuchLayoutException if a layout with the primary key could not be found
	*/
	public Layout[] filterFindByG_P_GtLP_LtRP_PrevAndNext(long plid,
		long groupId, long leftPlid, long rightPlid, boolean privateLayout,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Removes all the layouts where groupId = &#63; and leftPlid &gt; &#63; and rightPlid &lt; &#63; and privateLayout = &#63; from the database.
	*
	* @param groupId the group ID
	* @param leftPlid the left plid
	* @param rightPlid the right plid
	* @param privateLayout the private layout
	*/
	public void removeByG_P_GtLP_LtRP(long groupId, long leftPlid,
		long rightPlid, boolean privateLayout);

	/**
	* Returns the number of layouts where groupId = &#63; and leftPlid &gt; &#63; and rightPlid &lt; &#63; and privateLayout = &#63;.
	*
	* @param groupId the group ID
	* @param leftPlid the left plid
	* @param rightPlid the right plid
	* @param privateLayout the private layout
	* @return the number of matching layouts
	*/
	public int countByG_P_GtLP_LtRP(long groupId, long leftPlid,
		long rightPlid, boolean privateLayout);

	/**
	* Returns the number of layouts that the user has permission to view where groupId = &#63; and leftPlid &gt; &#63; and rightPlid &lt; &#63; and privateLayout = &#63;.
	*
	* @param groupId the group ID
	* @param leftPlid the left plid
	* @param rightPlid the right plid
	* @param privateLayout the private layout
	* @return the number of matching layouts that the user has permission to view
	*/
	public int filterCountByG_P_GtLP_LtRP(long groupId, long leftPlid,
		long rightPlid, boolean privateLayout);

	/**
	* Returns all the layouts where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63; and priority &le; &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutId the parent layout ID
	* @param priority the priority
	* @return the matching layouts
	*/
	public java.util.List<Layout> findByG_P_P_LtP(long groupId,
		boolean privateLayout, long parentLayoutId, int priority);

	/**
	* Returns a range of all the layouts where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63; and priority &le; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutId the parent layout ID
	* @param priority the priority
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @return the range of matching layouts
	*/
	public java.util.List<Layout> findByG_P_P_LtP(long groupId,
		boolean privateLayout, long parentLayoutId, int priority, int start,
		int end);

	/**
	* Returns an ordered range of all the layouts where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63; and priority &le; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutId the parent layout ID
	* @param priority the priority
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching layouts
	*/
	public java.util.List<Layout> findByG_P_P_LtP(long groupId,
		boolean privateLayout, long parentLayoutId, int priority, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns an ordered range of all the layouts where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63; and priority &le; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutId the parent layout ID
	* @param priority the priority
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching layouts
	*/
	public java.util.List<Layout> findByG_P_P_LtP(long groupId,
		boolean privateLayout, long parentLayoutId, int priority, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first layout in the ordered set where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63; and priority &le; &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutId the parent layout ID
	* @param priority the priority
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching layout
	* @throws NoSuchLayoutException if a matching layout could not be found
	*/
	public Layout findByG_P_P_LtP_First(long groupId, boolean privateLayout,
		long parentLayoutId, int priority,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns the first layout in the ordered set where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63; and priority &le; &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutId the parent layout ID
	* @param priority the priority
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByG_P_P_LtP_First(long groupId, boolean privateLayout,
		long parentLayoutId, int priority,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns the last layout in the ordered set where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63; and priority &le; &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutId the parent layout ID
	* @param priority the priority
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching layout
	* @throws NoSuchLayoutException if a matching layout could not be found
	*/
	public Layout findByG_P_P_LtP_Last(long groupId, boolean privateLayout,
		long parentLayoutId, int priority,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns the last layout in the ordered set where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63; and priority &le; &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutId the parent layout ID
	* @param priority the priority
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByG_P_P_LtP_Last(long groupId, boolean privateLayout,
		long parentLayoutId, int priority,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns the layouts before and after the current layout in the ordered set where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63; and priority &le; &#63;.
	*
	* @param plid the primary key of the current layout
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutId the parent layout ID
	* @param priority the priority
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next layout
	* @throws NoSuchLayoutException if a layout with the primary key could not be found
	*/
	public Layout[] findByG_P_P_LtP_PrevAndNext(long plid, long groupId,
		boolean privateLayout, long parentLayoutId, int priority,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Returns all the layouts that the user has permission to view where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63; and priority &le; &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutId the parent layout ID
	* @param priority the priority
	* @return the matching layouts that the user has permission to view
	*/
	public java.util.List<Layout> filterFindByG_P_P_LtP(long groupId,
		boolean privateLayout, long parentLayoutId, int priority);

	/**
	* Returns a range of all the layouts that the user has permission to view where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63; and priority &le; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutId the parent layout ID
	* @param priority the priority
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @return the range of matching layouts that the user has permission to view
	*/
	public java.util.List<Layout> filterFindByG_P_P_LtP(long groupId,
		boolean privateLayout, long parentLayoutId, int priority, int start,
		int end);

	/**
	* Returns an ordered range of all the layouts that the user has permissions to view where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63; and priority &le; &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutId the parent layout ID
	* @param priority the priority
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching layouts that the user has permission to view
	*/
	public java.util.List<Layout> filterFindByG_P_P_LtP(long groupId,
		boolean privateLayout, long parentLayoutId, int priority, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns the layouts before and after the current layout in the ordered set of layouts that the user has permission to view where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63; and priority &le; &#63;.
	*
	* @param plid the primary key of the current layout
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutId the parent layout ID
	* @param priority the priority
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next layout
	* @throws NoSuchLayoutException if a layout with the primary key could not be found
	*/
	public Layout[] filterFindByG_P_P_LtP_PrevAndNext(long plid, long groupId,
		boolean privateLayout, long parentLayoutId, int priority,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator)
		throws NoSuchLayoutException;

	/**
	* Removes all the layouts where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63; and priority &le; &#63; from the database.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutId the parent layout ID
	* @param priority the priority
	*/
	public void removeByG_P_P_LtP(long groupId, boolean privateLayout,
		long parentLayoutId, int priority);

	/**
	* Returns the number of layouts where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63; and priority &le; &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutId the parent layout ID
	* @param priority the priority
	* @return the number of matching layouts
	*/
	public int countByG_P_P_LtP(long groupId, boolean privateLayout,
		long parentLayoutId, int priority);

	/**
	* Returns the number of layouts that the user has permission to view where groupId = &#63; and privateLayout = &#63; and parentLayoutId = &#63; and priority &le; &#63;.
	*
	* @param groupId the group ID
	* @param privateLayout the private layout
	* @param parentLayoutId the parent layout ID
	* @param priority the priority
	* @return the number of matching layouts that the user has permission to view
	*/
	public int filterCountByG_P_P_LtP(long groupId, boolean privateLayout,
		long parentLayoutId, int priority);

	/**
	* Returns the layout where headId = &#63; or throws a {@link NoSuchLayoutException} if it could not be found.
	*
	* @param headId the head ID
	* @return the matching layout
	* @throws NoSuchLayoutException if a matching layout could not be found
	*/
	public Layout findByHeadId(long headId) throws NoSuchLayoutException;

	/**
	* Returns the layout where headId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param headId the head ID
	* @return the matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByHeadId(long headId);

	/**
	* Returns the layout where headId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param headId the head ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching layout, or <code>null</code> if a matching layout could not be found
	*/
	public Layout fetchByHeadId(long headId, boolean retrieveFromCache);

	/**
	* Removes the layout where headId = &#63; from the database.
	*
	* @param headId the head ID
	* @return the layout that was removed
	*/
	public Layout removeByHeadId(long headId) throws NoSuchLayoutException;

	/**
	* Returns the number of layouts where headId = &#63;.
	*
	* @param headId the head ID
	* @return the number of matching layouts
	*/
	public int countByHeadId(long headId);

	/**
	* Caches the layout in the entity cache if it is enabled.
	*
	* @param layout the layout
	*/
	public void cacheResult(Layout layout);

	/**
	* Caches the layouts in the entity cache if it is enabled.
	*
	* @param layouts the layouts
	*/
	public void cacheResult(java.util.List<Layout> layouts);

	/**
	* Creates a new layout with the primary key. Does not add the layout to the database.
	*
	* @param plid the primary key for the new layout
	* @return the new layout
	*/
	public Layout create(long plid);

	/**
	* Removes the layout with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param plid the primary key of the layout
	* @return the layout that was removed
	* @throws NoSuchLayoutException if a layout with the primary key could not be found
	*/
	public Layout remove(long plid) throws NoSuchLayoutException;

	public Layout updateImpl(Layout layout);

	/**
	* Returns the layout with the primary key or throws a {@link NoSuchLayoutException} if it could not be found.
	*
	* @param plid the primary key of the layout
	* @return the layout
	* @throws NoSuchLayoutException if a layout with the primary key could not be found
	*/
	public Layout findByPrimaryKey(long plid) throws NoSuchLayoutException;

	/**
	* Returns the layout with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param plid the primary key of the layout
	* @return the layout, or <code>null</code> if a layout with the primary key could not be found
	*/
	public Layout fetchByPrimaryKey(long plid);

	/**
	* Returns all the layouts.
	*
	* @return the layouts
	*/
	public java.util.List<Layout> findAll();

	/**
	* Returns a range of all the layouts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @return the range of layouts
	*/
	public java.util.List<Layout> findAll(int start, int end);

	/**
	* Returns an ordered range of all the layouts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of layouts
	*/
	public java.util.List<Layout> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator);

	/**
	* Returns an ordered range of all the layouts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LayoutModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of layouts
	* @param end the upper bound of the range of layouts (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of layouts
	*/
	public java.util.List<Layout> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Layout> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the layouts from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of layouts.
	*
	* @return the number of layouts
	*/
	public int countAll();

	@Override
	public Set<String> getBadColumnNames();

	public long countAncestors(Layout layout);

	public long countDescendants(Layout layout);

	public java.util.List<Layout> getAncestors(Layout layout);

	public java.util.List<Layout> getDescendants(Layout layout);

	/**
	* Rebuilds the layouts tree for the scope using the modified pre-order tree traversal algorithm.
	*
	* <p>
	* Only call this method if the tree has become stale through operations other than normal CRUD. Under normal circumstances the tree is automatically rebuilt whenver necessary.
	* </p>
	*
	* @param groupId the ID of the scope
	* @param force whether to force the rebuild even if the tree is not stale
	*/
	public void rebuildTree(long groupId, boolean force);

	public void setRebuildTreeEnabled(boolean rebuildTreeEnabled);
}