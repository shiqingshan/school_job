package com.sc.app.convert.apply;

import com.sc.model.entity.apply.InterviewInvitationDO;
import com.sc.model.entity.apply.vo.InterviewInvitationCreateReqVO;
import com.sc.model.entity.apply.vo.InterviewInvitationPageQueryReqVO;
import com.sc.model.entity.apply.vo.InterviewInvitationResVO;
import com.sc.model.entity.apply.vo.InterviewInvitationUpdateReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface InterviewInvitationConvert {
    InterviewInvitationConvert INSTANCE = Mappers.getMapper(InterviewInvitationConvert.class);

    InterviewInvitationDO convert(InterviewInvitationPageQueryReqVO interviewInvitationPageQueryReqVO);

    List<InterviewInvitationResVO> convert(List<InterviewInvitationDO> records);

    InterviewInvitationDO convert(InterviewInvitationCreateReqVO interviewInvitationCreateReqVO);

    InterviewInvitationResVO convert(InterviewInvitationDO interviewInvitationDO);

    InterviewInvitationDO convert(InterviewInvitationUpdateReqVO interviewInvitationUpdateReqVO);
}
