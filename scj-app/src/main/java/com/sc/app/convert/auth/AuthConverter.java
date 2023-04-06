package com.sc.app.convert.auth;

import com.sc.model.entity.auth.vo.UserLoginInfoResVO;
import com.sc.web.security.core.LoginUserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthConverter {
    AuthConverter INSTANCE = Mappers.getMapper(AuthConverter.class);

    UserLoginInfoResVO convert(LoginUserInfo userInfo);
}
