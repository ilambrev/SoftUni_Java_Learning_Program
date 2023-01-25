package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "forecasts")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastsDTO implements Serializable {

    @XmlElement(name = "forecast")
    List<ForecastCreateDTO> forecasts;

    public ForecastsDTO() {
        this.forecasts = new ArrayList<>();
    }

    public ForecastsDTO(List<ForecastCreateDTO> forecasts) {
        this.forecasts = forecasts;
    }

    public List<ForecastCreateDTO> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<ForecastCreateDTO> forecasts) {
        this.forecasts = forecasts;
    }

}