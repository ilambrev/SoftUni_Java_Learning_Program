package softuni.exam.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AgentCreateDTO {

    @NotNull
    @Size(min = 2)
    private String firstName;

    @NotNull
    @Size(min = 2)
    private String lastName;

    @NotNull
    @Size(min = 2)
    private String town;

    @NotNull
    @Pattern(regexp = "^(.+)@(.+)\\.(.+)$")
    private String email;

    public AgentCreateDTO() {

    }

    public AgentCreateDTO(String firstName, String lastName, String town, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.town = town;
        this.email = email;
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

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}