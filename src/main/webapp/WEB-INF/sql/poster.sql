use nps;
create table poster (
    id varchar(8) not null,
    name varchar(20) not null,
    password varchar(20) not null ,
    email varchar(100) not null ,
    usertype varchar(20) not null ,
    brith varchar(20) not null ,
    gender varchar(20) not null ,
    userwords varchar(150) not null ,
    primary key (id));