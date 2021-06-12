package com.tweeter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.tweeter.model.Reply;


@Repository
public interface ReplyRepository extends JpaRepository<Reply,Integer> {
	
	List<Reply> findByTweetId(Integer tweetId);

}
