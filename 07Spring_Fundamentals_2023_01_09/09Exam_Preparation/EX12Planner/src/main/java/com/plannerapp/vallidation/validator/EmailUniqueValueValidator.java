package com.plannerapp.vallidation.validator;

import com.plannerapp.service.UserService;
import com.plannerapp.vallidation.annotation.EmailUniqueValue;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailUniqueValueValidator implements ConstraintValidator<EmailUniqueValue, String> {

    private final UserService userService;

    public EmailUniqueValueValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null) {
            return true;
        }

        return this.userService.checkIfEmailExists(value);
    }

}