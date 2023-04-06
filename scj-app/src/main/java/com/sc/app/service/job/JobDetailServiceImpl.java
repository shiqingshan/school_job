package com.sc.app.service.job;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.app.convert.job.JobDetailConvert;
import com.sc.common.exception.ServiceException;
import com.sc.common.exception.enums.ErrorCode;
import com.sc.model.entity.job.JobDetailDO;
import com.sc.model.entity.job.vo.*;
import com.sc.persistence.job.JobDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobDetailServiceImpl extends ServiceImpl<JobDetailMapper, JobDetailDO> implements IJobDetailService {
    /**
     * @param jobDetailCreateReqVO
     * @return
     */
    @Override
    public JobDetailResVO addJobDetail(JobDetailCreateReqVO jobDetailCreateReqVO) {
        JobDetailDO jobDetailDO = JobDetailConvert.INSTANCE.convert(jobDetailCreateReqVO);
        if(save(jobDetailDO)){
            return JobDetailConvert.INSTANCE.convert(jobDetailDO);
        }
        throw new ServiceException(ErrorCode.SERVICE_ERROR.getCode(),"添加职位详情失败");
    }

    /**
     * @param jobDetailUpdateReqVO
     * @return
     */
    @Override
    public JobDetailResVO updateJobDetail(JobDetailUpdateReqVO jobDetailUpdateReqVO) {
        JobDetailDO jobDetailDO = JobDetailConvert.INSTANCE.convert(jobDetailUpdateReqVO);
        if(updateById(jobDetailDO)){
            return JobDetailConvert.INSTANCE.convert(jobDetailDO);
        }
        throw new ServiceException(ErrorCode.SERVICE_ERROR.getCode(),"更新职位详情失败");
    }

    /**
     * @param jobId
     * @return
     */
    @Override
    public JobDetailResVO getJobDetailByJobId(String jobId) {
        JobDetailDO jobDetailDO = getOne(new LambdaQueryWrapper<JobDetailDO>().eq(JobDetailDO::getJobId, jobId));
        return JobDetailConvert.INSTANCE.convert(jobDetailDO);
    }
}
