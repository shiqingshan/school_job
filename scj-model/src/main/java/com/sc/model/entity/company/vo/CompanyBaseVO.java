package com.sc.model.entity.company.vo;

import lombok.Data;

@Data
public class CompanyBaseVO {
    /**
     * 企业名称
     */
    private String name;

    /**
     * 企业地址
     */
    private String address;

    /**
     * 企业联系人
     */
    private String contact;

    /**
     * 企业联系人电话
     */
    private String contactPhone;

    /**
     * 企业工商注册号
     */
    private String businessLicense;

    private String status;
}
