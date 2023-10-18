package com.plannerapp.init;

import com.plannerapp.model.entity.Priority;
import com.plannerapp.model.enums.PriorityEnum;
import com.plannerapp.repo.PriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DataInitializer implements CommandLineRunner {

    private final PriorityRepository priorityRepository;

    @Autowired
    public DataInitializer(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (this.priorityRepository.count() == 0) {

            List<Priority> priorities = Arrays.stream(PriorityEnum.values())
                    .map(Priority::new)
                    .collect(Collectors.toList());

            priorities.get(0).setDescription("An urgent problem that blocks the system use until the issue is resolved.");
            priorities.get(1).setDescription("A core functionality that your product is explicitly supposed to perform is compromised.");
            priorities.get(2).setDescription("Should be fixed if time permits but can be postponed.");

            this.priorityRepository.saveAll(priorities);

        }

    }

}