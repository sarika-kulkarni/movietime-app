insert into auditorium(theater_id, capacity, num_rows, num_seats_per_row)
values(1, 100, 10, 10);

INSERT INTO movierelease (movie_id, theater_id, start_date, end_date)
VALUES (1, 1, '2023-02-20', '2023-05-22');

INSERT INTO movierelease ( movie_id, theater_id, start_date, end_date)
VALUES (2, 1, '2023-03-06', '2023-06-05');

insert into movieshow (movie_id, theater_id, showtime, auditorium_id)
values(1, 1, "15:00:00", 1);

INSERT INTO auditorium (auditorium_id, theater_id, capacity, NUM_Rows, Num_Seats_Per_Row)
VALUES (1, 2, 100, 10, 10);

INSERT INTO auditorium (auditorium_id, theater_id, capacity, NUM_Rows, Num_Seats_Per_Row)
VALUES (2, 2, 100, 10, 10);

INSERT INTO movieshowtime (movieshow_id, showtime, auditorium_id)
VALUES (1, '15:00:00', 1);
INSERT INTO movieshowtime (movieshow_id, showtime, auditorium_id)
VALUES (2, '19:00:00', 1);