package com.sc.model.entity.resume.vo;

import lombok.Data;

@Data
public class UserResumeBaseVO {
    /**
     * 用户id
     */
    private String userId;

    /**
     * 姓名
     */
    private String fullName;

    /**
     * 联系电话
     */
    private String contactPhone;

    /**
     * 电子邮箱地址
     */
    private String contactEmail;
}
