package softuni.exam.instagraphlite.models.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity {

    @Column(name = "path", nullable = false, unique = true)
    private String path;

    @Column(name = "size", nullable = false)
    private double size;

    @OneToMany(targetEntity = User.class, mappedBy = "profilePicture", fetch = FetchType.EAGER)
    private Set<User> users;

    @OneToMany(targetEntity = Post.class, mappedBy = "picture", fetch = FetchType.EAGER)
    private Set<Post> posts;

    public Picture() {
        super();

        this.users = new HashSet<>();
        this.posts = new HashSet<>();
    }

    public Picture(String path, double size, Set<User> users, Set<Post> posts) {
        this();

        this.path = path;
        this.size = size;
        this.users = users;
        this.posts = posts;
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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

}