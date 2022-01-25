package com.example.emos.api.controller.form;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class UpdateUserForm {

    @NotNull(message = "userId cannot be blank")
    @Min(value = 1, message = "userId cannot be <1")
    private Integer userId;

    @NotBlank(message = "username cannot be blank")
    @Pattern(regexp = "^[a-zA-Z0-9]{5,20}$", message = "incorrect username")
    private String username;

    @NotBlank(message = "password cannot be blank")
    @Pattern(regexp = "^[a-zA-Z0-9]{6,20}$", message = "incorrect password")
    private String password;

    @NotBlank(message = "name cannot be blank")
    @Pattern(regexp = "^[a-zA-Z\\s]+", message = "incorrect name")
    private String name;

    @NotBlank(message = "sex cannot be blank")
    @Pattern(regexp = "^F$|^M$", message = "incorrect sex")
    private String sex;

    @NotBlank(message = "tel cannot be blank")
    @Pattern(regexp = "[0-9]+", message = "incorrect tel")
    private String tel;

    @NotBlank(message = "email cannot be blank")
    private String email;

    @NotBlank(message = "hire date cannot be blank")
    @Pattern(regexp = "^((((1[6-9]|[2-9]\\d)\\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\\d|3[01]))|(((1[6-9]|[2-9]\\d)\\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\\d|30))|(((1[6-9]|[2-9]\\d)\\d{2})-0?2-(0?[1-9]|1\\d|2[0-8]))|(((1[6-9]|[2-9]\\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$", message = "incorrect hiredate")
    private String hiredate;

    @NotEmpty(message = "role cannot be blank")
    private Integer[] role;

    @NotNull(message = "deptId cannot be blank")
    @Min(value = 1, message = "incorrect deptId")
    private Integer deptId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public Integer[] getRole() {
        return role;
    }

    public void setRole(Integer[] role) {
        this.role = role;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
}


