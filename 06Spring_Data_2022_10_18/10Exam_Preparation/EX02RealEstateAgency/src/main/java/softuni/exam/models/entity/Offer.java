package softuni.exam.models.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity {

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "published_on", nullable = false)
    private LocalDate publishedOn;

    @ManyToOne(targetEntity = Apartment.class, optional = false)
    @JoinColumn(name = "apartment_id", referencedColumnName = "id")
    private Apartment apartment;

    @ManyToOne(targetEntity = Agent.class, optional = false)
    @JoinColumn(name = "agent_id", referencedColumnName = "id")
    private Agent agent;

    public Offer() {
        super();
    }

    public Offer(BigDecimal price, LocalDate publishedOn, Apartment apartment, Agent agent) {
        this();

        this.price = price;
        this.publishedOn = publishedOn;
        this.apartment = apartment;
        this.agent = agent;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(LocalDate publishedOn) {
        this.publishedOn = publishedOn;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

}