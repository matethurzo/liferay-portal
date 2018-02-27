create table EntityPublication (
	mvccVersion LONG default 0 not null,
	id_ LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	classNameId LONG,
	classPK LONG,
	publicationDate DATE null
);