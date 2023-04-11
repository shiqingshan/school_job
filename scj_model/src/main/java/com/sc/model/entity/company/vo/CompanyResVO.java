package com.sc.model.entity.company.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class CompanyResVO extends CompanyBaseVO{
    private String id;
    private Date createTime;
}
