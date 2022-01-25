package com.example.emos.api.controller.form;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Data
public class SearchUserByPageForm {
    @NotNull(message = "page error")
    @Min(value = 1, message = "page error")
    private Integer page;

    @NotNull(message = "length error")
    @Range(min = 5, max = 100, message = "length error")
    private Integer length;

    @Pattern(regexp = "^[\\u4e00-\\u9fa5]{1,10}$", message = "name error")
    private String name;

    @Pattern(regexp = "^F$|^M$", message = "gender error")
    private String gender;

    @Pattern(regexp = "^[a-zA-Z0-9\\u4e00-\\u9fa5]{2,10}$", message = "role error")
    private String role;

    @Min(value = 1, message = "dept error")
    private Integer deptId;

    @Min(value = 1, message = "status error")
    private Integer status;

}


