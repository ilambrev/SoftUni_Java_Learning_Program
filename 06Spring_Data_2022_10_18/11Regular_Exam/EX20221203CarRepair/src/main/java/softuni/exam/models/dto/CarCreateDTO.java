package softuni.exam.models.dto;

import softuni.exam.constants.CarTypes;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class CarCreateDTO {

    @XmlElement(name = "carType")
    @NotNull
    @Enumerated(EnumType.STRING)
    private CarTypes carType;

    @XmlElement(name = "carMake")
    @NotNull
    @Size(min = 2, max = 30)
    private String carMake;

    @XmlElement(name = "carModel")
    @NotNull
    @Size(min = 2, max = 30)
    private String carModel;

    @XmlElement(name = "year")
    @NotNull
    @Positive
    private int year;

    @XmlElement(name = "plateNumber")
    @NotNull
    @Size(min = 2, max = 30)
    private String plateNumber;

    @XmlElement(name = "kilometers")
    @NotNull
    @Positive
    private int kilometers;

    @XmlElement(name = "engine")
    @NotNull
    @Min(1)
    private double engine;

    public CarCreateDTO() {

    }

    public CarCreateDTO(CarTypes carType, String carMake, String carModel, int year,
                        String plateNumber, int kilometers, double engine) {
        this.carType = carType;
        this.carMake = carMake;
        this.carModel = carModel;
        this.year = year;
        this.plateNumber = plateNumber;
        this.kilometers = kilometers;
        this.engine = engine;
    }

    public CarTypes getCarType() {
        return carType;
    }

    public void setCarType(CarTypes carType) {
        this.carType = carType;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }

}