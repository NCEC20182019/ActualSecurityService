package com.lemmeknow;

import com.lemmeknow.model.User;
import com.lemmeknow.service.UserDetailsServiceImpl;
import netscape.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @RequestMapping("user/me")
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public UserDetails getUser(@PathVariable Integer id) {
        return userDetailsService.getUserById(id);
    }

    @RequestMapping(value = "user/put", method = RequestMethod.POST)
    public UserDetails putUser(@RequestBody User user){
        return userDetailsService.saveUser(user);
    }

    @RequestMapping(value = "user/get", method = RequestMethod.GET)
    public String putUser(){
        return "page";
    }
}
