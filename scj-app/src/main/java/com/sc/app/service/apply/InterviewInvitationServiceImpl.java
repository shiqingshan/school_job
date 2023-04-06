package com.sc.app.service.apply;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.app.convert.apply.InterviewInvitationConvert;
import com.sc.common.base.PageInfoVO;
import com.sc.common.base.PageResult;
import com.sc.common.exception.ServiceException;
import com.sc.common.exception.enums.ErrorCode;
import com.sc.model.entity.apply.InterviewInvitationDO;
import com.sc.model.entity.apply.vo.InterviewInvitationCreateReqVO;
import com.sc.model.entity.apply.vo.InterviewInvitationPageQueryReqVO;
import com.sc.model.entity.apply.vo.InterviewInvitationResVO;
import com.sc.model.entity.apply.vo.InterviewInvitationUpdateReqVO;
import com.sc.persistence.apply.InterviewInvitationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InterviewInvitationServiceImpl extends 
        ServiceImpl<InterviewInvitationMapper, InterviewInvitationDO> 
        implements IInterviewInvitationService{
    /**
     * @param interviewInvitationPageQueryReqVO
     * @return
     */
    @Override
    public PageResult<InterviewInvitationResVO> getPageInterviewInvitationList(InterviewInvitationPageQueryReqVO interviewInvitationPageQueryReqVO) {
        InterviewInvitationDO interviewInvitationDO = InterviewInvitationConvert.INSTANCE.convert(interviewInvitationPageQueryReqVO);
        PageInfoVO pageInfo = interviewInvitationPageQueryReqVO.getPageInfo();
        Page<InterviewInvitationDO> page = new Page<>(pageInfo.getPageNum(), pageInfo.getPageSize());
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
        if(save(interviewInvitationDO)){
            return InterviewInvitationConvert.INSTANCE.convert(interviewInvitationDO);
        }
        throw new ServiceException(ErrorCode.SERVICE_ERROR.getCode(),"添加职位申请失败");
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
        throw new ServiceException(ErrorCode.SERVICE_ERROR.getCode(),"更新职位申请失败");
    }
}
