package com.sc.admin.enums.exception;

import com.sc.common.exception.enums.IErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public enum ErrorCode implements IErrorCode {
    AUTH_LOGIN_BAD_CREDENTIALS(1002000000, "登录失败，账号密码不正确"),
    AUTH_USER_BAD(1003000000, "授权失败，用户不存在"),
    AUTH_USER_ACCOUNT_BAD(1003000001, "授权失败，用户账号不存在");
    private final Integer code;
    private final String message;
}
