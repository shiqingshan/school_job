package com.sc.app.convert.user;

import com.sc.model.entity.auth.vo.UserRegisterReqVO;
import com.sc.model.entity.user.UserDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    @Mapping(target = "userPwd", source = "password")
    @Mapping(target = "userName", source = "username")
    UserDO convert(UserRegisterReqVO userRegisterReqVO);
}
