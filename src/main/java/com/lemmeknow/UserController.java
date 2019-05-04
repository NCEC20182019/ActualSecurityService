package com.lemmeknow;

import com.lemmeknow.model.User;
import com.lemmeknow.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @RequestMapping("user/me")
    public Principal user(Principal user) {
        return user;
    }

    @RequestMapping(value = "user/put", method = RequestMethod.PUT)
    public UserDetails putUser(@RequestBody Map<String, String> body){

        User user = new User();
        user.setEmail(body.get("email"));
        user.setUsername(body.get("username"));
        user.setPassword(body.get("password"));
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
