package com.company.twitterClone.Core.Exception;

public class TweetNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8846723868653433581L;
	private String message;

	public TweetNotFoundException() {
		this.message = "Tweet was not found";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}