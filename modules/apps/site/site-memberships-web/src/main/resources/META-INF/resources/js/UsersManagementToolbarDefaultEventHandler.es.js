import dom from 'metal-dom';
import {DefaultEventHandler} from 'frontend-js-web';

class UsersManagementToolbarDefaultEventHandler extends DefaultEventHandler {
	deleteSelectedUsers() {
		if (
			confirm(
				Liferay.Language.get('are-you-sure-you-want-to-delete-this')
			)
		) {
			submitForm(this.one('#fm'));
		}
	}

	removeUserSiteRole(itemData) {
		if (confirm(itemData.message)) {
			submitForm(this.one('#fm'), itemData.removeUserSiteRoleURL);
		}
	}

	selectRoles(itemData) {
		Liferay.Util.selectEntity(
			{
				dialog: {
					constrain: true,
					destroyOnHide: true,
					modal: true
				},
				eventName: this.ns('selectSiteRole'),
				title: Liferay.Language.get('select-site-role'),
				uri: itemData.selectRolesURL
			},
			function(event) {
				location.href = Liferay.Util.addParams(
					`${this.ns('roleId')}=${event.id}`,
					itemData.viewRoleURL
				);
			}.bind(this)
		);
	}

	selectSiteRole(itemData) {
		AUI().use('liferay-item-selector-dialog', A => {
			const itemSelectorDialog = new A.LiferayItemSelectorDialog({
				eventName: this.ns('selectSiteRole'),
				on: {
					selectedItemChange: function(event) {
						const selectedItem = event.newVal;

						if (selectedItem) {
							const fm = this.one('#fm');

							selectedItem.forEach(item => {
								dom.append(fm, item);
							});

							submitForm(fm, itemData.editUsersSiteRolesURL);
						}
					}.bind(this)
				},
				'strings.add': Liferay.Language.get('done'),
				title: Liferay.Language.get('assign-site-roles'),
				url: itemData.selectSiteRoleURL
			});

			itemSelectorDialog.open();
		});
	}

	selectUsers(itemData) {
		AUI().use('liferay-item-selector-dialog', A => {
			const itemSelectorDialog = new A.LiferayItemSelectorDialog({
				eventName: this.ns('selectUsers'),
				on: {
					selectedItemChange: function(event) {
						const selectedItem = event.newVal;

						if (selectedItem) {
							const addGroupUsersFm = this.one(
								'#addGroupUsersFm'
							);

							selectedItem.forEach(item => {
								dom.append(addGroupUsersFm, item);
							});

							submitForm(addGroupUsersFm);
						}
					}.bind(this)
				},
				'strings.add': Liferay.Language.get('done'),
				title: Liferay.Language.get('assign-users-to-this-site'),
				url: itemData.selectUsersURL
			});

			itemSelectorDialog.open();
		});
	}
}

export default UsersManagementToolbarDefaultEventHandler;
