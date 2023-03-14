package softuni.exam.models.dto;

import java.time.LocalDate;

public class CarExportDTO {

    private String make;

    private String model;

    private int kilometers;

    private LocalDate registeredOn;

    private int countOfPictures;

    public CarExportDTO() {

    }

    public CarExportDTO(String make, String model, int kilometers, LocalDate registeredOn, int countOfPictures) {
        this.make = make;
        this.model = model;
        this.kilometers = kilometers;
        this.registeredOn = registeredOn;
        this.countOfPictures = countOfPictures;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public LocalDate getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(LocalDate registeredOn) {
        this.registeredOn = registeredOn;
    }

    public int getCountOfPictures() {
        return countOfPictures;
    }

    public void setCountOfPictures(int countOfPictures) {
        this.countOfPictures = countOfPictures;
    }

    @Override
    public String toString() {
        return String.format("Car make - %s, model - %s", this.make, this.model) + System.lineSeparator() +
                String.format("\tKilometers - %d", this.kilometers) + System.lineSeparator() +
                String.format("\tRegistered on - %s", this.registeredOn) + System.lineSeparator() +
                String.format("\tNumber of pictures - %d", this.countOfPictures) + System.lineSeparator();
    }

}