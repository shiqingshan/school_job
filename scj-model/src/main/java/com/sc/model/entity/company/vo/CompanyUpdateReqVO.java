package com.sc.model.entity.company.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CompanyUpdateReqVO extends CompanyBaseVO{
    /**
     * 企业id
     */
    private Long id;
}
