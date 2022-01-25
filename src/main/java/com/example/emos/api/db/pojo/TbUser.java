package com.example.emos.api.db.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * tb_user
 * @author 
 */
@Data
public class TbUser implements Serializable {

    private Integer id;


    private String username;


    private String password;


    private String openId;


    private String nickname;


    private String photo;


    private String name;


    private Object sex;


    private String tel;

    private String email;

    private Date hiredate;

    private Object role;


    private Boolean root;


    private Integer deptId;


    private Byte status;

    private Date createTime;

    private static final long serialVersionUID = 1L;
}