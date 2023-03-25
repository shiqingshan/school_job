package com.sc.persistence.admin.dao.dataobject.role;

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

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者
     */
    private String updater;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 是否删除
     */
    private Boolean deleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}