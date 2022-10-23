package com.company.twitterClone.Models.Dtos;

import java.util.Date;

import com.company.twitterClone.Models.Concrete.Comment;

public class CommentDto {
	private long id;
	private String content;
	private int likeCount;
	private int reTweetCount;
	private Date createdAt;
	private Date updatedAt;
	private UserDto user;

	public CommentDto() {

	}

	public CommentDto(Comment comment) {
		this.setId(comment.getId());
		this.setContent(comment.getContent());
		this.setLikeCount(comment.getLikeCount());
		this.setReTweetCount(comment.getReTweetCount());
		this.setUser(new UserDto(comment.getUser()));
		this.setCreatedAt(comment.getCreatedAt());
		this.setUpdatedAt(comment.getUpdatedAt());

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

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

}
