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

package com.liferay.change.tracking.change.lists.history.web.internal.display.context;

import com.liferay.change.tracking.CTEngineManager;
import com.liferay.change.tracking.constants.CTWebKeys;
import com.liferay.change.tracking.model.CTEntry;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.ViewTypeItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.ViewTypeItemList;
import com.liferay.portal.kernel.dao.orm.QueryDefinition;
import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.template.soy.util.SoyContext;
import com.liferay.portal.template.soy.util.SoyContextFactoryUtil;

import java.util.List;
import java.util.Objects;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import javax.servlet.http.HttpServletRequest;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * @author Máté Thurzó
 */
public class ChangeListsHistoryDisplayContext {

	public ChangeListsHistoryDisplayContext(
		HttpServletRequest httpServletRequest, RenderRequest renderRequest,
		RenderResponse renderResponse) {

		_httpServletRequest = httpServletRequest;
		_renderRequest = renderRequest;
		_renderResponse = renderResponse;

		_themeDisplay = (ThemeDisplay)_httpServletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);
	}

	public SoyContext getChangeListsHistoryContext() {
		SoyContext soyContext = SoyContextFactoryUtil.createSoyContext();

		soyContext.put("baseURL", String.valueOf(_getPortletURL()));
		soyContext.put("filterStatus", _getFilterByStatus());
		soyContext.put("filterUser", _getFilterByUser());
		soyContext.put("orderByCol", _getOrderByCol());
		soyContext.put("orderByType", getOrderByType());
		soyContext.put(
			"spritemap",
			_themeDisplay.getPathThemeImages() + "/lexicon/icons.svg");
		soyContext.put(
			"urlProcesses",
			_themeDisplay.getPortalURL() +
				"/o/change-tracking/processes?companyId=" +
					_themeDisplay.getCompanyId());

		return soyContext;
	}

	public String getChangeType(int changeType) {
		if (changeType == 1) {
			return "deleted";
		}
		else if (changeType == 2) {
			return "modified";
		}
		else {
			return "added";
		}
	}

	public List<DropdownItem> getFilterDropdownItems() {
		return new DropdownItemList() {
			{
				addGroup(
					dropdownGroupItem -> {
						dropdownGroupItem.setDropdownItems(
							_getFilterStatusDropdownItems());
						dropdownGroupItem.setLabel(
							LanguageUtil.get(
								_httpServletRequest, "filter-by-status"));
					});
				addGroup(
					dropdownGroupItem -> {
						dropdownGroupItem.setDropdownItems(
							_getFilterUserDropdownItems());
						dropdownGroupItem.setLabel(
							LanguageUtil.get(
								_httpServletRequest, "filter-by-user"));
					});
				addGroup(
					dropdownGroupItem -> {
						dropdownGroupItem.setDropdownItems(
							_getOrderByDropdownItems());
						dropdownGroupItem.setLabel(
							LanguageUtil.get(_httpServletRequest, "order-by"));
					});
			}
		};
	}

	public String getOrderByType() {
		if (_orderByType != null) {
			return _orderByType;
		}

		_orderByType = ParamUtil.getString(
			_httpServletRequest, "orderByType", "desc");

		return _orderByType;
	}

	public SearchContainer<CTEntry> getSearchContainer(long ctCollectionId) {
		SearchContainer<CTEntry> searchContainer = new SearchContainer<>(
			_renderRequest, new DisplayTerms(_renderRequest), null,
			SearchContainer.DEFAULT_CUR_PARAM, 0, SearchContainer.DEFAULT_DELTA,
			_getIteratorURL(), null, "there-are-no-change-entries");

		CTEngineManager ctEngineManager = _serviceTracker.getService();

		OrderByComparator<CTEntry> orderByComparator =
			OrderByComparatorFactoryUtil.create(
				"CTEntry", _getOrderByCol(), getOrderByType().equals("asc"));

		QueryDefinition<CTEntry> queryDefinition = new QueryDefinition<>(
			WorkflowConstants.STATUS_DRAFT, true, searchContainer.getStart(),
			searchContainer.getEnd(), orderByComparator);

		queryDefinition.setStatus(WorkflowConstants.STATUS_APPROVED);
		queryDefinition.setOrderByComparator(orderByComparator);

		List<CTEntry> ctEntries = ctEngineManager.getCTEntries(
			ctCollectionId, queryDefinition);

		searchContainer.setResults(ctEntries);

		searchContainer.setTotal(ctEntries.size());

		return searchContainer;
	}

	public String getSortingURL() {
		PortletURL sortingURL = _getPortletURL();

		sortingURL.setParameter(
			"orderByType",
			Objects.equals(getOrderByType(), "asc") ? "desc" : "asc");

		return sortingURL.toString();
	}

	public String getViewSearchActionURL() {
		PortletURL portletURL = _renderResponse.createRenderURL();

		return portletURL.toString();
	}

	public List<ViewTypeItem> getViewTypeItems() {
		return new ViewTypeItemList(_getPortletURL(), _getDisplayStyle()) {
			{
				addCardViewTypeItem();
				addTableViewTypeItem();
			}
		};
	}

	private String _getDisplayStyle() {
		if (_displayStyle != null) {
			return _displayStyle;
		}

		_displayStyle = ParamUtil.getString(
			_httpServletRequest, "displayStyle", "list");

		return _displayStyle;
	}

	private String _getFilterByStatus() {
		if (_filterByStatus != null) {
			return _filterByStatus;
		}

		_filterByStatus = ParamUtil.getString(
			_httpServletRequest, "status", "all");

		return _filterByStatus;
	}

	private String _getFilterByUser() {
		if (_filterByUser != null) {
			return _filterByUser;
		}

		_filterByUser = ParamUtil.getString(_httpServletRequest, "user", "all");

		return _filterByUser;
	}

	private List<DropdownItem> _getFilterStatusDropdownItems() {
		return new DropdownItemList() {
			{
				add(
					dropdownItem -> {
						dropdownItem.setActive(
							Objects.equals(_getFilterByStatus(), "all"));
						dropdownItem.setHref(_getPortletURL(), "status", "all");
						dropdownItem.setLabel(
							LanguageUtil.get(_httpServletRequest, "all"));
					});
				add(
					dropdownItem -> {
						dropdownItem.setActive(
							Objects.equals(_getFilterByStatus(), "published"));
						dropdownItem.setHref(
							_getPortletURL(), "status", "published");
						dropdownItem.setLabel(
							LanguageUtil.get(_httpServletRequest, "published"));
					});
				add(
					dropdownItem -> {
						dropdownItem.setActive(
							Objects.equals(_getFilterByStatus(), "failed"));
						dropdownItem.setHref(
							_getPortletURL(), "status", "failed");
						dropdownItem.setLabel(
							LanguageUtil.get(_httpServletRequest, "failed"));
					});
				add(
					dropdownItem -> {
						dropdownItem.setActive(
							Objects.equals(
								_getFilterByStatus(), "in-progress"));
						dropdownItem.setHref(
							_getPortletURL(), "status", "in-progress");
						dropdownItem.setLabel(
							LanguageUtil.get(
								_httpServletRequest, "in-progress"));
					});
				add(
					dropdownItem -> {
						dropdownItem.setActive(
							Objects.equals(_getFilterByStatus(), "scheduled"));
						dropdownItem.setHref(
							_getPortletURL(), "status", "scheduled");
						dropdownItem.setLabel(
							LanguageUtil.get(_httpServletRequest, "scheduled"));
					});
			}
		};
	}

	private List<DropdownItem> _getFilterUserDropdownItems() {
		return new DropdownItemList() {
			{
				add(
					dropdownItem -> {
						dropdownItem.setActive(
							Objects.equals(_getFilterByUser(), "all"));
						dropdownItem.setHref(_getPortletURL(), "user", "all");
						dropdownItem.setLabel(
							LanguageUtil.get(_httpServletRequest, "all"));
					});
			}
		};
	}

	private PortletURL _getIteratorURL() {
		PortletURL currentURL = PortletURLUtil.getCurrent(
			_renderRequest, _renderResponse);

		long ctProcessId = ParamUtil.getLong(
			_renderRequest, CTWebKeys.CT_PROCESS_ID);

		PortletURL iteratorURL = _renderResponse.createRenderURL();

		iteratorURL.setParameter("mvcPath", "/details.jsp");
		iteratorURL.setParameter("redirect", currentURL.toString());
		iteratorURL.setParameter(
			CTWebKeys.CT_PROCESS_ID, String.valueOf(ctProcessId));

		return iteratorURL;
	}

	private String _getOrderByCol() {
		if (_orderByCol != null) {
			return _orderByCol;
		}

		_orderByCol = ParamUtil.getString(
			_httpServletRequest, "orderByCol", "modifiedDate");

		return _orderByCol;
	}

	private List<DropdownItem> _getOrderByDropdownItems() {
		return new DropdownItemList() {
			{
				add(
					dropdownItem -> {
						dropdownItem.setActive(
							Objects.equals(_getOrderByCol(), "modifiedDate"));
						dropdownItem.setHref(
							_getPortletURL(), "orderByCol", "modifiedDate");
						dropdownItem.setLabel(
							LanguageUtil.get(
								_httpServletRequest, "modified-date"));
					});
				add(
					dropdownItem -> {
						dropdownItem.setActive(
							Objects.equals(_getOrderByCol(), "name"));
						dropdownItem.setHref(
							_getPortletURL(), "orderByCol", "name");
						dropdownItem.setLabel(
							LanguageUtil.get(_httpServletRequest, "name"));
					});
			}
		};
	}

	private PortletURL _getPortletURL() {
		PortletURL portletURL = _renderResponse.createRenderURL();

		String displayStyle = ParamUtil.getString(
			_httpServletRequest, "displayStyle");

		if (Validator.isNotNull(displayStyle)) {
			portletURL.setParameter("displayStyle", _getDisplayStyle());
		}

		String orderByCol = _getOrderByCol();

		if (Validator.isNotNull(orderByCol)) {
			portletURL.setParameter("orderByCol", orderByCol);
		}

		String orderByType = getOrderByType();

		if (Validator.isNotNull(orderByType)) {
			portletURL.setParameter("orderByType", orderByType);
		}

		return portletURL;
	}

	private static ServiceTracker<CTEngineManager, CTEngineManager>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CTEngineManager.class);

		ServiceTracker<CTEngineManager, CTEngineManager> serviceTracker =
			new ServiceTracker<>(
				bundle.getBundleContext(), CTEngineManager.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

	private String _displayStyle;
	private String _filterByStatus;
	private String _filterByUser;
	private final HttpServletRequest _httpServletRequest;
	private String _orderByCol;
	private String _orderByType;
	private final RenderRequest _renderRequest;
	private final RenderResponse _renderResponse;
	private final ThemeDisplay _themeDisplay;

}