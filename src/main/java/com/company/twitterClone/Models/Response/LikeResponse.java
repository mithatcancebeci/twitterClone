package com.company.twitterClone.Models.Response;

import com.company.twitterClone.Models.Concrete.Like;

public class LikeResponse {
	private long id;
	private UserResponse user;
	private TweetResponse tweet;
	private TweetResponse comment;

	public LikeResponse() {

	}

	public LikeResponse(Like like) {
		this.setId(like.getId());
		this.setUser(new UserResponse(like.getUser()));
		this.setTweet(new TweetResponse(like.getTweet()));
		this.setComment(new TweetResponse(like.getComment()));
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserResponse getUser() {
		return user;
	}

	public void setUser(UserResponse user) {
		this.user = user;
	}

	public TweetResponse getTweet() {
		return tweet;
	}

	public void setTweet(TweetResponse tweet) {
		this.tweet = tweet;
	}

	public TweetResponse getComment() {
		return comment;
	}

	public void setComment(TweetResponse comment) {
		this.comment = comment;
	}

}
