package com.sarika.apps.movietime.api;

import com.sarika.apps.movietime.domain.entities.Theater;
import com.sarika.apps.movietime.domain.repositories.TheaterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/theaters")
@Slf4j
public class TheaterController {

    private TheaterRepository theaterRepository;

    @Autowired
    public TheaterController(TheaterRepository theaterRepository){
        this.theaterRepository = theaterRepository;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public void addTheater(@RequestBody Theater theater){
        theaterRepository.save(theater);
        log.info("Theater saved successfully");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<Theater> getTheater(@PathVariable Integer id){
        Optional<Theater> theater =  theaterRepository.findById(id);

        if(theater.isPresent()){
            return ResponseEntity.ok(theater.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Theater>> getTheatersByZip(@RequestParam("zip") String zip){
        System.out.println(zip);
        List<Theater> theaters = theaterRepository.findByZip(zip);
        return ResponseEntity.ok(theaters);
    }
}
