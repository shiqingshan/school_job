package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.AdminMenuDO;
import generator.service.AdminMenuService;
import generator.mapper.AdminMenuMapper;
import org.springframework.stereotype.Service;

/**
* @author hzw
* @description 针对表【scj_admin_menu(菜单)】的数据库操作Service实现
* @createDate 2023-04-08 12:29:28
*/
@Service
public class AdminMenuServiceImpl extends ServiceImpl<AdminMenuMapper, AdminMenuDO>
    implements AdminMenuService{

}




