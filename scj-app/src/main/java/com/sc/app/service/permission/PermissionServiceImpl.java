package com.sc.app.service.permission;


import com.sc.app.convert.permission.PermissionConvert;
import com.sc.model.entity.permission.AdminPermissionDO;
import com.sc.model.entity.permission.vo.PermissionCreateReqVO;
import com.sc.model.entity.permission.vo.PermissionResVO;
import com.sc.persistence.permission.AdminPermissionMapper;
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
