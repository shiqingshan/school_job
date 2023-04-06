package com.sc.model.entity.auth.vo;

import lombok.Data;

@Data
public class UserLoginReqVO {
    private String userName;
    private String password;
    private Integer accountType;
}
