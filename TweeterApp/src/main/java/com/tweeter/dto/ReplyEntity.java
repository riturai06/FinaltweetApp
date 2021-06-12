package com.tweeter.dto;

public class ReplyEntity {
	
	
	private Integer replyId;
	
	private String email;
	
	private Integer tweetId;
	
	private String replyDesc;
	
	private String date;

	
	public Integer getReplyId() {
		return replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getTweetId() {
		return tweetId;
	}

	public void setTweetId(Integer tweetId) {
		this.tweetId = tweetId;
	}

	public String getReplyDesc() {
		return replyDesc;
	}

	public void setReplyDesc(String replyDesc) {
		this.replyDesc = replyDesc;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	

}
