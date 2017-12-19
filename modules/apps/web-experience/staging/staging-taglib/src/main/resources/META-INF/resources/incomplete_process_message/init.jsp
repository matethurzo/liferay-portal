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

<%@ page import="com.liferay.portal.kernel.backgroundtask.BackgroundTaskManagerUtil" %>

<%@ include file="/init.jsp" %>

<%
boolean localPublishing = ((Boolean)request.getAttribute("liferay-staging:incomplete-process-message:localPublishing")).booleanValue();
String taskExecutorClassName = (String)request.getAttribute("liferay-staging:incomplete-process-message:taskExecutorClassName");

int incompleteBackgroundTaskCount = BackgroundTaskManagerUtil.getBackgroundTasksCount(groupId, taskExecutorClassName, false);

if (localPublishing) {
	incompleteBackgroundTaskCount += BackgroundTaskManagerUtil.getBackgroundTasksCount(liveGroupId, taskExecutorClassName, false);
}

	incompleteBackgroundTaskCount = 5;
%>