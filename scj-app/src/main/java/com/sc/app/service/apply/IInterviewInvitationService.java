package com.sc.app.service.apply;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sc.common.base.PageResult;
import com.sc.model.entity.apply.InterviewInvitationDO;
import com.sc.model.entity.apply.vo.InterviewInvitationCreateReqVO;
import com.sc.model.entity.apply.vo.InterviewInvitationPageQueryReqVO;
import com.sc.model.entity.apply.vo.InterviewInvitationResVO;
import com.sc.model.entity.apply.vo.InterviewInvitationUpdateReqVO;

public interface IInterviewInvitationService extends IService<InterviewInvitationDO> {
    PageResult<InterviewInvitationResVO> getPageInterviewInvitationList(InterviewInvitationPageQueryReqVO interviewInvitationPageQueryReqVO);

    InterviewInvitationResVO addInterviewInvitation(InterviewInvitationCreateReqVO interviewInvitationCreateReqVO);

    InterviewInvitationResVO updateInterviewInvitation(InterviewInvitationUpdateReqVO interviewInvitationUpdateReqVO);
}
