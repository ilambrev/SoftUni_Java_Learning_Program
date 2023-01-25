package softuni.exam.models.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cities")
public class City extends BaseEntity {

    @Column(name = "city_name", nullable = false, unique = true)
    private String cityName;

    @Column(name = "description", columnDefinition = "Text")
    private String description;

    @Column(name = "population", nullable = false)
    private int population;

    @ManyToOne(optional = false)
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;

    @OneToMany(targetEntity = Forecast.class, mappedBy = "city", fetch = FetchType.EAGER)
    private Set<Forecast> forecasts;

    public City() {
        super();

        this.forecasts = new HashSet<>();
    }

    public City(String cityName, String description, int population, Country country, Set<Forecast> forecasts) {
        this();

        this.cityName = cityName;
        this.description = description;
        this.population = population;
        this.country = country;
        this.forecasts = forecasts;
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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<Forecast> getForecasts() {
        return forecasts;
    }

    public void setForecasts(Set<Forecast> forecasts) {
        this.forecasts = forecasts;
    }

}