package com.sarika.apps.movietime.domain.services.impl;

import com.sarika.apps.movietime.domain.entities.User;
import com.sarika.apps.movietime.domain.entities.UserRole;
import com.sarika.apps.movietime.domain.repositories.UserRepository;
import com.sarika.apps.movietime.domain.services.UserService;
import com.sarika.apps.movietime.domain.vo.UserRegistrationRequest;
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
public class UserServiceImpl implements UserService {

    private static final String ROLE_USER = "ROLE_USER";

    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(UserRegistrationRequest userRegistrationRequest) {
        User user = new User();
        user.setEmail(userRegistrationRequest.getEmail());
        user.setFirstName(userRegistrationRequest.getFirstName());
        user.setLastName(userRegistrationRequest.getLastName());
        user.setPhone(userRegistrationRequest.getPhone());
        user.setPassword(passwordEncoder.encode(userRegistrationRequest.getPassword()));

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(ROLE_USER);

        user.setRoles(Arrays.asList(userRole));

        userRepository.saveAndFlush(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findById(username);

        if(user.isEmpty()){
            throw new UsernameNotFoundException("Invalid username or password");
        }

        return new org.springframework.security.core.userdetails.User(user.get().getEmail(),
                user.get().getPassword(),
                mapRolesToAuthorities(user.get().getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(List<UserRole> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole()))
                .collect(Collectors.toList());
    }
}
