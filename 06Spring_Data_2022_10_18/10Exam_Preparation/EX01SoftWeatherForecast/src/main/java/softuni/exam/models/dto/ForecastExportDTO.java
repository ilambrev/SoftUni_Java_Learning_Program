package softuni.exam.models.dto;

import java.time.LocalTime;

public class ForecastExportDTO {

    private String cityName;

    private double minTemperature;

    private double maxTemperature;

    private LocalTime sunrise;

    private LocalTime sunset;

    public ForecastExportDTO() {

    }

    public ForecastExportDTO(String cityName, double minTemperature, double maxTemperature, LocalTime sunrise, LocalTime sunset) {
        this.cityName = cityName;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public LocalTime getSunrise() {
        return sunrise;
    }

    public void setSunrise(LocalTime sunrise) {
        this.sunrise = sunrise;
    }

    public LocalTime getSunset() {
        return sunset;
    }

    public void setSunset(LocalTime sunset) {
        this.sunset = sunset;
    }

    public String toString() {
        return (String.format("City: %s", this.cityName) + System.lineSeparator() +
                String.format("-min temperature: %.2f", this.minTemperature) + System.lineSeparator() +
                String.format("--max temperature: %.2f", this.maxTemperature) + System.lineSeparator() +
                String.format("---sunrise: %s", this.sunrise.toString()) + System.lineSeparator() +
                String.format("----sunset: %s", this.sunset.toString())).trim();
    }

}