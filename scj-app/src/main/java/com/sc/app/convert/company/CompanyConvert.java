package com.sc.app.convert.company;

import com.sc.model.entity.company.CompanyDO;
import com.sc.model.entity.company.vo.CompanyCreateReqVO;
import com.sc.model.entity.company.vo.CompanyPageQueryReqVO;
import com.sc.model.entity.company.vo.CompanyResVO;
import com.sc.model.entity.company.vo.CompanyUpdateReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CompanyConvert {
    CompanyConvert INSTANCE = Mappers.getMapper(CompanyConvert.class);

    CompanyDO convert(CompanyPageQueryReqVO companyPageQueryReqVO);

    List<CompanyResVO> convert(List<CompanyDO> records);

    CompanyDO convert(CompanyCreateReqVO companyCreateReqVO);

    CompanyResVO convert(CompanyDO companyDO);

    CompanyDO convert(CompanyUpdateReqVO companyUpdateReqVO);
}
