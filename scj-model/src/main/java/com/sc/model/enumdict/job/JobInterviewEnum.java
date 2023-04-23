package com.sc.model.enumdict.job;

import com.sc.common.enumdic.base.IEnumMapping;
import lombok.RequiredArgsConstructor;

/**
 * 待处理 、已接受、已拒绝
 */
@RequiredArgsConstructor
public enum JobInterviewEnum implements IEnumMapping {
    /**
     * 待处理
     */
    WAITING(1, "待处理"),
    /**
     * 已接受
     */
    ACCEPTED(2, "已接受"),
    /**
     * 已拒绝
     */
    REJECTED(3, "已拒绝");

    private final Integer code;
    private final String text;

    /**
     * @return
     */
    @Override
    public Integer getCode() {
        return this.code;
    }

    /**
     * @return
     */
    @Override
    public String getText() {
        return this.text;
    }
}
