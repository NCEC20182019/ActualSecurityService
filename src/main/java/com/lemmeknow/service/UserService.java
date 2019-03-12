package com.lemmeknow.service;

import com.lemmeknow.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User getById(int eventId);
    List<User> getAll();
    User createUser(User newEvent);
    User updateUser(int userId,User updatedUser);
    void deleteUser(int userId);
}
