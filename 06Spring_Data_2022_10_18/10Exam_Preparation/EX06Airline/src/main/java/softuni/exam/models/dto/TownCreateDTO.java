package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class TownCreateDTO {

    @Expose
    @NotNull
    @Size(min = 2)
    private String name;

    @Expose
    @NotNull
    @Positive
    private int population;

    @Expose
    @NotNull
    private String guide;

    public TownCreateDTO() {

    }

    public TownCreateDTO(String name, int population, String guide) {
        this.name = name;
        this.population = population;
        this.guide = guide;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

}