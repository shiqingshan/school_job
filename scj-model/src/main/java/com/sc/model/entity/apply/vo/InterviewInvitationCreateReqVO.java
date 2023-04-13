package com.sc.model.entity.apply.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class InterviewInvitationCreateReqVO extends InterviewInvitationBaseVO{
    private String creator;
    private String updater;
}
