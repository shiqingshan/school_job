package com.sc.app.service.job;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sc.model.entity.job.JobDetailDO;
import com.sc.model.entity.job.vo.JobDetailCreateReqVO;
import com.sc.model.entity.job.vo.JobDetailResVO;
import com.sc.model.entity.job.vo.JobDetailUpdateReqVO;

public interface IJobDetailService extends IService<JobDetailDO> {
    JobDetailResVO addJobDetail(JobDetailCreateReqVO jobInfoCreateReqVO);

    JobDetailResVO updateJobDetail(JobDetailUpdateReqVO jobInfoUpdateReqVO);

    JobDetailResVO getJobDetailByJobId(String jobId);
}
