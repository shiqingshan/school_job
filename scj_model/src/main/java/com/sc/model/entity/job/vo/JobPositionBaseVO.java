package com.sc.model.entity.job.vo;

import lombok.Data;

@Data
public class JobPositionBaseVO {
    /**
     * 父岗位编码
     */
    private String parentId;
    /**
     * 岗位名称
     */
    private String name;
}
