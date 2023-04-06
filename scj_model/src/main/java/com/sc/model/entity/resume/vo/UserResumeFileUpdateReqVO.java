package com.sc.model.entity.resume.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserResumeFileUpdateReqVO extends UserResumeBaseVO{
   private String id;
   private byte[] file;
   private String updater;
}
