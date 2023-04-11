package com.sc.app.service.apply;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sc.common.base.PageResult;
import com.sc.model.entity.apply.*;
import com.sc.model.entity.apply.vo.*;

public interface IInterviewInvitationService extends IService<InterviewInvitationDO> {
    PageResult<InterviewInvitationResVO> getPageInterviewInvitationList(InterviewInvitationPageQueryReqVO interviewInvitationPageQueryReqVO);

    InterviewInvitationResVO addInterviewInvitation(InterviewInvitationCreateReqVO interviewInvitationCreateReqVO);

    InterviewInvitationResVO updateInterviewInvitation(InterviewInvitationUpdateReqVO interviewInvitationUpdateReqVO);
}
