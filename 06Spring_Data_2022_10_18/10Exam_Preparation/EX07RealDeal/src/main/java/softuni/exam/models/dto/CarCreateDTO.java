package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class CarCreateDTO {

    @Expose
    @NotNull
    @Size(min = 2, max = 19)
    private String make;

    @Expose
    @NotNull
    @Size(min = 2, max = 19)
    private String model;

    @Expose
    @NotNull
    @Positive
    private int kilometers;

    @Expose
    @NotNull
    private String registeredOn;

    public CarCreateDTO() {

    }

    public CarCreateDTO(String make, String model, int kilometers, String registeredOn) {
        this.make = make;
        this.model = model;
        this.kilometers = kilometers;
        this.registeredOn = registeredOn;
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

    public String getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(String registeredOn) {
        this.registeredOn = registeredOn;
    }

}