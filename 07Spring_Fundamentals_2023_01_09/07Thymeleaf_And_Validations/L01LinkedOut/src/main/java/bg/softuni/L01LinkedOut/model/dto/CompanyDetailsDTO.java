package bg.softuni.L01LinkedOut.model.dto;

import java.math.BigDecimal;

public class CompanyDetailsDTO {

    private Long id;

    private String name;

    private String town;

    private String description;

    private BigDecimal budget;

    public CompanyDetailsDTO() {

    }

    public Long getId() {
        return id;
    }

    public CompanyDetailsDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CompanyDetailsDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getTown() {
        return town;
    }

    public CompanyDetailsDTO setTown(String town) {
        this.town = town;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CompanyDetailsDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public CompanyDetailsDTO setBudget(BigDecimal budget) {
        this.budget = budget;
        return this;
    }
}