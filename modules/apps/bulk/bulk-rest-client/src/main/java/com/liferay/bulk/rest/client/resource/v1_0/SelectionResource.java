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

package com.liferay.bulk.rest.client.resource.v1_0;

import com.liferay.bulk.rest.client.dto.v1_0.Selection;
import com.liferay.bulk.rest.client.http.HttpInvoker;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Generated;

/**
 * @author Alejandro Tardín
 * @generated
 */
@Generated("")
public interface SelectionResource {

	public static Builder builder() {
		return new Builder();
	}

	public Selection postBulkSelection(
			com.liferay.bulk.rest.client.dto.v1_0.DocumentBulkSelection
				documentBulkSelection)
		throws Exception;

	public HttpInvoker.HttpResponse postBulkSelectionHttpResponse(
			com.liferay.bulk.rest.client.dto.v1_0.DocumentBulkSelection
				documentBulkSelection)
		throws Exception;

	public static class Builder {

		public Builder authentication(String login, String password) {
			_login = login;
			_password = password;

			return this;
		}

		public SelectionResource build() {
			return new SelectionResourceImpl(this);
		}

		public Builder endpoint(String host, int port, String scheme) {
			_host = host;
			_port = port;
			_scheme = scheme;

			return this;
		}

		public Builder locale(Locale locale) {
			_locale = locale;

			return this;
		}

		private Builder() {
		}

		private String _host = "localhost";
		private Locale _locale;
		private String _login = "test@liferay.com";
		private String _password = "test";
		private int _port = 8080;
		private String _scheme = "http";

	}

	public static class SelectionResourceImpl implements SelectionResource {

		public Selection postBulkSelection(
				com.liferay.bulk.rest.client.dto.v1_0.DocumentBulkSelection
					documentBulkSelection)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse =
				postBulkSelectionHttpResponse(documentBulkSelection);

			String content = httpResponse.getContent();

			_logger.fine("HTTP response content: " + content);

			_logger.fine("HTTP response message: " + httpResponse.getMessage());
			_logger.fine(
				"HTTP response status code: " + httpResponse.getStatusCode());

			try {
				return com.liferay.bulk.rest.client.serdes.v1_0.SelectionSerDes.
					toDTO(content);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw e;
			}
		}

		public HttpInvoker.HttpResponse postBulkSelectionHttpResponse(
				com.liferay.bulk.rest.client.dto.v1_0.DocumentBulkSelection
					documentBulkSelection)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			httpInvoker.body(
				documentBulkSelection.toString(), "application/json");

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port + "/o/bulk/v1.0/bulk-selection");

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		private SelectionResourceImpl(Builder builder) {
			_builder = builder;
		}

		private static final Logger _logger = Logger.getLogger(
			SelectionResource.class.getName());

		private Builder _builder;

	}

}