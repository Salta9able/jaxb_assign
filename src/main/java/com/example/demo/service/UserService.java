package com.example.demo.service;

import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void save(User user) {
        String passwordRaw = user.getPassword();
        String passwordEnc = passwordEncoder.encode(passwordRaw);
        user.setPassword(passwordEnc);
        Set<Role> roleSet = new HashSet<>();
        Role role = new Role();
        role.setId(0);
        role.setName("user");
        roleSet.add(role);
        user.setRoles(roleSet);
        userRepository.save(user);
    }
}
