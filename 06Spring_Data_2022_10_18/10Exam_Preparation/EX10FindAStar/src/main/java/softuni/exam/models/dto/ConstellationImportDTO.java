package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class ConstellationImportDTO {

    @Expose
    @NotNull
    @Length(min = 3, max = 20)
    private String name;

    @Expose
    @NotNull
    @Length(min = 5)
    private String description;

    public ConstellationImportDTO() {

    }

    public ConstellationImportDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}