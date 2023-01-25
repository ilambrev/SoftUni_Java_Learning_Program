package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "apartments")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApartmentsDTO implements Serializable {

    @XmlElement(name = "apartment")
    List<ApartmentCreateDTO> apartments;

    public ApartmentsDTO() {
        this.apartments = new ArrayList<>();
    }

    public ApartmentsDTO(List<ApartmentCreateDTO> apartments) {
        this.apartments = apartments;
    }

    public List<ApartmentCreateDTO> getApartments() {
        return apartments;
    }

    public void setApartments(List<ApartmentCreateDTO> apartments) {
        this.apartments = apartments;
    }

}