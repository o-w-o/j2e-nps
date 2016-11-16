use nps;
create table msg (
	MID int UNSIGNED not null AUTO_INCREMENT,
    UID int UNSIGNED not null,
    FIDS varchar(1000) ,
	MSG varchar(1000) not null ,
	SENTIME varchar(20) not null ,
	CATEGORY varchar(20) not null ,
    foreign key(UID) references user(UID) on delete cascade on update cascade,
	primary key (MID));
