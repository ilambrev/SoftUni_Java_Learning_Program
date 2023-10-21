package com.dictionaryapp.repo;

import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.model.enums.LanguageName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {

    List<Word> findAllByLanguageName(LanguageName name);

}