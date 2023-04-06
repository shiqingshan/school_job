package com.sc.model.entity.job.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class JobPositionResVO extends JobPositionBaseVO{
    /**
     * 职位id
     */
    private String id;
}
