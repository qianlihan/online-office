package com.example.emos.api.controller.form;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class SearchMeetingInfoForm {
    @NotNull(message = "id cannot be empty")
    @Min(value = 1,message = "id不能小于1")
    private Long id;

    @NotNull(message = "status cannot be empty")
    @Range(min = 1, max = 5,message = "invalid status")
    private Short status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }
}

