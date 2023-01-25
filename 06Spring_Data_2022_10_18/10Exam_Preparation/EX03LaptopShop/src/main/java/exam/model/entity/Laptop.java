package exam.model.entity;

import exam.constant.WarrantyTypes;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "laptops")
public class Laptop extends BaseEntity {

    @Column(name = "mac_address", nullable = false, unique = true)
    private String macAddress;

    @Column(name = "cpu_speed", nullable = false)
    private double cpuSpeed;

    @Column(name = "ram", nullable = false)
    private int ram;

    @Column(name = "storage", nullable = false)
    private int storage;

    @Column(name = "description", nullable = false, columnDefinition = "Text")
    private String description;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "warranty_type")
    private WarrantyTypes warrantyType;

    @ManyToOne(targetEntity = Shop.class, optional = false)
    @JoinColumn(name = "shop_id", referencedColumnName = "id")
    private Shop shop;

    public Laptop() {
        super();
    }

    public Laptop(String macAddress, double cpuSpeed, int ram, int storage, String description, BigDecimal price, WarrantyTypes warrantyType, Shop shop) {
        this();

        this.macAddress = macAddress;
        this.cpuSpeed = cpuSpeed;
        this.ram = ram;
        this.storage = storage;
        this.description = description;
        this.price = price;
        this.warrantyType = warrantyType;
        this.shop = shop;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public double getCpuSpeed() {
        return cpuSpeed;
    }

    public void setCpuSpeed(double cpuSpeed) {
        this.cpuSpeed = cpuSpeed;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public WarrantyTypes getWarrantyType() {
        return warrantyType;
    }

    public void setWarrantyType(WarrantyTypes warrantyType) {
        this.warrantyType = warrantyType;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

}