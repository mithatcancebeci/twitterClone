package com.company.twitterClone.Models.Request;

public class UserRegisterRequest {
	private String email;
	private String password;
	private String username;
	private String displayName;
	private String profileImage;
	private int birthDateYear;
	private String location;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public int getBirthDateYear() {
		return birthDateYear;
	}

	public void setBirthDateYear(int birthDateYear) {
		this.birthDateYear = birthDateYear;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
