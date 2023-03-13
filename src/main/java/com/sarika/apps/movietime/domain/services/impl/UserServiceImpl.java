package com.sarika.apps.movietime.domain.services.impl;

import com.sarika.apps.movietime.domain.entities.User;
import com.sarika.apps.movietime.domain.entities.UserRole;
import com.sarika.apps.movietime.domain.repositories.UserRepository;
import com.sarika.apps.movietime.domain.services.UserService;
import com.sarika.apps.movietime.domain.vo.UserRegistrationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private static final String ROLE_USER = "ROLE_USER";

    private UserRepository userRepository;

    @Autowired // Autowire the PasswordEncoder dependency.
    private PasswordEncoder passwordEncoder;

    @Autowired // Autowire the UserRepository dependency to the constructor.
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override // Override the registerUser method of the UserService interface.
    public void registerUser(UserRegistrationRequest userRegistrationRequest) {
        User user = new User(); // Create a new User object.
        user.setEmail(userRegistrationRequest.getEmail());// Set the email field of the User object.
        user.setFirstName(userRegistrationRequest.getFirstName()); // Set the first name field of the User object.
        user.setLastName(userRegistrationRequest.getLastName()); // Set the last name field of the User object.
        user.setPhone(userRegistrationRequest.getPhone()); // Set the phone field of the User object.
        user.setPassword(passwordEncoder.encode(userRegistrationRequest.getPassword())); // Set the password field of the User object after encoding it.

        UserRole userRole = new UserRole();
        userRole.setUser(user); // Set the user field of the UserRole object to the User object.
        userRole.setRole(ROLE_USER); // Set the role field of the UserRole object to the user role constant.
        user.setRoles(Arrays.asList(userRole)); // Set the roles field of the User object to a list containing the UserRole object.

        userRepository.saveAndFlush(user); // Save the User object to the UserRepository.
    }

    @Override // Override the loadUserByUsername method of the UserDetailsService interface.
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findById(username); // Find the User object with the specified email.

        if(user.isEmpty()){ // If the User object is not found, throw a UsernameNotFoundException.
            throw new UsernameNotFoundException("Invalid username or password");
        }

        return new org.springframework.security.core.userdetails.User(user.get().getEmail(),// Return a new User object with the email, password, and roles of the found User object.
                user.get().getPassword(),
                mapRolesToAuthorities(user.get().getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(List<UserRole> roles){ // A helper method to map the user roles to authorities.
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole()))
                .collect(Collectors.toList());
    }
}
