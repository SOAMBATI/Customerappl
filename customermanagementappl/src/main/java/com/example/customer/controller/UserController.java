/*package com.example.customer.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.customer.entity.UserLogin;
import com.example.customer.service.UserService;

@CrossOrigin
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserLogin> registerUser(@RequestBody UserLogin user) {
        // Check if user with given username already exists
        if (userService.findByUsername(user.getUsername()).isPresent()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        // Save the user details if not already present
        UserLogin savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        
        
        
    }

    @PostMapping("/log")
    public ResponseEntity<UserLogin> loginUser(@RequestBody UserLogin user) {
        // Find the user by username
        Optional<UserLogin> foundUser = userService.findByUsername(user.getUsername());
        if (foundUser.isPresent()) {
            // Compare passwords
            if (foundUser.get().getPassword().equals(user.getPassword())) {
                return new ResponseEntity<>(foundUser.get(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
*/
