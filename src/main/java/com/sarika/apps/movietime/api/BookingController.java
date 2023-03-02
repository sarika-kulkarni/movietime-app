package com.sarika.apps.movietime.api;

import com.sarika.apps.movietime.domain.repositories.BookingRepository;
import com.sarika.apps.movietime.domain.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private BookingRepository bookingRepository;

    private BookingService bookingService;

    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;

    }

    @Autowired
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")



    public void bookShow(){

    }
}
