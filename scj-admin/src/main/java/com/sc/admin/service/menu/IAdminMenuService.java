package com.sc.admin.service.menu;


import com.baomidou.mybatisplus.extension.service.IService;
import com.sc.admin.controller.menu.vo.MenuCreateReqVO;
import com.sc.admin.controller.menu.vo.MenuResVO;

public interface IAdminMenuService{
    /**
     * 添加菜单
     * @param menuCreateReqVO
     * @return
     */
    MenuResVO addMenu(MenuCreateReqVO menuCreateReqVO);
}
