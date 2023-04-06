package com.sc.model.entity.job.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class JobDetailCreateReqVO extends JobDetailBaseVO{
    private String creator;
    private String updater;
}
