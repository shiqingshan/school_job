package com.sc.web.controller.job;

import com.sc.app.service.job.IJobPositionService;
import com.sc.common.base.PageResult;
import com.sc.common.base.Result;
import com.sc.common.utils.ResultUtils;
import com.sc.model.entity.job.vo.JobPositionCreateReqVO;
import com.sc.model.entity.job.vo.JobPositionPageQueryReqVO;
import com.sc.model.entity.job.vo.JobPositionResVO;
import com.sc.model.entity.job.vo.JobPositionUpdateReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 工作岗位
 */
@Api(tags = "工作岗位")
@RequiredArgsConstructor
@RequestMapping("/job/position")
@RestController
public class JobPositionController {
    private final IJobPositionService jobPositionService;

    @ApiOperation("获取工作岗位列表(分页)")
    @GetMapping("/page/list")
    public Result<PageResult<JobPositionResVO>> getPageJobPositionList(JobPositionPageQueryReqVO jobPositionPageQueryReqVO){
        return ResultUtils.success("获取工作岗位分页列表成功！",jobPositionService.getPageJobPositionList(jobPositionPageQueryReqVO));
    }

    /**
     * 添加工作岗位
     */
    @ApiOperation("添加工作岗位")
    @PostMapping("/add")
    public Result<JobPositionResVO> addJobPosition(@RequestBody JobPositionCreateReqVO jobPositionCreateReqVO){
        return ResultUtils.success("添加工作岗位成功！",jobPositionService.addJobPosition(jobPositionCreateReqVO));
    }

    /**
     * 更新工作岗位
     * @param jobPositionUpdateReqVO
     * @return
     */
    @ApiOperation("更新工作岗位")
    @PostMapping("/update")
    public Result<JobPositionResVO> updateJobPosition(@RequestBody JobPositionUpdateReqVO jobPositionUpdateReqVO){
        return ResultUtils.success("更新工作岗位成功！",jobPositionService.updateJobPosition(jobPositionUpdateReqVO));
    }

    /**
     * 删除工作岗位
     * @param id
     * @return
     */
    @ApiOperation("删除工作岗位")
    @DeleteMapping("/delete/{id}")
    public Result<Boolean> deleteComPanyById(@PathVariable("id") Long id){
        return ResultUtils.success("删除工作岗位成功！",jobPositionService.removeById(id));
    }
}
