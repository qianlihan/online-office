package com.example.emos.api.controller.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class SearchOfflineMeetingInWeekForm {

    private String date;

    @NotNull(message = "incorrect mode")
    @Pattern(regexp = "^my$|^all$", message = "incorrect mode")
    private String mode;

    @NotBlank(message = "name cannot be empty")
    private String name;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

