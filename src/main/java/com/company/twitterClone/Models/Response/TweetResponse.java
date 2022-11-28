package com.company.twitterClone.Models.Response;

import java.util.Date;
import java.util.List;

import com.company.twitterClone.Models.Concrete.Tweet;

public class TweetResponse {
	private long id;
	private String content;
	private int likeCount;
	private int reTweetCount;
	private Date createdAt;
	private Date updatedAt;
	private UserResponse user;
	private List<TweetResponse> comments;
	private List<LikeResponse> likes;
	private List<ReTweetResponse> reTweets;

	public TweetResponse() {

	}

	public TweetResponse(Tweet tweet) {
		this.setId(tweet.getId());
		this.setContent(tweet.getContent());
		this.setCreatedAt(tweet.getCreatedAt());
		this.setUpdatedAt(tweet.getUpdatedAt());
		this.setUser(new UserResponse(tweet.getUser()));
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

	public UserResponse getUser() {
		return user;
	}

	public void setUser(UserResponse user) {
		this.user = user;
	}

	public List<TweetResponse> getComments() {
		return comments;
	}

	public void setComments(List<TweetResponse> comments) {
		this.comments = comments;
	}

	public List<LikeResponse> getLikes() {
		return likes;
	}

	public void setLikes(List<LikeResponse> likes) {
		this.likes = likes;
	}

	public List<ReTweetResponse> getReTweets() {
		return reTweets;
	}

	public void setReTweets(List<ReTweetResponse> reTweets) {

		this.reTweets = reTweets;
	}

}
