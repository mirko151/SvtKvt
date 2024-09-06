// UserController.java
package com.sitpass.controller;

import com.sitpass.model.User;
import com.sitpass.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Registracija korisnika
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }

    // Prijava korisnika
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        User storedUser = userRepository.findByUsername(user.getUsername());
        if (storedUser != null && passwordEncoder.matches(user.getPassword(), storedUser.getPassword())) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    // Odjava korisnika
    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        return ResponseEntity.ok("Logout successful");
    }

    // Dobijanje korisnika po username
    @GetMapping("/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username) {
        return new ResponseEntity<>(userRepository.findByUsername(username), HttpStatus.OK);
    }
}
