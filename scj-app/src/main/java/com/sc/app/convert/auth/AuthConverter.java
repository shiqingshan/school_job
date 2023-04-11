package com.sc.app.convert.auth;

import com.sc.common.core.LoginUserInfo;
import com.sc.model.entity.auth.vo.UserLoginInfoResVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthConverter {
    AuthConverter INSTANCE = Mappers.getMapper(AuthConverter.class);

    UserLoginInfoResVO convert(LoginUserInfo userInfo);
}
