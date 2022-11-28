package com.company.twitterClone.Models.Response;

import com.company.twitterClone.Models.Concrete.ReTweet;

public class ReTweetResponse {
	private long id;

	private UserResponse user;

	private TweetResponse tweet;

	private TweetResponse comment;

	public ReTweetResponse() {

	}

	public ReTweetResponse(ReTweet reTweet) {
		this.setId(reTweet.getId());
		this.setTweet(new TweetResponse(reTweet.getTweet()));
		this.setUser(new UserResponse(reTweet.getUser()));
		this.setComment(new TweetResponse(reTweet.getComment()));
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
