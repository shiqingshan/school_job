package com.sc.admin.service.role;

import com.sc.admin.controller.role.vo.RoleCreateReqVO;
import com.sc.admin.controller.role.vo.RoleResVO;
import com.sc.admin.convert.role.RoleConvert;
import com.sc.persistence.admin.dao.dataobject.role.AdminRoleDO;
import com.sc.persistence.admin.dao.mysql.role.AdminRoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements IRoleService {
    private final AdminRoleMapper adminRoleMapper;

    /**
     * 添加角色
     * @param roleCreateReqVO
     * @return
     */
    @Override
    public RoleResVO addRole(RoleCreateReqVO roleCreateReqVO) {
        AdminRoleDO adminRoleDO = RoleConvert.INSTANCE.convert(roleCreateReqVO);
        int insert = adminRoleMapper.insert(adminRoleDO);
        if (insert > 0) {
            return RoleConvert.INSTANCE.convert(adminRoleDO);
        }
        return null;
    }
}
