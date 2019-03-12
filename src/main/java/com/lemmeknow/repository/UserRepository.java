package com.lemmeknow.repository;

import com.lemmeknow.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Integer> {
    User findById(int userId);

    Optional<User> findByEmail(String email);
}
