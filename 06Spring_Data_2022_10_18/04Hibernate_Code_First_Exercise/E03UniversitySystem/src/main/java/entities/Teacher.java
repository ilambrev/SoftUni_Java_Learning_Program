package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "teachers")
public class Teacher extends Person{

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "salary_per_hour", nullable = false)
    private float salaryPerHour;

    @OneToMany(targetEntity = Course.class, mappedBy = "teacher")
    private Set<Course> courses;

    public Teacher() {
        super();
    }

}