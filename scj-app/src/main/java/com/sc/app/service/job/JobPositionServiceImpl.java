package com.sc.app.service.job;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.app.convert.job.JobPositionConvert;
import com.sc.common.base.PageResult;
import com.sc.common.exception.ServiceException;
import com.sc.model.entity.job.JobPositionDO;
import com.sc.model.entity.job.vo.*;
import com.sc.persistence.job.JobPositionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
        Page<JobPositionDO> page = new Page<>(jobPositionPageQueryReqVO.getPageNum(), jobPositionPageQueryReqVO.getPageSize());
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

        Long parentId = jobPositionDO.getParentId();
        if(Objects.isNull(parentId)){
            if(save(jobPositionDO)){
                return JobPositionConvert.INSTANCE.convert(jobPositionDO);
            }
        }else{
            JobPositionDO prentJobPositionDO = getById(parentId);
            if(Objects.isNull(prentJobPositionDO)){
                throw new ServiceException("父岗位不存在");
            }
            if(!"0".equals(prentJobPositionDO.getStatus())){
                throw new ServiceException("父岗位已禁用");
            }
            jobPositionDO.setAncestors(prentJobPositionDO.getAncestors()+","+parentId);
            if(save(jobPositionDO)){
                return JobPositionConvert.INSTANCE.convert(jobPositionDO);
            }
        }
        throw new ServiceException("添加岗位失败");
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
        throw new ServiceException("更新岗位失败");
    }

    @Override
    public List<JobPositionResVO> getJobPositionList(JobPositionQueryReqVO jobPositionQueryReqVO) {
        JobPositionDO jobPositionDO = JobPositionConvert.INSTANCE.convert(jobPositionQueryReqVO);
        return JobPositionConvert.INSTANCE.convert(list(new QueryWrapper<>(jobPositionDO)));
    }
}
