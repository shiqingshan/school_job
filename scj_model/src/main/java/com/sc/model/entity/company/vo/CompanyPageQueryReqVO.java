package com.sc.model.entity.company.vo;

import com.sc.common.base.PageInfoVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CompanyPageQueryReqVO extends CompanyBaseVO{
    private PageInfoVO pageInfo;
}
