package com.sc.web.controller.resume;

import com.sc.app.service.resume.IUserResumeService;
import com.sc.common.base.PageResult;
import com.sc.common.base.Result;
import com.sc.common.utils.ResultUtils;
import com.sc.model.entity.resume.vo.UserResumeCreateReqVO;
import com.sc.model.entity.resume.vo.UserResumePageQueryReqVO;
import com.sc.model.entity.resume.vo.UserResumeResVO;
import com.sc.model.entity.resume.vo.UserResumeUpdateReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 用户简历
 */
@Api(tags = "用户简历")
@RequiredArgsConstructor
@RequestMapping("/user/resume")
@RestController
public class UserResumeController {
    private final IUserResumeService userResumeService;

    @ApiOperation("获取用户简历列表(分页)")
    @GetMapping("/page/list")
    public Result<PageResult<UserResumeResVO>> getPageUserResumeList(UserResumePageQueryReqVO userResumePageQueryReqVO){
        return ResultUtils.success("获取用户简历分页列表成功！",userResumeService.getPageUserResumeList(userResumePageQueryReqVO));
    }

    /**
     * 添加用户简历
     */
    @ApiOperation("添加用户简历")
    @PostMapping("/add")
    public Result<UserResumeResVO> addUserResume(@RequestBody UserResumeCreateReqVO userResumeCreateReqVO){
        return ResultUtils.success("添加用户简历成功！",userResumeService.addUserResume(userResumeCreateReqVO));
    }

    /**
     * 更新用户简历
     * @param userResumeUpdateReqVO
     * @return
     */
    @ApiOperation("更新用户简历")
    @PostMapping("/update")
    public Result<UserResumeResVO> updateUserResume(@RequestBody UserResumeUpdateReqVO userResumeUpdateReqVO){
        return ResultUtils.success("更新用户简历成功！",userResumeService.addOrUpdateUserResume(userResumeUpdateReqVO));
    }

    /**
     * 删除用户简历
     * @param id
     * @return
     */
    @ApiOperation("删除用户简历")
    @DeleteMapping("/delete/{id}")
    public Result<Boolean> deleteComPanyById(@PathVariable("id") Long id){
        return ResultUtils.success("删除用户简历成功！",userResumeService.removeById(id));
    }

    /**
     * 获取当前用户在线简历
     */
    @ApiOperation("获取当前用户在线简历")
    @GetMapping("/get/online")
    public Result<UserResumeResVO> getOnlineUserResume(){
        return ResultUtils.success("获取当前用户在线简历成功！",userResumeService.getOnlineUserResume());
    }
}
