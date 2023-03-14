package softuni.exam.models.dto;

import softuni.exam.constants.Rating;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class SellerCreateDTO {

    @XmlElement(name = "first-name")
    @NotNull
    @Size(min = 2, max = 19)
    private String firstName;

    @XmlElement(name = "last-name")
    @NotNull
    @Size(min = 2, max = 19)
    private String lastName;

    @XmlElement(name = "email")
    @NotNull
    @Pattern(regexp = "^(.+)@(.+)\\.(.+)$")
    private String email;

    @XmlElement(name = "rating")
    @NotNull
    @Enumerated(EnumType.STRING)
    private Rating rating;

    @XmlElement(name = "town")
    @NotNull
    private String town;

    public SellerCreateDTO() {

    }

    public SellerCreateDTO(String firstName, String lastName, String email, Rating rating, String town) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.rating = rating;
        this.town = town;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

}