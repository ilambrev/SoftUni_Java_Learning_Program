package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PictureCreateDTO {

    @Expose
    @NotNull
    @Size(min = 2, max = 19)
    private String name;

    @Expose
    @NotNull
    private String dateAndTime;

    @Expose
    @NotNull
    @Min(1)
    private long car;

    public PictureCreateDTO() {

    }

    public PictureCreateDTO(String name, String dateAndTime, long car) {
        this.name = name;
        this.dateAndTime = dateAndTime;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public long getCar() {
        return car;
    }

    public void setCar(long car) {
        this.car = car;
    }

}