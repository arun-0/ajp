create table credit
(
    id       int          null,
    username varchar(50)  not null,
    password varchar(50)  not null,
    data     varchar(100) null
);

create table registration
(
    name varchar(50) not null,
    pwd  varchar(50) not null
);

create table students
(
    studentId int auto_increment
        primary key,
    name      varchar(50) null,
    age       int         null,
    grade     varchar(10) null
);

create table user
(
    username  varchar(50) not null,
    birthDate varchar(10) not null,
    emailId   varchar(50) not null,
    contactNo varchar(20) null
);

