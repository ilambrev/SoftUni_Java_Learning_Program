package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.dto.WordCreateDTO;
import com.dictionaryapp.model.dto.WordDTO;
import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.model.enums.LanguageName;
import com.dictionaryapp.repo.WordRepository;
import com.dictionaryapp.service.LanguageService;
import com.dictionaryapp.service.UserService;
import com.dictionaryapp.service.WordService;
import com.dictionaryapp.util.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordServiceImpl implements WordService {

    private final UserService userService;
    private final LanguageService languageService;
    private final WordRepository wordRepository;
    private final CurrentUser currentUser;

    @Autowired
    public WordServiceImpl(UserService userService, LanguageService languageService, WordRepository wordRepository, CurrentUser currentUser) {
        this.userService = userService;
        this.languageService = languageService;
        this.wordRepository = wordRepository;
        this.currentUser = currentUser;
    }

    @Override
    public void addWord(WordCreateDTO wordCreateDTO) {

        User user = this.userService.getUserById(currentUser.getId());
        Language language = this.languageService.getLanguageByName(wordCreateDTO.getLanguage());

        Word word = new Word().setTerm(wordCreateDTO.getTerm())
                .setTranslation(wordCreateDTO.getTranslation())
                .setExample(wordCreateDTO.getExample())
                .setInputDate(wordCreateDTO.getInputDate())
                .setLanguage(language)
                .setAddedBy(user);

        this.wordRepository.save(word);
    }

    @Override
    public void deleteAllWords() {

        this.wordRepository.deleteAll();
    }

    @Override
    public List<WordDTO> findAllWordsByLanguage(LanguageName name) {

        return this.wordRepository.findAllByLanguageName(name)
                .stream()
                .map(word -> new WordDTO().setTerm(word.getTerm())
                        .setId(word.getId())
                        .setTranslation(word.getTranslation())
                        .setExample(word.getExample())
                        .setInputDate(word.getInputDate())
                        .setLanguage(word.getLanguage().getName().name())
                        .setUsername(word.getAddedBy().getUsername())).toList();
    }

    @Override
    public void deleteWordById(Long id) {
        this.wordRepository.findById(id).ifPresent(this.wordRepository::delete);
    }

}