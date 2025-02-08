package com.twitterclone.controller;

import com.twitterclone.model.Tweet;
import com.twitterclone.model.User;
import com.twitterclone.service.TweetService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TweetController {
    @Autowired
    private TweetService tweetService;

    // Show Home Page with Tweets
    @GetMapping("/home")
    public String showHomePage(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/auth/login";
        }

        List<Tweet> tweets = tweetService.getAllTweets();
        model.addAttribute("tweets", tweets);
        model.addAttribute("user", user);
        return "home";
    }

    // Post a Tweet
    @PostMapping("/tweet")
    public String postTweet(@RequestParam String content, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            tweetService.postTweet(user, content);
        }
        return "redirect:/home";
    }

    // Retweet
    @GetMapping("/retweet/{id}")
    public String retweet(@PathVariable Long id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            tweetService.retweet(user, id);
        }
        return "redirect:/home";
    }
}
