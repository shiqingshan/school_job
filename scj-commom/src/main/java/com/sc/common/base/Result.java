package com.sc.common.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result <T>{
    /**
     * 状态
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 返回结果
     */
    private T data;
}
