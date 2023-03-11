package softuni.exam.instagraphlite.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post extends BaseEntity {

    @Column(name = "caption", nullable = false)
    private String caption;

    @ManyToOne(targetEntity = User.class, optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne(targetEntity = Picture.class, optional = false)
    @JoinColumn(name = "picture_id", referencedColumnName = "id")
    private Picture picture;

    public Post() {
        super();
    }

    public Post(String caption, User user, Picture picture) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

}