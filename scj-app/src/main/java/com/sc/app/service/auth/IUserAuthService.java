package com.sc.app.service.auth;


import com.sc.model.entity.auth.vo.*;

import javax.servlet.http.HttpServletRequest;

public interface IUserAuthService {
    public UserLoginResVO login(UserLoginReqVO userLoginReqVO);

    UserPermissionInfoResVO getPermissionInfo(Long loginUserId);

    UserMenuInfoResVO getMenuInfo(Long loginUserId);

    UserLoginInfoResVO getUserInfo(HttpServletRequest request);

    UserRegisterResVO register(UserRegisterReqVO userRegisterReqVO);

    void logout();
}
