package com.tweeter.repository;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.tweeter.model.ApplicationUser;


@Repository
public interface UserRepository extends JpaRepository<ApplicationUser, String>{
	
	
	ApplicationUser findByEmail(String email);

	

	

}
