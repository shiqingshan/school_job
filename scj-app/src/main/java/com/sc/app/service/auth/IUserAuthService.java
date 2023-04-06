package com.sc.app.service.auth;


import com.sc.model.entity.auth.vo.*;
import com.sc.web.security.core.LoginUserInfo;

public interface IUserAuthService {
    public UserLoginResVO login(UserLoginReqVO adminUserLoginReqVO);

    UserPermissionInfoResVO getPermissionInfo(Long loginUserId);

    UserMenuInfoResVO getMenuInfo(Long loginUserId);

    UserLoginInfoResVO getUserInfo(LoginUserInfo userInfo);
}
