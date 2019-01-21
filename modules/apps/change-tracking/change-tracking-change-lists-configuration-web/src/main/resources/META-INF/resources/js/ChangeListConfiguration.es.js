import PortletBase from 'frontend-js-web/liferay/PortletBase.es';
import Soy from 'metal-soy';
import {Config} from 'metal-state';
import {openToast} from 'frontend-js-web/liferay/toast/commands/OpenToast.es';

import templates from './ChangeListConfiguration.soy';

/**
 * Turns Change Lists on/off
 * ...
 */
class ChangeListConfiguration extends PortletBase {

	created() {
		this._getDataRequest(
			this.urlChangeTrackingConfiguration,
			response => {
				if (response) {
					this.setState(
						{
							changeTrackingEnabled: response.changeTrackingEnabled,
							initialFetch: true,
							tooltipBody: response.supportedContentTypes
						}
					);
				}
			}
		);
	}

	handleCheck(event) {
		this.setState(
			{
				changeTrackingEnabled: event.target.checked
			}
		);
	}

	save(event) {
		event.preventDefault();

		let data = {
			changeTrackingEnabled: this.changeTrackingEnabled
		};

		this._putDataRequest(
			this.urlChangeTrackingConfiguration,
			data,
			response => {

				// TODO display response message

				const message = 'saved!';

				openToast(
					{
						message,
						title: Liferay.Language.get('success'),
						type: 'success'
					}
				);
			}
		);
	}

	saveAndGoToOverview(event) {
		let data = {
			changeTrackingEnabled: this.changeTrackingEnabled
		};

		this._putDataRequest(
			this.urlChangeListConfigApi,
			data,
			response => {
				if (response) {

					// TODO redirect to overview
					// TODO display response message

					const message = 'saved and navigate!';

					openToast(
						{
							message,
							title: Liferay.Language.get('success'),
							type: 'success'
						}
					);
				}
			}
		);
	}

	_getDataRequest(url, callback) {
		let headers = new Headers();
		headers.append('Content-Type', 'application/json');

		const request = {
			credentials: 'include',
			headers,
			method: 'GET'
		};

		fetch(url, request)
			.then(
				response => response.json()
			)
			.then(
				response => {
					callback(response);
				}
			)
			.catch(
				(error) => {
					const message = typeof error === 'string' ?
						error :
						Liferay.Language.get('error');

					openToast(
						{
							message,
							title: Liferay.Language.get('error'),
							type: 'danger'
						}
					);
				}
			);
	}

	_putDataRequest(url, bodyData, callback) {
		let body = JSON.stringify(bodyData);

		let headers = new Headers();
		headers.append('Content-Type', 'application/json');

		const request = {
			body,
			credentials: 'include',
			headers,
			method: 'PUT'
		};

		fetch(url, request)
			.then(
				response => response.json()
			)
			.then(
				response => {
					callback(response);
				}
			)
			.catch(
				(error) => {
					const message = typeof error === 'string' ?
						error :
						Liferay.Language.get('error');

					openToast(
						{
							message,
							title: Liferay.Language.get('error'),
							type: 'danger'
						}
					);
				}
			);
	}
}

/**
 * State definition.
 *
 * @static
 * @type {!Object}
 */
ChangeListConfiguration.STATE = {

	/**
	 * change tracking on/off
	 *
	 * @type {Boolean}
	 */

	changeTrackingEnabled: Config.bool(),

	/**
	 * Initial fetch happened?
	 *
	 * @type {Boolean}
	 */

	initialFetch: Config.bool().value(false),

	/**
	 * api url
	 *
	 * @type {String}
	 */

	urlChangeTrackingConfiguration: Config.string().required(),

	/**
	 * Path to images.
	 *
	 * @type {String}
	 */

	spritemap: Config.string().required(),

	/**
	 * Lists of supported content types that are used up in tooltip
	 *
	 * @type {List<String>}
	 */

	tooltipBody: Config.array()
};

Soy.register(ChangeListConfiguration, templates);

export default ChangeListConfiguration;