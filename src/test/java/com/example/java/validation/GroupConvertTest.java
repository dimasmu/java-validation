package com.example.java.validation;

import com.example.java.validation.entities.Customer;
import com.example.java.validation.entities.Payment;
import com.example.java.validation.group.CreditCardPaymentGroup;
import org.junit.jupiter.api.Test;

public class GroupConvertTest extends AbstractValidatorTest {

    @Test
    void testGroupConvert() {

        Payment payment = new Payment();
        payment.setOrderId("001");
        payment.setAmount(20_000L);
        payment.setCreditCard("4111111111111111");
        payment.setCustomer(new Customer());

        validateWithGroup(payment, CreditCardPaymentGroup.class);

    }

}
