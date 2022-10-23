package com.company.twitterClone.Models.Concrete;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String content;
	private int likeCount;
	private int reTweetCount;
	private Date createdAt;
	private Date updatedAt;

	@ManyToOne
	private User user;

	@OneToMany(targetEntity = Like.class, cascade = CascadeType.ALL)
	private List<Like> likes;

	@OneToMany(targetEntity = ReTweet.class, cascade = CascadeType.ALL)
	private List<ReTweet> reTweets;

	public Comment() {

	}

	public Comment(String content, int likeCount, int reTweetCount, Date createdAt, Date updatedAt, User user,
			List<Like> likes, List<ReTweet> reTweets) {
		super();
		this.content = content;
		this.likeCount = likeCount;
		this.reTweetCount = reTweetCount;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.user = user;
		this.likes = likes;
		this.reTweets = reTweets;
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
}
