package bg.softuni.ex20230218reseller.models.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @ManyToMany(targetEntity = OfferEntity.class, fetch = FetchType.EAGER)
    @JoinTable(name = "seller_offers", joinColumns = @JoinColumn(name = "seller_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "offer_id", referencedColumnName = "id"))
    private Set<OfferEntity> offers;

    @ManyToMany(targetEntity = OfferEntity.class, fetch = FetchType.EAGER)
    @JoinTable(name = "buyers_offers", joinColumns = @JoinColumn(name = "buyer_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "offer_id", referencedColumnName = "id"))
    private Set<OfferEntity> boughtOffers;

    public UserEntity() {
        this.offers = new HashSet<>();
        this.boughtOffers = new HashSet<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<OfferEntity> getOffers() {
        return offers;
    }

    public void setOffers(Set<OfferEntity> offers) {
        this.offers = offers;
    }

    public Set<OfferEntity> getBoughtOffers() {
        return boughtOffers;
    }

    public void setBoughtOffers(Set<OfferEntity> boughtOffers) {
        this.boughtOffers = boughtOffers;
    }

}