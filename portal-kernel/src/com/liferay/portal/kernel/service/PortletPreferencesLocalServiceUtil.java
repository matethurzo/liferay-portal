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

package com.liferay.portal.kernel.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * Provides the local service utility for PortletPreferences. This utility wraps
 * <code>com.liferay.portal.service.impl.PortletPreferencesLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PortletPreferencesLocalService
 * @generated
 */
@ProviderType
public class PortletPreferencesLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.portal.service.impl.PortletPreferencesLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addLayoutPortletPreferences(
		long plid, long portletPreferencesId) {

		getService().addLayoutPortletPreferences(plid, portletPreferencesId);
	}

	public static void addLayoutPortletPreferences(
		long plid,
		com.liferay.portal.kernel.model.PortletPreferences portletPreferences) {

		getService().addLayoutPortletPreferences(plid, portletPreferences);
	}

	public static void addLayoutPortletPreferenceses(
		long plid,
		java.util.List<com.liferay.portal.kernel.model.PortletPreferences>
			portletPreferenceses) {

		getService().addLayoutPortletPreferenceses(plid, portletPreferenceses);
	}

	public static void addLayoutPortletPreferenceses(
		long plid, long[] portletPreferencesIds) {

		getService().addLayoutPortletPreferenceses(plid, portletPreferencesIds);
	}

	public static void addNewLayoutVersionPreferences(
		long oldLayoutVersionId, long layoutVersionId) {

		getService().addNewLayoutVersionPreferences(
			oldLayoutVersionId, layoutVersionId);
	}

	public static com.liferay.portal.kernel.model.PortletPreferences
		addPortletPreferences(
			long companyId, long ownerId, int ownerType, long plid,
			String portletId, com.liferay.portal.kernel.model.Portlet portlet,
			String defaultPreferences) {

		return getService().addPortletPreferences(
			companyId, ownerId, ownerType, plid, portletId, portlet,
			defaultPreferences);
	}

	/**
	 * Adds the portlet preferences to the database. Also notifies the appropriate model listeners.
	 *
	 * @param portletPreferences the portlet preferences
	 * @return the portlet preferences that was added
	 */
	public static com.liferay.portal.kernel.model.PortletPreferences
		addPortletPreferences(
			com.liferay.portal.kernel.model.PortletPreferences
				portletPreferences) {

		return getService().addPortletPreferences(portletPreferences);
	}

	public static void clearLayoutPortletPreferenceses(long plid) {
		getService().clearLayoutPortletPreferenceses(plid);
	}

	/**
	 * Creates a new portlet preferences with the primary key. Does not add the portlet preferences to the database.
	 *
	 * @param portletPreferencesId the primary key for the new portlet preferences
	 * @return the new portlet preferences
	 */
	public static com.liferay.portal.kernel.model.PortletPreferences
		createPortletPreferences(long portletPreferencesId) {

		return getService().createPortletPreferences(portletPreferencesId);
	}

	public static void deleteLayoutPortletPreferences(
		long plid, long portletPreferencesId) {

		getService().deleteLayoutPortletPreferences(plid, portletPreferencesId);
	}

	public static void deleteLayoutPortletPreferences(
		long plid,
		com.liferay.portal.kernel.model.PortletPreferences portletPreferences) {

		getService().deleteLayoutPortletPreferences(plid, portletPreferences);
	}

	public static void deleteLayoutPortletPreferenceses(
		long plid,
		java.util.List<com.liferay.portal.kernel.model.PortletPreferences>
			portletPreferenceses) {

		getService().deleteLayoutPortletPreferenceses(
			plid, portletPreferenceses);
	}

	public static void deleteLayoutPortletPreferenceses(
		long plid, long[] portletPreferencesIds) {

		getService().deleteLayoutPortletPreferenceses(
			plid, portletPreferencesIds);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the portlet preferences with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param portletPreferencesId the primary key of the portlet preferences
	 * @return the portlet preferences that was removed
	 * @throws PortalException if a portlet preferences with the primary key could not be found
	 */
	public static com.liferay.portal.kernel.model.PortletPreferences
			deletePortletPreferences(long portletPreferencesId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePortletPreferences(portletPreferencesId);
	}

	public static void deletePortletPreferences(
		long ownerId, int ownerType, long plid) {

		getService().deletePortletPreferences(ownerId, ownerType, plid);
	}

	public static void deletePortletPreferences(
			long ownerId, int ownerType, long plid, String portletId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deletePortletPreferences(
			ownerId, ownerType, plid, portletId);
	}

	/**
	 * Deletes the portlet preferences from the database. Also notifies the appropriate model listeners.
	 *
	 * @param portletPreferences the portlet preferences
	 * @return the portlet preferences that was removed
	 */
	public static com.liferay.portal.kernel.model.PortletPreferences
		deletePortletPreferences(
			com.liferay.portal.kernel.model.PortletPreferences
				portletPreferences) {

		return getService().deletePortletPreferences(portletPreferences);
	}

	public static void deletePortletPreferencesByOwnerId(long ownerId) {
		getService().deletePortletPreferencesByOwnerId(ownerId);
	}

	public static void deletePortletPreferencesByPlid(long plid) {
		getService().deletePortletPreferencesByPlid(plid);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.portal.model.impl.PortletPreferencesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.portal.model.impl.PortletPreferencesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.portal.kernel.model.PortletPreferences
		fetchPortletPreferences(long portletPreferencesId) {

		return getService().fetchPortletPreferences(portletPreferencesId);
	}

	public static com.liferay.portal.kernel.model.PortletPreferences
		fetchPortletPreferences(
			long ownerId, int ownerType, long plid, String portletId) {

		return getService().fetchPortletPreferences(
			ownerId, ownerType, plid, portletId);
	}

	public static javax.portlet.PortletPreferences fetchPreferences(
		long companyId, long ownerId, int ownerType, long plid,
		String portletId) {

		return getService().fetchPreferences(
			companyId, ownerId, ownerType, plid, portletId);
	}

	public static javax.portlet.PortletPreferences fetchPreferences(
		com.liferay.portal.kernel.model.PortletPreferencesIds
			portletPreferencesIds) {

		return getService().fetchPreferences(portletPreferencesIds);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static javax.portlet.PortletPreferences getDefaultPreferences(
		long companyId, String portletId) {

		return getService().getDefaultPreferences(companyId, portletId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static java.util.List
		<com.liferay.portal.kernel.model.PortletPreferences>
			getLayoutPortletPreferenceses(long plid) {

		return getService().getLayoutPortletPreferenceses(plid);
	}

	public static java.util.List
		<com.liferay.portal.kernel.model.PortletPreferences>
			getLayoutPortletPreferenceses(long plid, int start, int end) {

		return getService().getLayoutPortletPreferenceses(plid, start, end);
	}

	public static java.util.List
		<com.liferay.portal.kernel.model.PortletPreferences>
			getLayoutPortletPreferenceses(
				long plid, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<com.liferay.portal.kernel.model.PortletPreferences>
						orderByComparator) {

		return getService().getLayoutPortletPreferenceses(
			plid, start, end, orderByComparator);
	}

	public static int getLayoutPortletPreferencesesCount(long plid) {
		return getService().getLayoutPortletPreferencesesCount(plid);
	}

	/**
	 * Returns the plids of the layouts associated with the portlet preferences.
	 *
	 * @param portletPreferencesId the portletPreferencesId of the portlet preferences
	 * @return long[] the plids of layouts associated with the portlet preferences
	 */
	public static long[] getLayoutPrimaryKeys(long portletPreferencesId) {
		return getService().getLayoutPrimaryKeys(portletPreferencesId);
	}

	public static java.util.Set
		<com.liferay.portal.kernel.model.PortletPreferences>
			getLayoutVersionPortletPreferences(long layoutVersionId) {

		return getService().getLayoutVersionPortletPreferences(layoutVersionId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static com.liferay.portal.kernel.settings.Settings
		getPortletInstanceSettings(
			long companyId, long groupId, String portletId,
			com.liferay.portal.kernel.settings.PortletInstanceSettingsLocator
				portletInstanceSettingsLocator,
			com.liferay.portal.kernel.settings.Settings
				portalPreferencesSettings) {

		return getService().getPortletInstanceSettings(
			companyId, groupId, portletId, portletInstanceSettingsLocator,
			portalPreferencesSettings);
	}

	public static java.util.List
		<com.liferay.portal.kernel.model.PortletPreferences>
			getPortletPreferences() {

		return getService().getPortletPreferences();
	}

	public static java.util.List
		<com.liferay.portal.kernel.model.PortletPreferences>
			getPortletPreferences(int ownerType, long plid, String portletId) {

		return getService().getPortletPreferences(ownerType, plid, portletId);
	}

	/**
	 * Returns the portlet preferences with the primary key.
	 *
	 * @param portletPreferencesId the primary key of the portlet preferences
	 * @return the portlet preferences
	 * @throws PortalException if a portlet preferences with the primary key could not be found
	 */
	public static com.liferay.portal.kernel.model.PortletPreferences
			getPortletPreferences(long portletPreferencesId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPortletPreferences(portletPreferencesId);
	}

	public static java.util.List
		<com.liferay.portal.kernel.model.PortletPreferences>
			getPortletPreferences(long ownerId, int ownerType, long plid) {

		return getService().getPortletPreferences(ownerId, ownerType, plid);
	}

	public static com.liferay.portal.kernel.model.PortletPreferences
			getPortletPreferences(
				long ownerId, int ownerType, long plid, String portletId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPortletPreferences(
			ownerId, ownerType, plid, portletId);
	}

	public static java.util.List
		<com.liferay.portal.kernel.model.PortletPreferences>
				getPortletPreferences(
					long companyId, long ownerId, int ownerType,
					String portletId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPortletPreferences(
			companyId, ownerId, ownerType, portletId);
	}

	public static java.util.List
		<com.liferay.portal.kernel.model.PortletPreferences>
			getPortletPreferences(
				long companyId, long groupId, long ownerId, int ownerType,
				String portletId, boolean privateLayout) {

		return getService().getPortletPreferences(
			companyId, groupId, ownerId, ownerType, portletId, privateLayout);
	}

	public static java.util.List
		<com.liferay.portal.kernel.model.PortletPreferences>
			getPortletPreferences(long plid, String portletId) {

		return getService().getPortletPreferences(plid, portletId);
	}

	public static java.util.List
		<com.liferay.portal.kernel.model.PortletPreferences>
			getPortletPreferencesByOwnerId(long ownerId) {

		return getService().getPortletPreferencesByOwnerId(ownerId);
	}

	public static java.util.List
		<com.liferay.portal.kernel.model.PortletPreferences>
			getPortletPreferencesByPlid(long plid) {

		return getService().getPortletPreferencesByPlid(plid);
	}

	public static long getPortletPreferencesCount(
		int ownerType, long plid, String portletId) {

		return getService().getPortletPreferencesCount(
			ownerType, plid, portletId);
	}

	public static long getPortletPreferencesCount(
		int ownerType, String portletId) {

		return getService().getPortletPreferencesCount(ownerType, portletId);
	}

	public static long getPortletPreferencesCount(
		long ownerId, int ownerType, long plid,
		com.liferay.portal.kernel.model.Portlet portlet,
		boolean excludeDefaultPreferences) {

		return getService().getPortletPreferencesCount(
			ownerId, ownerType, plid, portlet, excludeDefaultPreferences);
	}

	public static long getPortletPreferencesCount(
		long ownerId, int ownerType, String portletId,
		boolean excludeDefaultPreferences) {

		return getService().getPortletPreferencesCount(
			ownerId, ownerType, portletId, excludeDefaultPreferences);
	}

	/**
	 * Returns a range of all the portlet preferenceses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.portal.model.impl.PortletPreferencesModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of portlet preferenceses
	 * @param end the upper bound of the range of portlet preferenceses (not inclusive)
	 * @return the range of portlet preferenceses
	 */
	public static java.util.List
		<com.liferay.portal.kernel.model.PortletPreferences>
			getPortletPreferenceses(int start, int end) {

		return getService().getPortletPreferenceses(start, end);
	}

	/**
	 * Returns the number of portlet preferenceses.
	 *
	 * @return the number of portlet preferenceses
	 */
	public static int getPortletPreferencesesCount() {
		return getService().getPortletPreferencesesCount();
	}

	public static javax.portlet.PortletPreferences getPreferences(
		long companyId, long ownerId, int ownerType, long plid,
		String portletId) {

		return getService().getPreferences(
			companyId, ownerId, ownerType, plid, portletId);
	}

	public static javax.portlet.PortletPreferences getPreferences(
		long companyId, long ownerId, int ownerType, long plid,
		String portletId, String defaultPreferences) {

		return getService().getPreferences(
			companyId, ownerId, ownerType, plid, portletId, defaultPreferences);
	}

	public static javax.portlet.PortletPreferences getPreferences(
		com.liferay.portal.kernel.model.PortletPreferencesIds
			portletPreferencesIds) {

		return getService().getPreferences(portletPreferencesIds);
	}

	public static java.util.Map<String, javax.portlet.PortletPreferences>
		getStrictPreferences(
			com.liferay.portal.kernel.model.Layout layout,
			java.util.List<com.liferay.portal.kernel.model.Portlet> portlets) {

		return getService().getStrictPreferences(layout, portlets);
	}

	public static javax.portlet.PortletPreferences getStrictPreferences(
		long companyId, long ownerId, int ownerType, long plid,
		String portletId) {

		return getService().getStrictPreferences(
			companyId, ownerId, ownerType, plid, portletId);
	}

	public static javax.portlet.PortletPreferences getStrictPreferences(
		com.liferay.portal.kernel.model.PortletPreferencesIds
			portletPreferencesIds) {

		return getService().getStrictPreferences(portletPreferencesIds);
	}

	public static boolean hasLayoutPortletPreferences(
		long plid, long portletPreferencesId) {

		return getService().hasLayoutPortletPreferences(
			plid, portletPreferencesId);
	}

	public static boolean hasLayoutPortletPreferenceses(long plid) {
		return getService().hasLayoutPortletPreferenceses(plid);
	}

	public static void setLayoutPortletPreferenceses(
		long plid, long[] portletPreferencesIds) {

		getService().setLayoutPortletPreferenceses(plid, portletPreferencesIds);
	}

	/**
	 * Updates the portlet preferences in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param portletPreferences the portlet preferences
	 * @return the portlet preferences that was updated
	 */
	public static com.liferay.portal.kernel.model.PortletPreferences
		updatePortletPreferences(
			com.liferay.portal.kernel.model.PortletPreferences
				portletPreferences) {

		return getService().updatePortletPreferences(portletPreferences);
	}

	public static com.liferay.portal.kernel.model.PortletPreferences
		updatePreferences(
			long ownerId, int ownerType, long plid, String portletId,
			javax.portlet.PortletPreferences portletPreferences) {

		return getService().updatePreferences(
			ownerId, ownerType, plid, portletId, portletPreferences);
	}

	public static com.liferay.portal.kernel.model.PortletPreferences
		updatePreferences(
			long ownerId, int ownerType, long plid, String portletId,
			String xml) {

		return getService().updatePreferences(
			ownerId, ownerType, plid, portletId, xml);
	}

	public static PortletPreferencesLocalService getService() {
		if (_service == null) {
			_service =
				(PortletPreferencesLocalService)PortalBeanLocatorUtil.locate(
					PortletPreferencesLocalService.class.getName());

			ReferenceRegistry.registerReference(
				PortletPreferencesLocalServiceUtil.class, "_service");
		}

		return _service;
	}

	private static PortletPreferencesLocalService _service;

}