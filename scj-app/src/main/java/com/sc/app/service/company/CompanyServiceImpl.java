package com.sc.app.service.company;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.app.convert.company.CompanyConvert;
import com.sc.common.base.PageInfoVO;
import com.sc.common.base.PageResult;
import com.sc.common.exception.ServiceException;
import com.sc.common.exception.enums.ErrorCode;
import com.sc.model.entity.company.CompanyDO;
import com.sc.model.entity.company.vo.CompanyCreateReqVO;
import com.sc.model.entity.company.vo.CompanyPageQueryReqVO;
import com.sc.model.entity.company.vo.CompanyResVO;
import com.sc.model.entity.company.vo.CompanyUpdateReqVO;
import com.sc.persistence.company.CompanyMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, CompanyDO> implements ICompanyService{
    /**
     * @param companyPageQueryReqVO
     * @return
     */
    @Override
    public PageResult<CompanyResVO> getPageCompanyList(CompanyPageQueryReqVO companyPageQueryReqVO) {
        CompanyDO companyDo = CompanyConvert.INSTANCE.convert(companyPageQueryReqVO);
        PageInfoVO pageInfo = companyPageQueryReqVO.getPageInfo();

        Page<CompanyDO> pageParam = new Page<>(pageInfo.getPageNum(),pageInfo.getPageSize());
        Page<CompanyDO> pageRes = page(pageParam, new QueryWrapper<>(companyDo));
        List<CompanyDO> records = pageRes.getRecords();
        long total = pageRes.getTotal();
        return new PageResult<>(CompanyConvert.INSTANCE.convert(records),total);
    }

    /**
     * @param companyCreateReqVO
     * @return
     */
    @Override
    public CompanyResVO addCompany(CompanyCreateReqVO companyCreateReqVO) {
        CompanyDO companyDO = CompanyConvert.INSTANCE.convert(companyCreateReqVO);
        if(save(companyDO)){
            return CompanyConvert.INSTANCE.convert(companyDO);
        }
        throw new ServiceException(ErrorCode.SERVICE_ERROR.getCode(),"添加公司失败");
    }

    /**
     * @param companyUpdateReqVO
     * @return
     */
    @Override
    public CompanyResVO updateCompany(CompanyUpdateReqVO companyUpdateReqVO) {
        CompanyDO companyDO = CompanyConvert.INSTANCE.convert(companyUpdateReqVO);
        if(updateById(companyDO)){
            return CompanyConvert.INSTANCE.convert(companyDO);
        }
        throw new ServiceException(ErrorCode.SERVICE_ERROR.getCode(),"更新公司失败");
    }
}