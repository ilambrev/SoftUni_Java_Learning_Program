package softuni.exam.models.dto;

import softuni.exam.constants.ApartmentType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ApartmentCreateDTO {

    @XmlElement(name = "apartmentType")
    @NotNull
    @Enumerated(EnumType.STRING)
    private ApartmentType apartmentType;

    @XmlElement(name = "area")
    @NotNull
    @Min(value = 40)
    private double area;

    @XmlElement(name = "town")
    @NotNull
    @Size(min = 2)
    private String town;

    public ApartmentCreateDTO() {

    }

    public ApartmentCreateDTO(ApartmentType apartmentType, double area, String town) {
        this.apartmentType = apartmentType;
        this.area = area;
        this.town = town;
    }

    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(ApartmentType apartmentType) {
        this.apartmentType = apartmentType;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

}