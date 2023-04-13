package com.sc.model.entity.job.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class JobInfoUpdateReqVO extends JobInfoBaseVO{
    private String id;
    private String updater;
}
