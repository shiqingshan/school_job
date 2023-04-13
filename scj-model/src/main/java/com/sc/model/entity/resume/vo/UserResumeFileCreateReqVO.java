package com.sc.model.entity.resume.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserResumeFileCreateReqVO extends UserResumeBaseVO{
   private byte[] file;
   private String creator;
   private String updater;
}
