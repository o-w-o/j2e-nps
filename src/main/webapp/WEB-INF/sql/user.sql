use nps;
create table user (
	UID INT UNSIGNED not null AUTO_INCREMENT,
	UNAME varchar(20) not null,
	PASSWORD varchar(20) not null ,
	EMAIL varchar(100) not null ,
	BIRTHDAY varchar(20) not null ,
	GENDER varchar(20) not null ,
	UWORDS varchar(150) not null ,
	UTYPE varchar(20) not null ,
	primary key (UID));
