package com.sc.model.entity.permission;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.sc.common.base.BaseDO;
import lombok.Data;

/**
 * 
 * @TableName scj_admin_permission
 */
@TableName(value ="scj_admin_permission")
@Data
public class AdminPermissionDO extends BaseDO implements Serializable {
    /**
     * 权限主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 菜单项ID
     */
    private Long menuItemId;

    /**
     * 是否具有查看权限 0否 1是
     */
    private Boolean canView;

    /**
     * 是否具有编辑权限 0否 1是
     */
    private Boolean canEdit;

    /**
     * 是否具有删除权限 0否 1是
     */
    private Boolean canDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}