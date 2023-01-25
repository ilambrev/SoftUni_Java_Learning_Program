package softuni.exam.models.entity;

import softuni.exam.constants.ApartmentType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "apartments")
public class Apartment extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "apartment_type", nullable = false)
    private ApartmentType apartmentType;

    @Column(name = "area", nullable = false)
    private double area;

    @ManyToOne(targetEntity = Town.class, optional = false)
    @JoinColumn(name = "town_id", referencedColumnName = "id")
    private Town town;

    @OneToMany(targetEntity = Offer.class, mappedBy = "apartment", fetch = FetchType.EAGER)
    private Set<Offer> offers;

    public Apartment() {
        super();

        this.offers = new HashSet<>();
    }

    public Apartment(ApartmentType apartmentType, double area, Town town, Set<Offer> offers) {
        this();

        this.apartmentType = apartmentType;
        this.area = area;
        this.town = town;
        this.offers = offers;
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

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }

}