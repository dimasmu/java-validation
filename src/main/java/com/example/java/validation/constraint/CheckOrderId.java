package com.example.java.validation.constraint;

import com.example.java.validation.enums.CaseMode;
import com.example.java.validation.group.CreditCardPaymentGroup;
import com.example.java.validation.group.VirtualAccountPaymentGroup;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.lang.annotation.*;

@CheckCase(mode = CaseMode.UPPER, groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, message = "order.id.upper")
@NotBlank(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, message = "{order.id.notblank}")
@Size(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, min = 1, max = 10, message = "{order.id.size}")
@Documented
@Constraint(
        validatedBy = {}
)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@ReportAsSingleViolation
// untuk mengeluarkan error langsung di message dibawah tanpa message lain yaitu "invalid order id"
public @interface CheckOrderId {
    String message() default "invalid order id";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
