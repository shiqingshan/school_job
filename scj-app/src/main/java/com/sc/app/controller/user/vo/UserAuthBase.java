package com.sc.app.controller.user.vo;

import com.sc.app.enums.account.AccountEnum;
import lombok.Data;

@Data
public class UserAuthBase {
    private String username;
    private String password;
    private AccountEnum accountType;
}
