package com.sc.app.enums.account;

import com.sc.common.enumdic.base.IEnumMapping;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum AccountEnum implements IEnumMapping {
    PERSONAL(0, "个人"),
    COMPANY(1, "公司"),
    ADMIN(2, "管理员");
    private final Integer code;
    private final String text;

    public static AccountEnum valueOfCode(Integer accountType) {
        for (AccountEnum accountEnum : AccountEnum.values()) {
            if (accountEnum.getCode().equals(accountType)) {
                return accountEnum;
            }
        }
        return null;
    }
}
