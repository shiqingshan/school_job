package com.sc.model.enumdict.job;

import com.sc.common.enumdic.base.IEnumMapping;

/**
 * 应聘申请状态
 * 应聘状态（待处理、已查看、已面试、已录用、未录用）
 */
public enum JobApplyStatusEnum implements IEnumMapping {
    /**
     * 待处理
     */
    WAIT(1, "待处理"),
    /**
     * 已查看
     */
    VIEWED(2, "已查看"),
    /**
     * 已面试
     */
    INTERVIEWED(3, "已面试"),
    /**
     * 已录用
     */
    HIRED(4, "已录用"),
    /**
     * 未录用
     */
    NOT_HIRED(5, "未录用");

    private Integer code;
    private String text;

    JobApplyStatusEnum(Integer code, String text) {
        this.code = code;
        this.text = text;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getText() {
        return text;
    }
}
