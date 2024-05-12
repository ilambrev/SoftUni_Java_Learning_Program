package bg.softuni.L01LinkedOut.model.dto;

import bg.softuni.L01LinkedOut.model.еnums.EducationLevelEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeDetailsDTO {

    private String firstName;

    private String lastName;

    private EducationLevelEnum educationLevel;

    private String jobTitle;

    private LocalDate birthDate;

    private BigDecimal salary;

    private String companyName;

    public EmployeeDetailsDTO() {

    }

    public String getFirstName() {
        return firstName;
    }

    public EmployeeDetailsDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public EmployeeDetailsDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public EducationLevelEnum getEducationLevel() {
        return educationLevel;
    }

    public EmployeeDetailsDTO setEducationLevel(EducationLevelEnum educationLevel) {
        this.educationLevel = educationLevel;
        return this;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public EmployeeDetailsDTO setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public EmployeeDetailsDTO setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public EmployeeDetailsDTO setSalary(BigDecimal salary) {
        this.salary = salary;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public EmployeeDetailsDTO setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }
}