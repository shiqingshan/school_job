package com.sc.model.entity.job.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class JobInfoCreateReqVO extends JobInfoBaseVO{
    private String creator;
    private String updater;
}
