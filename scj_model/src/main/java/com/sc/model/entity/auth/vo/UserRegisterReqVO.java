package com.sc.model.entity.auth.vo;

import lombok.Data;

@Data
public class UserRegisterReqVO {
    private String username;
    private String password;
    private String email;
    private String phone;
    private Integer accountType;
    private String companyName;
    private String companyAddress;
    private String contact;
    private String contactPhone;
    private String businessLicense;
}
