package com.sc.model.entity.apply;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.sc.common.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 应聘邀请表
 * @TableName scj_interview_invitation
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="scj_interview_invitation")
@Data
public class InterviewInvitationDO extends BaseDO implements Serializable {
    /**
     * 应聘信息ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 应聘用户ID
     */
    private Long userId;

    /**
     * 面试公司
     */
    private Long coId;

    /**
     * 应聘信息ID
     */
    private Long applyId;

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
    private Integer status;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}