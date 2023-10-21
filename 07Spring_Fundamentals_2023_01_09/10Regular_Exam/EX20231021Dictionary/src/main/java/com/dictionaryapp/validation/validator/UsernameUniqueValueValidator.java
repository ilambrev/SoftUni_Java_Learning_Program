package com.dictionaryapp.validation.validator;

import com.dictionaryapp.service.UserService;
import com.dictionaryapp.validation.annotation.UsernameUniqueValue;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UsernameUniqueValueValidator implements ConstraintValidator<UsernameUniqueValue, String> {

    private final UserService userService;

    public UsernameUniqueValueValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null) {
            return true;
        }

        return this.userService.checkIfUsernameExists(value);
    }

}