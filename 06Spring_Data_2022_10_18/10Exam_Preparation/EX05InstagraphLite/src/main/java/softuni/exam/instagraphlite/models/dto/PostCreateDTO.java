package softuni.exam.instagraphlite.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PostCreateDTO {

    @XmlElement(name = "caption")
    @NotNull
    @Size(min = 21)
    private String caption;

    @XmlElement(name = "user")
    @NotNull
    private UserSimpleDTO user;

    @XmlElement(name = "picture")
    @NotNull
    private PictureSimpleDTO picture;

    public PostCreateDTO() {

    }

    public PostCreateDTO(String caption, UserSimpleDTO user, PictureSimpleDTO picture) {
        this.caption = caption;
        this.user = user;
        this.picture = picture;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public UserSimpleDTO getUser() {
        return user;
    }

    public void setUser(UserSimpleDTO user) {
        this.user = user;
    }

    public PictureSimpleDTO getPicture() {
        return picture;
    }

    public void setPicture(PictureSimpleDTO picture) {
        this.picture = picture;
    }

}