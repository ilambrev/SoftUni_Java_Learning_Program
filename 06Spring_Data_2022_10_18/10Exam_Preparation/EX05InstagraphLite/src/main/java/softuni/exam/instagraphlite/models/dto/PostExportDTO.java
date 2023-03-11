package softuni.exam.instagraphlite.models.dto;

public class PostExportDTO {

    private String caption;

    private double pictureSize;

    public PostExportDTO() {

    }

    public PostExportDTO(String caption, double pictureSize) {
        this.caption = caption;
        this.pictureSize = pictureSize;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public double getPictureSize() {
        return pictureSize;
    }

    public void setPictureSize(double pictureSize) {
        this.pictureSize = pictureSize;
    }

    @Override
    public String toString() {
        return (String.format("==Post Details:") + System.lineSeparator() +
                String.format("----Caption: %s", this.caption) + System.lineSeparator() +
                String.format("----Picture Size: %.2f", this.pictureSize) + System.lineSeparator());
    }

}