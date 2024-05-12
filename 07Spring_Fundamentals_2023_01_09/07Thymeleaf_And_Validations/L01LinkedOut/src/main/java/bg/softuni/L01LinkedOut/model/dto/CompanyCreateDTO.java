package bg.softuni.L01LinkedOut.model.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class CompanyCreateDTO {

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 10, message = "Name length must be between 2 and 10")
    private String name;

    @NotBlank(message = "Town is required")
    @Size(min = 2, max = 10, message = "Town length must be between 2 and 10")
    private String town;

    @NotBlank(message = "Description is required")
    @Size(min = 11, message = "Description length must be more than 10")
    private String description;

    @NotNull(message = "Budget is required.")
    @Positive(message = "Budget must be positive number")
    private BigDecimal budget;

    public CompanyCreateDTO() {

    }

    public String getName() {
        return name;
    }

    public CompanyCreateDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getTown() {
        return town;
    }

    public CompanyCreateDTO setTown(String town) {
        this.town = town;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CompanyCreateDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public CompanyCreateDTO setBudget(BigDecimal budget) {
        this.budget = budget;
        return this;
    }
}