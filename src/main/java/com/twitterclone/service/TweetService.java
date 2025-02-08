package com.twitterclone.service;

import com.twitterclone.model.Tweet;
import com.twitterclone.model.User;
import com.twitterclone.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TweetService {
    @Autowired
    private TweetRepository tweetRepository;

    public void postTweet(User user, String content) {
        tweetRepository.save(new Tweet(user, content, null));
    }

    public void retweet(User user, Long originalTweetId) {
        tweetRepository.save(new Tweet(user, "Retweeted", originalTweetId));
    }

    public List<Tweet> getAllTweets() {
        return tweetRepository.findByOrderByTimestampDesc();
    }

    public List<Tweet> getUserTweets(User user) {
        return tweetRepository.findByUserOrderByTimestampDesc(user);
    }
    
}
