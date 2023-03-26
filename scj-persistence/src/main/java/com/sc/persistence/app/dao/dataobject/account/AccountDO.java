package com.sc.persistence.app.dao.dataobject.account;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.sc.common.base.BaseDO;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 账户类型 0 普通用户 1企业用户 2管理员
     */
    private Integer accountType;

    /**
     * 头像
     */
    private byte[] profilePicture;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}