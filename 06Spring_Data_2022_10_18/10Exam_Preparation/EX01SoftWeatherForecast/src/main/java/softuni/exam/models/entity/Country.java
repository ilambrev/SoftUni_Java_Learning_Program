package softuni.exam.models.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "countries")
public class Country extends BaseEntity {

    @Column(name = "country_name", nullable = false, unique = true)
    private String countryName;

    @Column(name = "currency", nullable = false)
    private String currency;

    @OneToMany(targetEntity = City.class, mappedBy = "country", fetch = FetchType.EAGER)
    private Set<City> cities;

    public Country() {
        super();

        this.cities = new HashSet<>();
    }

    public Country(String countryName, String currency, Set<City> cities) {
        this();

        this.countryName = countryName;
        this.currency = currency;
        this.cities = cities;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Set<City> getCities() {
        return cities;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

}