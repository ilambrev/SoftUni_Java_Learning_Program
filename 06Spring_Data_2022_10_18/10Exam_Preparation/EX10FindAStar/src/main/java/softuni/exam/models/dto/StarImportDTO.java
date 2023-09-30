package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class StarImportDTO {

    @Expose
    @NotNull
    @Length(min = 2, max = 30)
    private String name;

    @Expose
    @NotNull
    @Positive(message = "The distance from Earth in light years. Accepts only positive number.")
    private Double lightYears;

    @Expose
    @NotNull
    @Length(min = 6)
    private String description;

    @Expose
    @NotNull
    @Enumerated(EnumType.STRING)
    private String starType;

    @Expose
    @NotNull
    private Long constellation;

    public StarImportDTO() {

    }

    public StarImportDTO(String name, Double lightYears, String description, String starType, Long constellation) {
        this.name = name;
        this.lightYears = lightYears;
        this.description = description;
        this.starType = starType;
        this.constellation = constellation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLightYears() {
        return lightYears;
    }

    public void setLightYears(Double lightYears) {
        this.lightYears = lightYears;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStarType() {
        return starType;
    }

    public void setStarType(String starType) {
        this.starType = starType;
    }

    public Long getConstellation() {
        return constellation;
    }

    public void setConstellation(Long constellation) {
        this.constellation = constellation;
    }

}