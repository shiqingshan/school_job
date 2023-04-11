package com.sc.web.controller.permission;

import com.sc.model.entity.permission.vo.PermissionCreateReqVO;
import com.sc.model.entity.permission.vo.PermissionResVO;
import com.sc.app.service.permission.IPermissionService;
import com.sc.common.base.Result;
import com.sc.common.utils.ResultUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/permission")
public class PermissionController {
    private final IPermissionService permissionService;

    @PostMapping("/add")
    public Result<PermissionResVO> addPermission(@RequestBody PermissionCreateReqVO permissionCreateReqVO){
        return ResultUtils.success(permissionService.addPermission(permissionCreateReqVO));
    }

}
