package com.bbd.server;

import java.io.Serializable;
import java.sql.Timestamp;

@SuppressWarnings("serial")
public class PostBean implements Serializable
{
	private int postId, userId;
	private String content;
	private Timestamp createdAt;
	
	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public PostBean() {}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
