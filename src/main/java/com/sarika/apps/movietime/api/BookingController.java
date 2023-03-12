package com.sarika.apps.movietime.api;

import com.sarika.apps.movietime.domain.entities.Booking;
import com.sarika.apps.movietime.domain.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private BookingRepository bookingRepository;

    @Autowired
    public BookingController(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getMyBookings(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && authentication.isAuthenticated()){

            List<Booking> myBookings = bookingRepository.findByUser(
                    ((UserDetails) authentication.getPrincipal()).getUsername()
            );

            return ResponseEntity.ok(myBookings);
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @DeleteMapping(path = "/{bookingId}")
    public void cancelBooking(@PathVariable Integer bookingId){
        bookingRepository.deleteById(bookingId);
    }
}
