package com.example.java.validation;

import com.example.java.validation.entities.Payment;
import com.example.java.validation.group.CreditCardPaymentGroup;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class MessageInternationalizationTest extends AbstractValidatorTest {

    @Test
    void testI18N() {

        Locale.setDefault(new Locale("in", "ID"));

        Payment payment = new Payment();
        payment.setOrderId("32134235324");
        payment.setAmount(10L);

        validateWithGroup(payment, CreditCardPaymentGroup.class);

    }

    @Test
    void testMessageInterpolator(){

        Locale.setDefault(new Locale("in", "ID"));

        Payment payment = new Payment();
        payment.setOrderId("321342353241231234124123901243912491");
        payment.setAmount(10L);

        validateWithGroup(payment, CreditCardPaymentGroup.class);

    }

}
