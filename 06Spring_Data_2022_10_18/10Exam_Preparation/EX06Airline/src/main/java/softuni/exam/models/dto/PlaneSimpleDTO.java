package softuni.exam.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PlaneSimpleDTO {

    @XmlElement(name = "register-number")
    @NotNull
    @Size(min = 5)
    private String registerNumber;

    public PlaneSimpleDTO() {

    }

    public PlaneSimpleDTO(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

}