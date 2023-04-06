package com.sc.model.entity.company;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.sc.common.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 企业表
 * @TableName scj_company
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="scj_company")
@Data
public class CompanyDO extends BaseDO implements Serializable {
    /**
     * 企业ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 企业名称
     */
    private Long name;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}