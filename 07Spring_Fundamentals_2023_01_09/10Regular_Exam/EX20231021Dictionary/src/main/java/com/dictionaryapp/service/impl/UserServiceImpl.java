package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.dto.UserLoginDTO;
import com.dictionaryapp.model.dto.UserRegistrationDTO;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.service.UserService;
import com.dictionaryapp.util.CurrentUser;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;
    private final HttpSession httpSession;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, CurrentUser currentUser, HttpSession httpSession) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
        this.httpSession = httpSession;
    }

    @Override
    public void registerUser(UserRegistrationDTO userRegistrationDTO) {

        User user = new User().setUsername(userRegistrationDTO.getUsername())
                .setEmail(userRegistrationDTO.getEmail())
                .setPassword(this.passwordEncoder.encode(userRegistrationDTO.getPassword()));

        this.userRepository.save(user);
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
    public User getUserById(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }

    @Override
    public void logoutUser() {
        this.httpSession.invalidate();
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