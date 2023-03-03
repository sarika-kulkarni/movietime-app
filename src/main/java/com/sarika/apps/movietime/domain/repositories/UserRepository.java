package com.sarika.apps.movietime.domain.repositories;


import com.sarika.apps.movietime.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    @Override
    <S extends User> S saveAndFlush(S entity);

    @Override
    Optional<User> findById(String s);
}
