package com.example.emos.api.controller.form;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class SearchMeetingRoomByPageForm {
    private String name;

    private Boolean canDelete;

    @NotNull(message = "page cannot be blank")
    @Min(value = 1, message = "page cannot be <1")
    private Integer page;

    @NotNull(message = "length cannot be blank")
    private Integer length;
}
