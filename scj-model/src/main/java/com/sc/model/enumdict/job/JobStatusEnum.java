package com.sc.model.enumdict.job;

import com.sc.common.enumdic.base.IEnumMapping;
import lombok.RequiredArgsConstructor;

/**
 * {
 * 		value: "0",
 * 		label: "发布中"
 *        },
 *    {
 * 		value: "1",
 * 		label: "已下架"
 *    },
 *    {
 * 		value: "2",
 * 		label: "待审核"
 *    },
 *    {
 * 		value: "3",
 * 		label: "审核不通过"
 *    }
 */
@RequiredArgsConstructor
public enum JobStatusEnum implements IEnumMapping {
    PUBLISHING(0, "发布中"),
    OFF_SHELF(1, "已下架"),
    PENDING_REVIEW(2, "待审核"),
    REVIEW_FAILED(3, "审核不通过");

    private final Integer code;
    private final String text;

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getText() {
        return text;
    }
    public static JobStatusEnum valueOfCode(Integer code) {
        for (JobStatusEnum e : JobStatusEnum.values()) {
            if (e.getCode().equals(code)) {
                return e;
            }
        }
        return null;
    }
}
