package com.sc.admin.controller.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户管理
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 用户列表
     */
    @RequestMapping("/list")
    public String list() {
        return "user list";
    }
}
