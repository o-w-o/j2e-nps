use nps;
create table friend (
    FID int UNSIGNED not null,
    UID int UNSIGNED not null,
    GNAME varchar(100) not null,
    foreign key(UID) references user(UID) on delete cascade on update cascade,
    primary key(UID,FID));