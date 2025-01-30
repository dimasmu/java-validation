package com.example.java.validation.service;

import com.example.java.validation.constraint.CheckPassword;
import com.example.java.validation.constraint.CheckPasswordParameter;
import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

public class UserService {

    @CheckPasswordParameter(
            passwordParam = 1,
            retypePasswordParam = 2
    )
    public void register(
            @NotBlank(message = "Username can not blank") String username,
            @NotBlank(message = "Password can not blank") String password,
            @NotBlank(message = "retype password can not blank") String retypePassword) {



    }

}
