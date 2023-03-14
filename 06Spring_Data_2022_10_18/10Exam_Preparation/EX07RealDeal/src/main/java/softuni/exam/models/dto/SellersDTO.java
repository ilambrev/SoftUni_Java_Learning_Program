package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "sellers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SellersDTO {

    @XmlElement(name = "seller")
    private List<SellerCreateDTO> sellers;

    public SellersDTO() {
        this.sellers = new ArrayList<>();
    }

    public SellersDTO(List<SellerCreateDTO> sellers) {
        this.sellers = sellers;
    }

    public List<SellerCreateDTO> getSellers() {
        return sellers;
    }

    public void setSellers(List<SellerCreateDTO> sellers) {
        this.sellers = sellers;
    }

}