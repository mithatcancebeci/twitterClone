package com.company.twitterClone.Models.Dtos;

public class UserRegisterDto {
	private String email;
	private String password;
	private String name;
	private String surname;
	private String profileImage;
	private int birthDateYear;
	private String location;

	public UserRegisterDto() {
		
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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
