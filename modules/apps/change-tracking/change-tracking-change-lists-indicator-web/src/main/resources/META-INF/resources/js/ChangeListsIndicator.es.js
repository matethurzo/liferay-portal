import ClayTooltip from 'clay-tooltip';
import ClayIcon from 'clay-icon';
import PortletBase from 'frontend-js-web/liferay/PortletBase.es';
import Soy from 'metal-soy';
import {Config} from 'metal-state';

import templates from './ChangeListsIndicator.soy';

/**
 * Component for the Change Lists indicator screen
 * @review
 */
class ChangeListsIndicator extends PortletBase {

	created() {
	}
}

/**
 * State definition.
 * @review
 * @static
 * @type {!Object}
 */
ChangeListsIndicator.STATE = {
	
	/**
	 * Path of the available icons.
	 * @default undefined
	 * @instance
	 * @memberOf ChangeListsIndicator
	 * @review
	 * @type {!string}
	 */

	spritemap: Config.string().required()

};

Soy.register(ChangeListsIndicator, templates);

export default ChangeListsIndicator;