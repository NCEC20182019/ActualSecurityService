package com.lemmeknow.service;

import com.lemmeknow.model.User;
import com.lemmeknow.model.UserDetails;
import com.lemmeknow.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.el.PropertyNotFoundException;
import java.util.Optional;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<User> optionalUser = userDetailsRepository.findByEmail(email);

        optionalUser.orElseThrow(() -> new UsernameNotFoundException("Bad credentials"));

        UserDetails userDetails = new com.lemmeknow.model.UserDetails(optionalUser.get());
        new AccountStatusUserDetailsChecker().check(userDetails);
        return userDetails;
    }

    public UserDetails getUserById(Integer id) throws PropertyNotFoundException{

        Optional<User> optionalUser = userDetailsRepository.findById(id);

        optionalUser.orElseThrow(() -> new PropertyNotFoundException("Bad credentials"));

        UserDetails userDetails = new com.lemmeknow.model.UserDetails(optionalUser.get());
        new AccountStatusUserDetailsChecker().check(userDetails);
        return userDetails;
    }

    public UserDetails saveUser(User user){
        return new com.lemmeknow.model.UserDetails(userDetailsRepository.save(user));
    }
}
