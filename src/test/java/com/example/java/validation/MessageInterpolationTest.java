package com.example.java.validation;

import com.example.java.validation.entities.Payment;
import com.example.java.validation.group.CreditCardPaymentGroup;
import com.example.java.validation.group.VirtualAccountPaymentGroup;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.MessageInterpolator;
import org.hibernate.validator.internal.engine.MessageInterpolatorContext;
import org.hibernate.validator.messageinterpolation.ExpressionLanguageFeatureLevel;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Set;

public class MessageInterpolationTest extends AbstractValidatorTest {

    @Test
    void testMessage() {

        Payment payment = new Payment();
        payment.setOrderId("1023456");
        payment.setVirtualAccount("312312");
        payment.setAmount(10L);

        Locale locale = new Locale("in", "ID");

        Set<ConstraintViolation<Object>> violations = validator.validate(payment, CreditCardPaymentGroup.class);
        for (ConstraintViolation<Object> violation : violations) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath().toString());
            System.out.println(violation.getMessageTemplate().toString());

            MessageInterpolator.Context context = new MessageInterpolatorContext(
                    violation.getConstraintDescriptor(), violation.getInvalidValue(), violation.getRootBeanClass(),
                    violation.getPropertyPath(), violation.getConstraintDescriptor().getAttributes(),
                    violation.getConstraintDescriptor().getAttributes(),
                    ExpressionLanguageFeatureLevel.VARIABLES, true
            );

            String message = messageInterpolator.interpolate(violation.getMessageTemplate(), context, locale);
            System.out.println(message);

            System.out.println("===============================================");
        }
    }

}
