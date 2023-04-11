package com.sc.app.service.job;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sc.common.base.PageResult;
import com.sc.model.entity.job.JobPositionDO;
import com.sc.model.entity.job.vo.*;

import java.util.List;

public interface IJobPositionService extends IService<JobPositionDO> {
    PageResult<JobPositionResVO> getPageJobPositionList(JobPositionPageQueryReqVO jobPositionPageQueryReqVO);

    JobPositionResVO addJobPosition(JobPositionCreateReqVO jobPositionCreateReqVO);

    JobPositionResVO updateJobPosition(JobPositionUpdateReqVO jobPositionUpdateReqVO);

    List<JobPositionResVO> getJobPositionList(JobPositionQueryReqVO jobPositionQueryReqVO);
}
