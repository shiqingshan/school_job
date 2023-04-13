package com.sc.model.entity.job.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class JobDetailUpdateReqVO extends JobDetailBaseVO{
    private String updater;
    private String id;
}
