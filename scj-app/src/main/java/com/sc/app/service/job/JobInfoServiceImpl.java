package com.sc.app.service.job;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.app.convert.job.JobInfoConvert;
import com.sc.common.base.PageInfoVO;
import com.sc.common.base.PageResult;
import com.sc.common.exception.ServiceException;
import com.sc.common.exception.enums.ErrorCode;
import com.sc.model.entity.job.JobInfoDO;
import com.sc.model.entity.job.vo.*;
import com.sc.persistence.job.JobInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobInfoServiceImpl extends ServiceImpl<JobInfoMapper, JobInfoDO> implements IJobInfoService {
    /**
     * @param jobInfoPageQueryReqVO
     * @return
     */
    @Override
    public PageResult<JobInfoResVO> getPageJobInfoList(JobInfoPageQueryReqVO jobInfoPageQueryReqVO) {
        JobInfoDO jobInfoDO = JobInfoConvert.INSTANCE.convert(jobInfoPageQueryReqVO);
        PageInfoVO pageInfo = jobInfoPageQueryReqVO.getPageInfo();
        Page<JobInfoDO> page = new Page<>(pageInfo.getPageNum(), pageInfo.getPageSize());
        Page<JobInfoDO> pageRes = page(page, new QueryWrapper<>(jobInfoDO));
        long total = pageRes.getTotal();
        List<JobInfoDO> records = pageRes.getRecords();
        List<JobInfoResVO> jobPositionResVOList =  JobInfoConvert.INSTANCE.convert(records);
        return new PageResult<>(jobPositionResVOList,total);
    }

    /**
     * @param jobInfoCreateReqVO
     * @return
     */
    @Override
    public JobInfoResVO addJobInfo(JobInfoCreateReqVO jobInfoCreateReqVO) {
        JobInfoDO jobInfoDO = JobInfoConvert.INSTANCE.convert(jobInfoCreateReqVO);
        if(save(jobInfoDO)){
            return JobInfoConvert.INSTANCE.convert(jobInfoDO);
        }
        throw new ServiceException(ErrorCode.SERVICE_ERROR.getCode(),"添加职位失败");
    }

    /**
     * @param jobInfoUpdateReqVO
     * @return
     */
    @Override
    public JobInfoResVO updateJobInfo(JobInfoUpdateReqVO jobInfoUpdateReqVO) {
        JobInfoDO jobInfoDO = JobInfoConvert.INSTANCE.convert(jobInfoUpdateReqVO);
        if(updateById(jobInfoDO)){
            return JobInfoConvert.INSTANCE.convert(jobInfoDO);
        }
        throw new ServiceException(ErrorCode.SERVICE_ERROR.getCode(),"更新职位失败");
    }
}
