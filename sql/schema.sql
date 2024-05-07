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

create table user
(
    username  varchar(50) not null,
    birthDate varchar(10) not null,
    emailId   varchar(50) not null,
    contactNo varchar(20) null
);
