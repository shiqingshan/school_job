package com.sc.web.controller.role;

import com.sc.common.base.PageResult;
import com.sc.model.entity.role.vo.RoleCreateReqVO;
import com.sc.model.entity.role.vo.RolePageQueryReqVO;
import com.sc.model.entity.role.vo.RoleResVO;
import com.sc.app.service.role.IRoleService;
import com.sc.common.base.Result;
import com.sc.common.utils.ResultUtils;
import com.sc.model.entity.role.vo.RoleUpdateReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/role")
@Api(tags = "角色管理")
public class RoleController {
    private final IRoleService roleService;

    /**
     * 获取角色列表分页
     */
    @ApiOperation("获取角色列表(分页)")
    @GetMapping("/page/list")
    public Result<PageResult<RoleResVO>> getPageRoleList(RolePageQueryReqVO rolePageQueryReqVO){
        return ResultUtils.success("获取角色分页列表成功！",roleService.getPageRoleList(rolePageQueryReqVO));
    }

    /**
     * 获取角色列表
     */
    @ApiOperation("获取角色列表")
    @GetMapping("/list")
    public Result<List<RoleResVO>> getPageRoleList(){
        return ResultUtils.success("获取角色列表成功！",roleService.getAllRoleList());
    }

    /**
     * 添加角色
     */
    @ApiOperation("添加角色")
    @PostMapping("/add")
    public Result<RoleResVO> addRole(@RequestBody RoleCreateReqVO roleCreateReqVO){
        return ResultUtils.success("添加角色成功！",roleService.addRole(roleCreateReqVO));
    }

    /**
     * 更新角色
     * @param roleUpdateReqVO
     * @return
     */
    @ApiOperation("更新角色")
    @PostMapping("/update")
    public Result<RoleResVO> updateRole(@RequestBody RoleUpdateReqVO roleUpdateReqVO){
        return ResultUtils.success("更新角色成功！",roleService.update(roleUpdateReqVO));
    }

    /**
     * 删除角色
     * @param id
     * @return
     */
    @ApiOperation("删除角色")
    @DeleteMapping("/delete/{id}")
    public Result<Boolean> deleteRoleById(@PathVariable("id") Long id){
        return ResultUtils.success("删除角色成功！",roleService.removeById(id));
    }
}
