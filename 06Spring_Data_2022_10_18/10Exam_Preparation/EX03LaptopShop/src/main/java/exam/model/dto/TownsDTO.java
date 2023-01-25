package exam.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "towns")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownsDTO {

    @XmlElement(name = "town")
    private List<TownCreateDTO> towns;

    public TownsDTO() {
        this.towns = new ArrayList<>();
    }

    public TownsDTO(List<TownCreateDTO> towns) {
        this();

        this.towns = towns;
    }

    public List<TownCreateDTO> getTowns() {
        return towns;
    }

    public void setTowns(List<TownCreateDTO> towns) {
        this.towns = towns;
    }

}