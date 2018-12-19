import Component from 'metal-component';
import Soy from 'metal-soy';
import { Config } from 'metal-state';

import templates from './GlanceCard.soy';

class GlanceCard extends Component {}

Soy.register(GlanceCard, templates);

export { GlanceCard };
export default GlanceCard;
