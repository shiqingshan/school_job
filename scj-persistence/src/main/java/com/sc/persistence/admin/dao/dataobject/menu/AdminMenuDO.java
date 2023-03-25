package com.sc.persistence.admin.dao.dataobject.menu;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.sc.common.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 菜单表
 * @TableName scj_admin_menu
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="scj_admin_menu")
@Data
public class AdminMenuDO extends BaseDO implements Serializable {
    /**
     * 菜单id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 上级菜单
     */
    private String parentId;

    /**
     * 图标
     */
    private String icon;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}