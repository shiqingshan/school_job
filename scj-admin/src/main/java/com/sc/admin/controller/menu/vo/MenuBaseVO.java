package com.sc.admin.controller.menu.vo;

import lombok.Data;

@Data
public class MenuBaseVO {
    private String menuName;
    private Long parentId;
    private String icon;
}
