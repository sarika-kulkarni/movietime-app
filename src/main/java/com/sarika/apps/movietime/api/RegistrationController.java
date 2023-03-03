package com.sarika.apps.movietime.api;

import com.sarika.apps.movietime.domain.services.UserService;
import com.sarika.apps.movietime.domain.vo.UserRegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public void registerUser(@RequestBody UserRegistrationRequest userRegistrationRequest){
        userService.registerUser(userRegistrationRequest);
    }
}
