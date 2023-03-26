package com.sc.admin.controller.auth;

import com.sc.admin.controller.auth.vo.UserLoginReqVO;
import com.sc.admin.controller.auth.vo.UserLoginResVO;
import com.sc.admin.controller.auth.vo.UserMenuInfoResVO;
import com.sc.admin.controller.auth.vo.UserPermissionInfoResVO;
import com.sc.admin.service.auth.IUserAuthService;
import com.sc.common.base.Result;
import com.sc.common.utils.ResultUtils;
import com.sc.web.security.util.SpringSecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/auth")
@RequiredArgsConstructor
public class UserAuthController {
    private final IUserAuthService userAuthService;
    @RequestMapping("/login")
    public Result<UserLoginResVO> login(@RequestBody UserLoginReqVO adminUserLoginReqVO){
        return ResultUtils.success(userAuthService.login(adminUserLoginReqVO));
    }

    /**
     * 获取用户权限信息
     * @return
     */
    @RequestMapping("/getPermissionInfo")
    public Result<UserPermissionInfoResVO> getPermissionInfo(){
        return ResultUtils.success(userAuthService.getPermissionInfo(SpringSecurityUtils.getLoginUserId()));
    }
    /**
     * 获取用户菜单信息
     */
    @RequestMapping("/getMenuInfo")
    public Result<UserMenuInfoResVO> getMenuInfo(){
        return ResultUtils.success(userAuthService.getMenuInfo(SpringSecurityUtils.getLoginUserId()));
    }
}
