package com.sc.model.entity.vo;

import lombok.Data;

@Data
public class LoginRequestVO {
    private String username;
    private String password;
    private String accountType;
}
