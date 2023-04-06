package com.sc.web.security.core;

import lombok.Data;

@Data
public class LoginUserInfo {
    private Long userId;
    private String userName;
    private Long accountId;
    private String roleType;
}
