package com.sc.app.convert.item;

import com.sc.model.entity.item.AdminItemDO;
import com.sc.model.entity.item.vo.ItemCreateReqVO;
import com.sc.model.entity.item.vo.ItemResVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ItemConvert {
    ItemConvert INSTANCE = Mappers.getMapper(ItemConvert.class);
    AdminItemDO convert(ItemCreateReqVO bean);
    ItemResVO convert(AdminItemDO bean);
}
