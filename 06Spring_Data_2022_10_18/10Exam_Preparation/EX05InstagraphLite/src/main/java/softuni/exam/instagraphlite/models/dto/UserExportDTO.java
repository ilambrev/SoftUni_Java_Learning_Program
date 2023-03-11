package softuni.exam.instagraphlite.models.dto;

import java.util.ArrayList;
import java.util.List;

public class UserExportDTO {

    private String username;

    private List<PostExportDTO> posts;

    public UserExportDTO() {
        this.posts = new ArrayList<>();
    }

    public UserExportDTO(String username, List<PostExportDTO> posts) {
        this();

        this.username = username;
        this.posts = posts;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<PostExportDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostExportDTO> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {

        StringBuilder userdata = new StringBuilder();

        userdata.append(String.format("User: %s", this.username)).append(System.lineSeparator());
        userdata.append(String.format("Post count: %d", this.posts.size())).append(System.lineSeparator());

        posts.forEach(p -> userdata.append(p.toString()));

        return userdata.toString().trim();
    }
}