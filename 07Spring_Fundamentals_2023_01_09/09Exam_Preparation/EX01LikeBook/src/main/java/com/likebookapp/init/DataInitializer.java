package com.likebookapp.init;

import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.enums.MoodEnum;
import com.likebookapp.repository.MoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final MoodRepository moodRepository;

    @Autowired
    public DataInitializer(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (this.moodRepository.count() == 0) {
            List<Mood> moods = Arrays.stream(MoodEnum.values())
                    .map(value -> new Mood().setName(value))
                    .toList();

            moods.get(0).setDescription("Feeling, showing, or causing pleasure or satisfaction");
            moods.get(1).setDescription("Showing, feeling, or causing unhappiness or regret");
            moods.get(2).setDescription("Feeling of being mentally stimulated to manifest what we want to create");

            this.moodRepository.saveAll(moods);

        }

    }

}