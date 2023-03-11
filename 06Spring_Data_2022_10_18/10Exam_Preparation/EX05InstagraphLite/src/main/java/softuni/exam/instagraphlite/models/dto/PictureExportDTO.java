package softuni.exam.instagraphlite.models.dto;

public class PictureExportDTO {

    private String path;

    private double size;

    public PictureExportDTO() {

    }

    public PictureExportDTO(String path, double size) {
        this.path = path;
        this.size = size;
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

    @Override
    public String toString() {
        return String.format("%.2f - %s", this.size, this.path);
    }

}