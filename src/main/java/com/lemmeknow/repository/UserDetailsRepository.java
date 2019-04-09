package com.lemmeknow.repository;

import com.lemmeknow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailsRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    <S extends User> S save(S entity);
}
