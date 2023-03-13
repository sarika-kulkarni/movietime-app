package com.sarika.apps.movietime.api;

import com.sarika.apps.movietime.domain.entities.User;
import com.sarika.apps.movietime.domain.repositories.UserRepository;
import com.sarika.apps.movietime.domain.vo.UserProfile;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {
    private UserRepository userRepository;

    @Autowired
    public ProfileController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping
    public ResponseEntity<UserProfile> getUserProfile(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && authentication.isAuthenticated()){

            Optional<User> user = userRepository.findById(
                    ((UserDetails) authentication.getPrincipal()).getUsername()
            );

            if(user.isPresent()){

                UserProfile userProfile = new UserProfile();
                userProfile.setFirstName(user.get().getFirstName());
                userProfile.setLastName(user.get().getLastName());
                userProfile.setPhone(user.get().getPhone());

                return ResponseEntity.ok(userProfile);
            }else{
                return ResponseEntity.notFound().build();
            }

        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PutMapping
    public ResponseEntity updateUserProfile(@RequestBody @Valid UserProfile userProfile){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && authentication.isAuthenticated()){

            Optional<User> user = userRepository.findById(
                    ((UserDetails) authentication.getPrincipal()).getUsername()
            );

            if(user.isPresent()){
                User updatedUser = user.get();
                updatedUser.setFirstName(userProfile.getFirstName());
                updatedUser.setLastName(userProfile.getLastName());
                updatedUser.setPhone(userProfile.getPhone());

                userRepository.saveAndFlush(updatedUser);

                return ResponseEntity.ok().build();
            }else{
                return ResponseEntity.notFound().build();
            }

        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
