package com.sc.app.service.menu;


import com.sc.model.entity.menu.vo.MenuCreateReqVO;
import com.sc.model.entity.menu.vo.MenuResVO;

public interface IAdminMenuService{
    /**
     * 添加菜单
     * @param menuCreateReqVO
     * @return
     */
    MenuResVO addMenu(MenuCreateReqVO menuCreateReqVO);
}
