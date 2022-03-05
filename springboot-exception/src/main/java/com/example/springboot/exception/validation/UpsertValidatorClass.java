package com.example.springboot.exception.validation;

import com.example.springboot.exception.util.UserValidationUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UpsertValidatorClass implements ConstraintValidator<UniqueUser,Object> {

    private String field;
    private String message;
    private String id;
    @Override
    public void initialize(UniqueUser constraintAnnotation) {
        this.field = constraintAnnotation.field();
        this.message = constraintAnnotation.message();
        this.id = constraintAnnotation.id();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return UserValidationUtil.checkUser(field, message,o,id);
    }

}
