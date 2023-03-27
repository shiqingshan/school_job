package com.sc.web.exception;

import com.sc.common.base.Result;
import com.sc.common.exception.ServerException;
import com.sc.common.exception.ServiceException;
import com.sc.common.exception.enums.ErrorCode;
import com.sc.common.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<Object> error(Exception e){
        log.error(e.getMessage(),e);
        return ResultUtils.fail(ErrorCode.INTERNAL_SERVER_ERROR.getCode(),ErrorCode.INTERNAL_SERVER_ERROR.getMessage());
    }

    @ExceptionHandler(ServiceException.class)
    @ResponseBody
    public Result<Object> error(ServiceException e){
        log.error(e.getMessage(),e);
        return ResultUtils.fail(e.getCode(),e.getMessage());
    }
    @ExceptionHandler(ServerException.class)
    @ResponseBody
    public Result<Object> error(ServerException e){
        log.error(e.getMessage(),e);
        return ResultUtils.fail(e.getCode(),e.getMessage());
    }
}
