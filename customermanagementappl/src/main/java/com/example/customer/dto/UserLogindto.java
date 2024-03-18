package com.example.customer.dto;

import lombok.Data;

@Data
public class UserLogindto {
	 private String emailId;
	 private String password;
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	 
}
