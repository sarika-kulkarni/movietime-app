package com.sarika.apps.movietime.api;

import com.sarika.apps.movietime.domain.entities.UserDetails;
import com.sarika.apps.movietime.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class RegistrationController {

    private UserRepository userRepository;

    @Autowired
    public RegistrationController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public void registerUser(@RequestBody UserDetails userDetails){
        userRepository.saveAndFlush(userDetails);
    }
}
