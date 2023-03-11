package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.dto.PostExportDTO;
import softuni.exam.instagraphlite.models.dto.UserCreateDTO;
import softuni.exam.instagraphlite.models.dto.UserExportDTO;
import softuni.exam.instagraphlite.models.entity.Picture;
import softuni.exam.instagraphlite.models.entity.User;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.repository.UserRepository;
import softuni.exam.instagraphlite.service.UserService;
import softuni.exam.instagraphlite.util.DataFromFile;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static softuni.exam.instagraphlite.constants.FilePaths.USERS_JSON_PATH;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PictureRepository pictureRepository;
    private final DataFromFile dataFromFile;
    private final ValidationUtil validationUtil;

    private final Gson gson;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PictureRepository pictureRepository,
                           DataFromFile dataFromFile, ValidationUtil validationUtil, Gson gson, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.pictureRepository = pictureRepository;
        this.dataFromFile = dataFromFile;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.userRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return this.dataFromFile.read(USERS_JSON_PATH);
    }

    @Override
    public String importUsers() throws IOException {

        StringBuilder messages = new StringBuilder();

        UserCreateDTO[] userDTOs = this.gson.fromJson(readFromFileContent(), UserCreateDTO[].class);

        for (UserCreateDTO userDTO : userDTOs) {

            if (this.validationUtil.isValid(userDTO)) {

                Optional<User> optionalUser = this.userRepository.findByUsername(userDTO.getUsername());

                Optional<Picture> pictureOptional = this.pictureRepository.findByPath(userDTO.getProfilePicture());

                if (optionalUser.isEmpty() && pictureOptional.isPresent()) {

                    Picture picture = pictureOptional.get();
                    User user = this.modelMapper.map(userDTO, User.class);
                    user.setProfilePicture(picture);
                    messages.append(String.format("Successfully imported User: %s",
                            user.getUsername())).append(System.lineSeparator());

                    this.userRepository.saveAndFlush(user);

                } else {
                    messages.append("Invalid User").append(System.lineSeparator());
                }
            } else {
                messages.append("Invalid User").append(System.lineSeparator());
            }
        }

        return messages.toString().trim();
    }

    @Override
    public String exportUsersWithTheirPosts() {

        StringBuilder usersWithPosts = new StringBuilder();

        List<UserExportDTO> userDTOs = this.userRepository.findAllByPosts().stream()
                .map(u -> this.modelMapper.map(u, UserExportDTO.class)).toList();

        for(UserExportDTO userDTO : userDTOs) {
            List<PostExportDTO> sortedPosts = userDTO.getPosts().stream()
                    .sorted(Comparator.comparingDouble(PostExportDTO::getPictureSize)).toList();

            userDTO.setPosts(sortedPosts);
        }

        userDTOs.forEach(u -> usersWithPosts.append(u.toString()).append(System.lineSeparator()));

        return usersWithPosts.toString().trim();
    }

}