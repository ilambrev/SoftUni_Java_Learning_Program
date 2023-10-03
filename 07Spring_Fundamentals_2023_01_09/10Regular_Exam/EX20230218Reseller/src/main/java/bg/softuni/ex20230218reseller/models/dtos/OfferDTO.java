package bg.softuni.ex20230218reseller.models.dtos;

import bg.softuni.ex20230218reseller.models.enums.ConditionNameEnum;

import java.math.BigDecimal;

public class OfferDTO {

    private Long id;

    private ConditionNameEnum conditionName;

    private BigDecimal price;

    private String description;

    private String userUsername;

    public OfferDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ConditionNameEnum getConditionName() {
        return conditionName;
    }

    public void setConditionName(ConditionNameEnum conditionName) {
        this.conditionName = conditionName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

}