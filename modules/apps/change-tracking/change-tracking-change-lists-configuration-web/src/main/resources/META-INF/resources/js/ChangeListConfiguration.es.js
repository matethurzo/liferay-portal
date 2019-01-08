import Component from 'metal-component';
import Soy from 'metal-soy';

import templates from './ChangeListConfiguration.soy';

/**
 * ChangeListConfiguration
 *
 */

class ChangeListConfiguration extends Component {

	attached() {
		axios.get('http://localhost:8080/o/change-tracking/configurations/' + context.companyId)
			.then(function(response) {
				console.log(response);
			});
	}

	save(event) {
		console.log(event + 'saving...');
	}

}

ChangeListConfiguration.STATE = {


};

Soy.register(ChangeListConfiguration, templates);

export default ChangeListConfiguration;
