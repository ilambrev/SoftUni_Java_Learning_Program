package softuni.exam.models.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "date_and_time", nullable = false)
    private LocalDateTime dateAndTime;

    @ManyToOne(targetEntity = Car.class, optional = false)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;

    public Picture() {
        super();
    }

    public Picture(String name, LocalDateTime dateAndTime, Car car) {
        this();

        this.name = name;
        this.dateAndTime = dateAndTime;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

}