package com.lemmeknow;

import com.lemmeknow.model.User;
import com.lemmeknow.service.UserDetailsServiceImpl;
import netscape.security.Principal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
@EnableAuthorizationServer
public class Application {


    private UserDetailsServiceImpl userDetailsService = new UserDetailsServiceImpl();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}