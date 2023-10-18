package com.plannerapp.service.impl;

import com.plannerapp.model.dto.UserLoginDTO;
import com.plannerapp.model.dto.UserRegistrationDTO;
import com.plannerapp.model.entity.User;
import com.plannerapp.repo.UserRepository;
import com.plannerapp.service.UserService;
import com.plannerapp.util.CurrentUser;
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
    public User getUserById(Long id) {

        return this.userRepository.getById(id);
    }

    @Override
    public boolean registerUser(UserRegistrationDTO userRegistrationDTO) {

        User user = new User()
                .setUsername(userRegistrationDTO.getUsername())
                .setEmail(userRegistrationDTO.getEmail())
                .setPassword(this.passwordEncoder.encode(userRegistrationDTO.getPassword()));

        this.userRepository.save(user);

        return true;
    }

    @Override
    public boolean loginUser(UserLoginDTO userLoginDTO) {

        Optional<User> userOptional = this.userRepository.findFirstByUsername(userLoginDTO.getUsername());

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
    public void logoutUser() {
        this.currentUser.logout();
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