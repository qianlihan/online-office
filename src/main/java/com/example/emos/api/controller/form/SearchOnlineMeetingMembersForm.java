package com.example.emos.api.controller.form;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class SearchOnlineMeetingMembersForm {
    @NotNull(message = "meetingId cannot be empty")
    @Min(value = 1, message = "meetingId cannot be <1")
    private Integer meetingId;
}

