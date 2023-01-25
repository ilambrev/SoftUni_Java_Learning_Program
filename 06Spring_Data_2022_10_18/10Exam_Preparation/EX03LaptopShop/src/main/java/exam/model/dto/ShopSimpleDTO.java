package exam.model.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ShopSimpleDTO {

    @Expose
    @NotNull
    @Size(min = 4)
    private String name;

    public ShopSimpleDTO() {

    }

    public ShopSimpleDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}