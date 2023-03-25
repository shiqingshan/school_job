package com.sc.persistence.app.dao.dataobject.job;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.sc.common.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 招聘岗位信息
 * @TableName scj_job_position
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="scj_job_position")
@Data
public class JobPositionDO extends BaseDO implements Serializable {
    /**
     * 招聘岗位类别ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 父级岗位类别ID
     */
    private Long prentId;

    /**
     * 岗位类型名称
     */
    private String positionName;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}