package com.tweeter.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tweeter.model.Tweet;


@Repository
public interface TweetRepository extends JpaRepository<Tweet, Integer> {

	public List<Tweet> findByRecordActive(char recordActive);

	public List<Tweet> findByEmail(String email);
	

}
