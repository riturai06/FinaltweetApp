package com.tweeter.dto;

import java.util.List;

public class UserTweets {
	
	private Integer tweetId;
	
	private String tweetDesc;
	
	private String Date;
	
	private List<ReplyEntity> replyList;

	public Integer getTweetId() {
		return tweetId;
	}

	public void setTweetId(Integer tweetId) {
		this.tweetId = tweetId;
	}

	public String getTweetDesc() {
		return tweetDesc;
	}

	public void setTweetDesc(String tweetDesc) {
		this.tweetDesc = tweetDesc;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public List<ReplyEntity> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<ReplyEntity> replyList) {
		this.replyList = replyList;
	}

}
