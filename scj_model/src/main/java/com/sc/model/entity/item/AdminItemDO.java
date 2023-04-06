package com.sc.model.entity.item;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.sc.common.base.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @TableName scj_admin_item
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value ="scj_admin_item")
@Data
public class AdminItemDO extends BaseDO implements Serializable {
    /**
     * 菜单项主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 菜单id
     */
    private Long menuId;

    /**
     * 菜单项名称
     */
    private String itemName;

    /**
     * 菜单类型 0 菜单项,1 按钮
     */
    private Integer itemType;

    /**
     * 图标
     */
    private String icon;

    /**
     * 菜单项链接
     */
    private String url;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}