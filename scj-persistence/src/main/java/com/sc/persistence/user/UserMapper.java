package com.sc.persistence.user;

import com.sc.model.entity.user.UserDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @description 针对表【scj_user】的数据库操作Mapper
* @createDate 2023-03-25 13:53:02
* @Entity com.sc.persistence.app.dao.dataobject.user.UserDO
*/
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {

}




