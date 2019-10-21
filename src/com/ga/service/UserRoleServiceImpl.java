package com.ga.service;

import com.ga.dao.UserRoleDoa;
import com.ga.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService{

    @Autowired
    UserRoleDoa userRoleDoa;

    @Override
    public UserRole createRole(UserRole newRole) {
        return userRoleDoa.createRole(newRole);
    }

    @Override
    public UserRole getRole(String roleName) {
        return userRoleDoa.getRole(roleName);
    }
}
