package com.sc.app.service.job;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.app.convert.job.JobDetailConvert;
import com.sc.app.convert.job.JobInfoConvert;
import com.sc.app.service.TokenService;
import com.sc.common.base.PageResult;
import com.sc.common.exception.ServiceException;
import com.sc.model.entity.auth.LoginUserInfo;
import com.sc.model.entity.company.CompanyDO;
import com.sc.model.entity.job.JobDetailDO;
import com.sc.model.entity.job.JobInfoDO;
import com.sc.model.entity.job.JobPositionDO;
import com.sc.model.entity.job.vo.*;
import com.sc.model.entity.user.UserDO;
import com.sc.persistence.company.CompanyMapper;
import com.sc.persistence.job.JobDetailMapper;
import com.sc.persistence.job.JobInfoMapper;
import com.sc.persistence.job.JobPositionMapper;
import com.sc.persistence.user.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

@Service
@Slf4j
@RequiredArgsConstructor
public class JobInfoServiceImpl extends ServiceImpl<JobInfoMapper, JobInfoDO> implements IJobInfoService {
    private final JobPositionMapper jobPositionMapper;
    private final CompanyMapper companyMapper;
    private final UserMapper userMapper;
    private final TokenService tokenService;
    private final JobDetailMapper jobDetailMapper;
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
            addJobDetail(jobInfoResVOList);
        }
        return new PageResult<>(jobInfoResVOList,total);
    }

    private void addJobDetail(List<JobInfoResVO> jobInfoResVOList) {
        Set<String> ids = jobInfoResVOList.stream().map(JobInfoResVO::getId).collect(Collectors.toSet());
        List<JobDetailDO> jobDetailDOs = jobDetailMapper.selectList(Wrappers.lambdaQuery(JobDetailDO.class).in(JobDetailDO::getJobId, ids));
        Map<Long, JobDetailDO> map = jobDetailDOs.stream().collect(toMap(JobDetailDO::getJobId, jobDetailDO -> jobDetailDO));
        jobInfoResVOList.forEach(jobInfoResVO -> {
            JobDetailDO jobDetailDO = map.get(Long.parseLong(jobInfoResVO.getId()));
            JobInfoConvert.INSTANCE.merge(jobInfoResVO,jobDetailDO);
        });
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
    @Transactional(rollbackFor = Exception.class)
    public JobInfoResVO addJobInfo(JobInfoCreateReqVO jobInfoCreateReqVO) {
        LoginUserInfo loginUser = tokenService.getLoginUser();
        JobInfoDO jobInfoDO = JobInfoConvert.INSTANCE.convert(jobInfoCreateReqVO);
        jobInfoDO.setUserId(loginUser.getUserId());
        if(save(jobInfoDO)){
            //添加职位详情
            JobDetailDO jobDetailDO = JobDetailConvert.INSTANCE.convert(jobInfoCreateReqVO);
            jobDetailDO.setJobId(jobInfoDO.getId());
            if(jobDetailMapper.insert(jobDetailDO)>0){
                return JobInfoConvert.INSTANCE.convert(jobInfoDO);
            }
            log.error("添加职位详情失败");
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

    /**
     * @param jobInfoPageQueryReqVO
     * @return
     */
    @Override
    public PageResult<JobInfoResVO> getPageJobInfoListByUserId(JobInfoPageQueryReqVO jobInfoPageQueryReqVO) {
        LoginUserInfo loginUser = tokenService.getLoginUser();
        Page<JobInfoDO> page = new Page<>(jobInfoPageQueryReqVO.getPageNum(), jobInfoPageQueryReqVO.getPageSize());
        Page<JobInfoDO> pageRes = page(page, new LambdaQueryWrapper<>(JobInfoDO.class).eq(JobInfoDO::getUserId, loginUser.getUserId()));
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

    /**
     * @param id
     * @return
     */
    @Override
    public JobInfoResVO getJobInfo(String id) {
        //获取职位信息
        JobInfoDO jobInfoDO = getById(id);
        if(jobInfoDO!=null){
            CompanyDO companyDO = companyMapper.selectOne(Wrappers.lambdaQuery(CompanyDO.class).eq(CompanyDO::getId, jobInfoDO.getCoId()));
            //获取职位详情
            JobDetailDO jobDetailDO = jobDetailMapper.selectOne(Wrappers.lambdaQuery(JobDetailDO.class).eq(JobDetailDO::getJobId, id));

            if(jobDetailDO!=null){
                JobInfoResVO jobInfoResVO = JobInfoConvert.INSTANCE.convert(jobInfoDO, jobDetailDO);
                jobInfoResVO.setCoName(companyDO.getName());
                return jobInfoResVO;
            }
        }
        return null;
    }
}
