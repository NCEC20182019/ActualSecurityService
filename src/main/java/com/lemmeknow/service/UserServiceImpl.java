package com.lemmeknow.service;

import com.lemmeknow.model.CustomUserDetails;
import com.lemmeknow.model.User;
import com.lemmeknow.repository.UserRepository;
import org.hibernate.service.UnknownServiceException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    public User getById(int userId) {
        return userRepository.findById(userId);
    }

    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        userRepository.findAll().forEach(list::add);
        return list;
    }

    public User createUser(User newUser) {
        return userRepository.save(newUser);
    }

    public User updateUser(int userId, User updatedUser) {
        User userFromDB = userRepository.findById(userId);

        BeanUtils.copyProperties(updatedUser, userFromDB, "id");

        return userRepository.save(userFromDB);
    }

    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByEmail(email);

        user
            .orElseThrow(() -> new UsernameNotFoundException("Email not found"));
        return user
                .map(CustomUserDetails::new)
                .get();
    }
}
