package com.sc.app.controller.auth;

import com.sc.app.controller.user.vo.UserAuthLoginReqVO;
import com.sc.app.controller.user.vo.UserAuthLoginResVO;
import com.sc.app.service.auth.IUserAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/user/auth")
@RequiredArgsConstructor
public class UserAuthController {
    private final IUserAuthService userAuthService;

    /**
     * 用户登录
     */
    @RequestMapping("/login")
    public UserAuthLoginResVO login(@RequestBody UserAuthLoginReqVO userLoginReqVO){
        return userAuthService.login(userLoginReqVO);
    }

    /**
     * 用户登出
     */
    @RequestMapping("/logout")
    public String logout(){
        //TODO
        return "logout";
    }

}
