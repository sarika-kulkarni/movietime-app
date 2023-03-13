package com.sarika.apps.movietime.api;

import com.sarika.apps.movietime.domain.services.UserService;
import com.sarika.apps.movietime.domain.vo.UserRegistrationRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController // This class is a REST controller, meaning it will handle HTTP requests and return responses in JSON format.
@RequestMapping("/registration") // The root URL path for this controller is /registration.
@Slf4j // This is a Lombok annotation that generates a logger object for logging.
public class RegistrationController {

    private UserService userService;

    @Autowired // Autowire the UserService dependency to the constructor.
    public RegistrationController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json") // Handle POST requests with Content-Type of application/json.
    public void registerUser(@RequestBody @Valid UserRegistrationRequest userRegistrationRequest){
        try {
            userService.registerUser(userRegistrationRequest);// Call the registerUser method of the UserService with the userRegistrationRequest object.
            log.info("User has been registered successfully");// Log a successful registration message.
        }catch (Exception exception){
            log.error("Error occurred while registering user", exception);// Log an error message if an exception is caught while registering the user.
        }
        }
    }

