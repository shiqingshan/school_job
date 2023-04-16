package com.sc.app.convert.user;

import com.sc.model.entity.auth.vo.UserRegisterReqVO;
import com.sc.model.entity.user.UserDO;
import com.sc.model.entity.user.vo.UserCreateReqVO;
import com.sc.model.entity.user.vo.UserPageQueryReqVO;
import com.sc.model.entity.user.vo.UserResVO;
import com.sc.model.entity.user.vo.UserUpdateReqVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    @Mapping(target = "userPwd", source = "password")
    @Mapping(target = "userName", source = "username")
    UserDO convert(UserRegisterReqVO userRegisterReqVO);

    UserDO convert(UserPageQueryReqVO userPageQueryReqVO);

    List<UserResVO> convert(List<UserDO> records);

    UserResVO convert(UserDO byId);

    UserDO convert(UserCreateReqVO userCreateReqVO);

    UserDO convert(UserUpdateReqVo userUpdateReqVo);
}
