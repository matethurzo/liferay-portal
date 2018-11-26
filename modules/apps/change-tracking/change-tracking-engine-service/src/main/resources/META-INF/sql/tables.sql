create table CTEChangeCollection (
	cteChangeCollectionId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	description VARCHAR(75) null
);

create table CTEChangeEntry (
	cteChangeEntryId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	classNameId LONG,
	classPK LONG,
	resourcePrimKey LONG
);

create table Collections_Entries (
	companyId LONG not null,
	cteChangeCollectionId LONG not null,
	cteChangeEntryId LONG not null,
	primary key (cteChangeCollectionId, cteChangeEntryId)
);