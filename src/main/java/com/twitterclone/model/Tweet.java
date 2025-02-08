package com.twitterclone.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tweets")
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column
    private String content;

    private LocalDateTime timestamp;

    private Long retweetId; // Stores original tweet ID if it's a retweet

    // Constructors
    public Tweet() {}

    public Tweet(User user, String content, Long retweetId) {
        this.user = user;
        this.content = content;
        this.timestamp = LocalDateTime.now();
        this.retweetId = retweetId;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public Long getRetweetId() { return retweetId; }
    public void setRetweetId(Long retweetId) { this.retweetId = retweetId; }
}
