package com.tweeter.serviceImplementation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tweeter.dto.ReplyEntity;
import com.tweeter.dto.TweetResponse;
import com.tweeter.model.ApplicationUser;
import com.tweeter.model.Reply;
import com.tweeter.model.Tweet;
import com.tweeter.repository.ReplyRepository;
import com.tweeter.repository.TweetRepository;
import com.tweeter.repository.UserRepository;


@Component
@Service
public class CustomerServiceImplementation implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TweetRepository repository;
	
	@Autowired
	private ReplyRepository replyRepository;

	public CustomerServiceImplementation(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public ApplicationUser createUser(ApplicationUser user) {
		//user.setId(UUID.randomUUID().toString());
		if (!user.getEmail().isEmpty() && user.getEmail() != null) {
			ApplicationUser register = userRepository.findByEmail(user.getEmail());
			if (register != null) {
			System.out.println("Entered E-mail/Login Id Already Exists");
			}
		   else {
		
		user.setPassword(user.getPassword()); 
		user.setSucessMessage("Registration Successful");
		System.out.println("Getting data from DB " + user);
		user =userRepository.save(user);
		}
		}
		
		return user;
		
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		ApplicationUser user = userRepository.findByEmail(email);

		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				getAuthority());
	}
	


		

	private List<SimpleGrantedAuthority> getAuthority() {

		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public ApplicationUser findOne(String email) {

		return userRepository.findByEmail(email);
	}

	public Optional<ApplicationUser> getUserById(String id) {

		return userRepository.findById(id);
	}

//	public ApplicationUser getUserByEmail(String email) {
//		return userRepository.findByEmail(email);
//	}
//	
	public List<ApplicationUser> getAllUser() {
		List<ApplicationUser> userList = (List<ApplicationUser>) userRepository.findAll();
		userList.stream().forEach(user -> {
			ApplicationUser users = new ApplicationUser();
			users.setFirstName(user.getFirstName());
			users.setTweet(user.getTweet());	
			});
		return userList;
			
	}

	public List<Tweet> getUsersTweet(String email) {
		
		List<Tweet> userTweetsList = new ArrayList<>();
		List<Tweet> tweetList = repository.findByEmail(email);
		tweetList.stream().forEach(tweet -> {
			Tweet userTweets = new Tweet();
			userTweets.setTweetId(tweet.getTweetId());
			userTweets.setTweetDescription(tweet.getTweetDescription());
			userTweets.setDate(tweet.getDate());
			List<Reply> replyList = replyRepository.findByTweetId(tweet.getTweetId());
			List<ReplyEntity> replyEntityList = new ArrayList<>();
			replyList.stream().forEach(reply -> {
				ReplyEntity replyEntity = new ReplyEntity();
				replyEntity.setEmail(reply.getEmail());
				replyEntity.setReplyDesc(reply.getReplyDesc());
				replyEntity.setTweetId(reply.getTweetId());
				replyEntity.setDate(reply.getDate());
				replyEntityList.add(replyEntity);
			});
			userTweets.setReply(replyList);
			userTweetsList.add(userTweets);
		});
    return repository.findByEmail(email);
	}

	public void updateUser(ApplicationUser user) {

		userRepository.save(user);
	}



	
}
