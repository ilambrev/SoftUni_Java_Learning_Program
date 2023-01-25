package exam.model.dto;

import com.google.gson.annotations.Expose;
import exam.constant.WarrantyTypes;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import java.math.BigDecimal;

public class LaptopCreateDTO {

    @Expose
    @NotNull
    @Size(min = 8)
    private String macAddress;

    @Expose
    @NotNull
    @Positive
    private double cpuSpeed;

    @Expose
    @NotNull
    @Max(128)
    @Min(8)
    private int ram;

    @Expose
    @NotNull
    @Max(1024)
    @Min(128)
    private int storage;

    @Expose
    @NotNull
    @Size(min = 10)
    private String description;

    @Expose
    @NotNull
    @Positive
    private BigDecimal price;

    @Expose
    @NotNull
    @Enumerated(EnumType.STRING)
    private WarrantyTypes warrantyType;

    @Expose
    @NotNull
    private ShopSimpleDTO shop;

    public LaptopCreateDTO() {

    }

    public LaptopCreateDTO(String macAddress, double cpuSpeed, int ram, int storage, String description,
                           BigDecimal price, WarrantyTypes warrantyType, ShopSimpleDTO shop) {
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

    public ShopSimpleDTO getShop() {
        return shop;
    }

    public void setShop(ShopSimpleDTO shop) {
        this.shop = shop;
    }

}