use nps;
create table tables (

    TID int UNSIGNED not null AUTO_INCREMENT,
    UID int UNSIGNED not null,
    FIDS varchar(500),
    TNAME varchar(150) not null,
    POSTIME time not null,
    ENDTIME time not null,
    LIMITED boolean not null ,
    foreign key (UID) references user(UID) on delete cascade on update cascade,
    primary key (TID));
    
