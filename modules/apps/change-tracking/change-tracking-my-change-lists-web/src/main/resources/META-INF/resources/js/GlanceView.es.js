import Component from 'metal-component';
import Soy from 'metal-soy';
import {Config} from 'metal-state';

import templates from './GlanceView.soy';

class GlanceView extends Component {}

GlanceView.STATE = {};	

Soy.register(GlanceView, templates);

export {GlanceView};
export default GlanceView;