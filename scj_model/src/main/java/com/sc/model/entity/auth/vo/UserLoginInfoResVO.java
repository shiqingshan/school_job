package com.sc.model.entity.auth.vo;

import lombok.Data;

@Data
public class UserLoginInfoResVO {
    /** 用户id */
    private String userId;
    /** 用户名 */
    private String userName;
    /** 用户角色类型 */
    private String userRole;
}
