import Component from 'metal-component';
import Soy from 'metal-soy';
import { Config } from 'metal-state';

import templates from './GlanceCardTable.soy';

class GlanceCardTable extends Component {}

GlanceCardTable.STATE = {};

Soy.register(GlanceCardTable, templates);

export { GlanceCardTable };
export default GlanceCardTable;