import PortletBase from 'frontend-js-web/liferay/PortletBase.es';
import Soy from 'metal-soy';
import {Config} from 'metal-state';


import templates from './ChangeListConfiguration.soy';

/**
 * Turns Change Lists on/off
 * ...
 */
class ChangeListConfiguration extends PortletBase {
}

/**
 * State definition.
 *
 * @static
 * @type {!Object}
 */
ChangeListConfiguration.STATE = {
	/**
	 * api url
	 *
	 * @type {String}
	 */
	urlChangeListConfigApi: Config.string().required(),

	/**
	 * PortalURL
	 *
	 * @type {String}
	 */
	portalURL: Config.string().required(),

	/**
	 * Path to images.
	 *
	 * @type {String}
	 */
	spritemap: Config.string().required(),
};

Soy.register(ChangeListConfiguration, templates);

export default ChangeListConfiguration;