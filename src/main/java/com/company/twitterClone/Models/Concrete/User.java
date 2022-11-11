package com.company.twitterClone.Models.Concrete;

import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private long id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("surname")
	private String surname;

	@JsonProperty("backgroundImage")
	private String backgroundImage;

	@JsonProperty("location")
	private String location;

	@JsonProperty("profileImage")
	private String profileImage;

	@JsonProperty("birthDateYear")
	private int birthDateYear;

	@JsonProperty("password")
	private String password;

	@Column(unique = true)
	@JsonProperty("displayName")
	private String displayName;

	@Column(unique = true)
	@JsonProperty("email")
	private String email;

	@OneToMany(targetEntity = Tweet.class, cascade = CascadeType.ALL)
	@JsonProperty("tweets")
	private List<Tweet> tweets;

	@OneToMany(targetEntity = Tweet.class, cascade = CascadeType.ALL)
	@JsonProperty("comments")
	private List<Tweet> comments;

	@OneToMany(targetEntity = Like.class, cascade = CascadeType.ALL)
	@JsonProperty("likes")
	private List<Like> likes;

	@OneToMany(targetEntity = ReTweet.class, cascade = CascadeType.ALL)
	@JsonProperty("reTweets")
	private List<ReTweet> reTweets;

	public User() {

	}

	public User(String name, String surname, String backgroundImage, String location, String profileImage,
			int birthDateYear, String password, String displayName, String email, List<Tweet> tweets,
			List<Tweet> comments, List<Like> likes, List<ReTweet> reTweets) {
		super();
		this.name = name;
		this.surname = surname;
		this.backgroundImage = backgroundImage;
		this.location = location;
		this.profileImage = profileImage;
		this.birthDateYear = birthDateYear;
		this.password = password;
		this.displayName = displayName;
		this.email = email;
		this.tweets = tweets;
		this.comments = comments;
		this.likes = likes;
		this.reTweets = reTweets;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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
