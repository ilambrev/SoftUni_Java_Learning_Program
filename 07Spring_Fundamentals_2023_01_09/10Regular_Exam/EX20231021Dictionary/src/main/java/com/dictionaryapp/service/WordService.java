package com.dictionaryapp.service;

import com.dictionaryapp.model.dto.WordCreateDTO;
import com.dictionaryapp.model.dto.WordDTO;
import com.dictionaryapp.model.enums.LanguageName;

import java.util.List;

public interface WordService {

    void addWord(WordCreateDTO wordCreateDTO);

    void deleteAllWords();

    List<WordDTO> findAllWordsByLanguage(LanguageName name);

    void deleteWordById(Long id);

}