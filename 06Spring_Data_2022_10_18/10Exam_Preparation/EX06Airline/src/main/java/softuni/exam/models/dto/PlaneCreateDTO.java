package softuni.exam.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PlaneCreateDTO {

    @XmlElement(name = "register-number")
    @NotNull
    @Size(min = 5)
    private String registerNumber;

    @XmlElement(name = "capacity")
    @NotNull
    @Positive
    private int capacity;

    @XmlElement(name = "airline")
    @NotNull
    @Size(min = 2)
    private String airline;

    public PlaneCreateDTO() {

    }

    public PlaneCreateDTO(String registerNumber, int capacity, String airline) {
        this.registerNumber = registerNumber;
        this.capacity = capacity;
        this.airline = airline;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

}