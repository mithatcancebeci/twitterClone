package com.company.twitterClone.Models.Concrete;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Tweet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	private long id;

	@JsonProperty("content")
	private String content;

	@JsonProperty("likeCount")
	private int likeCount;

	@JsonProperty("reTweetCount")
	private int reTweetCount;

	@JsonProperty("createdAt")
	private Date createdAt;

	@JsonProperty("updatedAt")
	private Date updatedAt;

	@ManyToOne
	@JsonProperty("user")
	private User user;

	@OneToMany(targetEntity = Tweet.class, cascade = CascadeType.ALL)
	@JsonProperty("comments")
	private List<Tweet> comments;

	@OneToMany(targetEntity = Like.class, cascade = CascadeType.ALL)
	@JsonProperty("likes")
	private List<Like> likes;

	@OneToMany(targetEntity = ReTweet.class, cascade = CascadeType.ALL)
	@JsonProperty("reTweets")
	private List<ReTweet> reTweets;

	public Tweet() {

	}

	public Tweet(String content, int likeCount, int reTweetCount, Date createdAt, Date updatedAt, User user,
			List<Tweet> comments, List<Like> likes, List<ReTweet> reTweets) {
		super();
		this.content = content;
		this.likeCount = likeCount;
		this.reTweetCount = reTweetCount;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.user = user;
		this.comments = comments;
		this.likes = likes;
		this.reTweets = reTweets;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Tweet> getComments() {
		return comments;
	}

	public void setComments(List<Tweet> comments) {
		this.comments = comments;
	}

	public List<Like> getLikes() {
		return likes;
	}

	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

	public List<ReTweet> getReTweets() {
		return reTweets;
	}

	public void setReTweets(List<ReTweet> reTweets) {
		this.reTweets = reTweets;
	}

	public long getId() {
		return id;
	}

}
