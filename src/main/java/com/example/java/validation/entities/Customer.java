package com.example.java.validation.entities;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Customer {

    @NotBlank(message = "Email can not blank")
    @Email(message = "Email must valid format")
    String email;

    @NotBlank(message = "Name can not blank")
    String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
