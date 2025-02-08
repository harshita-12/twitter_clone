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
@RequestMapping("/profile")
public class ProfilePageController {
    @Autowired
    private TweetService tweetService;

    @GetMapping
    public String showProfilePage(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/auth/login";
        }

        List<Tweet> userTweets = tweetService.getUserTweets(user);
        model.addAttribute("tweets", userTweets);
        model.addAttribute("user", user);
        return "profile";
    }
}
