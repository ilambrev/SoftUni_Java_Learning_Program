package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "offers")
@XmlAccessorType(XmlAccessType.FIELD)
public class OffersDTO {

    @XmlElement(name = "offer")
    private List<OfferCreateDTO> offers;

    public OffersDTO() {
        this.offers = new ArrayList<>();
    }

    public OffersDTO(List<OfferCreateDTO> offers) {
        this();

        this.offers = offers;
    }

    public List<OfferCreateDTO> getOffers() {
        return offers;
    }

    public void setOffers(List<OfferCreateDTO> offers) {
        this.offers = offers;
    }

}