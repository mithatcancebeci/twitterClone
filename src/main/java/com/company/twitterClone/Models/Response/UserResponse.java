package com.company.twitterClone.Models.Response;

import com.company.twitterClone.Models.Concrete.User;

public class UserResponse {

	private long id;

	private String username;

	private String displayName;

	private String profileImage;

	public UserResponse() {

	}

	public UserResponse(User user) {
		this.setId(user.getId());
		this.setUsername(user.getUsername());
		this.setDisplayName(user.getDisplayName());
		this.setProfileImage(user.getProfileImage());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

}
