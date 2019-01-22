create unique index IX_A0CFE092 on CTCollection (companyId, name[$COLUMN_LENGTH:75$]);

create index IX_AFC3725E on CTCollections_CTEntries (companyId);
create index IX_D9FBD9E8 on CTCollections_CTEntries (ctCollectionId);
create index IX_6EA8BE62 on CTCollections_CTEntries (ctEntryId);

create unique index IX_776391C on CTEntry (classNameId, classPK);
create index IX_C57DDD34 on CTEntry (resourcePrimKey);

create index IX_7523B0A4 on CTProcess (companyId);
create index IX_5F9B5D3E on CTProcess (userId);