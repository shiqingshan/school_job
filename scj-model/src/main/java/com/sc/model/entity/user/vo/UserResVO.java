package com.sc.model.entity.user.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserResVO extends UserBaseVO{
    private String id;
}
