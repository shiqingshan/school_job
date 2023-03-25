package com.sc.persistence.app.dao.dataobject.company;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.sc.common.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 企业用户表
 * @TableName scj_company_user
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="scj_company_user")
@Data
public class CompanyUserDO extends BaseDO implements Serializable {
    /**
     * 企业用户ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 企业ID
     */
    private Long coId;

    /**
     * 用户ID
     */
    private Long userId;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}