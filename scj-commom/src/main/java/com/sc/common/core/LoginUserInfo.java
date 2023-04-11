package com.sc.common.core;

import lombok.Data;

@Data
public class LoginUserInfo {
    private Long userId;
    private String userName;
    private Long accountId;
    private String roleType;
    /**
     * 登录时间
     */
    private Long loginTime;

    /**
     * 过期时间
     */
    private Long expireTime;

    /**
     * 登录IP地址
     */
    private String ipaddr;

    /**
     * 登录地点
     */
    private String loginLocation;

    /**
     * 浏览器类型
     */
    private String browser;

    /**
     * 操作系统
     */
    private String os;

}
