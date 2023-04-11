package com.sc.model.entity.auth;

import com.sc.model.entity.account.AccountDO;
import com.sc.model.entity.user.UserDO;
import lombok.Data;

@Data
public class LoginUserInfo {
    private String token;
    private Long userId;
    private Long accountId;
    private String userName;
    private Integer accountType;
    private UserDO userInfo;
    private AccountDO accountInfo;

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
