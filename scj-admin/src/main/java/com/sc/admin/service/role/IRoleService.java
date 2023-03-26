package com.sc.admin.service.role;

import com.sc.admin.controller.role.vo.RoleCreateReqVO;
import com.sc.admin.controller.role.vo.RoleResVO;

public interface IRoleService {
    RoleResVO addRole(RoleCreateReqVO roleCreateReqVO);
}
