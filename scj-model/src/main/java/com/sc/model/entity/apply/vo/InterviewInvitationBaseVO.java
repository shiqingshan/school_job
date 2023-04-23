package com.sc.model.entity.apply.vo;

import com.sc.model.entity.user.vo.UserResVO;
import lombok.Data;

import java.util.Date;

@Data
public class InterviewInvitationBaseVO {
    /**
     * 应聘用户ID
     */
    private String userId;
    private UserResVO userInfo;

    /**
     * 面试公司
     */
    private String coId;

    /**
     * 应聘信息ID
     */
    private String applyId;

    private JobApplyResVO jobApplyInfo;

    /**
     * 邀请日期
     */
    private Date invitationDate;

    /**
     * 面试日期
     */
    private Date interviewDate;

    /**
     * 面试地点
     */
    private String interviewLocation;

    /**
     * 邀请状态（待处理 、已接受、已拒绝）
     */
    private String status;
}
