package com.tweeter.controller;

import java.util.List;
import java.util.Map;
import org.apache.naming.java.javaURLContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tweeter.model.ApplicationUser;
import com.tweeter.model.Tweet;
import com.tweeter.serviceImplementation.CustomerServiceImplementation;

import lombok.extern.apachecommons.CommonsLog;



/*
 *  Author - Ritu Bala Rai
 * Project - BankManagement System
 * Duration - 3 Weeks
 * 
 */

/*  1. COMPLETE REST API's 
 *  2. Swagger Implemented
 *  3. Kafka Implemented
 *  4. SECURITY USING JWT
 *  5. JUNIT TESTING
 *  6. VALIDATIONS
 */
@CrossOrigin("*")
@Component
@RestController
@RequestMapping("/api/v1.0/tweets")
public class CustomerController {

	@Autowired
	CustomerServiceImplementation customerService;
	

    // For SignUp of User

	@PostMapping(value = "/register", produces = "application/json")
	public ApplicationUser createUser( @RequestBody ApplicationUser user) {
		ApplicationUser details = customerService.createUser(user);
		//kafkaTemplate.send(topic , "Successfully Register !!" + details );
		return details;

	}
	
	//For Getting All User Details
	
	@GetMapping(value = "/getAllUser", produces = "application/json")
	public List<ApplicationUser> getAllUser() {
		List<ApplicationUser> details = customerService.getAllUser();
		//kafkaTemplate.send(topic , "All Users Details : \n " + details );
		return details;

	}
	
	// Get User Tweets
	
	@GetMapping("/UsersTweet")
	public List<Tweet> getUsersTweet(@RequestParam("email") String email) {
		
		//kafkaTemplate.send(topic , "Welcome" + email + " " + customerService.getUsersTweet(email) );
		return customerService.getUsersTweet(email);
	}
	
	//Search User By Email
	
	@GetMapping("/search/{email}")
	public ApplicationUser getUsersByEmail(@PathVariable("email") String email) {
		// kafkaTemplate.send(topic , "Search Successful!! \n" + " " + "User Details :" + email + " " + customerService.findOne(email) );
		return customerService.findOne(email);
	}
	
	// For Resetting the passwords
	
	@PatchMapping("/reset/{email}")
	public void resetPassword(@PathVariable("email") String email, @RequestBody Map<Object , Object> fields) {
		ApplicationUser user = customerService.findOne(email);
		fields.forEach((k,v)->{
			java.lang.reflect.Field field = ReflectionUtils.findRequiredField(ApplicationUser.class, (String) k);
            field.setAccessible(true);  
            ReflectionUtils.setField(field, user, v);
		});
	//	 kafkaTemplate.send(topic , "Password Reset Successfully" );
		 customerService.updateUser(user);
	}








}
