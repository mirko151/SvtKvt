// UserService.java
package com.sitpass.service;

import com.sitpass.model.User;
import com.sitpass.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean userExists(String username) {
        return userRepository.findByUsername(username) != null;
    }
}
