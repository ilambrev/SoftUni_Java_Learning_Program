package exam.model.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class ShopCreateDTO {

    @XmlElement(name = "address")
    @NotNull
    @Size(min = 4)
    private String address;

    @XmlElement(name = "employee-count")
    @NotNull
    @Max(50)
    @Min(1)
    private int employeeCount;

    @XmlElement(name = "income")
    @NotNull
    @Min(20000)
    private BigDecimal income;

    @XmlElement(name = "name")
    @NotNull
    @Size(min = 4)
    private String name;

    @XmlElement(name = "shop-area")
    @NotNull
    @Min(150)
    private int shoArea;

    @XmlElement(name = "town")
    @NotNull
    private TownSimpleDTO town;

    public ShopCreateDTO() {

    }

    public ShopCreateDTO(String address, int employeeCount, BigDecimal income, String name, int shoArea, TownSimpleDTO town) {
        this.address = address;
        this.employeeCount = employeeCount;
        this.income = income;
        this.name = name;
        this.shoArea = shoArea;
        this.town = town;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShoArea() {
        return shoArea;
    }

    public void setShoArea(int shoArea) {
        this.shoArea = shoArea;
    }

    public TownSimpleDTO getTown() {
        return town;
    }

    public void setTown(TownSimpleDTO town) {
        this.town = town;
    }

}