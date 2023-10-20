package com.likebookapp.service;

import com.likebookapp.model.dto.UserLoginDTO;
import com.likebookapp.model.dto.UserRegistrationDTO;
import com.likebookapp.model.entity.User;

public interface UserService {

    boolean registerUser(UserRegistrationDTO userRegistrationDTO);

    boolean loginUser(UserLoginDTO userLoginDTO);

    void logOutUser();

    User getUserById(Long id);

    boolean checkIfUsernameExists(String username);

    boolean checkIfEmailExists(String email);

}