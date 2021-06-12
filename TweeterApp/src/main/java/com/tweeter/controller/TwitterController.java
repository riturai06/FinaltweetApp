package com.tweeter.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweeter.dto.ReplyEntity;
import com.tweeter.dto.TweetRequest;
import com.tweeter.dto.TweetResponse;
import com.tweeter.serviceImplementation.TweetServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1.0/tweets")
public class TwitterController {
	
	@Autowired
	TweetServiceImpl tweetService;
	
//	@Autowired
//	KafkaTemplate<String, String> kafkaTemplate;
//	
//	public String topic = "kafkaTopic";
	
	@ApiOperation(value = "Post tweet", response = String.class, notes = "This API used to post loggedin users tweet."
			+ "and return success message")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successful operation"),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 401, message = "Unauthorized access"),
			@ApiResponse(code = 500, message = "Internal server error") })
	@PostMapping("/posttweet")
	public String postTweet(@RequestBody TweetRequest tweet) {
		String message = tweetService.postTweet(tweet);
	//	kafkaTemplate.send(topic , "Tweet Successfully Posted: " + message  );

		return message;
	}
	
	@GetMapping("/gettweets/{email}")
	public ResponseEntity<List<TweetResponse>> getAllTweets(@PathVariable String email) {
	//	kafkaTemplate.send(topic , "Your Tweets :" + tweetService.getAllTweets(email) );
		return ResponseEntity.ok().body(tweetService.getAllTweets(email));
	}
	
	@PostMapping("/replyTweet")
	public String replytweet(@RequestBody ReplyEntity reply)
	{
		String message = tweetService.postReply(reply);
	//	kafkaTemplate.send(topic , "Reply Posted: " + message );
		return message;
		
	}
	
	@CrossOrigin("*")
	@DeleteMapping("/deleteTweet/{tweetId}")
	public String replytweet(@PathVariable Integer tweetId)
	{
		String message = tweetService.deleteTweet(tweetId);
	//	kafkaTemplate.send(topic , "Tweet Deleted Successfully" );
		return message;
		
	}
	
	
	

}
