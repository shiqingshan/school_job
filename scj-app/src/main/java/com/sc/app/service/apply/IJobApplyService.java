package com.sc.app.service.apply;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sc.common.base.PageResult;
import com.sc.model.entity.apply.JobApplyDO;
import com.sc.model.entity.apply.vo.JobApplyCreateReqVO;
import com.sc.model.entity.apply.vo.JobApplyPageQueryReqVO;
import com.sc.model.entity.apply.vo.JobApplyResVO;
import com.sc.model.entity.apply.vo.JobApplyUpdateReqVO;

public interface IJobApplyService extends IService<JobApplyDO> {
    PageResult<JobApplyResVO> getPageJobApplyList(JobApplyPageQueryReqVO jobApplyPageQueryReqVO);

    JobApplyResVO addJobApply(JobApplyCreateReqVO jobApplyCreateReqVO);

    JobApplyResVO updateJobApply(JobApplyUpdateReqVO jobApplyUpdateReqVO);
}
