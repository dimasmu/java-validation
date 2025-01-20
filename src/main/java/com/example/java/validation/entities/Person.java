package com.example.java.validation.entities;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Person {

    @Size(max = 20, message = "First name length max must 20 character")
    @NotBlank(message = "First name can't blank")
    private String firstName;

    @Size(max = 20, message = "First name length max must 20 character")
    @NotBlank(message = "Last name can't blank")
    private String lastName;

    @NotNull(message = "Address can not null")
    @Valid // anotasi untuk meminta validasi ke dalam objek / nested validation
    private Address address;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void sayHello(@NotBlank(message = "Name can not blank") String name) {
        System.out.println("Hello " + name + ", my name is" + firstName);
    }

    @NotBlank(message = "full name can not blank")
    public String fullName() {
        return firstName + " " + lastName;
    }
}
