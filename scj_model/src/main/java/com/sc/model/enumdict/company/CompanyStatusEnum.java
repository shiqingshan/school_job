package com.sc.model.enumdict.company;

import com.sc.common.enumdic.base.IEnumMapping;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum CompanyStatusEnum implements IEnumMapping {
    /**
     * 正常
     */
    NORMAL(0, "正常"),
    /**
     * 冻结
     */
    FREEZE(1, "冻结"),
    /**
     * 待审核
     */
    PENDING(2, "待审核");

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
