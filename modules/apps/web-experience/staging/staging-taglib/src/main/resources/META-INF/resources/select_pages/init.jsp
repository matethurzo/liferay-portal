<%--
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
--%>

<%@ include file="/init.jsp" %>

<%
boolean disableInputs = GetterUtil.getBoolean(request.getAttribute("liferay-staging:select-pages:disableInputs"));
groupId = GetterUtil.getLong(request.getAttribute("liferay-staging:select-pages:groupId"));
long layoutSetBranchId = GetterUtil.getLong(request.getAttribute("liferay-staging:select-pages:layoutSetBranchId"));
boolean layoutSetSettings = GetterUtil.getBoolean(request.getAttribute("liferay-staging:select-pages:layoutSetSettings"));
boolean logo = GetterUtil.getBoolean(request.getAttribute("liferay-staging:select-pages:logo"));
privateLayout = GetterUtil.getBoolean(request.getAttribute("liferay-staging:select-pages:privateLayout"));
String selectedLayoutIds = GetterUtil.getString(request.getAttribute("liferay-staging:select-pages:selectedLayoutIds"));
boolean showDeleteMissingLayouts = GetterUtil.getBoolean(request.getAttribute("liferay-staging:select-pages:showDeleteMissingLayouts"));
boolean themeReference = GetterUtil.getBoolean(request.getAttribute("liferay-staging:select-pages:themeReference"));
String treeId = GetterUtil.getString(request.getAttribute("liferay-staging:select-pages:treeId"));
%>