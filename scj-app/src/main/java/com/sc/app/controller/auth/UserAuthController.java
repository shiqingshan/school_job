package com.sc.app.controller.auth;

import com.sc.model.entity.auth.vo.*;
import com.sc.app.service.auth.IUserAuthService;
import com.sc.common.base.Result;
import com.sc.common.utils.ResultUtils;
import com.sc.web.security.util.SpringSecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/auth")
@RequiredArgsConstructor
@Api(tags = "用户认证")
public class UserAuthController {
    private final IUserAuthService userAuthService;
    @ApiOperation("用户登录")
    @PostMapping("/login")
    public Result<UserLoginResVO> login(@RequestBody UserLoginReqVO adminUserLoginReqVO){
        return ResultUtils.success(userAuthService.login(adminUserLoginReqVO));
    }

    @ApiOperation("获取用户信息")
    @GetMapping("/getUserInfo")
    public Result<UserLoginInfoResVO> getUserInfo(){
        return ResultUtils.success(userAuthService.getUserInfo(SpringSecurityUtils.getLoginUserInfo()));
    }

    /**
     * 获取用户权限信息
     * @return
     */
    @ApiOperation("获取用户权限信息")
    @GetMapping("/getPermissionInfo")
    public Result<UserPermissionInfoResVO> getPermissionInfo(){
        return ResultUtils.success(userAuthService.getPermissionInfo(SpringSecurityUtils.getLoginUserId()));
    }
    /**
     * 获取用户菜单信息
     */
    @ApiOperation("获取用户菜单信息")
    @GetMapping("/getMenuInfo")
    public Result<UserMenuInfoResVO> getMenuInfo(){
        return ResultUtils.success(userAuthService.getMenuInfo(SpringSecurityUtils.getLoginUserId()));
    }
}
