package com.sc.admin.controller.auth.vo;

import lombok.Data;

@Data
public class UserLoginReqVO {
    private String username;
    private String password;
    private Integer accountType;
}
