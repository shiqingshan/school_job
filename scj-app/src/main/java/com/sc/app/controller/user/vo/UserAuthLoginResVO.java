package com.sc.app.controller.user.vo;

import lombok.Data;

@Data
public class UserAuthLoginResVO {
    private String token;
    private String username;
    private String nickname;
    private String avatar;
    private String email;
    private String phone;
    private String role;
    private String status;
    private String lastLoginTime;
    private String lastLoginIp;
    private String createTime;
    private String updateTime;
    private String remark;
}
