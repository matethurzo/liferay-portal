import Component from 'metal-component';
import Soy from 'metal-soy';

import templates from './ChangeListConfiguration.soy';

/**
 * ChangeListConfiguration
 *
 */

class ChangeListConfiguration extends Component {

	save(event) {
		console.log(event + "saving...");
	}

}

ChangeListConfiguration.STATE = {


};

Soy.register(ChangeListConfiguration, templates);

export default ChangeListConfiguration;
