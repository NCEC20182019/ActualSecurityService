package com.lemmeknow.service;

import com.lemmeknow.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("roleService")
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Integer getRoleIdByName(String name){
        return roleRepository.findByName(name).get().getId();
    }
}
