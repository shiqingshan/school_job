package com.sc.web.controller.job;

import com.sc.app.convert.job.JobPositionConvert;
import com.sc.app.service.job.IJobPositionService;
import com.sc.common.base.Result;
import com.sc.common.utils.ResultUtils;
import com.sc.common.utils.StringUtils;
import com.sc.model.entity.job.vo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 工作岗位
 */
@Api(tags = "工作岗位")
@RequiredArgsConstructor
@RequestMapping("/job/position")
@RestController
public class JobPositionController {
    private final IJobPositionService jobPositionService;

    @ApiOperation("获取工作岗位列表")
    @GetMapping("/list")
    public Result<List<JobPositionResVO>> getJobPositionList(JobPositionQueryReqVO jobPositionQueryReqVO){
        return ResultUtils.success("获取工作岗位分页列表成功！",jobPositionService.getJobPositionList(jobPositionQueryReqVO));
    }

    @ApiOperation("获取工作岗位列表")
    @GetMapping("/list/exclude/{id}")
    public Result<List<JobPositionResVO>> getJobPositionList(@PathVariable(value = "id", required = false) Long id){
        List<JobPositionResVO> positionList = jobPositionService.getJobPositionList(new JobPositionQueryReqVO());
        positionList.removeIf(d -> Long.parseLong(d.getId()) == id || ArrayUtils.contains(StringUtils.split(d.getAncestors(), ","), id + ""));
        return ResultUtils.success("获取工作岗位分页列表成功！",positionList);
    }
    @ApiOperation("获取工作岗位")
    @GetMapping("/{id}")
    public Result<JobPositionResVO> getJobPosition(@PathVariable(value = "id") String id){
        return ResultUtils.success("获取岗位分类成功！", JobPositionConvert.INSTANCE.convert(jobPositionService.getById(id)));
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
    @PutMapping("/update")
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
