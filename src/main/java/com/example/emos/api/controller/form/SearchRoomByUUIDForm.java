package com.example.emos.api.controller.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SearchRoomByUUIDForm {

    @NotBlank(message = "uuid cannot be empty")
    private String uuid;
}

