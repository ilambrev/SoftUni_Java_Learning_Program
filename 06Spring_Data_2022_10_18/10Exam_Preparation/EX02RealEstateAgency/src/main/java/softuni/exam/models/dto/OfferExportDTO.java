package softuni.exam.models.dto;

import java.math.BigDecimal;

public class OfferExportDTO {

    private String agentFirstName;

    private String agentLastName;

    private long offerId;

    private double apartmentArea;

    private String apartmentTownName;

    private BigDecimal price;

    public OfferExportDTO() {

    }

    public OfferExportDTO(String agentFirstName, String agentLastName, long offerId, double apartmentArea, String apartmentTownName, BigDecimal price) {
        this.agentFirstName = agentFirstName;
        this.agentLastName = agentLastName;
        this.offerId = offerId;
        this.apartmentArea = apartmentArea;
        this.apartmentTownName = apartmentTownName;
        this.price = price;
    }

    public String getAgentFirstName() {
        return agentFirstName;
    }

    public void setAgentFirstName(String agentFirstName) {
        this.agentFirstName = agentFirstName;
    }

    public String getAgentLastName() {
        return agentLastName;
    }

    public void setAgentLastName(String agentLastName) {
        this.agentLastName = agentLastName;
    }

    public long getOfferId() {
        return offerId;
    }

    public void setOfferId(long offerId) {
        this.offerId = offerId;
    }

    public double getApartmentArea() {
        return apartmentArea;
    }

    public void setApartmentArea(double apartmentArea) {
        this.apartmentArea = apartmentArea;
    }

    public String getApartmentTownName() {
        return apartmentTownName;
    }

    public void setApartmentTownName(String apartmentTownName) {
        this.apartmentTownName = apartmentTownName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return (String.format("Agent %s %s with offer №%d:", this.agentFirstName, this.agentLastName, this.offerId) + System.lineSeparator() +
                String.format(" -Apartment area: %.2f", this.apartmentArea) + System.lineSeparator() +
                String.format(" --Town: %s", this.apartmentTownName) + System.lineSeparator() +
                String.format(" ---Price: %.2f$", this.price.doubleValue()) + System.lineSeparator()).trim();
    }

}