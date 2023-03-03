package com.sarika.apps.movietime.domain.repositories;


import com.sarika.apps.movietime.domain.entities.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDetails, String> {
    @Override
    <S extends UserDetails> S saveAndFlush(S entity);

    @Override
    Optional<UserDetails> findById(String s);
}
