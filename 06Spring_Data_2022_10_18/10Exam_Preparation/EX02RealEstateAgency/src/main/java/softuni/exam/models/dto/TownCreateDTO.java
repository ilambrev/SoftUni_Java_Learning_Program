package softuni.exam.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class TownCreateDTO {

    @NotNull
    @Size(min = 2)
    private String townName;

    @NotNull
    @Positive
    private int population;

    public TownCreateDTO() {

    }

    public TownCreateDTO(String townName, int population) {
        this.townName = townName;
        this.population = population;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

}