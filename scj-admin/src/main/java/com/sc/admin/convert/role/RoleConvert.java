package com.sc.admin.convert.role;

import com.sc.admin.controller.role.vo.RoleCreateReqVO;
import com.sc.admin.controller.role.vo.RoleResVO;
import com.sc.persistence.admin.dao.dataobject.role.AdminRoleDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleConvert {
    RoleConvert INSTANCE = Mappers.getMapper(RoleConvert.class);
    AdminRoleDO convert(RoleCreateReqVO roleCreateReqVO);
    RoleResVO convert(AdminRoleDO adminRoleDO);
}
