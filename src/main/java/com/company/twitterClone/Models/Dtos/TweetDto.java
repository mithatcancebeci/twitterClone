package com.company.twitterClone.Models.Dtos;

import java.util.Date;
import java.util.List;
import com.company.twitterClone.Models.Concrete.Tweet;

public class TweetDto {
	private long id;
	private String content;
	private Date createdAt;
	private Date updatedDate;
	private UserDto user;
	private List<CommentDto> comments;
	private List<LikeDto> likes;
	private List<ReTweetDto> reTweets;

	public TweetDto() {

	}

	public TweetDto(Tweet tweet) {
		this.setId(tweet.getId());
		this.setContent(tweet.getContent());
		this.setCreatedAt(tweet.getCreatedAt());
		this.setUpdatedDate(tweet.getUpdatedAt());
		this.setUser(new UserDto(tweet.getUser()));
		//
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public List<CommentDto> getComments() {
		return comments;
	}

	public void setComments(List<CommentDto> comments) {
		this.comments = comments;
	}

	public List<LikeDto> getLikes() {
		return likes;
	}

	public void setLikes(List<LikeDto> likes) {
		this.likes = likes;
	}

	public List<ReTweetDto> getReTweets() {
		return reTweets;
	}

	public void setReTweets(List<ReTweetDto> reTweets) {
		this.reTweets = reTweets;
	}

}
