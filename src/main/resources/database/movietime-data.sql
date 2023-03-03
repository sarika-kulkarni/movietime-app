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

insert into theater(theater_name, zip)
values("AMC 10", "07950")

INSERT INTO movierelease (movie_id, theater_id, start_date, end_date)
VALUES (1, 1, '2023-02-20', '2023-05-22');

insert into auditorium(theater_id, capacity, num_rows, num_seats_per_row)
values(1, 100, 10, 10);

insert into movieshow (movie_id, theater_id, showtime, auditorium_id, adult_ticket_price, child_ticket_price)
values(1, 1, "15:00:00", 1, 10, 5);