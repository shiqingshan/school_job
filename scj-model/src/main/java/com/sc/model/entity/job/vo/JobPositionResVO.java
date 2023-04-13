package com.sc.model.entity.job.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class JobPositionResVO extends JobPositionBaseVO{
    /**
     * 职位id
     */
    private String id;

    private String ancestors;
    private Date createTime;
    private List<JobPositionResVO> children = new ArrayList<>();
}
