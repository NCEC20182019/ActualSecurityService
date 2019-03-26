package com.lemmeknow.model;

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
    public String getPassword() {
        return  super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return super.isEnabled();
    }
}
