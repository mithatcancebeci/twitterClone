package com.company.twitterClone.Models.Dtos;

public class CreateCommentDto {
	private String content;
	private long userId;
	private long tweetId;
	public CreateCommentDto(String content, long userId, long tweetId) {
		super();
		this.content = content;
		this.userId = userId;
		this.tweetId = tweetId;
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
	public long getTweetId() {
		return tweetId;
	}
	public void setTweetId(long tweetId) {
		this.tweetId = tweetId;
	}
	
}
