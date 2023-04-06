package com.sc.app.service.item;

import com.sc.model.entity.item.AdminItemDO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sc.model.entity.item.vo.ItemCreateReqVO;
import com.sc.model.entity.item.vo.ItemResVO;

/**
* @description 针对表【scj_admin_item】的数据库操作Service
* @createDate 2023-03-24 22:33:51
*/
public interface IAdminItemService extends IService<AdminItemDO> {

    ItemResVO addItem(ItemCreateReqVO itemCreateReqVO);
}
