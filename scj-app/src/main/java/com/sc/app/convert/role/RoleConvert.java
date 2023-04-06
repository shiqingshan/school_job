package com.sc.app.convert.role;


import com.sc.model.entity.role.AdminRoleDO;
import com.sc.model.entity.role.vo.RoleCreateReqVO;
import com.sc.model.entity.role.vo.RolePageQueryReqVO;
import com.sc.model.entity.role.vo.RoleResVO;
import com.sc.model.entity.role.vo.RoleUpdateReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoleConvert {
    RoleConvert INSTANCE = Mappers.getMapper(RoleConvert.class);
    AdminRoleDO convert(RoleCreateReqVO roleCreateReqVO);
    RoleResVO convert(AdminRoleDO adminRoleDO);

    AdminRoleDO convert(RoleUpdateReqVO roleUpdateReqVO);

    AdminRoleDO convert(RolePageQueryReqVO rolePageQueryReqVO);

    List<RoleResVO> convert(List<AdminRoleDO> records);
}
