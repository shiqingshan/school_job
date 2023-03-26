package com.sc.admin.service.item;

import com.sc.admin.controller.item.vo.ItemCreateReqVO;
import com.sc.admin.controller.item.vo.ItemResVO;
import com.sc.persistence.admin.dao.dataobject.item.AdminItemDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @description 针对表【scj_admin_item】的数据库操作Service
* @createDate 2023-03-24 22:33:51
*/
public interface IAdminItemService extends IService<AdminItemDO> {

    ItemResVO addItem(ItemCreateReqVO itemCreateReqVO);
}