package com.dictionaryapp.model.dto;

import com.dictionaryapp.validation.annotation.EmailUniqueValue;
import com.dictionaryapp.validation.annotation.PasswordMatching;
import com.dictionaryapp.validation.annotation.UsernameUniqueValue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@PasswordMatching(
        password = "password",
        confirmPassword = "confirmPassword",
        message = "Password and Confirm Password must be matched!"
)
public class UserRegistrationDTO {

    @NotNull
    @UsernameUniqueValue
    @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 characters!")
    private String username;

    @NotNull
    @NotBlank(message = "Email can not be empty!")
    @EmailUniqueValue
    @Email
    private String email;

    @NotNull
    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters!")
    private String password;

    @NotNull
    @Size(min = 3, max = 20)
    private String confirmPassword;

    public UserRegistrationDTO() {

    }

    public String getUsername() {
        return username;
    }

    public UserRegistrationDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegistrationDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegistrationDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegistrationDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

}