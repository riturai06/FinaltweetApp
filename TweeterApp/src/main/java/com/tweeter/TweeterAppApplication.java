package com.tweeter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@Configuration
@CrossOrigin("*")
@SpringBootApplication
public class TweeterAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TweeterAppApplication.class, args);
	}

}
