package com.sc.app.service.job;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.app.convert.job.JobInfoConvert;
import com.sc.common.base.PageResult;
import com.sc.common.core.domain.entity.SysUser;
import com.sc.common.exception.ServiceException;
import com.sc.model.entity.company.CompanyDO;
import com.sc.model.entity.job.JobInfoDO;
import com.sc.model.entity.job.JobPositionDO;
import com.sc.model.entity.job.vo.*;
import com.sc.model.entity.user.UserDO;
import com.sc.persistence.company.CompanyMapper;
import com.sc.persistence.job.JobInfoMapper;
import com.sc.persistence.job.JobPositionMapper;
import com.sc.persistence.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

@Service
@RequiredArgsConstructor
public class JobInfoServiceImpl extends ServiceImpl<JobInfoMapper, JobInfoDO> implements IJobInfoService {
    private final JobPositionMapper jobPositionMapper;
    private final CompanyMapper companyMapper;
    private final UserMapper userMapper;
    /**
     * @param jobInfoPageQueryReqVO
     * @return
     */
    @Override
    public PageResult<JobInfoResVO> getPageJobInfoList(JobInfoPageQueryReqVO jobInfoPageQueryReqVO) {
        JobInfoDO jobInfoDO = JobInfoConvert.INSTANCE.convert(jobInfoPageQueryReqVO);
        Page<JobInfoDO> page = new Page<>(jobInfoPageQueryReqVO.getPageNum(), jobInfoPageQueryReqVO.getPageSize());
        Page<JobInfoDO> pageRes = page(page, new QueryWrapper<>(jobInfoDO));
        long total = pageRes.getTotal();
        List<JobInfoDO> records = pageRes.getRecords();
        List<JobInfoResVO> jobInfoResVOList =  JobInfoConvert.INSTANCE.convert(records);
        if(!jobInfoResVOList.isEmpty()){
            addUserName(jobInfoResVOList);
            addCoName(jobInfoResVOList);
            addJobPositionName(jobInfoResVOList);
        }
        return new PageResult<>(jobInfoResVOList,total);
    }

    private void addUserName(List<JobInfoResVO> jobInfoResVOList) {
        Set<String> ids = jobInfoResVOList.stream().map(JobInfoResVO::getUserId).collect(Collectors.toSet());
        List<UserDO> sysUsers = userMapper.selectList(Wrappers.lambdaQuery(UserDO.class).in(UserDO::getId, ids));
        Map<Long, String> map = sysUsers.stream().collect(toMap(UserDO::getId, UserDO::getUserName));
        jobInfoResVOList.forEach(jobInfoResVO -> jobInfoResVO.setUserName(map.get(Long.parseLong(jobInfoResVO.getUserId()))));
    }

    private void addJobPositionName(List<JobInfoResVO> jobInfoResVOList) {
        Set<String> ids = jobInfoResVOList.stream().map(JobInfoResVO::getPositionId).collect(Collectors.toSet());
        List<JobPositionDO> jobPositionDOS = jobPositionMapper.selectList(Wrappers.lambdaQuery(JobPositionDO.class).in(JobPositionDO::getId, ids));
        Map<Long, String> map = jobPositionDOS.stream().collect(toMap(JobPositionDO::getId, JobPositionDO::getPositionName));
        jobInfoResVOList.forEach(jobInfoResVO -> jobInfoResVO.setPositionName(map.get(Long.parseLong(jobInfoResVO.getPositionId()))));
    }

    private void addCoName(List<JobInfoResVO> jobInfoResVOList) {
        Set<String> ids = jobInfoResVOList.stream().map(JobInfoResVO::getCoId).collect(Collectors.toSet());
        List<CompanyDO> jobPositionDOS = companyMapper.selectList(Wrappers.lambdaQuery(CompanyDO.class).in(CompanyDO::getId, ids));
        Map<Long, String> map = jobPositionDOS.stream().collect(toMap(CompanyDO::getId, CompanyDO::getName));
        jobInfoResVOList.forEach(jobInfoResVO -> jobInfoResVO.setCoName(map.get(Long.parseLong(jobInfoResVO.getCoId()))));
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
        throw new ServiceException("添加职位失败");
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
        throw new ServiceException("更新职位失败");
    }
}
