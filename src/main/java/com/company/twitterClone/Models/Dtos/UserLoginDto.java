package com.company.twitterClone.Models.Dtos;

import com.company.twitterClone.Models.Concrete.User;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserLoginDto {

	@JsonProperty("email")
	private String email;

	@JsonProperty("password")
	private String password;

	public UserLoginDto() {

	}

	public UserLoginDto(User user) {
		user.setEmail(this.email);
		user.setPassword(this.password);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
