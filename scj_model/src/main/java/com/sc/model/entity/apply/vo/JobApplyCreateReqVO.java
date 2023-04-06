package com.sc.model.entity.apply.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class JobApplyCreateReqVO extends JobApplyBaseVO{
    private String creator;
    private String updater;
}
