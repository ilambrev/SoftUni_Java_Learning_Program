package com.likebookapp.service.impl;

import com.likebookapp.model.dto.UserLoginDTO;
import com.likebookapp.model.dto.UserRegistrationDTO;
import com.likebookapp.model.entity.User;
import com.likebookapp.repository.UserRepository;
import com.likebookapp.service.UserService;
import com.likebookapp.util.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }

    @Override
    public boolean registerUser(UserRegistrationDTO userRegistrationDTO) {

        if (!userRegistrationDTO.getPassword().equals(userRegistrationDTO.getConfirmPassword())) {
            return false;
        }

        Optional<User> userOptional = this.userRepository.findByUsernameOrEmail(userRegistrationDTO.getUsername(), userRegistrationDTO.getEmail());

        if (userOptional.isPresent()) {
            return false;
        }

        User user = new User().setUsername(userRegistrationDTO.getUsername())
                .setPassword(this.passwordEncoder.encode(userRegistrationDTO.getPassword()))
                .setEmail(userRegistrationDTO.getEmail());

        this.userRepository.save(user);

        return true;
    }

    @Override
    public boolean loginUser(UserLoginDTO userLoginDTO) {

        Optional<User> userOptional = this.userRepository.findByUsername(userLoginDTO.getUsername());

        if (userOptional.isEmpty()) {
            return false;
        }

        User user = userOptional.get();

        if (!this.passwordEncoder.matches(userLoginDTO.getPassword(), user.getPassword())) {
            return false;
        }

        this.currentUser.setId(user.getId())
                .setUsername(user.getUsername())
                .setLogged(true);

        return true;
    }

    @Override
    public void logOutUser() {
        this.currentUser.logout();
    }

    @Override
    public User getUserById(Long id) {

        return this.userRepository.findById(id).orElse(null);
    }

    @Override
    public boolean checkIfUsernameExists(String username) {
        return this.userRepository.findFirstByUsername(username).isEmpty();
    }

    @Override
    public boolean checkIfEmailExists(String email) {
        return this.userRepository.findFirstByEmail(email).isEmpty();
    }

}