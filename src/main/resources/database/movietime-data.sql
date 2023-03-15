insert into user_details(email, first_name, last_name, phone, user_password)
values("abc@xyz.com", "Deeksha", "Kulkarni", "1234567890", "password01");

insert into user_details(email, first_name, last_name, phone, user_password)
values("admin1@movietime.com", "Sarika", "Kulkarni", "1234568790", "admin123");

insert into user_roles(email, role)
values("abc@xyz.com", "ROLE_USER");

insert into user_roles(email, role)
values("admin1@movietime.com", "ROLE_USER");

insert into user_roles(email, role)
values("admin1@movietime.com", "ROLE_ADMIN");

insert into movie(title, movie_language, director, genre, release_date, duration )
values("CREED III (2023)", "English", "Michael B. Jordan", "Drama", "2023-03-03", 116);
insert into movie(title, movie_language, director, genre, release_date, duration )
values("DUNGEONS & DRAGONS: HONOR AMONG THIEVES (2023)", "English",
"Jonathan Goldstein", " Action/Adventure,  Sci-Fi/Fantasy", "2023-03-31", 134);
insert into movie(title, movie_language, director, genre, release_date, duration )
values("SCREAM VI (2023)", "English",
"Matt Bettinelli-Olpin", " Horror,  Suspense/Thriller", "2023-03-10", 122);
insert into movie(title, movie_language, director, genre, release_date, duration )
values("THE SUPER MARIO BROS. MOVIE (2023)", "English",
"Aaron Horvath", " Action/Adventure,  Animated", "2023-04-05", 92);
insert into movie(title, movie_language, director, genre, release_date, duration )
values("INSIDE (2023)", "English", "Vasilis Katsopis", " Suspense/Thriller",
 "2023-03-17", 120);
insert into movie(title, movie_language, director, genre, release_date, duration )
values("MOVING ON (2023)", "English", "Paul Weitz", " Comedy",
  "2023-03-17", 85);
insert into movie(title, movie_language, director, genre, release_date, duration )
values("CHAMPIONS (2023)", "English", "Robert Farrelly", " Comedy,  Drama",
  "2023-03-10", 124);
insert into movie(title, movie_language, director, genre, release_date, duration )
values("65 (2023)", "English", "Scott Beck", " Action/Adventure,  Drama",
 "2023-03-10", 85);
 insert into movie(title, movie_language, director, genre, release_date, duration )
 values("ANT-MAN AND THE WASP: QUANTUMANIA (2023)", "English", "Peyton Reed", " Action/Adventure,  Comedy",
  "2023-02-17", 125);
insert into movie(title, movie_language, director, genre, release_date, duration )
values("COCAINE BEAR (2023)", "English", "Elizabeth Banks", " Suspense/Thriller",
 "2023-02-24", 95);
 insert into movie(title, movie_language, director, genre, release_date, duration )
 values("DEMON SLAYER: KIMETSU NO YAIBA -TO THE SWORDSMITH VILLAGE- (2023)", "English", "Haruo Sotozaki", "Action/Adventure,  Animated",
  "2023-03-03", 110);
insert into movie(title, movie_language, director, genre, release_date, duration )
values("JESUS REVOLUTION (2023)", "English", "Jon Ervin", "Drama",
 "2023-02-24", 110);
 insert into movie(title, movie_language, director, genre, release_date, duration )
 values("JOHN WICK: CHAPTER 4 (2023)", "English", "Chad Stahelski", " Action/Adventure,  Suspense/Thriller",
  "2023-03-24", 110);
  insert into movie(title, movie_language, director, genre, release_date, duration )
  values("FAST X (2023)", "English", " Louis Leterrier", " Action/Adventure",
   "2023-03-19", 130);



insert into theater(theater_name, zip)
values("AMC 10", "07950");
insert into theater(theater_name, zip)
values("THE VILLAGE", "07079");
insert into theater(theater_name, zip)
values("AMC HEADQUARTERS 10", "07960");
insert into theater(theater_name, zip)
values("AMC DINE-IN Essex Green 9", "07052");
insert into theater(theater_name, zip)
values("AMC Loews East Hanover 12", "07936");
insert into theater(theater_name, zip)
values("AMC Mountainside 10", "07092");
insert into theater(theater_name, zip)
values("AMC Rockaway 16", "07866");
insert into theater(theater_name, zip)
values("AMC Wayne 14", "07470");
insert into theater(theater_name, zip)
values("Box Office Cinemas at Sparta", "07871");
insert into theater(theater_name, zip)
values("Chatham Hickory Cinema", "7928");
insert into theater(theater_name, zip)
values("Cinemark Willowbrook Mall and XD", "07470");
insert into theater(theater_name, zip)
values("Cinemark Watchung and XD", "07069");
insert into theater(theater_name, zip)
values("The Clairidge", "07042");


INSERT INTO movierelease (movie_id, theater_id, start_date, end_date)
VALUES (5, 4, "2023-03-10", "2023-06-27");
INSERT INTO movierelease (movie_id, theater_id, start_date, end_date)
VALUES (6, 5, "2023-04-05", "2023-07-30");
INSERT INTO movierelease (movie_id, theater_id, start_date, end_date)
VALUES (7, 6, "2023-03-17", "2023-06-28");
INSERT INTO movierelease (movie_id, theater_id, start_date, end_date)
VALUES (8, 7, "2023-03-17", "2023-06-28");
INSERT INTO movierelease (movie_id, theater_id, start_date, end_date)
VALUES (9, 8, "2023-03-10", "2023-06-22");
INSERT INTO movierelease (movie_id, theater_id, start_date, end_date)
VALUES (10, 9, "2023-03-10", "2023-06-22");
INSERT INTO movierelease (movie_id, theater_id, start_date, end_date)
VALUES (11, 10, "2023-02-17", "2023-05-28");
INSERT INTO movierelease (movie_id, theater_id, start_date, end_date)
VALUES (12, 11, "2023-02-24", "2023-05-28");
INSERT INTO movierelease (movie_id, theater_id, start_date, end_date)
VALUES (13, 12, "2023-03-03", "2023-06-26");
INSERT INTO movierelease (movie_id, theater_id, start_date, end_date)
VALUES (14, 13, "2023-02-24", "2023-05-27");
INSERT INTO movierelease (movie_id, theater_id, start_date, end_date)
VALUES (15, 13, "2023-03-24", "2023-06-27");
INSERT INTO movierelease (movie_id, theater_id, start_date, end_date)
VALUES (16, 12, "2023-03-19", "2023-06-27");



insert into auditorium(theater_id, capacity, num_rows, num_seats_per_row)
values(1, 100, 10, 10);

insert into movieshow (movie_id, theater_id, showtime, auditorium_id, adult_ticket_price, child_ticket_price)
values(1, 1, "15:00:00", 1, 10, 5);