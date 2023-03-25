package com.sc.app.enums.exception;

import com.sc.common.exception.enums.IErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public enum ErrorCode implements IErrorCode {
    AUTH_LOGIN_BAD_CREDENTIALS(1002000000, "登录失败，账号密码不正确");
    private final Integer code;
    private final String message;
}
