package com.sc.app.convert.menu;

import com.sc.model.entity.menu.AdminMenuDO;
import com.sc.model.entity.menu.vo.MenuCreateReqVO;
import com.sc.model.entity.menu.vo.MenuResVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MenuConvert {
    MenuConvert INSTANCE = Mappers.getMapper(MenuConvert.class);
    AdminMenuDO convert(MenuCreateReqVO menuCreateReqVO);
    MenuResVO convert(AdminMenuDO adminMenuDO);
}
