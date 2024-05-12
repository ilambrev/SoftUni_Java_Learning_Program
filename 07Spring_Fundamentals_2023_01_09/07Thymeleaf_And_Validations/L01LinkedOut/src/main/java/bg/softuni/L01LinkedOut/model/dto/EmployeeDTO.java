package bg.softuni.L01LinkedOut.model.dto;

import java.time.LocalDate;

public class EmployeeDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String jobTitle;

    private LocalDate birthDate;

    public EmployeeDTO() {

    }

    public Long getId() {
        return id;
    }

    public EmployeeDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public EmployeeDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public EmployeeDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public EmployeeDTO setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public EmployeeDTO setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }
}