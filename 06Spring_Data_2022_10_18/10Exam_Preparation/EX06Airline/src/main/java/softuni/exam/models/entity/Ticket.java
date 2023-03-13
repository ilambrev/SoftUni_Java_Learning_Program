package softuni.exam.models.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket extends BaseEntity {

    @Column(name = "serial_number", nullable = false, unique = true)
    private String serialNumber;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "take_off", nullable = false)
    private LocalDateTime takeOff;

    @ManyToOne(targetEntity = Town.class, optional = false)
    @JoinColumn(name = "from_town_id", referencedColumnName = "id")
    private Town fromTown;

    @ManyToOne(targetEntity = Town.class, optional = false)
    @JoinColumn(name = "to_town_id", referencedColumnName = "id")
    private Town toTown;

    @ManyToOne(targetEntity = Passenger.class, optional = false)
    @JoinColumn(name = "passenger_id", referencedColumnName = "id")
    private Passenger passenger;

    @ManyToOne(targetEntity = Plane.class, optional = false)
    @JoinColumn(name = "plane_id", referencedColumnName = "id")
    private Plane plane;

    public Ticket() {
        super();
    }

    public Ticket(String serialNumber, BigDecimal price, LocalDateTime takeOff, Town fromTown, Town toTown, Passenger passenger, Plane plane) {
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

    public LocalDateTime getTakeOff() {
        return takeOff;
    }

    public void setTakeOff(LocalDateTime takeOff) {
        this.takeOff = takeOff;
    }

    public Town getFromTown() {
        return fromTown;
    }

    public void setFromTown(Town fromTown) {
        this.fromTown = fromTown;
    }

    public Town getToTown() {
        return toTown;
    }

    public void setToTown(Town toTown) {
        this.toTown = toTown;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

}