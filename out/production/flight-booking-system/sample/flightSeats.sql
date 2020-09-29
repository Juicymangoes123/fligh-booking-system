create database flightSeats;
use flightSeats;

create table userAndPassword (
    idx int not null auto_increment,
    username varchar(255) unique,
    password varchar(255),
    primary key (Idx)
);

create table bookedSeats(
    idx int not null auto_increment,
    username varchar(255),
    seat varchar(255),
    primary key (Idx)
);

delete from bookedSeats;
delete from userAndPassword;
