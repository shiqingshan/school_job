package com.sc.framework.web.security.util;

import com.sc.model.entity.auth.LoginUserInfo;

public class SpringSecurityUtils {

    public static Long getLoginUserId() {
        return 1L;
    }

    public static LoginUserInfo getLoginUserInfo() {
        return new LoginUserInfo();
    }
}
