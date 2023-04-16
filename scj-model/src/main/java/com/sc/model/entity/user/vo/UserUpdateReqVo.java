package com.sc.model.entity.user.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserUpdateReqVo extends UserBaseVO{
    /**
     * 用户id
     */
    private String id;
}
