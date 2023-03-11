package softuni.exam.instagraphlite.models.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false, unique = true)
    private String password;

    @ManyToOne(targetEntity = Picture.class, optional = false)
    @JoinColumn(name = "profile_picture_id", referencedColumnName = "id")
    private Picture profilePicture;

    @OneToMany(targetEntity = Post.class, mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Post> posts;

    public User() {
        super();

        this.posts = new HashSet<>();
    }

    public User(String username, String password, Picture profilePicture, Set<Post> posts) {
        this();

        this.username = username;
        this.password = password;
        this.profilePicture = profilePicture;
        this.posts = posts;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Picture getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(Picture profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

}