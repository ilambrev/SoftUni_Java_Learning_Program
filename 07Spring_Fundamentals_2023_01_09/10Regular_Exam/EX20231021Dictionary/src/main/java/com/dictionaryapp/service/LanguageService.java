package com.dictionaryapp.service;

import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.enums.LanguageName;

public interface LanguageService {

    Language getLanguageByName(LanguageName name);

}