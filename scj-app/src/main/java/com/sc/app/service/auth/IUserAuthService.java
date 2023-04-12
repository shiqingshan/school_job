package com.sc.app.service.auth;


import com.sc.common.core.LoginUserInfo;
import com.sc.model.entity.auth.vo.*;

public interface IUserAuthService {
    public UserLoginResVO login(UserLoginReqVO userLoginReqVO);

    UserPermissionInfoResVO getPermissionInfo(Long loginUserId);

    UserMenuInfoResVO getMenuInfo(Long loginUserId);

    UserLoginInfoResVO getUserInfo(LoginUserInfo userInfo);

    UserRegisterResVO register(UserRegisterReqVO userRegisterReqVO);
}
