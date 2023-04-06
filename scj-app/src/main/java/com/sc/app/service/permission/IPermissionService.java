package com.sc.app.service.permission;

import com.sc.model.entity.permission.vo.PermissionCreateReqVO;
import com.sc.model.entity.permission.vo.PermissionResVO;

public interface IPermissionService {
    /**
     * 添加权限
     * @param permissionCreateReqVO
     * @return
     */
    PermissionResVO addPermission(PermissionCreateReqVO permissionCreateReqVO);
}
