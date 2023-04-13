package com.sc.model.entity.apply.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class InterviewInvitationUpdateReqVO extends InterviewInvitationBaseVO{
    private String id;
    private String updater;
}
