package com.sc.web.controller.user;

import com.sc.app.service.user.IUserService;
import com.sc.common.base.PageResult;
import com.sc.common.base.Result;
import com.sc.common.utils.ResultUtils;
import com.sc.model.entity.company.vo.CompanyPageQueryReqVO;
import com.sc.model.entity.company.vo.CompanyResVO;
import com.sc.model.entity.user.vo.UserPageQueryReqVO;
import com.sc.model.entity.user.vo.UserResVO;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;

    /**
     * 获取用户列表（分页）
     */
    @ApiOperation("获取用户列表（分页）")
    @GetMapping("/page/list")
    public Result<PageResult<UserResVO>> getPageCompanyList(UserPageQueryReqVO userPageQueryReqVO){
        return ResultUtils.success("获取企业分页列表成功！",userService.getPageUserList(userPageQueryReqVO));
    }

}
