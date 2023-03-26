package com.sc.admin.service.auth;

import com.sc.admin.controller.auth.vo.UserLoginReqVO;
import com.sc.admin.controller.auth.vo.UserLoginResVO;
import com.sc.admin.controller.auth.vo.UserMenuInfoResVO;
import com.sc.admin.controller.auth.vo.UserPermissionInfoResVO;

public interface IUserAuthService {
    public UserLoginResVO login(UserLoginReqVO adminUserLoginReqVO);

    UserPermissionInfoResVO getPermissionInfo(Long loginUserId);

    UserMenuInfoResVO getMenuInfo(Long loginUserId);
}
