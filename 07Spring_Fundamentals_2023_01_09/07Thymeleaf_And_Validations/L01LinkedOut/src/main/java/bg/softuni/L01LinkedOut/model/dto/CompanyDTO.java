package bg.softuni.L01LinkedOut.model.dto;

public class CompanyDTO {

    private Long id;

    private String name;

    private String town;

    private String description;

    public CompanyDTO() {

    }

    public Long getId() {
        return id;
    }

    public CompanyDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CompanyDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getTown() {
        return town;
    }

    public CompanyDTO setTown(String town) {
        this.town = town;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CompanyDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}