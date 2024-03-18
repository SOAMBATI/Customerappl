package com.example.customer.entity;


import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="user_login")
@DynamicUpdate
public class UserLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	@NotEmpty(message="Please select valid username")
    private String username;
	@NotEmpty(message="Please select valid password")
    private String password;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserLogin(Long id, @NotEmpty(message = "Please select valid username") String username,
			@NotEmpty(message = "Please select valid password") String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

    // Getters and setters (omitted for brevity)
}

