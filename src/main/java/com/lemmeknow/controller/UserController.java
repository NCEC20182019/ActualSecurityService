package com.lemmeknow.controller;

import com.lemmeknow.model.User;
import com.lemmeknow.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.security.Principal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping("user/me")
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping(value = "user/put", method = RequestMethod.PUT)
    @CrossOrigin(origins = "*")
    @ResponseBody
    public UserDetails putUser(@RequestBody Map<String, String> body){

        User user = new User();
        user.setEmail(body.get("username"));
//        if(body.get("username") != null) {
//            user.setUsername(body.get("username"));
//        }else{
        user.setUsername(body.get("username").split("@")[0]);
//        }
        String password = passwordEncoder.encode(body.get("password"));
        user.setPassword(password);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);

        UserDetails savedUser = userDetailsService.saveUser(user);

        return savedUser;
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public UserDetails getUser(@PathVariable Integer id) {
        return userDetailsService.getUserById(id);
    }
}
