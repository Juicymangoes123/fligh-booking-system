create database flightSeats;
use flightSeats;

create table userAndSeatsBooked (
    Idx int not null auto_increment,
    Username varchar(255),
    Password varchar(255),
    SeatsBooked array
);
