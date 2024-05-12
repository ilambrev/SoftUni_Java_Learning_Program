package bg.softuni.L01LinkedOut.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "companies")
public class CompanyEntity extends BaseEntity {

    @Column(name = "budget", nullable = false)
    private BigDecimal budget;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "town", nullable = false)
    private String town;

    public CompanyEntity() {

    }

    public BigDecimal getBudget() {
        return budget;
    }

    public CompanyEntity setBudget(BigDecimal budget) {
        this.budget = budget;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CompanyEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getName() {
        return name;
    }

    public CompanyEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getTown() {
        return town;
    }

    public CompanyEntity setTown(String town) {
        this.town = town;
        return this;
    }
}