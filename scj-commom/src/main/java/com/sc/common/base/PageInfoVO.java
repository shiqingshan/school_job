package com.sc.common.base;

import lombok.Data;

@Data
public class PageInfoVO {
    private Integer pageNum = 1;
    private Integer pageSize = 10;
}
