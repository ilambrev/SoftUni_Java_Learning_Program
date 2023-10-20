package com.likebookapp.model.dto;

import com.likebookapp.model.enums.MoodEnum;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PostCreateDTO {

    @NotNull
    @Size(min = 2, max = 150, message = "Content length must be between 2 and 150 characters!")
    private String content;

    @NotNull(message = "You must select a mood!")
    private MoodEnum mood;

    public PostCreateDTO() {

    }

    public String getContent() {
        return content;
    }

    public PostCreateDTO setContent(String content) {
        this.content = content;
        return this;
    }

    public MoodEnum getMood() {
        return mood;
    }

    public PostCreateDTO setMood(MoodEnum mood) {
        this.mood = mood;
        return this;
    }

}