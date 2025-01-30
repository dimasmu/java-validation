package com.example.java.validation.constraint;

import com.example.java.validation.enums.CaseMode;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {CheckPasswordValidator.class})
public @interface CheckPassword {

    String message() default "Password and retype password must same";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
