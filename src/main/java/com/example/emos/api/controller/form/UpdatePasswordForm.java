package com.example.emos.api.controller.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class UpdatePasswordForm {
    @NotBlank(message="password cannot be empty.")
    @Pattern(regexp = "^[a-zA-Z0-9]{6,20}$", message = "password format incorrect")
    private String password;

    public UpdatePasswordForm(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UpdatePasswordForm(){};
}
