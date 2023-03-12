package com.sarika.apps.movietime.domain.services;

import com.sarika.apps.movietime.domain.entities.Auditorium;
import com.sarika.apps.movietime.domain.entities.BookedSeat;
import com.sarika.apps.movietime.domain.entities.Booking;
import com.sarika.apps.movietime.domain.entities.MovieShow;
import com.sarika.apps.movietime.domain.repositories.BookingRepository;
import com.sarika.apps.movietime.domain.repositories.MovieShowRepository;
import com.sarika.apps.movietime.domain.services.impl.BookingServiceImpl;
import com.sarika.apps.movietime.domain.vo.BookingRequest;
import com.sarika.apps.movietime.domain.vo.MovieShowAvailability;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BookingServiceTest {
    private BookingService bookingService;

    @Mock
    private MovieShowRepository movieShowRepository;

    @Mock
    private BookingRepository bookingRepository;

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private static final Integer ARBITRARY_MOVIE_SHOW_ID = 2;
    private static final String ARBITRARY_MOVIE_SHOW_DATE = "2023-03-12";
    private static final String ARBITRARY_USER_ID = "abc@xyz.com";

    /**
     * This method is invoked before every test case execution
     */
    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
        bookingService = new BookingServiceImpl(movieShowRepository, bookingRepository );
    }

    @Test
    public void testGetMovieShowAvailability() throws ParseException {
        //setup mock behavior
        Mockito.when(movieShowRepository.findById(ARBITRARY_MOVIE_SHOW_ID)).thenReturn(mockMovieShow());
        Mockito.when(bookingRepository.findByMovieShow(ARBITRARY_MOVIE_SHOW_ID, dateFormat.parse(ARBITRARY_MOVIE_SHOW_DATE))).thenReturn(mockBookedSeats());

        //call test object
        MovieShowAvailability movieShowAvailability = bookingService.getMovieShowAvailability(ARBITRARY_MOVIE_SHOW_ID, dateFormat.parse(ARBITRARY_MOVIE_SHOW_DATE));

        //verify output
        Assertions.assertNotNull(movieShowAvailability);
        Assertions.assertEquals(2, movieShowAvailability.getBookedSeats().size());
    }

    @Test
    public void testBookShow() throws ParseException {
        //setup mock behavior
        Mockito.when(movieShowRepository.findById(ARBITRARY_MOVIE_SHOW_ID)).thenReturn(mockMovieShow());

        //prepare input data
        BookingRequest bookingRequest = new BookingRequest();
        BookedSeat bookedSeat = new BookedSeat();
        bookedSeat.setSeatNumber(5);
        bookedSeat.setSeatRow("A");
        bookingRequest.setRequestedSeats(Arrays.asList(bookedSeat));
        bookingRequest.setNumberOfAdultTickets(1);
        bookingRequest.setMovieShowDate(dateFormat.parse(ARBITRARY_MOVIE_SHOW_DATE));

        //call test object
        Booking booking = bookingService.bookShow(ARBITRARY_USER_ID, ARBITRARY_MOVIE_SHOW_ID, bookingRequest);

        //verify output
        Assertions.assertNotNull(booking);
        Mockito.verify(bookingRepository, Mockito.atLeastOnce()).saveAndFlush(Mockito.any(Booking.class));
    }

    /**
     * Setup mock booking object with booked seats
     * @return booking object
     * @throws ParseException
     */
    private List<Booking> mockBookedSeats() throws ParseException {
        Booking bookingOne = new Booking();
        bookingOne.setBookingDate(dateFormat.parse(ARBITRARY_MOVIE_SHOW_DATE));
        bookingOne.setSeats(Arrays.asList(new BookedSeat()));

        Booking bookingTwo = new Booking();
        bookingTwo.setBookingDate(dateFormat.parse(ARBITRARY_MOVIE_SHOW_DATE));
        bookingTwo.setSeats(Arrays.asList(new BookedSeat()));

        return Arrays.asList(bookingOne, bookingTwo);
    }

    /**
     * Setup mock movie show object
     * @return movieshow object
     */
    private Optional<MovieShow> mockMovieShow() {
        MovieShow movieShow = new MovieShow();
        movieShow.setMovieShowId(ARBITRARY_MOVIE_SHOW_ID);
        movieShow.setShowTime("15:00:00");

        Auditorium auditorium = new Auditorium();
        auditorium.setCapacity(100);
        auditorium.setNumberOfRows(10);
        auditorium.setNumberOfSeatsPerRow(10);

        movieShow.setAuditorium(auditorium);

        return Optional.of(movieShow);
    }
}
