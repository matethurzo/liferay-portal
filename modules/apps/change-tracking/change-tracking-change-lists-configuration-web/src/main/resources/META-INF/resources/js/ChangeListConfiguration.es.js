import Component from 'metal-component';
import Soy from 'metal-soy';

import templates from './ChangeListConfiguration.soy';

// const axios = require('axios');
/**
 * ChangeListConfiguration
 *
 */

class ChangeListConfiguration extends Component {

	attached() {
		fetch(
			this.portalURL + '/o/change-tracking/configurations/' + this.companyId,
			{
				credentials: 'include',
				headers: {
					'Content-Type': 'application/json'
				},
				method: 'GET'
			}
		)
			.then(
				response => response.json()
			)
			.then(
				json => console.log(json)
			);

		const mockUpData = {
			'changeTrackingEnabled': false,
			'tooltip': ['Web Content', 'Documents and Media', 'Forms', 'Blogs', 'Pages'],
			'userId': 20141
		};

		this.setState(
			{
				tooltip: mockUpData.tooltip
			}
		);
	}

	handleCheck(event) {
		this.setState(
			{changeTrackingEnabled: event.target.checked}
		);
	}

	save(event) {
		console.log(this.changeTrackingEnabled);
	}

	saveAndGoToOverview(event) {
		console.log(this.changeTrackingEnabled);
	}

}

ChangeListConfiguration.STATE = {

	companyId: {
		writeOnce: false
	},

	changeTrackingEnabled: {

		// Called whenever a new value is set. Useful when normalizing your
		// state data.
		// setter: 'setIt',

		// Accepts either number or string types. If the validator check fails,
		// the new value is discarded, and the current value kept.
		// validator: val => core.isBool(),

		// Initial value

		value: false,

		// You can, instead of the `value` option above, use a function to
		// return the initial value for the state.
		// valueFn: val => 0,

		// It's also possible to define that a property can only receive a
		// value once, and later behave as read-only.

		writeOnce: false
	},

	portalURL: {
		writeOnce: false
	},

	spritemap: {
		writeOnce: true
	},

	tooltip: {
		writeOnce: false
	}
};

Soy.register(ChangeListConfiguration, templates);

export default ChangeListConfiguration;