package com.tweeter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.springframework.stereotype.Component;

@Component
@Entity(name = "reply")
public class Reply {
	
    @Id
    @GeneratedValue
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

	public String getReplyDesc() {
		return replyDesc;
	}

	public void setReplyDesc(String replyDesc) {
		this.replyDesc = replyDesc;
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

	@Override
	public String toString() {
		return "Reply [replyId=" + replyId + ", email=" + email + ", tweetId=" + tweetId + ", replyDesc=" + replyDesc
				+ ", date=" + date + "]";
	}

	public Reply(Integer replyId, String email, Integer tweetId, String replyDesc, String date) {
		super();
		this.replyId = replyId;
		this.email = email;
		this.tweetId = tweetId;
		this.replyDesc = replyDesc;
		this.date = date;
	}

	public Reply() {
		// TODO Auto-generated constructor stub
	}



	
	
	
	
	
	
	
	
	

}
