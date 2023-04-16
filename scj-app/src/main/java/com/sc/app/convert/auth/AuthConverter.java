package com.sc.app.convert.auth;

import com.sc.model.entity.auth.LoginUserInfo;
import com.sc.model.entity.auth.vo.UserLoginInfoResVO;
import com.sc.model.entity.auth.vo.UserRegisterReqVO;
import com.sc.model.entity.auth.vo.UserRegisterResVO;
import com.sc.model.entity.company.CompanyDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthConverter {
    AuthConverter INSTANCE = Mappers.getMapper(AuthConverter.class);

    @Mapping( target="accountId",source = "accountInfo.id")
    UserLoginInfoResVO convert(LoginUserInfo userInfo);

    @Mapping(target="userName", source="username")
    UserRegisterResVO convert(UserRegisterReqVO userRegisterReqVO);

    @Mapping(target="name", source="companyName")
    @Mapping(target="address", source="companyAddress")
    CompanyDO convertToCompanyDO(UserRegisterReqVO userRegisterReqVO);
}
