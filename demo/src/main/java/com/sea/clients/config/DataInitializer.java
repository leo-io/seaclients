package com.sea.clients.config;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.sea.clients.entity.User;
import com.sea.clients.repository.UserRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer {
    private final UserRepository userRepository;
    
    @Lazy
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initUsers() {
        // Create ADMIN user
        createUserIfMissing("admin", "123qwei@#", User.Role.ADMIN);
        // Create STANDARD user
        createUserIfMissing("user", "123qwei123", User.Role.STANDARD);
    }

    private void createUserIfMissing(String username, String password, User.Role role) {
        if (!userRepository.existsByUsername(username)) {
            User user = new User();
            user.setUsername(username);
            user.setPasswordHash(passwordEncoder.encode(password));
            user.setRole(role);
            userRepository.save(user);
        }
    }
}