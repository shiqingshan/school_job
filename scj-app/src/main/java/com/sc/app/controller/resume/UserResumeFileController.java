package com.sc.app.controller.resume;

import com.sc.app.service.resume.IUserResumeFileService;
import com.sc.common.base.PageResult;
import com.sc.common.base.Result;
import com.sc.common.utils.ResultUtils;
import com.sc.model.entity.resume.vo.UserResumeFileCreateReqVO;
import com.sc.model.entity.resume.vo.UserResumeFileResVO;
import com.sc.model.entity.resume.vo.UserResumeFileUpdateReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 用户简历文件
 */
@Api(tags = "用户简历文件")
@RequiredArgsConstructor
@RequestMapping("/user/resume/file")
@RestController
public class UserResumeFileController {
    private final IUserResumeFileService userResumeFileService;


    /**
     * 添加用户简历文件
     */
    @ApiOperation("添加用户简历文件")
    @PostMapping("/add")
    public Result<UserResumeFileResVO> addUserResumeFile(@RequestBody UserResumeFileCreateReqVO userResumeFileCreateReqVO){
        return ResultUtils.success("添加用户简历文件成功！",userResumeFileService.addUserResumeFile(userResumeFileCreateReqVO));
    }

    /**
     * 更新用户简历文件
     * @param userResumeFileUpdateReqVO
     * @return
     */
    @ApiOperation("更新用户简历文件")
    @PostMapping("/update")
    public Result<UserResumeFileResVO> updateUserResumeFile(@RequestBody UserResumeFileUpdateReqVO userResumeFileUpdateReqVO){
        return ResultUtils.success("更新用户简历文件成功！",userResumeFileService.updateUserResumeFile(userResumeFileUpdateReqVO));
    }

    /**
     * 删除用户简历文件
     * @param id
     * @return
     */
    @ApiOperation("删除用户简历文件")
    @DeleteMapping("/delete/{id}")
    public Result<Boolean> deleteComPanyById(@PathVariable("id") Long id){
        return ResultUtils.success("删除用户简历文件成功！",userResumeFileService.removeById(id));
    }
}
