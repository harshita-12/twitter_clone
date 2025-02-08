package com.twitterclone;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.twitterclone.model.Tweet;
import com.twitterclone.model.User;
import com.twitterclone.repository.TweetRepository;
import com.twitterclone.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories
public class TwitterCloneApplication {
    public static void main(String[] args) {
        SpringApplication.run(TwitterCloneApplication.class, args);
        System.out.println("Twitter Clone is running...");
    }

    
 @Bean
    CommandLineRunner initData(UserRepository userRepository, TweetRepository tweetRepository) {
        return args -> {
            // Check if data already exists to avoid duplicates
            if (userRepository.count() == 0) {
                User user1 = new User("test_user22", "password123", "female");
                userRepository.save(user1);

                tweetRepository.save(new Tweet(user1, "Hello, Twitter Clone!", null));
                tweetRepository.save(new Tweet(user1, "Another test tweet!", null));

                System.out.println("✅ Test data inserted successfully!");
            } else {
                System.out.println("✅ Test data already exists.");
            }
        };
    }
}
