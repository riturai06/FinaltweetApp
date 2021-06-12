package com.tweeter.dto;

import java.time.LocalDateTime;

public class TweetRequest {
	
	private String tweetDesc;
	
	private String tweetTag;
	
	private String email;
	
	private LocalDateTime time;

	public String getTweetDesc() {
		return tweetDesc;
	}

	public void setTweetDesc(String tweetDesc) {
		this.tweetDesc = tweetDesc;
	}

	public String getTweetTag() {
		return tweetTag;
	}

	public void setTweetTag(String tweetTag) {
		this.tweetTag = tweetTag;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "TweetRequest [tweetDesc=" + tweetDesc + ", tweetTag=" + tweetTag + ", email=" + email + ", time=" + time
				+ "]";
	}
	
	


}
