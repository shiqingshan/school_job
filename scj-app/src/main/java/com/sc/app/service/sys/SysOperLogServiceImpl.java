package com.sc.app.service.sys;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.model.entity.sys.SysOperLog;
import com.sc.persistence.sys.SysOperLogMapper;
import org.springframework.stereotype.Service;

/**
* @author hzw
* @description 针对表【scj_sys_oper_log(操作日志记录)】的数据库操作Service实现
* @createDate 2023-04-08 12:12:32
*/
@Service
public class SysOperLogServiceImpl extends ServiceImpl<SysOperLogMapper, SysOperLog>
    implements ISysOperLogService {

}




