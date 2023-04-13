package com.sc.model.entity.company;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sc.common.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

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
    private String name;

    /**
     * 企业地址
     */
    private String address;

    /**
     * 企业联系人
     */
    private String contact;

   /**
     * 企业联系人电话
     */
    private String contactPhone;

    /**
     * 工商注册号
     */
    private String businessLicense;

    /**
     * 企业状态
     */
    private Integer status;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}