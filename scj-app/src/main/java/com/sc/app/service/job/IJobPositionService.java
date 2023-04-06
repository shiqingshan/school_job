package com.sc.app.service.job;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sc.common.base.PageResult;
import com.sc.model.entity.job.JobPositionDO;
import com.sc.model.entity.job.vo.JobPositionCreateReqVO;
import com.sc.model.entity.job.vo.JobPositionPageQueryReqVO;
import com.sc.model.entity.job.vo.JobPositionResVO;
import com.sc.model.entity.job.vo.JobPositionUpdateReqVO;

public interface IJobPositionService extends IService<JobPositionDO> {
    PageResult<JobPositionResVO> getPageJobPositionList(JobPositionPageQueryReqVO jobPositionPageQueryReqVO);

    JobPositionResVO addJobPosition(JobPositionCreateReqVO jobPositionCreateReqVO);

    JobPositionResVO updateJobPosition(JobPositionUpdateReqVO jobPositionUpdateReqVO);
}
