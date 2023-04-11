package com.sc.web.controller.job;


import com.sc.app.service.job.IJobInfoService;
import com.sc.common.base.PageResult;
import com.sc.common.base.Result;
import com.sc.common.utils.ResultUtils;
import com.sc.model.entity.job.vo.JobInfoCreateReqVO;
import com.sc.model.entity.job.vo.JobInfoPageQueryReqVO;
import com.sc.model.entity.job.vo.JobInfoResVO;
import com.sc.model.entity.job.vo.JobInfoUpdateReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 职位信息
 */
@Api(tags = "职位信息")
@RequiredArgsConstructor
@RequestMapping("/job/jobInfo")
@RestController
public class JobInfoController {
    private final IJobInfoService jobInfoService;

    @ApiOperation("获取职位信息列表(分页)")
    @GetMapping("/page/list")
    public Result<PageResult<JobInfoResVO>> getPageJobInfoList(JobInfoPageQueryReqVO jobInfoPageQueryReqVO){
        return ResultUtils.success("获取职位信息分页列表成功！",jobInfoService.getPageJobInfoList(jobInfoPageQueryReqVO));
    }

    /**
     * 添加职位信息
     */
    @ApiOperation("添加职位信息")
    @PostMapping("/add")
    public Result<JobInfoResVO> addJobInfo(@RequestBody JobInfoCreateReqVO jobInfoCreateReqVO){
        return ResultUtils.success("添加职位信息成功！",jobInfoService.addJobInfo(jobInfoCreateReqVO));
    }

    /**
     * 更新职位信息
     * @param jobInfoUpdateReqVO
     * @return
     */
    @ApiOperation("更新职位信息")
    @PostMapping("/update")
    public Result<JobInfoResVO> updateJobInfo(@RequestBody JobInfoUpdateReqVO jobInfoUpdateReqVO){
        return ResultUtils.success("更新职位信息成功！",jobInfoService.updateJobInfo(jobInfoUpdateReqVO));
    }

    /**
     * 删除职位信息
     * @param id
     * @return
     */
    @ApiOperation("删除职位信息")
    @DeleteMapping("/delete/{id}")
    public Result<Boolean> deleteComPanyById(@PathVariable("id") Long id){
        return ResultUtils.success("删除职位信息成功！",jobInfoService.removeById(id));
    }
}
