package com.hakkinenT.vetClinic.dto.validators.zipCode;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ZipCodeValidator implements ConstraintValidator<ZipCode, String> {

    @Override
    public void initialize(ZipCode constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String zipCodeValue, ConstraintValidatorContext context) {
        return zipCodeValue.length() == 8 && zipCodeValue.matches("[0-9]+");
    }
}
