package com.likebookapp.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "posts")
public class Post extends BaseEntity {

    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(targetEntity = Mood.class)
    @JoinColumn(name = "mood_id", referencedColumnName = "id")
    private Mood mood;

    @ManyToMany(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinTable(name = "posts_likes", joinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    private Set<User> userLikes;

    public Post() {
        this.userLikes = new HashSet<>();
    }

    public String getContent() {
        return content;
    }

    public Post setContent(String content) {
        this.content = content;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Post setUser(User user) {
        this.user = user;
        return this;
    }

    public Mood getMood() {
        return mood;
    }

    public Post setMood(Mood mood) {
        this.mood = mood;
        return this;
    }

    public Set<User> getUserLikes() {
        return userLikes;
    }

    public Post setUserLikes(Set<User> userLikes) {
        this.userLikes = userLikes;
        return this;
    }

}