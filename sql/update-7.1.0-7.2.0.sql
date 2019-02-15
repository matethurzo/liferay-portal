alter table Layout add parentPlid LONG;
alter table Layout add leftPlid LONG;
alter table Layout add rightPlid LONG;
alter table Layout add system BOOLEAN;
alter table Layout add headId LONG;
alter table Layout add head BOOL

COMMIT_TRANSACTION;

update Layout set system = FALSE, head = TRUE, headId = -1 * plid;

create table LayoutVersion (
	layoutVersionId LONG not null primary key,
	version INTEGER,
	uuid_ VARCHAR(75) null,
	plid LONG,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	parentPlid LONG,
	leftPlid LONG,
	rightPlid LONG,
	privateLayout BOOLEAN,
	layoutId LONG,
	parentLayoutId LONG,
	name STRING null,
	title STRING null,
	description STRING null,
	keywords STRING null,
	robots STRING null,
	type_ VARCHAR(75) null,
	typeSettings TEXT null,
	hidden_ BOOLEAN,
	system BOOLEAN,
	friendlyURL VARCHAR(255) null,
	iconImageId LONG,
	themeId VARCHAR(75) null,
	colorSchemeId VARCHAR(75) null,
	css TEXT null,
	priority INTEGER,
	layoutPrototypeUuid VARCHAR(75) null,
	layoutPrototypeLinkEnabled BOOLEAN,
	sourcePrototypeLayoutUuid VARCHAR(75) null,
	lastPublishDate DATE null
);

insert into Counter (name, currentId)
	select
		'com.liferay.portal.kernel.model.Layout' as name,
		max(plid) as currentId
	from Layout;

insert into LayoutVersion (
	select
		plid as layoutVersionId,
		1 as version,
		uuid_,
		plid,
		groupId,
		companyId,
		userId,
		userName,
		createDate,
		modifiedDate,
		parentPlid,
		leftPlid,
		rightPlid,
		privateLayout,
		layoutId,
		parentLayoutId,
		name,
		title,
		description,
		keywords,
		robots,
		type_,
		typeSettings,
		hidden_,
		system,
		friendlyURL,
		iconImageId,
		themeId,
		colorSchemeId,
		css,
		priority,
		layoutPrototypeUuid,
		layoutPrototypeLinkEnabled,
		sourcePrototypeLayoutUuid,
		lastPublishDate
	from
		Layout);

insert into Counter (name, currentId)
	select
		'com.liferay.portal.kernel.model.LayoutVersion' as name,
		max(layoutVersionId) as currentId
	from LayoutVersion;

COMMIT_TRANSACTION;

create index IX_FBF6F939 on LayoutVersion (companyId, layoutPrototypeUuid[$COLUMN_LENGTH:75$], version);
create index IX_DEFEF354 on LayoutVersion (companyId, version);
create index IX_D0513E86 on LayoutVersion (groupId, leftPlid, rightPlid, privateLayout, version);
create unique index IX_6A5941DB on LayoutVersion (groupId, privateLayout, friendlyURL[$COLUMN_LENGTH:255$], version);
create unique index IX_B816A2A8 on LayoutVersion (groupId, privateLayout, layoutId, version);
create index IX_1A490C46 on LayoutVersion (groupId, privateLayout, parentLayoutId, priority, version);
create index IX_23BEB05E on LayoutVersion (groupId, privateLayout, parentLayoutId, version);
create index IX_C32CE133 on LayoutVersion (groupId, privateLayout, sourcePrototypeLayoutUuid[$COLUMN_LENGTH:75$], version);
create index IX_7E7D225A on LayoutVersion (groupId, privateLayout, type_[$COLUMN_LENGTH:75$], version);
create index IX_B9B3D961 on LayoutVersion (groupId, privateLayout, version);
create index IX_B3248089 on LayoutVersion (groupId, type_[$COLUMN_LENGTH:75$], version);
create index IX_F8CF8212 on LayoutVersion (groupId, version);
create index IX_182CF60F on LayoutVersion (iconImageId, version);
create index IX_B8044279 on LayoutVersion (layoutPrototypeUuid[$COLUMN_LENGTH:75$], version);
create index IX_1A7E559F on LayoutVersion (parentPlid, version);
create unique index IX_F852DF29 on LayoutVersion (plid, version);
create index IX_C5652CE4 on LayoutVersion (privateLayout, iconImageId, version);
create index IX_45E580A0 on LayoutVersion (sourcePrototypeLayoutUuid[$COLUMN_LENGTH:75$], version);
create index IX_E66E67A0 on LayoutVersion (uuid_[$COLUMN_LENGTH:75$], companyId, version);
create unique index IX_BD8C095 on LayoutVersion (uuid_[$COLUMN_LENGTH:75$], groupId, privateLayout, version);
create index IX_82FCA548 on LayoutVersion (uuid_[$COLUMN_LENGTH:75$], version);