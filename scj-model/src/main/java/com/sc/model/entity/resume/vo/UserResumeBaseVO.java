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
    /**
     * 性别
     */
    private String sex;

    /**
     * 出生年月
     */
    private String birthday;

    /**
     * 当前求职状态
     */
    private String jobStatus;

    /**
     * 个人优势
     */
    private String advantage;
    /**
     * 期望薪资
     */
    private String expectSalary;
    /**
     * 期望工作地点
     */
    private String expectAddr;
    /**
     * 求职类型
     */
    private String jobType;
    /**
     * 期望从事职业
     */
    private String expectJob;
    /**
     * 最高学历
     */
    private String education;
}
