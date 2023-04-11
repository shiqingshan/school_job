package com.sc.app.service.apply;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.app.convert.apply.JobApplyConvert;
import com.sc.common.base.PageResult;
import com.sc.common.exception.ServiceException;
import com.sc.model.entity.apply.JobApplyDO;
import com.sc.model.entity.apply.vo.JobApplyCreateReqVO;
import com.sc.model.entity.apply.vo.JobApplyPageQueryReqVO;
import com.sc.model.entity.apply.vo.JobApplyResVO;
import com.sc.model.entity.apply.vo.JobApplyUpdateReqVO;
import com.sc.persistence.apply.JobApplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobApplyServiceImpl extends ServiceImpl<JobApplyMapper, JobApplyDO> implements IJobApplyService {
    /**
     * @param jobApplyPageQueryReqVO
     * @return
     */
    @Override
    public PageResult<JobApplyResVO> getPageJobApplyList(JobApplyPageQueryReqVO jobApplyPageQueryReqVO) {
        JobApplyDO jobApplyDO = JobApplyConvert.INSTANCE.convert(jobApplyPageQueryReqVO);
        Page<JobApplyDO> page = new Page<>(jobApplyPageQueryReqVO.getPageNum(), jobApplyPageQueryReqVO.getPageSize());
        Page<JobApplyDO> pageRes = page(page, new QueryWrapper<>(jobApplyDO));
        long total = pageRes.getTotal();
        List<JobApplyDO> records = pageRes.getRecords();
        List<JobApplyResVO> jobApplyResVOList =  JobApplyConvert.INSTANCE.convert(records);
        return new PageResult<>(jobApplyResVOList,total);
    }

    /**
     * @param jobApplyCreateReqVO
     * @return
     */
    @Override
    public JobApplyResVO addJobApply(JobApplyCreateReqVO jobApplyCreateReqVO) {
        JobApplyDO jobApplyDO = JobApplyConvert.INSTANCE.convert(jobApplyCreateReqVO);
        if(save(jobApplyDO)){
            return JobApplyConvert.INSTANCE.convert(jobApplyDO);
        }
        throw new ServiceException("添加职位申请失败");
    }

    /**
     * @param jobApplyUpdateReqVO
     * @return
     */
    @Override
    public JobApplyResVO updateJobApply(JobApplyUpdateReqVO jobApplyUpdateReqVO) {
        JobApplyDO jobApplyDO = JobApplyConvert.INSTANCE.convert(jobApplyUpdateReqVO);
        if(updateById(jobApplyDO)){
            return JobApplyConvert.INSTANCE.convert(jobApplyDO);
        }
        throw new ServiceException("更新职位申请失败");
    }
}
