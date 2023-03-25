package com.sc.admin.service.item;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.persistence.admin.dao.dataobject.item.AdminItemDO;
import com.sc.persistence.admin.dao.mysql.item.AdminItemMapper;
import org.springframework.stereotype.Service;

/**
* @description 针对表【scj_admin_item】的数据库操作Service实现
* @createDate 2023-03-24 22:33:51
*/
@Service
public class AdminItemServiceImpl extends ServiceImpl<AdminItemMapper, AdminItemDO>
    implements AdminItemService {

}




