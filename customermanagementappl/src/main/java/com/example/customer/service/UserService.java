
package com.example.customer.service;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.customer.entity.UserLogin;
import com.example.customer.repository.UserLoginRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserLoginRepository userRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    public void register(UserLogin user) {
//        // Encode password before saving
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userRepository.save(user);
//    }

   

    public Optional<UserLogin> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
	 @Transactional
	    public UserLogin saveUser(UserLogin user) {
	       
	        return userRepository.save(user);
	    }
}
