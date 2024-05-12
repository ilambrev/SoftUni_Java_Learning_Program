package bg.softuni.L01LinkedOut.model.entity;

import bg.softuni.L01LinkedOut.model.еnums.EducationLevelEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class EmployeeEntity extends BaseEntity {

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "education_level", nullable = false)
    private EducationLevelEnum educationLevel;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "salary", nullable = false)
    private BigDecimal salary;

    @ManyToOne(targetEntity = CompanyEntity.class)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private CompanyEntity company;

    public EmployeeEntity() {

    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public EmployeeEntity setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public EducationLevelEnum getEducationLevel() {
        return educationLevel;
    }

    public EmployeeEntity setEducationLevel(EducationLevelEnum educationLevel) {
        this.educationLevel = educationLevel;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public EmployeeEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public EmployeeEntity setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public EmployeeEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public EmployeeEntity setSalary(BigDecimal salary) {
        this.salary = salary;
        return this;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public EmployeeEntity setCompany(CompanyEntity company) {
        this.company = company;
        return this;
    }
}