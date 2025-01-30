package com.example.java.validation.entities;


import com.example.java.validation.constraint.CheckPassword;
import jakarta.validation.constraints.NotBlank;


@CheckPassword(message = "password and retype password must same")
public class Register {

    @NotBlank(message = "username can not blank")
    private String username;

    @NotBlank(message = "password can not blank")
    private String password;

    @NotBlank(message = "retype password can not blank")
    private String retypePassword;

    public @NotBlank(message = "username can not blank") String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank(message = "username can not blank") String username) {
        this.username = username;
    }

    public @NotBlank(message = "password can not blank") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "password can not blank") String password) {
        this.password = password;
    }

    public @NotBlank(message = "retype password can not blank") String getRetypePassword() {
        return retypePassword;
    }

    public void setRetypePassword(@NotBlank(message = "retype password can not blank") String retypePassword) {
        this.retypePassword = retypePassword;
    }
}
