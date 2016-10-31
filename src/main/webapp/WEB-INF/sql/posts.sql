use nps;
create table posts (

    id int(8) not null,
    title varchar(30) not null ,
    keywords varchar(30) not null ,
    summary varchar(150) not null ,
    content varchar(2000) not null ,
    categories varchar(20) not null ,
    postime varchar(20) not null ,
    words varchar(150) not null ,
    primary key (id));
    
