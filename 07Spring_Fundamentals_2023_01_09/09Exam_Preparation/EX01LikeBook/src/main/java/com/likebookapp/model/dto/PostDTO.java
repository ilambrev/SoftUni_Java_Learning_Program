package com.likebookapp.model.dto;

import com.likebookapp.model.enums.MoodEnum;

public class PostDTO {

    private Long id;

    private String content;

    private String username;

    private MoodEnum mood;

    private int likes;

    public PostDTO() {

    }

    public Long getId() {
        return id;
    }

    public PostDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getContent() {
        return content;
    }

    public PostDTO setContent(String content) {
        this.content = content;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public PostDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public MoodEnum getMood() {
        return mood;
    }

    public PostDTO setMood(MoodEnum mood) {
        this.mood = mood;
        return this;
    }

    public int getLikes() {
        return likes;
    }

    public PostDTO setLikes(int likes) {
        this.likes = likes;
        return this;
    }

}