package com.sc.model.entity.account.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AccountUpdateReqVO extends AccountBaseVO{
    private String id;
}
