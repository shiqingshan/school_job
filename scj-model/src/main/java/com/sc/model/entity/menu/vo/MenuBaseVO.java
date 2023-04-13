package com.sc.model.entity.menu.vo;

import lombok.Data;

@Data
public class MenuBaseVO {
    private String menuName;
    private Long parentId;
    private String icon;
}
