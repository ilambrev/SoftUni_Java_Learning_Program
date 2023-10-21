package com.dictionaryapp.validation.annotation;

import com.dictionaryapp.validation.validator.EmailUniqueValueValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = EmailUniqueValueValidator.class)
public @interface EmailUniqueValue {

    String message() default "Email already exists!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}