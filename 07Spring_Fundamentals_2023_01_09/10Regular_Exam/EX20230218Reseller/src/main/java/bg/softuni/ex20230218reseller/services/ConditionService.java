package bg.softuni.ex20230218reseller.services;

import bg.softuni.ex20230218reseller.models.entities.ConditionEntity;
import bg.softuni.ex20230218reseller.models.enums.ConditionNameEnum;
import bg.softuni.ex20230218reseller.repositories.ConditionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ConditionService {

    private final ConditionRepository conditionRepository;

    @Autowired
    public ConditionService(ConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
    }


    @PostConstruct
    public void initDb() {
        if (this.conditionRepository.count() == 0) {

            List<ConditionEntity> categories = Arrays.stream(ConditionNameEnum.values())
                    .map(ConditionEntity::new).toList();

            categories.get(0).setDescription("In perfect condition");
            categories.get(1).setDescription("Some signs of wear and tear or minor defects");
            categories.get(2).setDescription("The item is fairly worn but continues to function properly");

            this.conditionRepository.saveAllAndFlush(categories);
        }
    }

    public ConditionEntity getConditionByName(ConditionNameEnum conditionName) {

        return this.conditionRepository.findFirstByConditionName(conditionName);
    }

}