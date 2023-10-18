package com.plannerapp.vallidation.validator;

import com.plannerapp.service.UserService;
import com.plannerapp.vallidation.annotation.UsernameUniqueValue;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

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