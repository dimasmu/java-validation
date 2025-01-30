package com.example.java.validation.constraint;


import com.example.java.validation.entities.Register;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CheckPasswordValidator implements ConstraintValidator<CheckPassword, Register> {

    private String messageTemplate;

    @Override
    public void initialize(CheckPassword constraintAnnotation) {
        messageTemplate = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Register register, ConstraintValidatorContext constraintValidatorContext) {

        if (register.getPassword() == null || register.getRetypePassword() == null) {
            return true; // skip validation
        }

        boolean isValid = register.getPassword().equals(register.getRetypePassword());

        if (!isValid) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(messageTemplate).addPropertyNode("password").addConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(messageTemplate).addPropertyNode("retypePassword").addConstraintViolation();
        }

        return isValid;
    }
}
