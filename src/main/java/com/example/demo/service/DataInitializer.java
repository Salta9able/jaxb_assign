package com.example.demo.service;

import com.example.demo.models.Role;
import com.example.demo.models.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitializer {
    private final UserService userService;

    public DataInitializer(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void userInit() {
        User user = new User();

        user.setPassword("123");
        user.setUsername("user");

        Role role = new Role();

        role.setName("user");

        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);

        user.setRoles(roleSet);

        userService.save(user);
    }
}
