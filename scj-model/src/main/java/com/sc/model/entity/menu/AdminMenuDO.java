package com.sc.model.entity.menu;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sc.common.base.BaseDO;
import java.io.Serializable;

import lombok.Data;

/**
 * 菜单
 * @TableName scj_admin_menu
 */
@TableName(value ="scj_admin_menu")
@Data
public class AdminMenuDO extends BaseDO implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 名称
     */
    @TableField(value = "label")
    private String label;

    /**
     * 该节点的所有父节点
     */
    @TableField(value = "tree_path")
    private String treePath;

    /**
     * 权限
     */
    @TableField(value = "permission")
    private String permission;

    /**
     * 父级菜单ID
     */
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 路径
     */
    @TableField(value = "path")
    private String path;

    /**
     * 组件
     */
    @TableField(value = "component")
    private String component;

    /**
     * 排序
     */
    @TableField(value = "sequence")
    private Integer sequence;

    /**
     * 菜单图标
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 样式
     */
    @TableField(value = "style")
    private String style;

    /**
     * 类型（1=菜单;2=按钮）
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 1=启用;0=禁用
     */
    @TableField(value = "status")
    private Boolean status;

    /**
     * 内置菜单（0=否;1=是）
     */
    @TableField(value = "readonly")
    private Boolean readonly;

    /**
     * 公共资源
True是无需分配所有人就可以访问的
     */
    @TableField(value = "global")
    private Boolean global;

    /**
     * 0=隐藏;1=显示
     */
    @TableField(value = "display")
    private Boolean display;

    /**
     * 描述
     */
    @TableField(value = "description")
    private String description;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}