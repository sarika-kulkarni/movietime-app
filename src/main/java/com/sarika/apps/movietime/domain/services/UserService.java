package com.sarika.apps.movietime.domain.services;

import com.sarika.apps.movietime.domain.vo.UserRegistrationRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    void registerUser(UserRegistrationRequest userRegistrationRequest);
}
