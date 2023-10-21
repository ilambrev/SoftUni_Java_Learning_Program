package com.dictionaryapp.model.entity;

import com.dictionaryapp.model.enums.LanguageName;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "languages")
public class Language extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "name", unique = true, nullable = false)
    private LanguageName name;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(targetEntity = Word.class, mappedBy = "language")
    private List<Word> words;

    public Language() {
        this.words = new ArrayList<>();
    }

    public Language(LanguageName name) {
        this.name = name;
    }

    public LanguageName getName() {
        return name;
    }

    public Language setName(LanguageName name) {
        this.name = name;
        return this;
    }

    public List<Word> getWords() {
        return words;
    }

    public Language setWords(List<Word> words) {
        this.words = words;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Language setDescription(String description) {
        this.description = description;
        return this;
    }

}
