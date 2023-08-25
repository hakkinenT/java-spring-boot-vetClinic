package com.hakkinenT.vetClinic.dto.validators.zipCode;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ZipCodeValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ZipCode {
    String message() default "Informe um CEP válido.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
