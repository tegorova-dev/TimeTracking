package com.example.timetracking.Liquibase.services;

import com.example.timetracking.Liquibase.models.entity.User;
import com.example.timetracking.Liquibase.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> findByUsername(String str) {
        return userRepository.findByUsername(str);
    }

    public User getByUsername(String str) {
        return userRepository.getByUsername(str);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public User getOne(Long userId) {
        return userRepository.getOne(userId);
    }
}