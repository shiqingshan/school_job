package com.sc.admin.service.item;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.admin.controller.item.vo.ItemCreateReqVO;
import com.sc.admin.controller.item.vo.ItemResVO;
import com.sc.admin.convert.item.ItemConvert;
import com.sc.persistence.admin.dao.dataobject.item.AdminItemDO;
import com.sc.persistence.admin.dao.mysql.item.AdminItemMapper;
import org.springframework.stereotype.Service;

/**
* @description 针对表【scj_admin_item】的数据库操作Service实现
* @createDate 2023-03-24 22:33:51
*/
@Service
public class AdminItemServiceImpl extends ServiceImpl<AdminItemMapper, AdminItemDO>
    implements IAdminItemService {

    /**
     * @param itemCreateReqVO
     * @return
     */
    @Override
    public ItemResVO addItem(ItemCreateReqVO itemCreateReqVO) {
        AdminItemDO adminItemDO = ItemConvert.INSTANCE.convert(itemCreateReqVO);
        if(save(adminItemDO)){
            return ItemConvert.INSTANCE.convert(adminItemDO);
        }
        return null;
    }
}




