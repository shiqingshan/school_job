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
 * @TableName scj_job_position_item
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="scj_job_position_item")
@Data
public class JobPositionItemDO extends BaseDO implements Serializable {
    /**
     * 招聘岗位ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 父级岗位ID
     */
    private Long positionId;

    /**
     * 岗位名称
     */
    private String positionItemName;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}