package com.example.java.validation;

import com.example.java.validation.entities.Payment;
import com.example.java.validation.group.CreditCardPaymentGroup;
import com.example.java.validation.group.VirtualAccountPaymentGroup;
import org.junit.jupiter.api.Test;

public class GroupTest extends AbstractValidatorTest {

    @Test
    void testCreditCardGroup() {

        Payment payment = new Payment();
        payment.setOrderId("0111");
        payment.setAmount(20_000L);
        payment.setCreditCard("123");

        validateWithGroup(payment, CreditCardPaymentGroup.class);

    }

    //  credit card tidak dipanggil karena kita hanya akan mengeksekusi virtual accoount payment group
    @Test
    void testVirtualAccountPaymentGroup() {

        Payment payment = new Payment();
        payment.setOrderId("0111");
        payment.setAmount(20_000L);
        payment.setCreditCard("123");

        validateWithGroup(payment, VirtualAccountPaymentGroup.class);

    }

}
