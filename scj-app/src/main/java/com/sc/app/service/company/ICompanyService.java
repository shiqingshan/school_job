package com.sc.app.service.company;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sc.common.base.PageResult;
import com.sc.model.entity.company.CompanyDO;
import com.sc.model.entity.company.vo.CompanyCreateReqVO;
import com.sc.model.entity.company.vo.CompanyPageQueryReqVO;
import com.sc.model.entity.company.vo.CompanyResVO;
import com.sc.model.entity.company.vo.CompanyUpdateReqVO;

public interface ICompanyService extends IService<CompanyDO> {
    PageResult<CompanyResVO> getPageCompanyList(CompanyPageQueryReqVO companyService);

    CompanyResVO addCompany(CompanyCreateReqVO companyCreateReqVO);

    CompanyResVO updateCompany(CompanyUpdateReqVO companyUpdateReqVO);
}
