package bg.softuni.ex20230218reseller.models.entities;

import bg.softuni.ex20230218reseller.models.enums.ConditionNameEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "conditions")
public class ConditionEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "condition_name", nullable = false, unique = true)
    private ConditionNameEnum conditionName;

    @Column(name = "description", nullable = false)
    private String description;

    public ConditionEntity() {
    }

    public ConditionEntity(ConditionNameEnum conditionName) {
        this.conditionName = conditionName;
    }

    public ConditionNameEnum getConditionName() {
        return conditionName;
    }

    public void setConditionName(ConditionNameEnum conditionName) {
        this.conditionName = conditionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}