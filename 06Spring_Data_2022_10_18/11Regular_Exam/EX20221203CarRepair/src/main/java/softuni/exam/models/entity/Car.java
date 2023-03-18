package softuni.exam.models.entity;

import softuni.exam.constants.CarTypes;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "car_type", nullable = false)
    private CarTypes carType;

    @Column(name = "car_make", nullable = false)
    private String carMake;

    @Column(name = "car_model", nullable = false)
    private String carModel;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "plate_number", nullable = false, unique = true)
    private String plateNumber;

    @Column(name = "kilometers", nullable = false)
    private int kilometers;

    @Column(name = "engine", nullable = false)
    private double engine;

    @OneToMany(targetEntity = Task.class, mappedBy = "car")
    private Set<Task> tasks;

    public Car() {
        super();

        this.tasks = new HashSet<>();
    }

    public Car(CarTypes carType, String carMake, String carModel, int year,
               String plateNumber, int kilometers, double engine, Set<Task> tasks) {
        this();

        this.carType = carType;
        this.carMake = carMake;
        this.carModel = carModel;
        this.year = year;
        this.plateNumber = plateNumber;
        this.kilometers = kilometers;
        this.engine = engine;
        this.tasks = tasks;
    }

    public CarTypes getCarType() {
        return carType;
    }

    public void setCarType(CarTypes carType) {
        this.carType = carType;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

}