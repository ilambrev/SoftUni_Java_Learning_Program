package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "planes")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlanesDTO {

    @XmlElement(name = "plane")
    private List<PlaneCreateDTO> planes;

    public PlanesDTO() {

    }

    public PlanesDTO(List<PlaneCreateDTO> planes) {
        this.planes = planes;
    }

    public List<PlaneCreateDTO> getPlanes() {
        return planes;
    }

    public void setPlanes(List<PlaneCreateDTO> planes) {
        this.planes = planes;
    }

}