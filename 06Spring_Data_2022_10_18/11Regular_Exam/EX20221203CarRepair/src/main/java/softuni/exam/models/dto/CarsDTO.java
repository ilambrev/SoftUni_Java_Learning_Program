package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "cars")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarsDTO {

    @XmlElement(name = "car")
    private List<CarCreateDTO> cars;

    public CarsDTO() {
        this.cars = new ArrayList<>();
    }

    public CarsDTO(List<CarCreateDTO> cars) {
        this();

        this.cars = cars;
    }

    public List<CarCreateDTO> getCars() {
        return cars;
    }

    public void setCars(List<CarCreateDTO> cars) {
        this.cars = cars;
    }

}