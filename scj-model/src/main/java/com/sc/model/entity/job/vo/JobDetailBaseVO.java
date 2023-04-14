package com.sc.model.entity.job.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 职位信息基础类
 */
@Data
@ApiModel("职位详情信息")
public class JobDetailBaseVO {
    /**
     * 招聘信息ID
     */
    private Long jobId;

    private String jobName;

    /**
     * 职位描述
     */
    private String jobDescribe;

    /**
     * 教育要求
     */
    private String jobEdu;

    /**
     * 资格要求
     */
    private String jobQualification;

    /**
     * 工作地点
     */
    private String jobAddr;

    /**
     * 薪资待遇
     */
    private String jobSalary;
}
