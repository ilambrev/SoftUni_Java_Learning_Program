package softuni.exam.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "offer")
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferCreateDTO {

    @XmlElement(name = "price")
    @NotNull
    @Positive
    public BigDecimal price;

    @XmlElement(name = "agent")
    @NotNull
    public AgentSimpleDTO agent;

    @XmlElement(name = "apartment")
    @NotNull
    public ApartmentSimpleDTO apartment;

    @XmlElement(name = "publishedOn")
    @NotNull
    public String publishedOn;

    public OfferCreateDTO() {

    }

    public OfferCreateDTO(BigDecimal price, AgentSimpleDTO agent, ApartmentSimpleDTO apartment, String publishedOn) {
        this.price = price;
        this.agent = agent;
        this.apartment = apartment;
        this.publishedOn = publishedOn;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public AgentSimpleDTO getAgent() {
        return agent;
    }

    public void setAgent(AgentSimpleDTO agent) {
        this.agent = agent;
    }

    public ApartmentSimpleDTO getApartment() {
        return apartment;
    }

    public void setApartment(ApartmentSimpleDTO apartment) {
        this.apartment = apartment;
    }

    public String getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(String publishedOn) {
        this.publishedOn = publishedOn;
    }

}