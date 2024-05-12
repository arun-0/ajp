-- Create a database with the name 'ajp', user with name 'ajp' and create the following tables in it

-- Create a database with the name 'ajp'
CREATE DATABASE ajp;
-- Create a user with the name 'ajp' and password 'ajp', and grant it with all privileges on the database 'ajp'
CREATE USER 'ajp'@'localhost' IDENTIFIED BY 'ajp';
GRANT ALL PRIVILEGES ON ajp.* TO 'ajp'@'localhost';
FLUSH PRIVILEGES;
-- Below is the code for Java connection to the database 'ajp' with the user 'ajp' and password 'ajp'
-- DriverManager.registerDriver(new com.mysql.jdbc.Driver());
-- Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajp","ajp","ajp");

drop table if exists accounts;
drop table if exists credit;
drop table if exists phonebook;
drop table if exists registration;
drop table if exists students;
drop table if exists user;

-- Table creation scripts
create table accounts
(
    id      int         not null,
    name    varchar(50) not null,
    balance int         null
);

create table credit
(
    id       int          null,
    username varchar(50)  not null,
    password varchar(50)  not null,
    data     varchar(100) null
);

create table phonebook
(
    id     int auto_increment
        primary key,
    name   varchar(50) not null,
    number bigint      not null
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

-- lab16/17
CREATE TABLE ajp.user
(
    id        INT AUTO_INCREMENT,
    name      VARCHAR(50)  NOT NULL,
    username  VARCHAR(50)  NOT NULL,
    password  VARCHAR(40)  NOT NULL,
    contact   VARCHAR(20),
    address   VARCHAR(400),
    birthDate VARCHAR(10),
    emailId   VARCHAR(50),
    PRIMARY KEY (id),
    CONSTRAINT user_pk UNIQUE (username)
);
