package com.sc.web.security.util;

import com.sc.web.security.core.LoginUserInfo;

public class SpringSecurityUtils {

    public static Long getLoginUserId() {
        return 1L;
    }

    public static LoginUserInfo getLoginUserInfo() {
        return new LoginUserInfo();
    }
}
