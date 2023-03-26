package com.sc.admin.controller.role;

import com.sc.admin.controller.role.vo.RoleCreateReqVO;
import com.sc.admin.controller.role.vo.RoleResVO;
import com.sc.admin.service.role.IRoleService;
import com.sc.common.base.Result;
import com.sc.common.utils.ResultUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/role")
public class RoleController {
    private final IRoleService roleService;

    /**
     * 添加角色
     */
    public Result<RoleResVO> addRole(@RequestBody RoleCreateReqVO roleCreateReqVO){
        return ResultUtils.success(roleService.addRole(roleCreateReqVO));
    }
}
