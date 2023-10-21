package com.dictionaryapp.validation.validator;

import com.dictionaryapp.service.UserService;
import com.dictionaryapp.validation.annotation.EmailUniqueValue;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

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