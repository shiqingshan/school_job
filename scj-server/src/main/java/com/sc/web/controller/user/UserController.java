package com.sc.web.controller.user;

import com.sc.app.convert.company.CompanyConvert;
import com.sc.app.convert.user.UserConvert;
import com.sc.app.service.user.IUserService;
import com.sc.common.base.PageResult;
import com.sc.common.base.Result;
import com.sc.common.utils.ResultUtils;
import com.sc.model.entity.company.vo.CompanyCreateReqVO;
import com.sc.model.entity.company.vo.CompanyPageQueryReqVO;
import com.sc.model.entity.company.vo.CompanyResVO;
import com.sc.model.entity.company.vo.CompanyUpdateReqVO;
import com.sc.model.entity.user.vo.UserCreateReqVO;
import com.sc.model.entity.user.vo.UserPageQueryReqVO;
import com.sc.model.entity.user.vo.UserResVO;
import com.sc.model.entity.user.vo.UserUpdateReqVo;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public Result<PageResult<UserResVO>> getPageUserList(UserPageQueryReqVO userPageQueryReqVO){
        return ResultUtils.success("获取企业分页列表成功！",userService.getPageUserList(userPageQueryReqVO));
    }

    /**
     * 获取用户
     * @param id
     * @return
     */
    @RequestMapping("/{id}")
    public Result<UserResVO> getUser(@PathVariable(value = "id") String id){
        return ResultUtils.success("获取企业成功！", UserConvert.INSTANCE.convert(userService.getById(id)));
    }

    /**
     * 添加用户
     */
    @ApiOperation("添加用户")
    @PostMapping("/add")
    public Result<UserResVO> addUser(@RequestBody UserCreateReqVO userCreateReqVO){
        return ResultUtils.success("添加用户成功！",userService.addUser(userCreateReqVO));
    }

    /**
     * 更新企业
     * @param userUpdateReqVo
     * @return
     */
    @ApiOperation("更新用户")
    @PostMapping("/update")
    public Result<UserResVO> updateCompany(@RequestBody UserUpdateReqVo userUpdateReqVo){
        return ResultUtils.success("更新企业成功！",userService.updateUser(userUpdateReqVo));
    }

    /**
     * 删除企业
     * @param id
     * @return
     */
    @ApiOperation("删除企业")
    @DeleteMapping("/delete/{id}")
    public Result<Boolean> deleteComPanyById(@PathVariable("id") Long id){
        return ResultUtils.success("删除用户成功！",userService.removeById(id));
    }
}
