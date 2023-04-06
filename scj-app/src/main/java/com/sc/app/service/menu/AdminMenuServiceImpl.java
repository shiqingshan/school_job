package com.sc.app.service.menu;

import com.sc.app.convert.menu.MenuConvert;
import com.sc.model.entity.menu.AdminMenuDO;
import com.sc.model.entity.menu.vo.MenuCreateReqVO;
import com.sc.model.entity.menu.vo.MenuResVO;
import com.sc.persistence.menu.AdminMenuMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminMenuServiceImpl implements IAdminMenuService{
    private final AdminMenuMapper adminMenuMapper;

    /**
     * 添加菜单
     *
     * @param menuCreateReqVO
     * @return
     */
    @Override
    public MenuResVO addMenu(MenuCreateReqVO menuCreateReqVO) {
        AdminMenuDO adminMenuDO = MenuConvert.INSTANCE.convert(menuCreateReqVO);
        //添加菜单
        int insert = adminMenuMapper.insert(adminMenuDO);
        if (insert > 0) {
            return MenuConvert.INSTANCE.convert(adminMenuDO);
        }
        return null;
    }
}
