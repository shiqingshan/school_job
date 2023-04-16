package com.sc.web.controller.apply;

import com.sc.app.service.apply.IJobApplyService;
import com.sc.common.base.PageResult;
import com.sc.common.base.Result;
import com.sc.common.utils.ResultUtils;
import com.sc.model.entity.apply.vo.JobApplyCreateReqVO;
import com.sc.model.entity.apply.vo.JobApplyPageQueryReqVO;
import com.sc.model.entity.apply.vo.JobApplyResVO;
import com.sc.model.entity.apply.vo.JobApplyUpdateReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 职位申请
 */
@Api(tags = "职位申请")
@RequiredArgsConstructor
@RequestMapping("/job/apply")
@RestController
public class JobApplyController {
    private final IJobApplyService jobApplyService;

    @ApiOperation("获取职位申请列表(分页)")
    @GetMapping("/page/list")
    public Result<PageResult<JobApplyResVO>> getPageJobApplyList(JobApplyPageQueryReqVO jobApplyPageQueryReqVO){
        return ResultUtils.success("获取职位申请分页列表成功！",jobApplyService.getPageJobApplyList(jobApplyPageQueryReqVO));
    }

    /**
     * 添加职位申请
     */
    @ApiOperation("添加职位申请")
    @PostMapping("/add")
    public Result<JobApplyResVO> addJobApply(@RequestBody JobApplyCreateReqVO jobApplyCreateReqVO){
        return ResultUtils.success("添加职位申请成功！",jobApplyService.addJobApply(jobApplyCreateReqVO));
    }

    /**
     * 更新职位申请
     * @param jobApplyUpdateReqVO
     * @return
     */
    @ApiOperation("更新职位申请")
    @PostMapping("/update")
    public Result<JobApplyResVO> updateJobApply(@RequestBody JobApplyUpdateReqVO jobApplyUpdateReqVO){
        return ResultUtils.success("更新职位申请成功！",jobApplyService.updateJobApply(jobApplyUpdateReqVO));
    }

    /**
     * 删除职位申请
     * @param id
     * @return
     */
    @ApiOperation("删除职位申请")
    @DeleteMapping("/delete/{id}")
    public Result<Boolean> deleteComPanyById(@PathVariable("id") Long id){
        return ResultUtils.success("删除职位申请成功！",jobApplyService.removeById(id));
    }
    /**
     * 根据用户获取职位申请列表
     */
    @ApiOperation("根据用户获取职位申请列表")
    @GetMapping("/user/list")
    public Result<PageResult<JobApplyResVO>> getJobApplyListByUserId(JobApplyPageQueryReqVO jobApplyPageQueryReqVO){
        return ResultUtils.success("根据用户获取职位申请列表成功！",jobApplyService.getJobApplyListByUser(jobApplyPageQueryReqVO));
    }
}
