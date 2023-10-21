package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.enums.LanguageName;
import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;

    @Autowired
    public LanguageServiceImpl(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public Language getLanguageByName(LanguageName name) {
        return this.languageRepository.findByName(name);
    }

}