package com.sc.app.service.apply;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.app.convert.apply.InterviewInvitationConvert;
import com.sc.app.service.TokenService;
import com.sc.app.service.company.ICompanyService;
import com.sc.app.service.user.IUserService;
import com.sc.common.base.PageResult;
import com.sc.common.exception.ServiceException;
import com.sc.model.entity.apply.*;
import com.sc.model.entity.apply.vo.*;
import com.sc.model.entity.auth.LoginUserInfo;
import com.sc.model.entity.company.vo.CompanyResVO;
import com.sc.model.enumdict.job.JobInterviewEnum;
import com.sc.persistence.apply.InterviewInvitationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InterviewInvitationServiceImpl extends 
        ServiceImpl<InterviewInvitationMapper, InterviewInvitationDO>
        implements IInterviewInvitationService{
    private final TokenService tokenService;
    private final ICompanyService companyService;
    private final IJobApplyService jobApplyService;
    private final IUserService userService;

    /**
     * @param interviewInvitationPageQueryReqVO
     * @return
     */
    @Override
    public PageResult<InterviewInvitationResVO> getPageInterviewInvitationList(InterviewInvitationPageQueryReqVO interviewInvitationPageQueryReqVO) {
        InterviewInvitationDO interviewInvitationDO = InterviewInvitationConvert.INSTANCE.convert(interviewInvitationPageQueryReqVO);
        Page<InterviewInvitationDO> page = new Page<>(interviewInvitationPageQueryReqVO.getPageNum(), interviewInvitationPageQueryReqVO.getPageSize());
        Page<InterviewInvitationDO> pageRes = page(page, new QueryWrapper<>(interviewInvitationDO));
        long total = pageRes.getTotal();
        List<InterviewInvitationDO> records = pageRes.getRecords();
        List<InterviewInvitationResVO> interviewInvitationResVOList =  InterviewInvitationConvert.INSTANCE.convert(records);
        return new PageResult<>(interviewInvitationResVOList,total);
    }

    /**
     * @param interviewInvitationCreateReqVO
     * @return
     */
    @Override
    public InterviewInvitationResVO addInterviewInvitation(InterviewInvitationCreateReqVO interviewInvitationCreateReqVO) {
        InterviewInvitationDO interviewInvitationDO = InterviewInvitationConvert.INSTANCE.convert(interviewInvitationCreateReqVO);
        interviewInvitationDO.setInvitationDate(new Date());
        interviewInvitationDO.setStatus(JobInterviewEnum.WAITING.getCode());
        if(save(interviewInvitationDO)){
            return InterviewInvitationConvert.INSTANCE.convert(interviewInvitationDO);
        }
        throw new ServiceException("添加职位申请失败");
    }

    /**
     * @param interviewInvitationUpdateReqVO
     * @return
     */
    @Override
    public InterviewInvitationResVO updateInterviewInvitation(InterviewInvitationUpdateReqVO interviewInvitationUpdateReqVO) {
        InterviewInvitationDO interviewInvitationDO = InterviewInvitationConvert.INSTANCE.convert(interviewInvitationUpdateReqVO);
        if(updateById(interviewInvitationDO)){
            return InterviewInvitationConvert.INSTANCE.convert(interviewInvitationDO);
        }
        throw new ServiceException("更新职位申请失败");
    }

    /**
     * @return
     */
    @Override
    public PageResult<InterviewInvitationResVO> getInterviewInvitationListByCompany(InterviewInvitationPageQueryReqVO interviewInvitationPageQueryReqVO) {
        List<CompanyResVO> loginCompanyTreeList = companyService.getLoginCompanyTreeList();
        if(loginCompanyTreeList.isEmpty()){
            throw new ServiceException("当前登录用户没有公司信息");
        }
        Page<InterviewInvitationDO> page = new Page<>(interviewInvitationPageQueryReqVO.getPageNum(), interviewInvitationPageQueryReqVO.getPageSize());
        Page<InterviewInvitationDO> pageRes = page(page, new QueryWrapper<InterviewInvitationDO>()
                .in("co_id",loginCompanyTreeList.stream().map(CompanyResVO::getId).collect(Collectors.toList())));
        long total = pageRes.getTotal();
        List<InterviewInvitationDO> records = pageRes.getRecords();
        List<InterviewInvitationResVO> interviewInvitationResVOList =  InterviewInvitationConvert.INSTANCE.convert(records);
        addInterviewMore(interviewInvitationResVOList);
        return new PageResult<>(interviewInvitationResVOList,total);
    }


    private void addInterviewMore(List<InterviewInvitationResVO> interviewInvitationResVOList) {
        interviewInvitationResVOList.forEach(this::addInterviewMore);
    }
    private void addInterviewMore(InterviewInvitationResVO interviewInvitationResVO) {
        interviewInvitationResVO.setUserInfo(userService.getUserInfo(interviewInvitationResVO.getUserId()));
        interviewInvitationResVO.setJobApplyInfo(jobApplyService.getJobApplyById(interviewInvitationResVO.getApplyId()));
    }

    /**
     * @param id
     * @return
     */
    @Override
    public InterviewInvitationResVO getInterviewInvitationById(String id) {
        InterviewInvitationDO interviewInvitationDO = getById(id);
        if(interviewInvitationDO == null){
            throw new ServiceException("面试信息不存在");
        }
        InterviewInvitationResVO interviewInvitationResVO = InterviewInvitationConvert.INSTANCE.convert(interviewInvitationDO);
        addInterviewMore(interviewInvitationResVO);
        return interviewInvitationResVO;
    }

    /**
     * @param interviewInvitationPageQueryReqVO
     * @return
     */
    @Override
    public PageResult<InterviewInvitationResVO> getInterviewInvitationListByUser(InterviewInvitationPageQueryReqVO interviewInvitationPageQueryReqVO) {
        LoginUserInfo loginUser = tokenService.getLoginUser();
        Long userId = loginUser.getUserId();
        Page<InterviewInvitationDO> page = new Page<>(interviewInvitationPageQueryReqVO.getPageNum(), interviewInvitationPageQueryReqVO.getPageSize());
        Page<InterviewInvitationDO> pageRes = page(page, new QueryWrapper<InterviewInvitationDO>()
                .eq("user_id",userId));
        long total = pageRes.getTotal();
        List<InterviewInvitationDO> records = pageRes.getRecords();
        List<InterviewInvitationResVO> interviewInvitationResVOList =  InterviewInvitationConvert.INSTANCE.convert(records);
        addInterviewMore(interviewInvitationResVOList);
        return new PageResult<>(interviewInvitationResVOList,total);
    }
}
