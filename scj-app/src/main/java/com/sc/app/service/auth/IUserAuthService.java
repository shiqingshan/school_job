package com.sc.app.service.auth;

import com.sc.app.controller.user.vo.UserAuthLoginReqVO;
import com.sc.app.controller.user.vo.UserAuthLoginResVO;

public interface IUserAuthService {
    /**
     * 用户登录
     * @param userLoginReqVO
     * @return
     */
    UserAuthLoginResVO login(UserAuthLoginReqVO userLoginReqVO);
}
