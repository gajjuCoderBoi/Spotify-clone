package com.ga.controller;

import com.ga.entity.UserRole;
import com.ga.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class UserRoleController {
    @Autowired
    UserRoleService userRoleService;

    @PostMapping
    public UserRole createRole(@RequestBody UserRole userRole){
        return userRoleService.createRole(userRole);
    }

    @GetMapping("/{roleName}")
    public UserRole getRole(@PathVariable(name = "roleName") String roleName){
        return userRoleService.getRole(roleName);
    }
}
