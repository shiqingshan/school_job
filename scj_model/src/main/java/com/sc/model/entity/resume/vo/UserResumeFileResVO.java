package com.sc.model.entity.resume.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserResumeFileResVO extends UserResumeFileBaseVO{
    private String id;
}
