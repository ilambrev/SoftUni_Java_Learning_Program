package softuni.exam.models.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "agents")
public class Agent extends BaseEntity {

    @Column(name = "first_name", nullable = false, unique = true)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @ManyToOne(targetEntity = Town.class, optional = false)
    @JoinColumn(name = "town_id", referencedColumnName = "id")
    private Town town;

    @OneToMany(targetEntity = Offer.class, mappedBy = "agent", fetch = FetchType.EAGER)
    private Set<Offer> offers;

    public Agent() {
        super();

        this.offers = new HashSet<>();
    }

    public Agent(String firstName, String lastName, String email, Town town, Set<Offer> offers) {
        this();

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.town = town;
        this.offers = offers;
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