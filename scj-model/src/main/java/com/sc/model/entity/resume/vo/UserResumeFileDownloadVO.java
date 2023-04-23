package com.sc.model.entity.resume.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserResumeFileDownloadVO extends UserResumeFileBaseVO{
    private byte[] resumeFile;
}
