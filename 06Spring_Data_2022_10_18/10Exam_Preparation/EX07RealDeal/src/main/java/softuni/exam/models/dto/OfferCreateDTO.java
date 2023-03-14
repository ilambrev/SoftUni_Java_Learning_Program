package softuni.exam.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class OfferCreateDTO {

    @XmlElement(name = "price")
    @NotNull
    @Positive
    private BigDecimal price;

    @XmlElement(name = "description")
    @NotNull
    @Size(min = 5)
    private String description;

    @XmlElement(name = "has-gold-status")
    @NotNull
    private boolean hasGoldStatus;

    @XmlElement(name = "added-on")
    @NotNull
    private String addedOn;

    @XmlElement(name = "car")
    private CarSimpleDTO car;

    @XmlElement(name = "seller")
    private SellerSimpleDTO seller;

    public OfferCreateDTO() {

    }

    public OfferCreateDTO(BigDecimal price, String description, boolean hasGoldStatus, String addedOn,
                          CarSimpleDTO car, SellerSimpleDTO seller) {
        this.price = price;
        this.description = description;
        this.hasGoldStatus = hasGoldStatus;
        this.addedOn = addedOn;
        this.car = car;
        this.seller = seller;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isHasGoldStatus() {
        return hasGoldStatus;
    }

    public void setHasGoldStatus(boolean hasGoldStatus) {
        this.hasGoldStatus = hasGoldStatus;
    }

    public String getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(String addedOn) {
        this.addedOn = addedOn;
    }

    public CarSimpleDTO getCar() {
        return car;
    }

    public void setCar(CarSimpleDTO car) {
        this.car = car;
    }

    public SellerSimpleDTO getSeller() {
        return seller;
    }

    public void setSeller(SellerSimpleDTO seller) {
        this.seller = seller;
    }

}