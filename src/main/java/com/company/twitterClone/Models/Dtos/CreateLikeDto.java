package com.company.twitterClone.Models.Dtos;

public class CreateLikeDto {
	private long userId;
	private long tweetId;
	public CreateLikeDto(long userId, long tweetId) {
		super();
		this.userId = userId;
		this.tweetId = tweetId;
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
