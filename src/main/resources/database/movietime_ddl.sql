-- create database MovieTime;
drop table if exists booked_seats;
drop table if exists Booking;
drop table if exists user_details;
drop table if exists Movierelease;
drop table if exists Movieshow;
drop table if exists Auditorium;
drop table if exists Movie;
drop table if exists theater;

CREATE TABLE movie (
  movie_id INT AUTO_INCREMENT NOT NULL,
  Title VARCHAR(255) NOT NULL,
  Movie_Language VARCHAR(50),
  Director VARCHAR(100),
  Genre VARCHAR(50),
  Release_Date DATE,
  Duration INT,
  PRIMARY KEY (movie_id)
);
-------
CREATE TABLE theater (
  theater_id INT auto_increment NOT NULL,
  theater_name varchar(255),
  zip VARCHAR(10) NOT NULL,
  PRIMARY KEY (theater_id)
 ) ;
------
CREATE TABLE Auditorium (
  auditorium_id INT auto_increment NOT NULL,
  theater_id int not null,
  Capacity INT,
  Num_Rows INT,
  Num_Seats_Per_Row INT,
  PRIMARY KEY (auditorium_id),
  foreign key(theater_id) references theater(theater_id)
);
------
CREATE TABLE movierelease (
  -- movieshow_id INT auto_increment NOT NULL,
  movie_id int,
  theater_id int,
  start_date date,
  end_date date,
  -- PRIMARY KEY (movieshow_id),
  PRIMARY KEY (movie_id, theater_id ),
  FOREIGN KEY (movie_id) REFERENCES movie(movie_id),
FOREIGN KEY (theater_id) REFERENCES theater(theater_id)
);
------
CREATE TABLE user_details (
 email VARCHAR(255) NOT NULL,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  phone VARCHAR(20) NOT NULL,
user_password varchar(50),
isadmin boolean,
  PRIMARY KEY (email)
);
-------
CREATE TABLE Movieshow (
movieshow_id int auto_increment not null,
movie_id int not null,
theater_id int not null,
showtime time not null,
auditorium_id int not null,
adult_ticket_price decimal not null,
child_ticket_price decimal not null,
primary key (movieshow_id),
foreign key(auditorium_id) references auditorium(auditorium_id),
foreign key(movie_id) references movie(movie_id),
foreign key(theater_id) references theater(theater_id)
);
------
CREATE TABLE Booking (
  booking_id INT auto_increment NOT NULL,
  email VARCHAR(255) NOT NULL,
  movieshow_id int not null,
  booking_date DATE NOT NULL,
  adult_tickets INT,
  child_tickets INT,
  PRIMARY KEY (booking_id),
  FOREIGN KEY (email) REFERENCES user_details(email),
  FOREIGN KEY (movieshow_id) REFERENCES Movieshow(movieshow_id)
);
------
CREATE TABLE Booked_seats (
booking_id INT NOT NULL,
seat_row VARCHAR(1) NOT NULL,
seat_number INT NOT NULL,
primary key(booking_id, seat_row, seat_number),
foreign key (booking_id) REFERENCES Booking(booking_id)
);