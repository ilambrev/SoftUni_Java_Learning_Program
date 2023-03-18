package softuni.exam.models.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task extends BaseEntity {

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @ManyToOne(targetEntity = Part.class, optional = false)
    @JoinColumn(name = "parts_id", referencedColumnName = "id")
    private Part part;

    @ManyToOne(targetEntity = Mechanic.class, optional = false)
    @JoinColumn(name = "mechanic_id", referencedColumnName = "id")
    private Mechanic mechanic;

    @ManyToOne(targetEntity = Car.class, optional = false)
    @JoinColumn(name = "cars_id", referencedColumnName = "id")
    private Car car;

    public Task() {
        super();
    }

    public Task(BigDecimal price, LocalDateTime date, Part part, Mechanic mechanic, Car car) {
        this.price = price;
        this.date = date;
        this.part = part;
        this.mechanic = mechanic;
        this.car = car;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

}