package com.tweeter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tweeter.model.ApiResponse;
import com.tweeter.model.ApplicationUser;
import com.tweeter.model.AuthToken;
import com.tweeter.serviceImplementation.CustomerServiceImplementation;
import com.tweeter.config.JwtTokenUtil;
import com.tweeter.dto.User;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1.0/tweets")
public class AuthenticationController {

	//FOR LOGIN PURPOSE USING JWT
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;


	@Autowired
	private CustomerServiceImplementation customerService;

	//CONTROLLER FOR GENERATING TOKEN IF USER IS AUTHENTICATED
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ApiResponse<AuthToken> register(@RequestBody User user) throws AuthenticationException {

		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		final ApplicationUser authenticateCustomer = customerService.findOne(user.getUsername());
		final String token = jwtTokenUtil.generateToken(authenticateCustomer);
		System.out.println("user successfully login");
		return new ApiResponse<>(200, "success",
				new AuthToken(token, user.getUsername(), authenticateCustomer.getPassword()));

	}

}
