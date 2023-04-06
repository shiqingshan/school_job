package com.sc.app.service.role;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sc.common.base.PageResult;
import com.sc.model.entity.role.AdminRoleDO;
import com.sc.model.entity.role.vo.RoleCreateReqVO;
import com.sc.model.entity.role.vo.RolePageQueryReqVO;
import com.sc.model.entity.role.vo.RoleResVO;
import com.sc.model.entity.role.vo.RoleUpdateReqVO;

import java.util.List;

public interface IRoleService extends IService<AdminRoleDO> {
    RoleResVO addRole(RoleCreateReqVO roleCreateReqVO);

    RoleResVO update(RoleUpdateReqVO roleUpdateReqVO);

    PageResult<RoleResVO> getPageRoleList(RolePageQueryReqVO rolePageQueryReqVO);

    List<RoleResVO> getAllRoleList();
}
