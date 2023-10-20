package com.likebookapp.service.impl;

import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.enums.MoodEnum;
import com.likebookapp.repository.MoodRepository;
import com.likebookapp.service.MoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoodServiceImpl implements MoodService {

    private final MoodRepository moodRepository;

    @Autowired
    public MoodServiceImpl(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }

    @Override
    public Mood getMoodByName(MoodEnum name) {
        return this.moodRepository.findByName(name);
    }

}