package bg.softuni.ex20230218reseller.repositories;

import bg.softuni.ex20230218reseller.models.entities.ConditionEntity;
import bg.softuni.ex20230218reseller.models.enums.ConditionNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditionRepository extends JpaRepository<ConditionEntity, Long> {

    ConditionEntity findFirstByConditionName(ConditionNameEnum conditionName);

}