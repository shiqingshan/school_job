package com.sc.model.entity.role.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RoleUpdateReqVO extends RoleBaseVO{
    private Long id;
}
