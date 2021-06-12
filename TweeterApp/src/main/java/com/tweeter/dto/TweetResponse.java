package com.tweeter.dto;

import java.util.List;

import com.tweeter.model.Reply;

public class TweetResponse {
	
	private String tweetDesc;
	
	private String tweetBy;
	
	private Integer tweetId;
	
	private String date;
	
	private List<ReplyEntity> replyList;

	public String getTweetDesc() {
		return tweetDesc;
	}

	public void setTweetDesc(String tweetDesc) {
		this.tweetDesc = tweetDesc;
	}

	public String getTweetBy() {
		return tweetBy;
	}

	public void setTweetBy(String tweetBy) {
		this.tweetBy = tweetBy;
	}

	public Integer getTweetId() {
		return tweetId;
	}

	public void setTweetId(Integer tweetId) {
		this.tweetId = tweetId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<ReplyEntity> getReplyDTOList() {
		return replyList;
	}

	public void setReplyList(List<ReplyEntity> replyList) {
		this.replyList = replyList;
	}


	@Override
	public String toString() {
		return "TweetResponse [tweetDesc=" + tweetDesc + ", tweetBy=" + tweetBy + ", tweetId=" + tweetId + ", date="
				+ date + ", replyList=" + replyList + "]";
	}


	
	
	
	

}
