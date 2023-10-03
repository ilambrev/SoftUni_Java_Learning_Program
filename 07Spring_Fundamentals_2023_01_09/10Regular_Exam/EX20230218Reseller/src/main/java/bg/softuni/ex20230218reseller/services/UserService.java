package bg.softuni.ex20230218reseller.services;

import bg.softuni.ex20230218reseller.models.dtos.OfferDTO;
import bg.softuni.ex20230218reseller.models.dtos.UserLoginDTO;
import bg.softuni.ex20230218reseller.models.dtos.UserRegisterDTO;
import bg.softuni.ex20230218reseller.models.entities.UserEntity;
import bg.softuni.ex20230218reseller.repositories.UserRepository;
import bg.softuni.ex20230218reseller.session.LoggedUser;
import jakarta.servlet.http.HttpSession;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final LoggedUser loggedUser;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final HttpSession httpSession;

    @Autowired
    public UserService(UserRepository userRepository, LoggedUser loggedUser, ModelMapper modelMapper, PasswordEncoder passwordEncoder, HttpSession httpSession) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.httpSession = httpSession;
    }

    public boolean register(UserRegisterDTO userRegisterDTO) {

        if (!userRegisterDTO.getPassword().equals(userRegisterDTO.getConfirmPassword())) {
            return false;
        }

        if (this.userRepository.findFirstByUsername(userRegisterDTO.getUsername()).isPresent()) {
            return false;
        }

        if (this.userRepository.findFirstByEmail(userRegisterDTO.getEmail()).isPresent()) {
            return false;
        }

        UserEntity newUser = this.modelMapper.map(userRegisterDTO, UserEntity.class);

        String encodedPassword = this.passwordEncoder.encode(userRegisterDTO.getPassword());

        newUser.setPassword(encodedPassword);

        this.userRepository.saveAndFlush(newUser);

        return true;
    }

    public boolean login(UserLoginDTO userLoginDTO) {

        Optional<UserEntity> user = this.userRepository.findFirstByUsername(userLoginDTO.getUsername());

        if (user.isEmpty()) {
            return false;
        }

        if (!this.passwordEncoder.matches(userLoginDTO.getPassword(), user.get().getPassword())) {
            return false;
        }

        this.loggedUser.login(user.get());

        return true;

    }

    public boolean isUserLogged() {
        return this.loggedUser.getId() != null && this.loggedUser.getId() > 0;
    }

    public UserEntity getLoggedUser() {

        return this.userRepository.findById(this.loggedUser.getId()).orElse(null);
    }

    public List<OfferDTO> getUserOffers() {

        UserEntity user = getLoggedUser();

        return user.getOffers().stream().map(o -> this.modelMapper.map(o, OfferDTO.class)).toList();
    }

    public List<OfferDTO> getUsersBoughtOffers() {

        UserEntity user = getLoggedUser();

        return user.getBoughtOffers().stream().map(o -> this.modelMapper.map(o, OfferDTO.class)).toList();
    }

    public void logout() {
        this.httpSession.invalidate();
        this.loggedUser.logout();
    }

    public UserEntity getUserById(Long id) {

        return this.userRepository.findById(id).orElse(null);
    }

}