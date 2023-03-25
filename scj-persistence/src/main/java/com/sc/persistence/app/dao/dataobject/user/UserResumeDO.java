package com.sc.persistence.app.dao.dataobject.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.sc.common.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户简历表
 * @TableName scj_user_resume
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="scj_user_resume")
@Data
public class UserResumeDO extends BaseDO implements Serializable {
    /**
     * 用户简历ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 姓名
     */
    private String fullName;

    /**
     * 联系电话
     */
    private String contactPhone;

    /**
     * 电子邮箱地址
     */
    private String contactEmail;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}