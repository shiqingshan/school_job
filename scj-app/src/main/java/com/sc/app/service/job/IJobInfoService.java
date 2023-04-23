package com.sc.app.service.job;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sc.common.base.PageResult;
import com.sc.model.entity.job.JobInfoDO;
import com.sc.model.entity.job.vo.JobInfoCreateReqVO;
import com.sc.model.entity.job.vo.JobInfoPageQueryReqVO;
import com.sc.model.entity.job.vo.JobInfoResVO;
import com.sc.model.entity.job.vo.JobInfoUpdateReqVO;

import java.util.List;

public interface IJobInfoService extends IService<JobInfoDO> {
    PageResult<JobInfoResVO> getPageJobInfoList(JobInfoPageQueryReqVO jobInfoPageQueryReqVO);

    JobInfoResVO addJobInfo(JobInfoCreateReqVO jobInfoCreateReqVO);

    JobInfoResVO updateJobInfo(JobInfoUpdateReqVO jobInfoUpdateReqVO);

    PageResult<JobInfoResVO> getPageJobInfoListByUserId(JobInfoPageQueryReqVO jobInfoPageQueryReqVO);

    JobInfoResVO getJobInfo(String id);

    List<JobInfoResVO> getHotJobInfoList(JobInfoPageQueryReqVO jobInfoPageQueryReqVO);
}
