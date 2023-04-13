package com.sc.model.entity.role.vo;

import com.sc.common.base.PageInfoVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RolePageQueryReqVO extends RoleBaseVO{
    private PageInfoVO pageInfo;
}
