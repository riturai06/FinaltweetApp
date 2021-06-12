package com.tweeter.model;




import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Entity(name = "tweet")
public class Tweet {
	
    @Id
    @GeneratedValue
	private Integer tweetId;
	
	private String tweetDescription;
	
	private String tweetTag;
	
	private String Date;
	
	private String email;
	
	private char recordActive;
	
	@JsonIgnore
	@OneToMany
	private List<Reply> reply;

	public void setReply(List<Reply> reply) {
		this.reply = reply;
	}

	public List<Reply> getReply() {
		return reply;
	}

	public Integer getTweetId() {
		return tweetId;
	}

	public void setTweetId(Integer tweetId) {
		this.tweetId = tweetId;
	}

	public String getTweetDescription() {
		return tweetDescription;
	}

	public void setTweetDescription(String tweetDescription) {
		this.tweetDescription = tweetDescription;
	}

	public String getTweetTag() {
		return tweetTag;
	}

	public void setTweetTag(String tweetTag) {
		this.tweetTag = tweetTag;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getRecordActive() {
		return recordActive;
	}

	public void setRecordActive(char recordActive) {
		this.recordActive = recordActive;
	}

	@Override
	public String toString() {
		return "Tweet [tweetId=" + tweetId + ", tweetDescription=" + tweetDescription + ", tweetTag=" + tweetTag + ", Date="
				+ Date + ", email=" + email + ", recordActive=" + recordActive + ", reply=" + reply
				+ "]";
	}

	public Tweet(Integer tweetId, String tweetDescription, String tweetTag, String date, String email, char recordActive,
			List<Reply> reply) {
		super();
		this.tweetId = tweetId;
		this.tweetDescription = tweetDescription;
		this.tweetTag = tweetTag;
		Date = date;
		this.email = email;
		this.recordActive = recordActive;
		this.reply = reply;
	}

	public Tweet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	

	
	

	

}
