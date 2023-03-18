package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.*;

public class PartCreateDTO {

    @Expose
    @NotNull
    @Size(min = 2, max = 19)
    private String partName;

    @Expose
    @NotNull
    @Max(2000)
    @Min(10)
    private double price;

    @Expose
    @NotNull
    @Positive
    private int quantity;

    public PartCreateDTO() {

    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}