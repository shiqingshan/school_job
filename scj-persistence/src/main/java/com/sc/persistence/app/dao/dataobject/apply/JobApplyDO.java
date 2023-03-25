package com.sc.persistence.app.dao.dataobject.apply;

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
 * 应聘信息表
 * @TableName scj_job_apply
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="scj_job_apply")
@Data
public class JobApplyDO extends BaseDO implements Serializable {
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
     * 招聘信息ID
     */
    private Long jobId;

    /**
     * 应聘日期
     */
    private Date applyDate;

    /**
     * 应聘状态
     */
    private Integer status;

    /**
     * 简历ID
     */
    private Long resumeId;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}