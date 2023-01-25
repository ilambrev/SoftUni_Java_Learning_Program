package softuni.exam.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CountryCreateDTO {

    @NotNull
    @Size(min = 2, max = 60)
    private String countryName;

    @NotNull
    @Size(min = 2, max = 20)
    private String currency;

    public CountryCreateDTO() {

    }

    public CountryCreateDTO(String countryName, String currency) {
        this.countryName = countryName;
        this.currency = currency;
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

}