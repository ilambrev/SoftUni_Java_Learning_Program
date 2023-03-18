package softuni.exam.models.dto;

import java.math.BigDecimal;

public class TaskExportDTO {

    private String carMake;

    private String carModel;

    private int carKilometers;

    private String mechanicFirstName;

    private String mechanicLastName;

    private long id;

    private double carEngine;

    private BigDecimal price;

    public TaskExportDTO() {

    }

    public TaskExportDTO(String carMake, String carModel, int carKilometers, String mechanicFirstName,
                         String mechanicLastName, long id, double carEngine, BigDecimal price) {
        this.carMake = carMake;
        this.carModel = carModel;
        this.carKilometers = carKilometers;
        this.mechanicFirstName = mechanicFirstName;
        this.mechanicLastName = mechanicLastName;
        this.id = id;
        this.carEngine = carEngine;
        this.price = price;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getCarKilometers() {
        return carKilometers;
    }

    public void setCarKilometers(int carKilometers) {
        this.carKilometers = carKilometers;
    }

    public String getMechanicFirstName() {
        return mechanicFirstName;
    }

    public void setMechanicFirstName(String mechanicFirstName) {
        this.mechanicFirstName = mechanicFirstName;
    }

    public String getMechanicLastName() {
        return mechanicLastName;
    }

    public void setMechanicLastName(String mechanicLastName) {
        this.mechanicLastName = mechanicLastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getCarEngine() {
        return carEngine;
    }

    public void setCarEngine(double carEngine) {
        this.carEngine = carEngine;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return (String.format("Car %s %s with %dkm", this.carMake, this.carModel, this.carKilometers) + System.lineSeparator() +
                String.format("-Mechanic: %s %s - task №%d:", this.mechanicFirstName, this.mechanicLastName, this.id) + System.lineSeparator() +
                String.format("--Engine: %.1f", this.carEngine) + System.lineSeparator() +
                String.format("---Price: %.2f$", this.price.doubleValue()) + System.lineSeparator()).trim();
    }

}