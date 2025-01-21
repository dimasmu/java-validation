package com.example.java.validation.constraint;

import com.example.java.validation.enums.CaseMode;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {CheckCaseValidator.class})
@Documented
public @interface CheckCase {

    CaseMode mode();

    String message() default "invalid case format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
