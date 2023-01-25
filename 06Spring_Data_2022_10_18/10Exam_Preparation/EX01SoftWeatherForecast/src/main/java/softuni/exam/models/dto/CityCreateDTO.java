package softuni.exam.models.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CityCreateDTO {

    @NotNull
    @Size(min = 2, max = 60)
    private String cityName;

    @Size(min = 2)
    private String description;

    @NotNull
    @Min(500)
    private int population;

    @NotNull
    private long country;

    public CityCreateDTO() {

    }

    public CityCreateDTO(String cityName, String description, int population, long country) {
        this.cityName = cityName;
        this.description = description;
        this.population = population;
        this.country = country;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public long getCountry() {
        return country;
    }

    public void setCountry(long country) {
        this.country = country;
    }

}