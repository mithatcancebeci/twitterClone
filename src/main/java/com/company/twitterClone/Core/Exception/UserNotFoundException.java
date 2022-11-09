package com.company.twitterClone.Core.Exception;

public class UserNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1881786746333543676L;
	private String message;

	public UserNotFoundException() {
		this.message = "User not found";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
