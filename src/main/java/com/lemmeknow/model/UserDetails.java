package com.lemmeknow.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetails extends User
        implements org.springframework.security.core.userdetails.UserDetails {

    public UserDetails() {
    }

    public UserDetails(User user) {
        super(user);
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();

        getRoles().forEach(role->{
            grantedAuthorityList.add(new SimpleGrantedAuthority(role.getName()));
            role.getPermissions().forEach(permission -> {
               grantedAuthorityList.add(new SimpleGrantedAuthority(permission.getName()));
            });
        });

        return grantedAuthorityList;
    }

    @Override
    public Integer getId(){
        return super.getId();
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return  super.getPassword();
    }

    @Override
    public String getEmail(){
        return super.getEmail();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public String getNotificationChannel() {
        return super.getNotificationChannel();
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return super.isAccountNonExpired();
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return super.isAccountNonLocked();
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return super.isCredentialsNonExpired();
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return super.isEnabled();
    }
}
