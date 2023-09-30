package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "astronomers")
@XmlAccessorType(XmlAccessType.FIELD)
public class AstronomersDTO {

    @XmlElement(name = "astronomer")
    List<AstronomerImportDTO> astronomers;

    public AstronomersDTO() {
        this.astronomers = new ArrayList<>();
    }

    public AstronomersDTO(List<AstronomerImportDTO> astronomers) {
        this.astronomers = astronomers;
    }

    public List<AstronomerImportDTO> getAstronomers() {
        return astronomers;
    }

    public void setAstronomers(List<AstronomerImportDTO> astronomers) {
        this.astronomers = astronomers;
    }

}