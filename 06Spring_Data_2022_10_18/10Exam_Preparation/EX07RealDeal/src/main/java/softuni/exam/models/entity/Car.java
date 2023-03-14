package softuni.exam.models.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {

    @Column(name = "make", nullable = false)
    private String make;

    @Column(name = "model", nullable = false)
    private String model;

    @Column(name = "kilometers", nullable = false)
    private int kilometers;

    @Column(name = "registered_on", nullable = false)
    private LocalDate registeredOn;

    @OneToMany(targetEntity = Picture.class, mappedBy = "car", fetch = FetchType.EAGER)
    private Set<Picture> pictures;

    public Car() {
        super();

        this.pictures = new HashSet<>();
    }

    public Car(String make, String model, int kilometers, LocalDate registeredOn, Set<Picture> pictures) {
        this();

        this.make = make;
        this.model = model;
        this.kilometers = kilometers;
        this.registeredOn = registeredOn;
        this.pictures = pictures;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public LocalDate getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(LocalDate registeredOn) {
        this.registeredOn = registeredOn;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }

}