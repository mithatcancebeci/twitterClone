package com.company.twitterClone.Models.Request;

public class CreateTweetRequest {
	private String content;
	private long userId;

	public CreateTweetRequest(String content, long userId) {
		super();
		this.content = content;
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
}
