package com.sc.model.entity.user.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserResVO extends UserBaseVO{
    private String id;
    private Date createTime;
}
