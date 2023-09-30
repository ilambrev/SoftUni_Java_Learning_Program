package softuni.exam.models.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "astronomers")
public class AstronomerEntity extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "salary", nullable = false)
    private Double salary;

    @Column(name = "average_observation_hours", nullable = false)
    private Double averageObservationHours;

    @Column(name = "birthday")
    private LocalDate birthday;

    @ManyToOne(targetEntity = StarEntity.class)
    @JoinColumn(name = "observing_star_id", referencedColumnName = "id")
    private StarEntity observingStar;

    public AstronomerEntity() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getAverageObservationHours() {
        return averageObservationHours;
    }

    public void setAverageObservationHours(Double averageObservationHours) {
        this.averageObservationHours = averageObservationHours;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public StarEntity getObservingStar() {
        return observingStar;
    }

    public void setObservingStar(StarEntity observingStar) {
        this.observingStar = observingStar;
    }

}