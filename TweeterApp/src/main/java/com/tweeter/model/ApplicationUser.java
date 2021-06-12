package com.tweeter.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Entity(name = "register")
public class ApplicationUser  {
	
	@Id
	private String email;
	private String firstName;
	private String lastName;
	private String gender;
	private String password;
	private String confirmPassword;
//	@JsonIgnore
	@OneToMany
	private List<Tweet> tweet;
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public String setPassword(String password) {
		return this.password = password;
	}


	public List<Tweet> getTweet() {
		return tweet;
	}

	public void setTweet(List<Tweet> tweet) {
		this.tweet = tweet;
	}

	public ApplicationUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}



	@Override
	public String toString() {
		return "ApplicationUser [ email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", password=" + password + ", confirmPassword=" + confirmPassword + ", tweet="
				+ tweet + "]";
	}

	public ApplicationUser(String firstName, String lastName, String gender, String email, String password,
			String confirmPassword, List<Tweet> tweet) {
		super();
     	
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.tweet = tweet;
	}

	public void setErrorMessage(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setSucessMessage(String string) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
