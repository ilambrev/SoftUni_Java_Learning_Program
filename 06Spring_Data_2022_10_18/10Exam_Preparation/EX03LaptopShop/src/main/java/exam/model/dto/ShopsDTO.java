package exam.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "shops")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShopsDTO {

    @XmlElement(name = "shop")
    private List<ShopCreateDTO> shops;

    public ShopsDTO() {
        this.shops = new ArrayList<>();
    }

    public ShopsDTO(List<ShopCreateDTO> shops) {
        this.shops = shops;
    }

    public List<ShopCreateDTO> getShops() {
        return shops;
    }

    public void setShops(List<ShopCreateDTO> shops) {
        this.shops = shops;
    }

}