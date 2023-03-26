package com.sc.admin.convert.permission;

import com.sc.admin.controller.permission.vo.PermissionCreateReqVO;
import com.sc.admin.controller.permission.vo.PermissionResVO;
import com.sc.persistence.admin.dao.dataobject.permission.AdminPermissionDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PermissionConvert {
    PermissionConvert INSTANCE = Mappers.getMapper(PermissionConvert.class);

    AdminPermissionDO convert(PermissionCreateReqVO permissionCreateReqVO);
    PermissionResVO convert(AdminPermissionDO adminPermissionDO);
}
