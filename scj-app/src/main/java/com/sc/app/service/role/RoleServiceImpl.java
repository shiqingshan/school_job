package com.sc.app.service.role;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.app.convert.role.RoleConvert;
import com.sc.common.base.PageInfoVO;
import com.sc.common.base.PageResult;
import com.sc.common.exception.ServiceException;
import com.sc.common.exception.enums.ErrorCode;
import com.sc.model.entity.role.AdminRoleDO;
import com.sc.model.entity.role.vo.RoleCreateReqVO;
import com.sc.model.entity.role.vo.RolePageQueryReqVO;
import com.sc.model.entity.role.vo.RoleResVO;
import com.sc.model.entity.role.vo.RoleUpdateReqVO;
import com.sc.persistence.role.AdminRoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends ServiceImpl<AdminRoleMapper,AdminRoleDO> implements IRoleService {
    /**
     * 添加角色
     * @param roleCreateReqVO
     * @return
     */
    @Override
    public RoleResVO addRole(RoleCreateReqVO roleCreateReqVO) {
        AdminRoleDO adminRoleDO = RoleConvert.INSTANCE.convert(roleCreateReqVO);
        if (save(adminRoleDO)) {
            return RoleConvert.INSTANCE.convert(adminRoleDO);
        }
        throw new ServiceException(ErrorCode.SERVICE_ERROR.getCode(),"添加角色失败");
    }

    /**
     * @param roleUpdateReqVO
     * @return
     */
    @Override
    public RoleResVO update(RoleUpdateReqVO roleUpdateReqVO) {
        AdminRoleDO adminRoleDO = RoleConvert.INSTANCE.convert(roleUpdateReqVO);
        if(updateById(adminRoleDO)){
            return RoleConvert.INSTANCE.convert(adminRoleDO);
        }
        throw new ServiceException(ErrorCode.SERVICE_ERROR.getCode(),"更新角色失败");
    }

    /**
     * @param rolePageQueryReqVO
     * @return
     */
    @Override
    public PageResult<RoleResVO> getPageRoleList(RolePageQueryReqVO rolePageQueryReqVO) {
        AdminRoleDO roleDO = RoleConvert.INSTANCE.convert(rolePageQueryReqVO);
        PageInfoVO pageInfo = rolePageQueryReqVO.getPageInfo();
        Page<AdminRoleDO> pageParam = new Page<>(pageInfo.getPageNum(),pageInfo.getPageSize());
        IPage<AdminRoleDO> page = page(pageParam, new QueryWrapper<>(roleDO));
        List<AdminRoleDO> records = page.getRecords();
        List<RoleResVO> roleResVOS = RoleConvert.INSTANCE.convert(records);
        return new PageResult<>(roleResVOS,page.getTotal());
    }

    /**
     * @return
     */
    @Override
    public List<RoleResVO> getAllRoleList() {
        return RoleConvert.INSTANCE.convert(list());
    }
}
