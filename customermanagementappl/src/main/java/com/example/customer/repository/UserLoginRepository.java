package com.example.customer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.customer.entity.UserLogin;

public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {
	Optional<UserLogin> findByUsername(String username);

}
