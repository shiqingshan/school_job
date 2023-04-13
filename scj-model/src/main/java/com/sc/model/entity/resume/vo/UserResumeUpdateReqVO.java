package com.sc.model.entity.resume.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserResumeUpdateReqVO extends UserResumeBaseVO{
   private String id;
   private String updater;
}
