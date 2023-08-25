package com.hakkinenT.vetClinic.dto.validators.phone;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {
    @Override
    public void initialize(Phone constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String phoneValue, ConstraintValidatorContext ctx) {
        return ((phoneValue.length() == 10) || (phoneValue.length() == 11)) && phoneValue.matches("[0-9]+");
    }
}
