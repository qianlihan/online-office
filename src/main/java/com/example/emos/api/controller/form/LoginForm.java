package com.example.emos.api.controller.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class LoginForm {
    @NotBlank(message="username cannot be empty!")
    @Pattern(regexp = "^[a-zA-Z0-9]{5,20}$", message = "username format incorrect")
    private String username;

    @NotBlank(message="password cannot be empty.")
    @Pattern(regexp = "^[a-zA-Z0-9]{6,20}$", message = "password format incorrect")
    private String password;

    public LoginForm(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
