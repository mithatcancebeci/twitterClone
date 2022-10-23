package com.company.twitterClone.Models.Dtos;

import com.company.twitterClone.Models.Concrete.Like;

public class LikeDto {
	private long id;
	private UserDto user;
	private TweetDto tweet;
	private CommentDto comment;

	public LikeDto() {

	}

	public LikeDto(Like like) {
		this.setId(like.getId());
		this.setUser(new UserDto(like.getUser()));
		this.setTweet(new TweetDto(like.getTweet()));
		this.setComment(new CommentDto(like.getComment()));
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
