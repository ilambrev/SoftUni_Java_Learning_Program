package softuni.exam.models.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@XmlAccessorType(XmlAccessType.FIELD)
public class TicketCreateDTO {

    @XmlElement(name = "serial-number")
    @NotNull
    @Pattern(regexp = "^([ a-zA-Z0-9]+)$")
    @Size(min = 2)
    private String serialNumber;

    @XmlElement(name = "price")
    @NotNull
    @Positive
    private BigDecimal price;

    @XmlElement(name = "take-off")
    @NotNull
    private String takeOff;

    @XmlElement(name = "from-town")
    @NotNull
    private TownSimpleDTO fromTown;

    @XmlElement(name = "to-town")
    @NotNull
    private TownSimpleDTO toTown;

    @XmlElement(name = "passenger")
    @NotNull
    private PassengerSimpleDTO passenger;

    @XmlElement(name = "plane")
    @NotNull
    private PlaneSimpleDTO plane;

    public TicketCreateDTO() {

    }

    public TicketCreateDTO(String serialNumber, BigDecimal price, String takeOff, TownSimpleDTO fromTown,
                           TownSimpleDTO toTown, PassengerSimpleDTO passenger, PlaneSimpleDTO plane) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.takeOff = takeOff;
        this.fromTown = fromTown;
        this.toTown = toTown;
        this.passenger = passenger;
        this.plane = plane;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTakeOff() {
        return takeOff;
    }

    public void setTakeOff(String takeOff) {
        this.takeOff = takeOff;
    }

    public TownSimpleDTO getFromTown() {
        return fromTown;
    }

    public void setFromTown(TownSimpleDTO fromTown) {
        this.fromTown = fromTown;
    }

    public TownSimpleDTO getToTown() {
        return toTown;
    }

    public void setToTown(TownSimpleDTO toTown) {
        this.toTown = toTown;
    }

    public PassengerSimpleDTO getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerSimpleDTO passenger) {
        this.passenger = passenger;
    }

    public PlaneSimpleDTO getPlane() {
        return plane;
    }

    public void setPlane(PlaneSimpleDTO plane) {
        this.plane = plane;
    }

}