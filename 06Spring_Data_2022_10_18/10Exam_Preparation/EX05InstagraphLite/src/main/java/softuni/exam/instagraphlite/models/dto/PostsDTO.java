package softuni.exam.instagraphlite.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "posts")
@XmlAccessorType(XmlAccessType.FIELD)
public class PostsDTO {

    @XmlElement(name = "post")
    private List<PostCreateDTO> posts;

    public PostsDTO() {
        this.posts = new ArrayList<>();
    }

    public PostsDTO(List<PostCreateDTO> posts) {
        this();

        this.posts = posts;
    }

    public List<PostCreateDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostCreateDTO> posts) {
        this.posts = posts;
    }

}