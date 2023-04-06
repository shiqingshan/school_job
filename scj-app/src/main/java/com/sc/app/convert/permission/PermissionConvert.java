package com.sc.app.convert.permission;

import com.sc.model.entity.permission.AdminPermissionDO;
import com.sc.model.entity.permission.vo.PermissionCreateReqVO;
import com.sc.model.entity.permission.vo.PermissionResVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PermissionConvert {
    PermissionConvert INSTANCE = Mappers.getMapper(PermissionConvert.class);

    AdminPermissionDO convert(PermissionCreateReqVO permissionCreateReqVO);
    PermissionResVO convert(AdminPermissionDO adminPermissionDO);
}
