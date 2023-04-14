package com.sc.model.entity.job.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * 职位信息基础类
 */
@Data
@ApiModel("职位信息")
public class JobInfoBaseVO {
    /**
     * 企业Id
     */
    @ApiParam("企业Id")
    private String coId;
    private String coName;
    /**
     * 用户Id
     */
    @ApiParam("用户Id")
    private String userId;
    private String userName;

    private String contact;
    private String positionId;
    private String positionName;
    private String jobName;
    private String jobAddr;
    private String jobSalary;
    private String jobEdu;
    private String jobQualification;
    private String jobStatus;
}
