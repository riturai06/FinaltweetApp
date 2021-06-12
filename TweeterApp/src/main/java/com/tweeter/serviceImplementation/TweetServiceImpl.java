package com.tweeter.serviceImplementation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweeter.dto.ReplyEntity;
import com.tweeter.dto.TweetRequest;
import com.tweeter.dto.TweetResponse;
import com.tweeter.model.ApplicationUser;
import com.tweeter.model.Reply;
import com.tweeter.model.Tweet;
import com.tweeter.repository.ReplyRepository;
import com.tweeter.repository.TweetRepository;
import com.tweeter.repository.UserRepository;
import com.tweeter.serviceImplementation.TweetServiceImpl;

@Service
public class TweetServiceImpl {

	@Autowired
	TweetRepository tweetRepo;

	@Autowired
	UserRepository userRepo;

	@Autowired
	ReplyRepository replyRepo;

	public String postTweet(TweetRequest tweetRequest) {
		// TODO Auto-generated method stub
		Tweet tweets = convertDTOToEntity(tweetRequest);
		tweetRepo.save(tweets);
		String msg = null;
		if (tweets != null) {
			msg = "Success";
			return msg;
		} else {
			msg = "Internal Server Error Occured";
		}
		return msg;
	}

	private Tweet convertDTOToEntity(TweetRequest tweetRequest) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		Tweet tweets = new Tweet();
		tweets.setTweetDescription(tweetRequest.getTweetDesc());
		tweets.setTweetTag(tweetRequest.getTweetTag());
		tweets.setDate(dtf.format(now));
		ApplicationUser register = userRepo.findByEmail(tweetRequest.getEmail());
		tweets.setEmail(register.getEmail());
		tweets.setRecordActive('Y');
		return tweets;
	}

	public List<TweetResponse> getAllTweets(String Email) {
		// TODO Auto-generated method stub

		List<TweetResponse> tweetResponseList = new ArrayList<>();
		List<Tweet> tweetList = tweetRepo.findByRecordActive('Y');
		tweetList.stream().forEach(tweet -> {
			TweetResponse tweetResponse = new TweetResponse();
			tweetResponse.setTweetDesc(tweet.getTweetDescription());
			tweetResponse.setTweetBy(tweet.getEmail());
			tweetResponse.setTweetId(tweet.getTweetId());
			tweetResponse.setDate(tweet.getDate());
			List<Reply> replyList =replyRepo.findByTweetId(tweet.getTweetId());
			List<ReplyEntity> replyEntityList = new ArrayList<>();
			replyList.stream().forEach(reply ->{
				ReplyEntity replyEntity = new ReplyEntity();
				replyEntity.setEmail(reply.getEmail());
				replyEntity.setReplyDesc(reply.getReplyDesc());
				replyEntity.setTweetId(reply.getTweetId());
				replyEntity.setDate(reply.getDate());
				replyEntityList.add(replyEntity);	
			});
			
			
			tweetResponse.setReplyList(replyEntityList);
			tweetResponseList.add(tweetResponse);
		});

		return tweetResponseList;

	}

	public String postReply(ReplyEntity replyEntity) {
		// TODO Auto-generated method stub
		Reply reply = converttDTOToEntity(replyEntity);
		replyRepo.save(reply);
		String msg = null;
		if (reply != null) {
			msg = "Success";
			return msg;
		} else {
			msg = "Internal Server Error Occured";
		}
		return msg;
	}

	public Reply converttDTOToReplyEntity(ReplyEntity replyEntity) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		Reply reply = new Reply();
		reply.setEmail(replyEntity.getEmail());
		reply.setReplyDesc(replyEntity.getReplyDesc());
		reply.setTweetId(replyEntity.getTweetId());
		reply.setDate(dtf.format(now));

		return reply;
	}
	

	private Reply converttDTOToEntity(ReplyEntity replyEntity) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		Reply reply = new Reply();
		reply.setEmail(replyEntity.getEmail());
		reply.setTweetId(replyEntity.getTweetId());
		reply.setReplyDesc(replyEntity.getReplyDesc());
		reply.setDate(dtf.format(now));

		return reply;
	}

	public String deleteTweet(Integer id) {
		// TODO Auto-generated method stub
		tweetRepo.deleteById(id);
		return "success";
	}

	public String replyTweet(ReplyEntity reply) {
		// TODO Auto-generated method stub
		return null;
	}

}
