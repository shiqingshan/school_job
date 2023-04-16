package com.sc.model.entity.auth.vo;

import lombok.Data;

@Data
public class UserLoginInfoResVO {
    /** 用户id */
    private String userId;
    /** 用户名 */
    private String userName;

    private String accountType;

    private String accountId;

    private String coId;
}
