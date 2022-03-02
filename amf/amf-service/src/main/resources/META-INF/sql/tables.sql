create table Amf_Member (
	memberId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	emailAddress VARCHAR(75) null,
	male BOOLEAN,
	birthday DATE null,
	password_ VARCHAR(75) null,
	homePhone VARCHAR(75) null,
	mobilePhone VARCHAR(75) null,
	address1 VARCHAR(75) null,
	address2 VARCHAR(75) null,
	city VARCHAR(75) null,
	state_ VARCHAR(75) null,
	zipCode VARCHAR(75) null,
	securityQuestion VARCHAR(75) null,
	answer VARCHAR(75) null,
	termOfUse BOOLEAN
);