package com.company.twitterClone.Models.Dtos;

import com.company.twitterClone.Models.Concrete.User;

public class UserDto {

	private long id;

	private String name;

	private String displayName;

	private String profileImage;

	public UserDto() {

	}

	public UserDto(User user) {
		this.setId(user.getId());
		this.setName(user.getName());
		this.setDisplayName(user.getDisplayName());
		this.setProfileImage(user.getProfileImage());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}
