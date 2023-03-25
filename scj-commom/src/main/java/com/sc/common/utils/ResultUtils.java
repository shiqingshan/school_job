package com.sc.common.utils;

import com.sc.common.base.Result;
import com.sc.common.exception.enums.ErrorCode;

public class ResultUtils {
    private ResultUtils (){

    }
    public static <T>  Result<T> success(){
        return new Result<>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getMessage(), null);
    }
    public static <T>  Result<T> success(String message){
        return new Result<>(ErrorCode.SUCCESS.getCode(), message, null);
    }
    public static <T>  Result<T> success(String message,T data){
        return new Result<>(ErrorCode.SUCCESS.getCode(), message, data);
    }
    public static <T>  Result<T> success(T data){
        return new Result<>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getMessage(), data);
    }
    public static <T>  Result<T> fail(){
        return new Result<>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getMessage(), null);
    }
    public static <T>  Result<T> fail(String message){
        return new Result<>(ErrorCode.SUCCESS.getCode(), message, null);
    }
    public static <T>  Result<T> fail(String message,T data){
        return new Result<>(ErrorCode.SUCCESS.getCode(), message, data);
    }
    public static <T>  Result<T> fail(T data){
        return new Result<>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getMessage(), data);
    }
}
