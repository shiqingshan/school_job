package com.sc.web.controller.job;


import com.sc.app.service.job.IJobDetailService;
import com.sc.common.base.Result;
import com.sc.common.utils.ResultUtils;
import com.sc.model.entity.job.vo.JobDetailCreateReqVO;
import com.sc.model.entity.job.vo.JobDetailResVO;
import com.sc.model.entity.job.vo.JobDetailUpdateReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 职位详情信息
 */
@Api(tags = "职位详情信息")
@RequiredArgsConstructor
@RequestMapping("/job/detail")
@RestController
public class JobDetailController {
    private final IJobDetailService jobDetailService;

    @ApiOperation("获取职位详情信息")
    @GetMapping("/{jobId}")
    public Result<JobDetailResVO> getJobDetail(@PathVariable String jobId){
        return ResultUtils.success("获取职位详情信息分页列表成功！",jobDetailService.getJobDetailByJobId(jobId));
    }

    /**
     * 添加职位详情信息
     */
    @ApiOperation("添加职位详情信息")
    @PostMapping("/add")
    public Result<JobDetailResVO> addJobDetail(@RequestBody JobDetailCreateReqVO jobDetailCreateReqVO){
        return ResultUtils.success("添加职位详情信息成功！",jobDetailService.addJobDetail(jobDetailCreateReqVO));
    }

    /**
     * 更新职位详情信息
     * @param jobDetailUpdateReqVO
     * @return
     */
    @ApiOperation("更新职位详情信息")
    @PostMapping("/update")
    public Result<JobDetailResVO> updateJobDetail(@RequestBody JobDetailUpdateReqVO jobDetailUpdateReqVO){
        return ResultUtils.success("更新职位详情信息成功！",jobDetailService.updateJobDetail(jobDetailUpdateReqVO));
    }

    /**
     * 删除职位详情信息
     * @param id
     * @return
     */
    @ApiOperation("删除职位详情信息")
    @DeleteMapping("/delete/{id}")
    public Result<Boolean> deleteComPanyById(@PathVariable("id") Long id){
        return ResultUtils.success("删除职位详情信息成功！",jobDetailService.removeById(id));
    }
}
