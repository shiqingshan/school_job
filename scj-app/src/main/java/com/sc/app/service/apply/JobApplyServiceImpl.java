package com.sc.app.service.apply;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.app.convert.apply.JobApplyConvert;
import com.sc.app.service.TokenService;
import com.sc.app.service.company.ICompanyService;
import com.sc.app.service.job.IJobInfoService;
import com.sc.app.service.resume.IUserResumeFileService;
import com.sc.app.service.user.IUserService;
import com.sc.common.base.PageResult;
import com.sc.common.exception.ServiceException;
import com.sc.model.entity.apply.JobApplyDO;
import com.sc.model.entity.apply.vo.JobApplyCreateReqVO;
import com.sc.model.entity.apply.vo.JobApplyPageQueryReqVO;
import com.sc.model.entity.apply.vo.JobApplyResVO;
import com.sc.model.entity.apply.vo.JobApplyUpdateReqVO;
import com.sc.model.entity.auth.LoginUserInfo;
import com.sc.model.entity.company.vo.CompanyResVO;
import com.sc.model.entity.job.vo.JobInfoResVO;
import com.sc.model.entity.resume.vo.UserResumeFileResVO;
import com.sc.model.entity.user.vo.UserResVO;
import com.sc.model.enumdict.job.JobApplyStatusEnum;
import com.sc.model.enumdict.job.JobStatusEnum;
import com.sc.persistence.apply.JobApplyMapper;
import com.sc.persistence.job.JobInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobApplyServiceImpl extends ServiceImpl<JobApplyMapper, JobApplyDO> implements IJobApplyService {
    private final TokenService tokenService;
    private final IJobInfoService jobInfoService;
    private final IUserService userService;
    private final ICompanyService companyService;
    private final JobApplyMapper jobApplyMapper;
    private final IUserResumeFileService userResumeFileService;
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
        //获取职位信息
        addJobInfo(jobApplyResVOList);
        return new PageResult<>(jobApplyResVOList,total);
    }

    /**
     * @param jobApplyCreateReqVO
     * @return
     */
    @Override
    public JobApplyResVO addJobApply(JobApplyCreateReqVO jobApplyCreateReqVO) {
        //获取当前登录用户
        LoginUserInfo loginUser = tokenService.getLoginUser();
        jobApplyCreateReqVO.setUserId(String.valueOf(loginUser.getUserId()));
        //获取职位信息
        JobInfoResVO jobInfo = jobInfoService.getJobInfo(jobApplyCreateReqVO.getJobId());
        if(jobInfo == null){
            throw new ServiceException("职位不存在");
        }
        //判断职位信息是否是发布中
        if(!JobStatusEnum.PUBLISHING.getCode().equals(Integer.parseInt(jobInfo.getJobStatus())) ){
            throw new ServiceException("职位不是发布中状态");
        }
        //判断是否已经申请过该职位
        JobApplyDO getJoApply = getOne(new QueryWrapper<JobApplyDO>().eq("user_id",jobApplyCreateReqVO.getUserId()).eq("job_id",jobApplyCreateReqVO.getJobId()));
        if(getJoApply != null){
            throw new ServiceException("已经申请过该职位!");
        }
        JobApplyDO jobApplyDO = JobApplyConvert.INSTANCE.convert(jobApplyCreateReqVO);
        jobApplyDO.setApplyDate(new Date());
        jobApplyDO.setStatus(JobApplyStatusEnum.WAIT.getCode());
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

    /**
     * @param jobApplyPageQueryReqVO
     * @return
     */
    @Override
    public PageResult<JobApplyResVO> getJobApplyListByUser(JobApplyPageQueryReqVO jobApplyPageQueryReqVO) {
        LoginUserInfo loginUser = tokenService.getLoginUser();
        Long userId = loginUser.getUserId();
        Page<JobApplyDO> page = new Page<>(jobApplyPageQueryReqVO.getPageNum(), jobApplyPageQueryReqVO.getPageSize());
        Page<JobApplyDO> pageRes = page(page, new QueryWrapper<JobApplyDO>().eq("user_id",userId));
        long total = pageRes.getTotal();
        List<JobApplyDO> records = pageRes.getRecords();
        List<JobApplyResVO> jobApplyResVOList =  JobApplyConvert.INSTANCE.convert(records);
        //获取职位信息
        addJobInfo(jobApplyResVOList);
        return new PageResult<>(jobApplyResVOList,total);
    }

    private void addJobInfo(List<JobApplyResVO> jobApplyResVOList) {
        jobApplyResVOList.forEach(this::addJobInfo);

    }

    private void addJobInfo(JobApplyResVO jobApplyResVO) {
        JobInfoResVO jobInfo = jobInfoService.getJobInfo(jobApplyResVO.getJobId());
        jobApplyResVO.setJobInfo(jobInfo);
        UserResVO userInfo = userService.getUserInfo(jobApplyResVO.getUserId());
        jobApplyResVO.setUserInfo(userInfo);
        UserResumeFileResVO userResumeFileResVO = userResumeFileService.getUserResumeFile(jobApplyResVO.getResumeFileId());
        jobApplyResVO.setResumeFileInfo(userResumeFileResVO);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public JobApplyResVO getJobApplyById(String id) {
        JobApplyDO jobApplyDO = getById(id);
        if(jobApplyDO != null){
            JobApplyResVO jobApplyResVO = JobApplyConvert.INSTANCE.convert(jobApplyDO);
            addJobInfo(jobApplyResVO);
            return jobApplyResVO;
        }
        return null;
    }

    /**
     * @param jobApplyPageQueryReqVO
     * @return
     */
    @Override
    public PageResult<JobApplyResVO> getJobApplyListByCompany(JobApplyPageQueryReqVO jobApplyPageQueryReqVO) {
        List<CompanyResVO> loginCompanyTreeList = companyService.getLoginCompanyTreeList();
        Page<JobApplyDO> page = new Page<>(jobApplyPageQueryReqVO.getPageNum(), jobApplyPageQueryReqVO.getPageSize());
        Page<JobApplyDO> pageRes = jobApplyMapper.selectPageByCoId(page,loginCompanyTreeList.stream().map(CompanyResVO::getId).collect(Collectors.toList()));
        long total = pageRes.getTotal();
        List<JobApplyDO> records = pageRes.getRecords();
        List<JobApplyResVO> jobApplyResVOList =  JobApplyConvert.INSTANCE.convert(records);
        addJobInfo(jobApplyResVOList);
        return new PageResult<>(jobApplyResVOList,total);
    }
}
