package com.sc.web.controller.apply;

import com.sc.app.service.apply.IInterviewInvitationService;
import com.sc.common.base.PageResult;
import com.sc.common.base.Result;
import com.sc.common.utils.ResultUtils;
import com.sc.model.entity.apply.vo.InterviewInvitationCreateReqVO;
import com.sc.model.entity.apply.vo.InterviewInvitationPageQueryReqVO;
import com.sc.model.entity.apply.vo.InterviewInvitationResVO;
import com.sc.model.entity.apply.vo.InterviewInvitationUpdateReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 面试邀请
 */
@Api(tags = "面试邀请")
@RequiredArgsConstructor
@RequestMapping("/job/interview")
@RestController
public class InterviewInvitationController {
    private final IInterviewInvitationService interviewInvitationService;

    @ApiOperation("获取面试邀请列表(分页)")
    @GetMapping("/page/list")
    public Result<PageResult<InterviewInvitationResVO>> getPageInterviewInvitationList(InterviewInvitationPageQueryReqVO interviewInvitationPageQueryReqVO){
        return ResultUtils.success("获取面试邀请分页列表成功！",interviewInvitationService.getPageInterviewInvitationList(interviewInvitationPageQueryReqVO));
    }

    /**
     * 添加面试邀请
     */
    @ApiOperation("添加面试邀请")
    @PostMapping("/add")
    public Result<InterviewInvitationResVO> addInterviewInvitation(@RequestBody InterviewInvitationCreateReqVO interviewInvitationCreateReqVO){
        return ResultUtils.success("添加面试邀请成功！",interviewInvitationService.addInterviewInvitation(interviewInvitationCreateReqVO));
    }

    /**
     * 更新面试邀请
     * @param interviewInvitationUpdateReqVO
     * @return
     */
    @ApiOperation("更新面试邀请")
    @PostMapping("/update")
    public Result<InterviewInvitationResVO> updateInterviewInvitation(@RequestBody InterviewInvitationUpdateReqVO interviewInvitationUpdateReqVO){
        return ResultUtils.success("更新面试邀请成功！",interviewInvitationService.updateInterviewInvitation(interviewInvitationUpdateReqVO));
    }

    /**
     * 删除面试邀请
     * @param id
     * @return
     */
    @ApiOperation("删除面试邀请")
    @DeleteMapping("/delete/{id}")
    public Result<Boolean> deleteComPanyById(@PathVariable("id") Long id){
        return ResultUtils.success("删除面试邀请成功！",interviewInvitationService.removeById(id));
    }

    /**
     * 获取当前用户企业下的面试邀请列表
     */
    @ApiOperation("获取当前用户企业下的面试邀请列表")
    @GetMapping("/company/page/list")
    public Result<PageResult<InterviewInvitationResVO>> getInterviewInvitationListByCompany(InterviewInvitationPageQueryReqVO interviewInvitationPageQueryReqVO){
        return ResultUtils.success("获取当前用户企业下的面试邀请列表成功！",interviewInvitationService.getInterviewInvitationListByCompany(interviewInvitationPageQueryReqVO));
    }

    /**
     * 根据Id 获取面试邀请详情
     */
    @ApiOperation("根据Id 获取面试邀请详情")
    @GetMapping("/get/{id}")
    public Result<InterviewInvitationResVO> getInterviewInvitationById(@PathVariable("id") String id){
        return ResultUtils.success("根据Id 获取面试邀请详情成功！",interviewInvitationService.getInterviewInvitationById(id));
    }

    /**
     * 获取当前用户的面试邀请列表
     */
    @ApiOperation("获取当前用户的面试邀请列表")
    @GetMapping("/user/page/list")
    public Result<PageResult<InterviewInvitationResVO>> getInterviewInvitationListByUser(InterviewInvitationPageQueryReqVO interviewInvitationPageQueryReqVO){
        return ResultUtils.success("获取当前用户的面试邀请列表成功！",interviewInvitationService.getInterviewInvitationListByUser(interviewInvitationPageQueryReqVO));
    }
}
