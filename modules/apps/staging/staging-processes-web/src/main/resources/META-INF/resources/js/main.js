AUI.add(
	'liferay-staging-processes-export-import',
	function(A) {
		var $ = AUI.$;

		var Lang = A.Lang;

		var ADate = A.Date;

		var FAILURE_TIMEOUT = 10000;

		var RENDER_INTERVAL_IDLE = 60000;

		var RENDER_INTERVAL_IN_PROGRESS = 2000;

		var STR_CHECKED = 'checked';

		var STR_CLICK = 'click';

		var STR_EMPTY = '';

		var STR_HIDE = 'hide';

		var defaultConfig = {
			setter: '_setNode'
		};

		var ExportImport = A.Component.create({
			ATTRS: {
				archivedSetupsNode: defaultConfig,
				commentsNode: defaultConfig,
				deletionsNode: defaultConfig,
				exportLAR: defaultConfig,
				form: defaultConfig,
				incompleteProcessMessageNode: defaultConfig,
				locale: STR_EMPTY,
				processesNode: defaultConfig,
				rangeAllNode: defaultConfig,
				rangeDateRangeNode: defaultConfig,
				rangeLastNode: defaultConfig,
				rangeLastPublishNode: defaultConfig,
				ratingsNode: defaultConfig,
				setupNode: defaultConfig,
				timeZoneOffset: 0,
				userPreferencesNode: defaultConfig
			},

			AUGMENTS: [Liferay.PortletBase],

			EXTENDS: A.Base,

			NAME: 'exportimport',

			prototype: {
				initializer: function(config) {
					var instance = this;

					instance._bindUI();

					instance._exportLAR = config.exportLAR;
					instance._layoutsExportTreeOutput = instance.byId(
						config.pageTreeId + 'Output'
					);

					instance._nodeInputStates = [];

					instance._initLabels();

					instance._processesResourceURL =
						config.processesResourceURL;

					var eventHandles = [
						Liferay.on(
							instance.ns('viewBackgroundTaskDetails'),
							instance._onViewBackgroundTaskDetails,
							instance
						)
					];

					instance._eventHandles = eventHandles;

					instance._renderTimer = A.later(
						RENDER_INTERVAL_IN_PROGRESS,
						instance,
						instance._renderProcesses
					);
				},

				destructor: function() {
					var instance = this;

					if (instance._contentOptionsDialog) {
						instance._contentOptionsDialog.destroy();
					}

					if (instance._globalConfigurationDialog) {
						instance._globalConfigurationDialog.destroy();
					}

					if (instance._renderTimer) {
						instance._renderTimer.cancel();
					}

					if (instance._scheduledPublishingEventsDialog) {
						instance._scheduledPublishingEventsDialog.destroy();
					}
				},

				getDateRangeChecker: function() {
					var instance = this;

					var today = new Date();

					var todayMS = +today;

					var clientTZOffset = today.getTimezoneOffset();

					var serverTZOffset = this.get('timeZoneOffset');

					var adjustedDate = new Date(
						todayMS + serverTZOffset + clientTZOffset * 60 * 1000
					);

					var dateRangeChecker = {
						todayUsed: adjustedDate,
						validRange: true
					};

					if (instance._isChecked('rangeDateRangeNode')) {
						dateRangeChecker.validRange =
							instance._rangeEndsLater() &&
							instance._rangeEndsInPast(adjustedDate) &&
							instance._rangeStartsInPast(adjustedDate);
					}

					return dateRangeChecker;
				},

				showNotification: function(dateChecker) {
					var instance = this;

					if (instance._notice) {
						instance._notice.remove();
					}

					var message = instance._getNotificationMessage(dateChecker);

					instance._notice = new Liferay.Notice({
						animationConfig: {
							duration: 2,
							left: '0px',
							top: '0px'
						},
						closeText: false,
						content:
							message +
							'<button aria-label="' +
							Liferay.Language.get('close') +
							'" type="button" class="close">&times;</button>',
						noticeClass: 'hide',
						timeout: 10000,
						toggleText: false,
						type: 'warning',
						useAnimation: true
					});

					instance._notice.show();
				},

				_bindUI: function() {
					var instance = this;

					var form = instance.get('form');

					if (form) {
						form.delegate(
							STR_CLICK,
							function(event) {
								var portletId = event.currentTarget.attr(
									'data-portletid'
								);

								var portletTitle = event.currentTarget.attr(
									'data-portlettitle'
								);

								if (!portletTitle) {
									portletTitle = Liferay.Language.get(
										'content'
									);
								}

								var contentDialog = instance._getContentDialog(
									portletId,
									portletTitle
								);

								contentDialog.show();
							},
							'.content-link'
						);
					}

					$('[id^=' + instance.ns('PORTLET_DATA') + ']').each(
						function() {
							var checkBox = $(this);

							checkBox.on(STR_CLICK, function() {
								if (checkBox.is(':checked')) {
									var id = checkBox.prop('id');

									var controlCheckboxes = $(
										'[data-root-control-id=' + id + ']'
									);

									if (controlCheckboxes.length == 0) {
										return;
									}

									controlCheckboxes.each(function() {
										var controlCheckbox = $(this);

										if (!controlCheckbox.is(':checked')) {
											controlCheckbox.trigger(STR_CLICK);
										}
									});

									var portletId = id.replace(
										instance.ns('PORTLET_DATA') + '_',
										''
									);

									instance._setContentLabels(portletId);

									var contentNode = instance.byId(
										'content_' + portletId
									);

									instance._storeNodeInputStates(contentNode);
								}
							});
						}
					);

					var changeToPublicLayoutsButton = instance.byId(
						'changeToPublicLayoutsButton'
					);

					if (changeToPublicLayoutsButton) {
						changeToPublicLayoutsButton.on(STR_CLICK, function(
							event
						) {
							instance._changeLayouts(false);
						});
					}

					var changeToPrivateLayoutsButton = instance.byId(
						'changeToPrivateLayoutsButton'
					);

					if (changeToPrivateLayoutsButton) {
						changeToPrivateLayoutsButton.on(STR_CLICK, function(
							event
						) {
							instance._changeLayouts(true);
						});
					}

					var contentOptionsLink = instance.byId(
						'contentOptionsLink'
					);

					if (contentOptionsLink) {
						contentOptionsLink.on(STR_CLICK, function(event) {
							var contentOptionsDialog = instance._getContentOptionsDialog();

							contentOptionsDialog.show();
						});
					}

					var deletionsNode = instance.get('deletionsNode');

					if (deletionsNode) {
						deletionsNode.on('change', function() {
							instance._refreshDeletions();
						});
					}

					var globalConfigurationLink = instance.byId(
						'globalConfigurationLink'
					);

					if (globalConfigurationLink) {
						globalConfigurationLink.on(STR_CLICK, function(event) {
							var globalConfigurationDialog = instance._getGlobalConfigurationDialog();

							globalConfigurationDialog.show();
						});
					}

					var rangeLink = instance.byId('rangeLink');

					if (rangeLink) {
						rangeLink.on(STR_CLICK, function(event) {
							instance._preventNameRequiredChecking();

							instance._updateDateRange();
						});
					}

					var scheduledPublishingEventsLink = instance.byId(
						'scheduledPublishingEventsLink'
					);

					if (scheduledPublishingEventsLink) {
						scheduledPublishingEventsLink.on(STR_CLICK, function(
							event
						) {
							var scheduledPublishingEventsDialog = instance._getScheduledPublishingEventsDialog();

							scheduledPublishingEventsDialog.show();
						});
					}
				},

				_changeLayouts: function(privateLayout) {
					var instance = this;

					var privateLayoutNode = instance.byId('privateLayout');

					privateLayoutNode.val(privateLayout);

					instance._preventNameRequiredChecking();

					instance._reloadForm();
				},

				_getContentDialog: function(portletId, portletTitle) {
					var instance = this;

					var contentNode = instance.byId('content_' + portletId);

					var contentDialog = contentNode.getData('contentDialog');

					if (!contentDialog) {
						contentNode.show();

						contentDialog = Liferay.Util.Window.getWindow({
							dialog: {
								bodyContent: contentNode,
								centered: true,
								modal: true,
								render: instance.get('form'),
								toolbars: {
									footer: [
										{
											label: Liferay.Language.get('ok'),
											on: {
												click: function(event) {
													event.domEvent.preventDefault();

													instance._setContentLabels(
														portletId
													);

													instance._storeNodeInputStates(
														contentNode
													);

													contentDialog.hide();
												}
											},
											primary: true
										},
										{
											label: Liferay.Language.get(
												'cancel'
											),
											on: {
												click: function(event) {
													event.domEvent.preventDefault();

													instance._restoreNodeInputStates(
														contentNode
													);

													contentDialog.hide();
												}
											}
										}
									]
								},
								width: 400
							},
							title: portletTitle
						});

						instance._storeNodeInputStates(contentNode);

						contentNode.setData('contentDialog', contentDialog);
					}

					return contentDialog;
				},

				_getContentOptionsDialog: function() {
					var instance = this;

					var contentOptionsDialog = instance._contentOptionsDialog;

					var contentOptionsNode = instance.byId('contentOptions');

					if (!contentOptionsDialog) {
						contentOptionsNode.show();

						contentOptionsDialog = Liferay.Util.Window.getWindow({
							dialog: {
								bodyContent: contentOptionsNode,
								centered: true,
								height: 300,
								modal: true,
								render: instance.get('form'),
								toolbars: {
									footer: [
										{
											label: Liferay.Language.get('ok'),
											on: {
												click: function(event) {
													event.domEvent.preventDefault();

													instance._setContentOptionsLabels();

													instance._storeNodeInputStates(
														contentOptionsNode
													);

													contentOptionsDialog.hide();
												}
											},
											primary: true
										},
										{
											label: Liferay.Language.get(
												'cancel'
											),
											on: {
												click: function(event) {
													event.domEvent.preventDefault();

													instance._restoreNodeInputStates(
														contentOptionsNode
													);

													contentOptionsDialog.hide();
												}
											}
										}
									]
								},
								width: 400
							},
							title: Liferay.Language.get('comments-and-ratings')
						});

						instance._storeNodeInputStates(contentOptionsNode);

						instance._contentOptionsDialog = contentOptionsDialog;
					}

					return contentOptionsDialog;
				},

				_getGlobalConfigurationDialog: function() {
					var instance = this;

					var globalConfigurationDialog =
						instance._globalConfigurationDialog;

					if (!globalConfigurationDialog) {
						var globalConfigurationNode = instance.byId(
							'globalConfiguration'
						);

						globalConfigurationNode.show();

						globalConfigurationDialog = Liferay.Util.Window.getWindow(
							{
								dialog: {
									bodyContent: globalConfigurationNode,
									centered: true,
									height: 300,
									modal: true,
									render: instance.get('form'),
									toolbars: {
										footer: [
											{
												label: Liferay.Language.get(
													'ok'
												),
												on: {
													click: function(event) {
														event.domEvent.preventDefault();

														instance._setGlobalConfigurationLabels();

														globalConfigurationDialog.hide();
													}
												},
												primary: true
											},
											{
												label: Liferay.Language.get(
													'cancel'
												),
												on: {
													click: function(event) {
														event.domEvent.preventDefault();

														globalConfigurationDialog.hide();
													}
												}
											}
										]
									},
									width: 400
								},
								title: Liferay.Language.get(
									'application-configuration'
								)
							}
						);

						instance._globalConfigurationDialog = globalConfigurationDialog;
					}

					return globalConfigurationDialog;
				},

				_getNotificationMessage: function(dateChecker) {
					var instance = this;

					var message;

					if (!instance._rangeEndsLater()) {
						message = Liferay.Language.get(
							'end-date-must-be-greater-than-start-date'
						);
					} else if (
						!instance._rangeEndsInPast(dateChecker.todayUsed) ||
						!instance._rangeStartsInPast(dateChecker.todayUsed)
					) {
						message = Liferay.Language.get(
							'selected-dates-cannot-be-in-the-future'
						);
					}

					return message;
				},

				_getScheduledPublishingEventsDialog: function() {
					var instance = this;

					var scheduledPublishingEventsDialog =
						instance._scheduledPublishingEventsDialog;

					if (!scheduledPublishingEventsDialog) {
						var scheduledPublishingEventsNode = instance.byId(
							'scheduledPublishingEvents'
						);

						scheduledPublishingEventsNode.show();

						scheduledPublishingEventsDialog = Liferay.Util.Window.getWindow(
							{
								dialog: {
									bodyContent: scheduledPublishingEventsNode,
									centered: true,
									height: 300,
									modal: true,
									render: instance.get('form'),
									toolbars: {
										footer: [
											{
												label: Liferay.Language.get(
													'close'
												),
												on: {
													click: function(event) {
														event.domEvent.preventDefault();

														scheduledPublishingEventsDialog.hide();
													}
												}
											}
										]
									},
									width: 400
								},
								title: Liferay.Language.get('scheduled-events')
							}
						);

						instance._scheduledPublishingEventsDialog = scheduledPublishingEventsDialog;
					}

					return scheduledPublishingEventsDialog;
				},

				_getSelectedDates: function() {
					var instance = this;

					var startDatePicker = Liferay.component(
						instance.ns('startDateDatePicker')
					);
					var startTimePicker = Liferay.component(
						instance.ns('startTimeTimePicker')
					);

					var endDatePicker = Liferay.component(
						instance.ns('endDateDatePicker')
					);
					var endTimePicker = Liferay.component(
						instance.ns('endTimeTimePicker')
					);

					var endDate = endDatePicker.getDate();
					var endTime = endTimePicker.getTime();

					endDate.setHours(endTime.getHours());
					endDate.setMinutes(endTime.getMinutes());
					endDate.setSeconds(0);
					endDate.setMilliseconds(0);

					var startDate = startDatePicker.getDate();
					var startTime = startTimePicker.getTime();

					startDate.setHours(startTime.getHours());
					startDate.setMinutes(startTime.getMinutes());
					startDate.setSeconds(0);
					startDate.setMilliseconds(0);

					return {
						endDate: endDate,
						startDate: startDate
					};
				},

				_getValue: function(nodeName) {
					var instance = this;

					var value = STR_EMPTY;

					var node = instance.get(nodeName);

					if (node) {
						value = node.val();
					}

					return value;
				},

				_initLabels: function() {
					var instance = this;

					instance
						.all('.content-link')
						.each(function(item, index, collection) {
							instance._setContentLabels(
								item.attr('data-portletid')
							);
						});

					instance._refreshDeletions();
					instance._setContentOptionsLabels();
					instance._setGlobalConfigurationLabels();
				},

				_isBackgroundTaskInProgress: function() {
					var instance = this;

					var processesNode = instance.get('processesNode');

					return !!processesNode.one(
						'.background-task-status-in-progress'
					);
				},

				_isChecked: function(nodeName) {
					var instance = this;

					var node = instance.get(nodeName);

					return node && node.attr(STR_CHECKED);
				},

				_onViewBackgroundTaskDetails: function(config) {
					var instance = this;

					var node = instance.byId(instance.ns(config.nodeId));

					var bodyNode = node.cloneNode(true);

					bodyNode.show();

					var title = config.title;

					if (title) {
						title = title.trim();
					}

					if (!title) {
						title = Liferay.Language.get('process-details');
					}

					Liferay.Util.openWindow({
						dialog: {
							bodyContent: bodyNode
						},
						title: title
					});
				},

				_preventNameRequiredChecking: function() {
					var instance = this;

					var nameRequiredNode = instance.byId('nameRequired');

					if (nameRequiredNode) {
						nameRequiredNode.val('0');
					}
				},

				_rangeEndsInPast: function(today) {
					var instance = this;

					var selectedDates = instance._getSelectedDates();

					return ADate.isGreaterOrEqual(today, selectedDates.endDate);
				},

				_rangeEndsLater: function() {
					var instance = this;

					var selectedDates = instance._getSelectedDates();

					return ADate.isGreater(
						selectedDates.endDate,
						selectedDates.startDate
					);
				},

				_rangeStartsInPast: function(today) {
					var instance = this;

					var selectedDates = instance._getSelectedDates();

					return ADate.isGreaterOrEqual(
						today,
						selectedDates.startDate
					);
				},

				_refreshDeletions: function() {
					var instance = this;

					if (instance._isChecked('deletionsNode')) {
						instance
							.all('.deletions')
							.each(function(item, index, collection) {
								item.show();
							});
					} else {
						instance
							.all('.deletions')
							.each(function(item, index, collection) {
								item.hide();
							});
					}
				},

				_reloadForm: function() {
					var instance = this;

					var cmdNode = instance.byId('cmd');
					var redirectNode = instance.byId('redirect');

					if (cmdNode.val() === 'add' || cmdNode.val() === 'update') {
						var portletURL = Liferay.PortletURL.createURL(
							redirectNode.val()
						);

						portletURL.setParameter('cmd', cmdNode.val());

						if (instance._exportLAR) {
							portletURL.setParameter(
								'mvcRenderCommandName',
								'editExportConfiguration'
							);
							portletURL.setParameter(
								'tabs2',
								'new-export-process'
							);
							portletURL.setParameter(
								'exportConfigurationButtons',
								'custom'
							);
						} else {
							portletURL.setParameter(
								'mvcRenderCommandName',
								'editPublishConfiguration'
							);
							portletURL.setParameter(
								'tabs2',
								'new-publication-process'
							);
							portletURL.setParameter(
								'publishConfigurationButtons',
								'custom'
							);
						}

						var groupIdNode = instance.byId('groupId');

						if (groupIdNode) {
							portletURL.setParameter(
								'groupId',
								groupIdNode.val()
							);
						}

						var liveGroupIdNode = instance.byId('liveGroupId');

						if (liveGroupIdNode) {
							portletURL.setParameter(
								'liveGroupId',
								liveGroupIdNode.val()
							);
						}

						var privateLayoutNode = instance.byId('privateLayout');

						if (privateLayoutNode) {
							portletURL.setParameter(
								'privateLayout',
								privateLayoutNode.val()
							);
						}

						var rootNodeNameNode = instance.byId('rootNodeName');

						if (rootNodeNameNode) {
							portletURL.setParameter(
								'rootNodeName',
								rootNodeNameNode.val()
							);
						}

						redirectNode.val(portletURL.toString());
					}

					if (cmdNode) {
						var form = instance.get('form');

						var portletURL = Liferay.PortletURL.createURL(
							form.get('action')
						);

						portletURL.setParameter('p_p_lifecycle', '0');

						form.set('action', portletURL.toString());

						var currentURL = instance.byId('currentURL');

						redirectNode.val(currentURL);

						cmdNode.val(STR_EMPTY);

						submitForm(form);
					}
				},

				_renderProcesses: function() {
					var instance = this;

					var checkedCheckboxes = A.all(
						'input[name="' + instance.ns('rowIds') + '"]:checked'
					);

					if (checkedCheckboxes && checkedCheckboxes.size() > 0) {
						instance._scheduleRenderProcess();

						return;
					}

					var processesNode = instance.get('processesNode');

					if (processesNode && instance._processesResourceURL) {
						A.io.request(instance._processesResourceURL, {
							method: 'GET',
							on: {
								failure: function() {
									new Liferay.Notice({
										closeText: false,
										content:
											Liferay.Language.get(
												'your-request-failed-to-complete'
											) +
											'<button type="button" class="close">&times;</button>',
										noticeClass: 'hide',
										timeout: FAILURE_TIMEOUT,
										toggleText: false,
										type: 'warning',
										useAnimation: true
									}).show();
								},
								success: function(event, id, obj) {
									processesNode.empty();

									processesNode.plug(A.Plugin.ParseContent);

									processesNode.setContent(
										this.get('responseData')
									);

									instance._updateincompleteProcessMessage(
										instance._isBackgroundTaskInProgress(),
										processesNode.one(
											'.incomplete-process-message'
										)
									);

									instance._scheduleRenderProcess();
								}
							}
						});
					}
				},

				_restoreNodeCheckedState: function(node, state) {
					var val = state.value;

					if (val !== undefined) {
						node.set('checked', val);
					}
				},

				_restoreNodeHiddenState: function(node, state) {
					var hiddenList = node.ancestorsByClassName(STR_HIDE);

					hiddenList.each(function(hiddenNode) {
						hiddenNode.removeClass(STR_HIDE);
					});

					hiddenList = state.hiddenList;

					if (hiddenList !== null) {
						hiddenList.each(function(node) {
							node.addClass(STR_HIDE);
						});
					}
				},

				_restoreNodeInputStates: function(node) {
					var instance = this;

					var inputNodes = [];

					var inputStates = instance._nodeInputStates;

					if (node && node.getElementsByTagName) {
						inputNodes = node.getElementsByTagName('input');
					}

					inputNodes.each(function(node) {
						var id = node.get('id');

						var state = inputStates[id];

						if (state !== undefined) {
							instance._restoreNodeCheckedState(node, state);
							instance._restoreNodeHiddenState(node, state);
						}
					});
				},

				_scheduleRenderProcess: function() {
					var instance = this;

					var renderInterval = RENDER_INTERVAL_IDLE;

					if (instance._isBackgroundTaskInProgress()) {
						renderInterval = RENDER_INTERVAL_IN_PROGRESS;
					}

					instance._renderTimer = A.later(
						renderInterval,
						instance,
						instance._renderProcesses
					);
				},

				_setContentLabels: function(portletId) {
					var instance = this;

					var contentNode = instance.byId('content_' + portletId);

					var inputs = contentNode.all('.field');

					var selectedContent = [];

					inputs.each(function(item, index, collection) {
						var checked = item.attr(STR_CHECKED);

						if (checked) {
							selectedContent.push(item.attr('data-name'));
						}
					});

					if (
						selectedContent.length === 0 ||
						!instance
							.byId('PORTLET_DATA_' + portletId)
							.attr('checked')
					) {
						instance
							.byId('PORTLET_DATA_' + portletId)
							.attr('checked', false);

						instance.byId('showChangeContent_' + portletId).hide();
					} else {
						instance.byId('showChangeContent_' + portletId).show();
					}

					instance._setLabels(
						'contentLink_' + portletId,
						'selectedContent_' + portletId,
						selectedContent.join(', ')
					);
				},

				_setContentOptionsLabels: function() {
					var instance = this;

					var selectedContentOptions = [];

					if (instance._isChecked('commentsNode')) {
						selectedContentOptions.push(
							Liferay.Language.get('comments')
						);
					}

					if (instance._isChecked('ratingsNode')) {
						selectedContentOptions.push(
							Liferay.Language.get('ratings')
						);
					}

					instance._setLabels(
						'contentOptionsLink',
						'selectedContentOptions',
						selectedContentOptions.join(', ')
					);
				},

				_setGlobalConfigurationLabels: function() {
					var instance = this;

					var selectedGlobalConfiguration = [];

					if (instance._isChecked('setupNode')) {
						selectedGlobalConfiguration.push(
							Liferay.Language.get('setup')
						);
					}

					if (instance._isChecked('archivedSetupsNode')) {
						selectedGlobalConfiguration.push(
							Liferay.Language.get('configuration-templates')
						);
					}

					if (instance._isChecked('userPreferencesNode')) {
						selectedGlobalConfiguration.push(
							Liferay.Language.get('user-preferences')
						);
					}

					instance._setLabels(
						'globalConfigurationLink',
						'selectedGlobalConfiguration',
						selectedGlobalConfiguration.join(', ')
					);
				},

				_setLabels: function(linkId, labelDivId, label) {
					var instance = this;

					var linkNode = instance.byId(linkId);

					if (linkNode) {
						if (label !== STR_EMPTY) {
							linkNode.html(Liferay.Language.get('change'));
						} else {
							linkNode.html(Liferay.Language.get('select'));
						}
					}

					var labelNode = instance.byId(labelDivId);

					if (labelNode) {
						labelNode.html(label);
					}
				},

				_setNode: function(val) {
					var instance = this;

					if (Lang.isString(val)) {
						val = instance.one(val);
					} else {
						val = A.one(val);
					}

					return val;
				},

				_storeNodeInputStates: function(node) {
					var instance = this;

					var inputNodes = [];

					var inputStates = instance._nodeInputStates;

					if (node && node.getElementsByTagName) {
						inputNodes = node.getElementsByTagName('input');
					}

					inputNodes.each(function(node) {
						var hiddenList = node.ancestorsByClassName(STR_HIDE);

						var id = node.get('id');

						var val = node.get('checked');

						if (hiddenList.size() === 0) {
							hiddenList = null;
						}

						inputStates[id] = {
							hiddenList: hiddenList,
							value: val
						};
					});
				},

				_updateDateRange: function(event) {
					var instance = this;

					var dateChecker = instance.getDateRangeChecker();

					if (dateChecker.validRange) {
						instance._reloadForm();

						A.all(
							'.datepicker-popover, .timepicker-popover'
						).hide();
					} else {
						instance.showNotification(dateChecker);
					}
				},

				_updateincompleteProcessMessage: function(inProgress, content) {
					var instance = this;

					var incompleteProcessMessageNode = instance.get(
						'incompleteProcessMessageNode'
					);

					if (incompleteProcessMessageNode) {
						content.show();

						if (
							inProgress ||
							incompleteProcessMessageNode.hasClass('in-progress')
						) {
							incompleteProcessMessageNode.setContent(content);

							if (inProgress) {
								incompleteProcessMessageNode.addClass(
									'in-progress'
								);

								incompleteProcessMessageNode.show();
							}
						}
					}
				}
			}
		});

		Liferay.ExportImport = ExportImport;
	},
	'',
	{
		requires: [
			'aui-datatype',
			'aui-dialog-iframe-deprecated',
			'aui-io-request',
			'aui-modal',
			'aui-parse-content',
			'aui-toggler',
			'aui-tree-view',
			'liferay-notice',
			'liferay-portlet-base',
			'liferay-portlet-url',
			'liferay-store',
			'liferay-util-window'
		]
	}
);
