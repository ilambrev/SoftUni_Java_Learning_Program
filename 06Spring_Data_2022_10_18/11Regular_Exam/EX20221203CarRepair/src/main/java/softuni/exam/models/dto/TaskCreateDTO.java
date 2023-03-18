package softuni.exam.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class TaskCreateDTO {

    @XmlElement(name = "price")
    @NotNull
    @Positive
    private BigDecimal price;

    @XmlElement(name = "date")
    @NotNull
    private String date;

    @XmlElement(name = "car")
    @NotNull
    private CarSimpleDTO car;

    @XmlElement(name = "mechanic")
    @NotNull
    private MechanicSimpleDTO mechanic;

    @XmlElement(name = "part")
    @NotNull
    private PartSimpleDTO part;

    public TaskCreateDTO() {

    }

    public TaskCreateDTO(BigDecimal price, String date, CarSimpleDTO car, MechanicSimpleDTO mechanic, PartSimpleDTO part) {
        this.price = price;
        this.date = date;
        this.car = car;
        this.mechanic = mechanic;
        this.part = part;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public CarSimpleDTO getCar() {
        return car;
    }

    public void setCar(CarSimpleDTO car) {
        this.car = car;
    }

    public MechanicSimpleDTO getMechanic() {
        return mechanic;
    }

    public void setMechanic(MechanicSimpleDTO mechanic) {
        this.mechanic = mechanic;
    }

    public PartSimpleDTO getPart() {
        return part;
    }

    public void setPart(PartSimpleDTO part) {
        this.part = part;
    }

}