package com.dictionaryapp.model.dto;

import com.dictionaryapp.model.enums.LanguageName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class WordCreateDTO {

    @NotNull
    @Size(min = 2, max = 40, message = "The term length must be between 2 and 40 characters!")
    private String term;

    @Size(min = 2, max = 80, message = "The translation length must be between 2 and 80 characters!")
    private String translation;

    @NotNull
    @Size(min = 2, max = 200, message = "The example length must be between 2 and 200 characters!")
    private String example;

    @NotNull(message = "You must select input date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "The input date must be in the past or present!")
    private LocalDate inputDate;

    @NotNull(message = "You must select a language!")
    private LanguageName language;

    public WordCreateDTO() {

    }

    public String getTerm() {
        return term;
    }

    public WordCreateDTO setTerm(String term) {
        this.term = term;
        return this;
    }

    public String getTranslation() {
        return translation;
    }

    public WordCreateDTO setTranslation(String translation) {
        this.translation = translation;
        return this;
    }

    public String getExample() {
        return example;
    }

    public WordCreateDTO setExample(String example) {
        this.example = example;
        return this;
    }

    public LocalDate getInputDate() {
        return inputDate;
    }

    public WordCreateDTO setInputDate(LocalDate inputDate) {
        this.inputDate = inputDate;
        return this;
    }

    public LanguageName getLanguage() {
        return language;
    }

    public WordCreateDTO setLanguage(LanguageName language) {
        this.language = language;
        return this;
    }

}