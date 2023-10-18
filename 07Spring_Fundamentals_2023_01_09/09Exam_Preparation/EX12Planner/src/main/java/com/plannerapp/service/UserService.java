package com.plannerapp.service;

import com.plannerapp.model.dto.UserLoginDTO;
import com.plannerapp.model.dto.UserRegistrationDTO;
import com.plannerapp.model.entity.User;

public interface UserService {

    User getUserById(Long id);
    boolean registerUser(UserRegistrationDTO userRegistrationDTO);

    boolean loginUser(UserLoginDTO userLoginDTO);

    void logoutUser();

    boolean checkIfUsernameExists(String username);

    boolean checkIfEmailExists(String email);

}