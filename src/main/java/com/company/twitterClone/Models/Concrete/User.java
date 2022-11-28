package com.company.twitterClone.Models.Concrete;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(unique = true)
	private String username;

	private String backgroundImage;

	private String location;

	private String profileImage;

	private int birthDateYear;

	private String password;

	private String displayName;

	private Date createdAt;

	private Date updatedAt;

	@Column(unique = true)
	private String email;

	@OneToMany(targetEntity = Tweet.class, cascade = CascadeType.ALL)
	private List<Tweet> tweets;

	@OneToMany(targetEntity = Tweet.class, cascade = CascadeType.ALL)
	private List<Tweet> comments;

	@OneToMany(targetEntity = Like.class, cascade = CascadeType.ALL)
	private List<Like> likes;

	@OneToMany(targetEntity = ReTweet.class, cascade = CascadeType.ALL)
	private List<ReTweet> reTweets;

	public User() {
	}

	public User(String username, String backgroundImage, String location, String profileImage, int birthDateYear,
			String password, String displayName, Date createdAt, Date updatedAt, String email, List<Tweet> tweets,
			List<Tweet> comments, List<Like> likes, List<ReTweet> reTweets) {
		super();
		this.username = username;
		this.backgroundImage = backgroundImage;
		this.location = location;
		this.profileImage = profileImage;
		this.birthDateYear = birthDateYear;
		this.password = password;
		this.displayName = displayName;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.email = email;
		this.tweets = tweets;
		this.comments = comments;
		this.likes = likes;
		this.reTweets = reTweets;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(String backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public int getBirthDateYear() {
		return birthDateYear;
	}

	public void setBirthDateYear(int birthDateYear) {
		this.birthDateYear = birthDateYear;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Tweet> getTweets() {
		return tweets;
	}

	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
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

}
