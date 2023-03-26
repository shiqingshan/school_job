package com.sc.admin.convert.menu;

import com.sc.admin.controller.menu.vo.MenuCreateReqVO;
import com.sc.admin.controller.menu.vo.MenuResVO;
import com.sc.persistence.admin.dao.dataobject.menu.AdminMenuDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MenuConvert {
    MenuConvert INSTANCE = Mappers.getMapper(MenuConvert.class);
    AdminMenuDO convert(MenuCreateReqVO menuCreateReqVO);
    MenuResVO convert(AdminMenuDO adminMenuDO);
}
