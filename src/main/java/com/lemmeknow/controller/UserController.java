package com.lemmeknow.controller;

import com.lemmeknow.model.Role;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.GET)
    @RequestMapping(value = "user/me", method = RequestMethod.GET)
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
        List<Role> roles = new ArrayList<>();
        Role user_role = new Role();
        user_role.setName("ROLE_user");
        user_role.setId(2);
        roles.add(user_role);
        user.setRoles(roles);

        UserDetails savedUser = userDetailsService.saveUser(user);

        return savedUser;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public UserDetails getUser(@PathVariable Integer id) {
        return userDetailsService.getUserById(id);
    }
}
