package com.sc.model.entity.account;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sc.common.base.BaseDO;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 账号表
 * @TableName scj_account
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="scj_account")
@Data
public class AccountDO extends BaseDO implements Serializable {
    /**
     * 账号主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 账户类型 0 普通用户 1企业用户 2管理员
     */
    @TableField(value = "account_type")
    private Integer accountType;

    /**
     * 头像
     */
    @TableField(value = "profile_picture")
    private byte[] profilePicture;

    /**
     * 账户状态
     */
    @TableField(value = "status")
    private Integer status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}