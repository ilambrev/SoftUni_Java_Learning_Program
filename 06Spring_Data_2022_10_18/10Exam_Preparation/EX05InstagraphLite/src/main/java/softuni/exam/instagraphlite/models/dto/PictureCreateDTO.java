package softuni.exam.instagraphlite.models.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PictureCreateDTO {

    @Expose
    @NotNull
    private String path;

    @Expose
    @NotNull
    @Max(60000)
    @Min(500)
    private double size;

    public PictureCreateDTO() {

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

}