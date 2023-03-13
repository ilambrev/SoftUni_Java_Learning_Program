package softuni.exam.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PassengerSimpleDTO {

    @XmlElement(name = "email")
    @NotNull
    @Pattern(regexp = "^(.+)@(.+)\\.(.+)$")
    private String email;

    public PassengerSimpleDTO() {

    }

    public PassengerSimpleDTO(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}