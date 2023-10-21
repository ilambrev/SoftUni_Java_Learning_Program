package com.dictionaryapp.model.dto;

import java.time.LocalDate;

public class WordDTO {

    private Long id;

    private String term;

    private String translation;

    private String example;

    private LocalDate inputDate;

    private String language;

    private String username;

    public WordDTO() {

    }

    public Long getId() {
        return id;
    }

    public WordDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTerm() {
        return term;
    }

    public WordDTO setTerm(String term) {
        this.term = term;
        return this;
    }

    public String getTranslation() {
        return translation;
    }

    public WordDTO setTranslation(String translation) {
        this.translation = translation;
        return this;
    }

    public String getExample() {
        return example;
    }

    public WordDTO setExample(String example) {
        this.example = example;
        return this;
    }

    public LocalDate getInputDate() {
        return inputDate;
    }

    public WordDTO setInputDate(LocalDate inputDate) {
        this.inputDate = inputDate;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public WordDTO setLanguage(String language) {
        this.language = language;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public WordDTO setUsername(String username) {
        this.username = username;
        return this;
    }

}