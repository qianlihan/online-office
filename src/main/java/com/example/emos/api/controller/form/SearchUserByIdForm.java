package com.example.emos.api.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class SearchUserByIdForm {

    @NotNull(message = "userId cannot be blank")
    @Min(value = 1, message = "userId cannot be <1")
    private Integer userId;
}
