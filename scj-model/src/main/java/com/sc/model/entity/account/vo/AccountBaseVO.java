package com.sc.model.entity.account.vo;

import lombok.Data;

@Data
public class AccountBaseVO {
    private String userId;
    private String userName;
    private String accountType;
    private String status;
}
