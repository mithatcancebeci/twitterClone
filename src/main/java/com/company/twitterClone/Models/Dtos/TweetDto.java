package com.company.twitterClone.Models.Dtos;

import java.util.Date;
import java.util.List;
import com.company.twitterClone.Models.Concrete.Tweet;

public class TweetDto {
	private long id;
	private String content;
	private int likeCount;
	private int reTweetCount;
	private Date createdAt;
	private Date updatedAt;
	private UserDto user;
	private List<TweetDto> comments;
	private List<LikeDto> likes;
	private List<ReTweetDto> reTweets;

	public TweetDto() {

	}

	public TweetDto(Tweet tweet) {
		this.setId(tweet.getId());
		this.setContent(tweet.getContent());
		this.setCreatedAt(tweet.getCreatedAt());
		this.setUpdatedAt(tweet.getUpdatedAt());
		this.setUser(new UserDto(tweet.getUser()));
		this.setLikeCount(tweet.getLikeCount());
		this.setReTweetCount(tweet.getReTweetCount());
		this.setComments(comments);
		this.setLikes(likes);
		this.setReTweets(reTweets);
		//
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getReTweetCount() {
		return reTweetCount;
	}

	public void setReTweetCount(int reTweetCount) {
		this.reTweetCount = reTweetCount;
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

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public List<TweetDto> getComments() {
		return comments;
	}

	public void setComments(List<TweetDto> comments) {
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
