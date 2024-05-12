package bg.softuni.L01LinkedOut.model.dto;

import bg.softuni.L01LinkedOut.model.еnums.EducationLevelEnum;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeCreateDTO {

    @NotBlank(message = "First name is required.")
    @Size(min = 2, message = "First name must be at least 2 characters.")
    private String firstName;

    @NotBlank(message = "Last name is required.")
    @Size(min = 2, message = "Last name must be at least 2 characters.")
    private String lastName;

    @NotNull(message = "Education Level is required.")
    private EducationLevelEnum educationLevel;

    @NotBlank(message = "Company is required.")
    private String companyName;

    @NotBlank(message = "Job title is required.")
    private String jobTitle;

    @NotNull(message = "Birth date is required.")
    @PastOrPresent(message = "Birth date can not be in the future.")
    private LocalDate birthDate;

    @NotNull(message = "Salary is required.")
    @Positive(message = "Salary mut be positive number.")
    private BigDecimal salary;

    public EmployeeCreateDTO() {

    }

    public String getFirstName() {
        return firstName;
    }

    public EmployeeCreateDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public EmployeeCreateDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public EducationLevelEnum getEducationLevel() {
        return educationLevel;
    }

    public EmployeeCreateDTO setEducationLevel(EducationLevelEnum educationLevel) {
        this.educationLevel = educationLevel;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public EmployeeCreateDTO setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public EmployeeCreateDTO setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public EmployeeCreateDTO setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public EmployeeCreateDTO setSalary(BigDecimal salary) {
        this.salary = salary;
        return this;
    }
}