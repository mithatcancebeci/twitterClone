package com.company.twitterClone.Models.Concrete;

import javax.persistence.*;

@Entity
public class Like {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	private User user;
	@ManyToOne
	private Tweet tweet;
	@ManyToOne
	private Tweet comment;

	public Like() {

	}

	public Like(User user, Tweet tweet, Tweet comment) {
		super();
		this.user = user;
		this.tweet = tweet;
		this.comment = comment;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Tweet getTweet() {
		return tweet;
	}

	public void setTweet(Tweet tweet) {
		this.tweet = tweet;
	}

	public Tweet getComment() {
		return comment;
	}

	public void setComment(Tweet comment) {
		this.comment = comment;
	}

}
