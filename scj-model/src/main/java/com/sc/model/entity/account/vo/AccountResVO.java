package com.sc.model.entity.account.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class AccountResVO extends AccountBaseVO{
    private String id;
    private Date createTime;
}
