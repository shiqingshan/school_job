package com.sc.admin.service.permission;

import com.sc.admin.controller.permission.vo.PermissionCreateReqVO;
import com.sc.admin.controller.permission.vo.PermissionResVO;
import com.sc.admin.convert.permission.PermissionConvert;
import com.sc.persistence.admin.dao.dataobject.permission.AdminPermissionDO;
import com.sc.persistence.admin.dao.mysql.permission.AdminPermissionMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PermissionServiceImpl implements IPermissionService {
    private final AdminPermissionMapper adminPermissionMapper;

    /**
     * 添加权限
     *
     * @param permissionCreateReqVO
     * @return
     */
    @Override
    public PermissionResVO addPermission(PermissionCreateReqVO permissionCreateReqVO) {
        AdminPermissionDO adminPermissionDO = PermissionConvert.INSTANCE.convert(permissionCreateReqVO);
        int insert = adminPermissionMapper.insert(adminPermissionDO);
        if(insert>0){
            return PermissionConvert.INSTANCE.convert(adminPermissionDO);
        }
        return null;
    }
}
