package com.example.java.validation.entities;

import com.example.java.validation.constraint.CheckCase;
import com.example.java.validation.constraint.CheckOrderId;
import com.example.java.validation.enums.CaseMode;
import com.example.java.validation.group.CreditCardPaymentGroup;
import com.example.java.validation.group.VirtualAccountPaymentGroup;
import com.example.java.validation.payload.EmailErrorPayload;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;

public class Payment {

//  jika DTO yg dipasang groups tidak di deklarasikan ketika dipanggil maka tidak akan memanggil semua validasi yg telah dibuat kecuali menambahkan default interface di dalam groupnya

//    @CheckCase(mode = CaseMode.UPPER, groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, message = "order.id.upper")
//    @NotBlank(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, message = "{order.id.notblank}")
//    @Size(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, min = 1, max = 10, message = "{order.id.size}")
//    private String orderId;

    //  membuat custom anotasi
    @CheckOrderId(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class})
    private String orderId;

    @NotNull(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, message = "Amount can not null")
    @Range(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, min = 10_000L, max = 100_000_000L, message = "Amount must between 10.000 and 100.000.000")
    private Long amount;

    @LuhnCheck(groups = {CreditCardPaymentGroup.class}, message = "Invalid credit card number", payload = {EmailErrorPayload.class})
    @NotBlank(groups = {CreditCardPaymentGroup.class}, message = "Credit card can not blank")
    private String creditCard;


    @NotBlank(groups = {VirtualAccountPaymentGroup.class}, message = "Virtual account can not blank")
    private String virtualAccount;

    @Valid
    @NotNull(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, message = "Customer can not null")
    @ConvertGroup(from = VirtualAccountPaymentGroup.class, to = Default.class)
    @ConvertGroup(from = CreditCardPaymentGroup.class, to = Default.class)
    private Customer customer;

    public @NotBlank(message = "Order id can not blank") String getOrderId() {
        return orderId;
    }

    public void setOrderId(@NotBlank(message = "Order id can not blank") String orderId) {
        this.orderId = orderId;
    }

    public @NotNull(message = "Amount can not null") @Range(min = 10_000L, max = 100_000_000L, message = "Amount must between 10.000 and 100.000.000") Long getAmount() {
        return amount;
    }

    public void setAmount(@NotNull(message = "Amount can not null") @Range(min = 10_000L, max = 100_000_000L, message = "Amount must between 10.000 and 100.000.000") Long amount) {
        this.amount = amount;
    }

    public @LuhnCheck(message = "Invalid credit card number") @NotBlank(message = "Credit card can not blank") String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(@LuhnCheck(message = "Invalid credit card number") @NotBlank(message = "Credit card can not blank") String creditCard) {
        this.creditCard = creditCard;
    }

    public String getVirtualAccount() {
        return virtualAccount;
    }

    public void setVirtualAccount(String virtualAccount) {
        this.virtualAccount = virtualAccount;
    }

    public @NotNull(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, message = "Customer can not null") Customer getCustomer() {
        return customer;
    }

    public void setCustomer(@NotNull(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, message = "Customer can not null") Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "orderId='" + orderId + '\'' +
                ", amount=" + amount +
                ", creditCard='" + creditCard + '\'' +
                ", virtualAccount='" + virtualAccount + '\'' +
                ", customer=" + customer +
                '}';
    }
}
