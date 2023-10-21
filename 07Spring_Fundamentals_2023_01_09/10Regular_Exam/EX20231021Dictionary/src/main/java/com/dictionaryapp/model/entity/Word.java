package com.dictionaryapp.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "words")
public class Word extends BaseEntity {

    @Column(name = "term", nullable = false)
    private String term;

    @Column(name = "translation", nullable = false)
    private String translation;

    @Column(name = "example", columnDefinition = "TEXT")
    private String example;

    @Column(name = "input_date", nullable = false)
    private LocalDate inputDate;

    @ManyToOne(targetEntity = Language.class)
    @JoinColumn(name = "language_id", referencedColumnName = "id")
    private Language language;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "added_by_id", referencedColumnName = "id")
    private User addedBy;

    public Word() {

    }

    public String getTerm() {
        return term;
    }

    public Word setTerm(String term) {
        this.term = term;
        return this;
    }

    public String getTranslation() {
        return translation;
    }

    public Word setTranslation(String translation) {
        this.translation = translation;
        return this;
    }

    public String getExample() {
        return example;
    }

    public Word setExample(String example) {
        this.example = example;
        return this;
    }

    public LocalDate getInputDate() {
        return inputDate;
    }

    public Word setInputDate(LocalDate inputDate) {
        this.inputDate = inputDate;
        return this;
    }

    public Language getLanguage() {
        return language;
    }

    public Word setLanguage(Language language) {
        this.language = language;
        return this;
    }

    public User getAddedBy() {
        return addedBy;
    }

    public Word setAddedBy(User addedBy) {
        this.addedBy = addedBy;
        return this;
    }

}