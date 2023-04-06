package com.sc.app.service.item;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.app.convert.item.ItemConvert;
import com.sc.model.entity.item.AdminItemDO;
import com.sc.model.entity.item.vo.ItemCreateReqVO;
import com.sc.model.entity.item.vo.ItemResVO;
import com.sc.persistence.item.AdminItemMapper;
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




