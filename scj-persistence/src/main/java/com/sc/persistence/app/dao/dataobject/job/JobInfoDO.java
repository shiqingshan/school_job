package com.sc.persistence.app.dao.dataobject.job;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.sc.common.base.BaseDO;
import lombok.Data;

/**
 * 招聘信息表
 * @TableName scj_job_info
 */
@TableName(value ="scj_job_info")
@Data
public class JobInfoDO extends BaseDO implements Serializable {
    /**
     * 招聘信息ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 发布企业ID
     */
    private Long coId;

    /**
     * 发布用户ID
     */
    private Long userId;

    /**
     * 发布岗位项名称
     */
    private Long positionItem;

    /**
     * 岗位名称
     */
    private String jobName;

    /**
     * 职位状态
     */
    private Integer jobStatus;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}