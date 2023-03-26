package com.sc.admin.convert.item;

import com.sc.admin.controller.item.vo.ItemCreateReqVO;
import com.sc.admin.controller.item.vo.ItemResVO;
import com.sc.persistence.admin.dao.dataobject.item.AdminItemDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ItemConvert {
    ItemConvert INSTANCE = Mappers.getMapper(ItemConvert.class);
    AdminItemDO convert(ItemCreateReqVO bean);
    ItemResVO convert(AdminItemDO bean);
}
