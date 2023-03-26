package com.sc.admin.service.permission;

import com.sc.admin.controller.permission.vo.PermissionCreateReqVO;
import com.sc.admin.controller.permission.vo.PermissionResVO;

public interface IPermissionService {
    /**
     * 添加权限
     * @param permissionCreateReqVO
     * @return
     */
    PermissionResVO addPermission(PermissionCreateReqVO permissionCreateReqVO);
}
