import Component from 'metal-component';
import Soy from 'metal-soy';

import templates from './ChangeListConfiguration.soy';

/**
 * ChangeListConfiguration
 *
 */

class ChangeListConfiguration extends Component {

	attached() {
		fetch(
			"http://localhost:8080/o/change-tracking/configurations/20101",
			{
				method: "GET", //method: "PUT"
				headers: {
					"Authorization": "Basic dGVzdEBsaWZlcmF5LmNvbTp0ZXN0",
					"Content-Type": "application/json"
				},
				//body: {
				//     "changeTrackingEnabled": true,
				//     "userId": 20141
				// }
			})
			.then(response => response.json())
			.then(console.log(response));
	}

	save(event) {
		console.log(event + 'saving...');
	}

}

ChangeListConfiguration.STATE = {
};

Soy.register(ChangeListConfiguration, templates);

export default ChangeListConfiguration;
