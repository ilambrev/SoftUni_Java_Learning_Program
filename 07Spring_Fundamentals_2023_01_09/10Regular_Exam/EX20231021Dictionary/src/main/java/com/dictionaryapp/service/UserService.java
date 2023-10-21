package com.dictionaryapp.service;

import com.dictionaryapp.model.dto.UserLoginDTO;
import com.dictionaryapp.model.dto.UserRegistrationDTO;
import com.dictionaryapp.model.entity.User;

public interface UserService {

    void registerUser(UserRegistrationDTO userRegistrationDTO);

    boolean loginUser(UserLoginDTO userLoginDTO);

    User getUserById(Long id);

    void logoutUser();

    boolean checkIfUsernameExists(String username);

    boolean checkIfEmailExists(String email);

}
