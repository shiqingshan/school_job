package com.sc.model.entity.role.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RoleResVO extends RoleBaseVO{
    private String roleId;
}
