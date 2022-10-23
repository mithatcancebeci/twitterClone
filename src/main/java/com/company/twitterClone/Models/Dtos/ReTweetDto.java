package com.company.twitterClone.Models.Dtos;

import com.company.twitterClone.Models.Concrete.ReTweet;

public class ReTweetDto {
	private long id;

	private UserDto user;

	private TweetDto tweet;

	private CommentDto comment;

	public ReTweetDto() {

	}

	public ReTweetDto(ReTweet reTweet) {
		this.setId(reTweet.getId());
		this.setTweet(new TweetDto(reTweet.getTweet()));
		this.setUser(new UserDto(reTweet.getUser()));
		this.setComment(new CommentDto(reTweet.getComment()));
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public TweetDto getTweet() {
		return tweet;
	}

	public void setTweet(TweetDto tweet) {
		this.tweet = tweet;
	}

	public CommentDto getComment() {
		return comment;
	}

	public void setComment(CommentDto comment) {
		this.comment = comment;
	}

}
