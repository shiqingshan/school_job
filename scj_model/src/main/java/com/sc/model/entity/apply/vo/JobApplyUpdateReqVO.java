package com.sc.model.entity.apply.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class JobApplyUpdateReqVO extends JobApplyBaseVO{
    private String id;
    private String updater;
}
