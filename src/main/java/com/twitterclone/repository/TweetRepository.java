package com.twitterclone.repository;

import com.twitterclone.model.Tweet;
import com.twitterclone.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {
    List<Tweet> findByOrderByTimestampDesc(); // Get tweets in descending order

    List<Tweet> findByUserOrderByTimestampDesc(User user);

}
