insert into auditorium(theater_id, capacity, num_rows, num_seats_per_row)
values(1, 100, 10, 10);

INSERT INTO movierelease (movie_id, theater_id, start_date, end_date)
VALUES (1, 1, '2023-02-20', '2023-05-22');

insert into movieshow (movie_id, theater_id, showtime, auditorium_id, adult_ticket_price, child_ticket_price)
values(1, 1, "15:00:00", 1, 10, 5);