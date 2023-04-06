package com.sc.model.entity.job;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.sc.common.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 招聘明细
 * @TableName scj_job_detail
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="scj_job_detail")
@Data
public class JobDetailDO extends BaseDO implements Serializable {
    /**
     * 招聘信息详情ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 招聘信息ID
     */
    private Long jobId;

    /**
     * 职位描述
     */
    private String jobDescribe;

    /**
     * 教育要求
     */
    private String jobEdu;

    /**
     * 资格要求
     */
    private String jobQualification;

    /**
     * 工作地点
     */
    private String jobAddr;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}