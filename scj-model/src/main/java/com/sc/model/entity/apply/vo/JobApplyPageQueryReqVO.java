package com.sc.model.entity.apply.vo;

import com.sc.common.base.PageInfoVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class JobApplyPageQueryReqVO extends PageInfoVO {
    private String userId;
    private String coId;
    private String jobId;
}
