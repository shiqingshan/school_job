package com.sc.model.entity.resume.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserResumeCreateReqVO extends UserResumeBaseVO{
   private String creator;
   private String updater;
}
