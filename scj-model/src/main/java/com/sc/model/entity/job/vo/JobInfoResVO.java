package com.sc.model.entity.job.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class JobInfoResVO extends JobInfoBaseVO{
    private String id;
    private Date createTime;
}
