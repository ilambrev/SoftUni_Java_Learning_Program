package com.likebookapp.model.entity;

import com.likebookapp.model.enums.MoodEnum;

import javax.persistence.*;

@Entity
@Table(name = "moods")
public class Mood extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name="name", unique = true, nullable = false)
    private MoodEnum name;

    @Column(name = "description")
    private String description;

    public Mood() {

    }

    public MoodEnum getName() {
        return name;
    }

    public Mood setName(MoodEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Mood setDescription(String description) {
        this.description = description;
        return this;
    }

}