package com.sc.model.entity.role;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.sc.common.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @TableName scj_admin_role
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="scj_admin_role")
@Data
public class AdminRoleDO extends BaseDO implements Serializable {
    /**
     * 角色主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    private String roleCode;

    /**
     * 角色名称
     */
    private String roleName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}