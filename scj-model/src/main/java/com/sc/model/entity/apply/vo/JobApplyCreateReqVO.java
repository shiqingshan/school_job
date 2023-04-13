package com.sc.model.entity.apply.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class JobApplyCreateReqVO extends JobApplyBaseVO{
    private String creator;
    private String updater;
}
