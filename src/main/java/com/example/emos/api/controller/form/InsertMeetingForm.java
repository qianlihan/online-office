package com.example.emos.api.controller.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class InsertMeetingForm {

    @NotBlank(message = "title cannot be empty")
    private String title;

    @NotBlank(message = "date cannot be empty")
    private String date;

    //@Pattern(regexp = "^[a-zA-Z0-9\\u4e00-\\u9fa5]{2,20}$", message = "place内容不正确")
    private String place;

    @NotBlank(message = "start cannot be empty")
    @Pattern(regexp = "^([01]?[0-9]|2[0-3]):(00|30)$", message = "start内容不正确")
    private String start;

    @NotBlank(message = "end cannot be empty")
    @Pattern(regexp = "^([01]?[0-9]|2[0-3]):(00|30)$", message = "end内容不正确")
    private String end;

    @NotNull(message = "type cannot be empty")
    @Range(min = 1, max = 2, message = "incorrect type")
    private Byte type;

    @NotBlank(message = "members cannot be empty")
    private String members;

    @NotBlank(message = "desc cannot be empty")
    @Length(min = 1, max = 200)
    private String desc;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

