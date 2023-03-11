package softuni.exam.instagraphlite.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.PostCreateDTO;
import softuni.exam.instagraphlite.models.dto.PostsDTO;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.models.entity.Post;
import softuni.exam.instagraphlite.models.entity.User;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.PostRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.PostService;
import softuni.exam.instagraphlite.util.DataFromFile;
import softuni.exam.instagraphlite.util.ValidationUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.util.Optional;

import static softuni.exam.instagraphlite.constants.FilePaths.POSTS_XML_PATH;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final PictureRepository pictureRepository;
    private final UserRepository userRepository;
    private final DataFromFile dataFromFile;
    private final ValidationUtil validationUtil;

    private final ModelMapper modelMapper;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, PictureRepository pictureRepository,
                           UserRepository userRepository, DataFromFile dataFromFile, ValidationUtil validationUtil,
                           ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.pictureRepository = pictureRepository;
        this.userRepository = userRepository;
        this.dataFromFile = dataFromFile;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.postRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return this.dataFromFile.read(POSTS_XML_PATH);
    }

    @Override
    public String importPosts() throws IOException, JAXBException {

        StringBuilder messages = new StringBuilder();

        JAXBContext jaxbContext = JAXBContext.newInstance(PostsDTO.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        StringReader reader = new StringReader(readFromFileContent());

        PostsDTO postDTOs = (PostsDTO) unmarshaller.unmarshal(reader);

        for (PostCreateDTO postDTO : postDTOs.getPosts()) {

            if (this.validationUtil.isValid(postDTO)) {

                Optional<Picture> pictureOptional = this.pictureRepository.findByPath(postDTO.getPicture().getPath());

                Optional<User> userOptional = this.userRepository.findByUsername(postDTO.getUser().getUsername());

                if (pictureOptional.isPresent() && userOptional.isPresent()) {

                    Picture picture = pictureOptional.get();
                    User user = userOptional.get();
                    Post post = this.modelMapper.map(postDTO, Post.class);
                    post.setPicture(picture);
                    post.setUser(user);
                    messages.append(String.format("Successfully imported Post, made by %s",
                            post.getUser().getUsername())).append(System.lineSeparator());

                    this.postRepository.saveAndFlush(post);

                } else {
                    messages.append("Invalid Post").append(System.lineSeparator());
                }
            } else {
                messages.append("Invalid Post").append(System.lineSeparator());
            }
        }

        return messages.toString().trim();
    }

}