package com.twitterclone.service;

import com.twitterclone.model.User;
import com.twitterclone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(String username, String password, String gender) {
        if (userRepository.findByUsername(username) != null) {
            return null; // User already exists
        }
        return userRepository.save(new User(username, password, gender));
    }

    public User loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null; // Invalid credentials
    }
}
