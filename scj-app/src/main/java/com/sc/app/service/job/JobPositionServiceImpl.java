package com.sc.app.service.job;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.app.convert.job.JobPositionConvert;
import com.sc.common.base.PageInfoVO;
import com.sc.common.base.PageResult;
import com.sc.common.exception.ServiceException;
import com.sc.common.exception.enums.ErrorCode;
import com.sc.model.entity.job.JobPositionDO;
import com.sc.model.entity.job.vo.JobPositionCreateReqVO;
import com.sc.model.entity.job.vo.JobPositionPageQueryReqVO;
import com.sc.model.entity.job.vo.JobPositionResVO;
import com.sc.model.entity.job.vo.JobPositionUpdateReqVO;
import com.sc.persistence.job.JobPositionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPositionServiceImpl extends ServiceImpl<JobPositionMapper, JobPositionDO> implements IJobPositionService{
    /**
     * @param jobPositionPageQueryReqVO
     * @return
     */
    @Override
    public PageResult<JobPositionResVO> getPageJobPositionList(JobPositionPageQueryReqVO jobPositionPageQueryReqVO) {
        JobPositionDO jobPositionDO = JobPositionConvert.INSTANCE.convert(jobPositionPageQueryReqVO);
        PageInfoVO pageInfo = jobPositionPageQueryReqVO.getPageInfo();
        Page<JobPositionDO> page = new Page<>(pageInfo.getPageNum(), pageInfo.getPageSize());
        Page<JobPositionDO> pageRes = page(page, new QueryWrapper<>(jobPositionDO));
        long total = pageRes.getTotal();
        List<JobPositionDO> records = pageRes.getRecords();
        List<JobPositionResVO> jobPositionResVOList =  JobPositionConvert.INSTANCE.convert(records);
        return new PageResult<>(jobPositionResVOList,total);
    }

    /**
     * @param jobPositionCreateReqVO
     * @return
     */
    @Override
    public JobPositionResVO addJobPosition(JobPositionCreateReqVO jobPositionCreateReqVO) {
        JobPositionDO jobPositionDO = JobPositionConvert.INSTANCE.convert(jobPositionCreateReqVO);
        if(save(jobPositionDO)){
            return JobPositionConvert.INSTANCE.convert(jobPositionDO);
        }
        throw new ServiceException(ErrorCode.SERVICE_ERROR.getCode(),"添加岗位失败");
    }

    /**
     * @param jobPositionUpdateReqVO
     * @return
     */
    @Override
    public JobPositionResVO updateJobPosition(JobPositionUpdateReqVO jobPositionUpdateReqVO) {
        JobPositionDO jobPositionDO = JobPositionConvert.INSTANCE.convert(jobPositionUpdateReqVO);
        if(updateById(jobPositionDO)){
            return JobPositionConvert.INSTANCE.convert(jobPositionDO);
        }
        throw new ServiceException(ErrorCode.SERVICE_ERROR.getCode(),"更新岗位失败");
    }
}
