import 'clay-icon';
import PortletBase from 'frontend-js-web/liferay/PortletBase.es';
import Soy from 'metal-soy';
import {Config} from 'metal-state';
import {dom} from 'metal-dom';
import {EventHandler} from 'metal-events';
import {openToast} from 'frontend-js-web/liferay/toast/commands/OpenToast.es';

import templates from './ChangeListsIndicator.soy';

const BLUE_BACKGROUND_TOOLTIP_CSS_CLASS_NAME = 'tooltip-background-blue';

const CHANGE_LISTS_INDICATOR_QUERY_SELECTOR = '[data-change-lists-indicator]';

const GREEN_BACKGROUND_TOOLTIP_CSS_CLASS_NAME = 'tooltip-background-green';

const PRODUCTION_COLLECTION_NAME = 'productionCTCollectionName';

const TOOLTIP_QUERY_SELECTOR = '.yui3-widget.tooltip';

/**
 * Component for the Change Lists indicator
 * @review
 */
class ChangeListsIndicator extends PortletBase {

	/**
	 * @inheritDoc
	 */
	created() {
		this._eventHandler = new EventHandler();

		let urlActiveCollection = this.urlCollectionsBase + '?type=active&userId=' + Liferay.ThemeDisplay.getUserId();

		this._getDataRequest(
			urlActiveCollection,
			response => {
				if (response) {
					this.activeChangeListName = response[0].name;
					this._setTooltipCssClassName(this.activeChangeListName);
					this._setEventHandler();
				}
			}
		);
	}

	/**
	 * @inheritDoc
	 */
	detached() {
		this._eventHandler.removeAllListeners();
	}

	/**
	 * @inheritDoc
	 */
	disposed() {
		this._eventHandler.removeAllListeners();
	}

	/**
	 * Handles mouseenter event.
	 * @memberof ChangeListsIndicator
	 * @param {!Event} event
	 * @private
	 */
	_getDataRequest(url, callback) {
		let headers = new Headers();
		headers.append('Content-Type', 'application/json');

		let type = 'GET';

		let init = {
			credentials: 'include',
			headers,
			method: type
		};

		fetch(url, init)
			.then(response => response.json())
			.then(response => callback(response))
			.catch(
				(error) => {
					const message = typeof error === 'string' ?
						error :
						Liferay.Language.get('an-error-occured-while-getting-the-active-change-list');

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

	/**
	 * Handles blur event.
	 * @memberof ChangeListsIndicator
	 * @param {!Event} event
	 * @private
	 */
	_handleBlur(event) {
		this._handleMouseLeave.bind(this);
	}

	/**
	 * Handles focus event.
	 * @memberof ChangeListsIndicator
	 * @param {!Event} event
	 * @private
	 */
	_handleFocus(event) {
		this._handleMouseEnter.bind(this);
	}

	/**
	 * Handles click event.
	 * @memberof ChangeListsIndicator
	 * @param {!Event} event
	 * @private
	 */
	_handleMouseClick(event) {
		this._handleMouseEnter.bind(this);
	}

	/**
	 * Handles mouseenter event.
	 * @memberof ChangeListsIndicator
	 * @param {!Event} event
	 * @private
	 */
	_handleMouseEnter(event) {
		setTimeout(() => {
			let element = document.querySelector(TOOLTIP_QUERY_SELECTOR);

			if (element && !element.classList.contains(this._tooltipCssClassName)) {
				element.classList.add(this._tooltipCssClassName);
			}
		}, 0);
	}

	/**
	 * Handles mouseleave events.
	 * @memberof ChangeListsIndicator
	 * @param {!Event} event
	 * @private
	 */
	_handleMouseLeave(event) {
		setTimeout(() => {
			let element = document.querySelector(TOOLTIP_QUERY_SELECTOR);

			if (element && element.classList.contains(this._tooltipCssClassName)) {
				element.classList.remove(this._tooltipCssClassName);
			}
		}, 50);
	}

	/**
	 * Set the event for the change lists indicator.
	 * @memberof ChangeListsIndicator
	 * @param {!Event} event
	 * @private
	 */
	_setEventHandler() {
		let selector = CHANGE_LISTS_INDICATOR_QUERY_SELECTOR;

		this._eventHandler.add(
			dom.delegate(
				document,
				'blur',
				selector,
				this._handleBlur.bind(this)
			),
			dom.delegate(
				document,
				'click',
				selector,
				this._handleMouseClick.bind(this)
			),
			dom.delegate(
				document,
				'focus',
				selector,
				this._handleFocus.bind(this)
			),
			dom.delegate(
				document,
				'mouseenter',
				selector,
				this._handleMouseEnter.bind(this)
			),
			dom.delegate(
				document,
				'mouseleave',
				selector,
				this._handleMouseLeave.bind(this)
			)
		);
	}

	/**
	 * Set the tooltip css class name.
	 * @memberof ChangeListsIndicator
	 * @param {!Event} event
	 * @private
	 */
	_setTooltipCssClassName(activeChangeListName) {
		this._tooltipCssClassName = activeChangeListName != PRODUCTION_COLLECTION_NAME ? BLUE_BACKGROUND_TOOLTIP_CSS_CLASS_NAME : GREEN_BACKGROUND_TOOLTIP_CSS_CLASS_NAME;
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
	 * Name of the tooltip css class.
	 * @default
	 * @instance
	 * @memberOf ChangeListsIndicator
	 * @review
	 * @type {!string}
	 */

	_tooltipCssClassName: Config.string().value(''),

	/**
	 * Name of the active change list.
	 * @default
	 * @instance
	 * @memberOf ChangeListsIndicator
	 * @review
	 * @type {!string}
	 */

	activeChangeListName: Config.string().value(''),

	/**
	 * Path of the available icons.
	 * @default undefined
	 * @instance
	 * @memberOf ChangeListsIndicator
	 * @review
	 * @type {!string}
	 */

	spritemap: Config.string().required(),

	/**
	 * BBase REST API URL to collection resource
	 * @default
	 * @instance
	 * @memberOf ChangeListsIndicator
	 * @review
	 * @type {string}
	 */

	urlCollectionsBase: Config.string()

};

Soy.register(ChangeListsIndicator, templates);

export default ChangeListsIndicator;