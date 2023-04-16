package com.sc.app.service.company;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.app.convert.company.CompanyConvert;
import com.sc.app.service.TokenService;
import com.sc.common.base.PageResult;
import com.sc.common.exception.ServiceException;
import com.sc.model.entity.auth.LoginUserInfo;
import com.sc.model.entity.company.*;
import com.sc.model.entity.company.vo.*;
import com.sc.persistence.company.CompanyMapper;
import com.sc.persistence.company.CompanyUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, CompanyDO> implements ICompanyService{
    private final CompanyUserMapper companyUserMapper;
    private final TokenService tokenService;
    /**
     * @param companyPageQueryReqVO
     * @return
     */
    @Override
    public PageResult<CompanyResVO> getPageCompanyList(CompanyPageQueryReqVO companyPageQueryReqVO) {
        CompanyDO companyDo = CompanyConvert.INSTANCE.convert(companyPageQueryReqVO);
        Page<CompanyDO> pageParam = new Page<>(companyPageQueryReqVO.getPageNum(),companyPageQueryReqVO.getPageSize());
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
        throw new ServiceException("添加公司失败");
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
        throw new ServiceException("更新公司失败");
    }

    /**
     * @param companyPageQueryReqVO
     * @return
     */
    @Override
    public PageResult<CompanyResVO> getPageCompanyListByLoginUserId(CompanyPageQueryReqVO companyPageQueryReqVO) {
        LoginUserInfo loginUser = tokenService.getLoginUser();
        if(loginUser == null){
            throw new ServiceException("获取登录用户信息失败");
        }
        Long userId = loginUser.getUserId();
        Page<CompanyUserDO> pageParam = new Page<>(companyPageQueryReqVO.getPageNum(),companyPageQueryReqVO.getPageSize());
        Page<CompanyUserDO> pageRes = companyUserMapper.selectPage(pageParam, new QueryWrapper<CompanyUserDO>().eq("user_id", userId));
        List<CompanyUserDO> companyUserDOList = pageRes.getRecords();
        if(CollectionUtils.isEmpty(companyUserDOList)){
            throw new ServiceException("获取登录用户所属公司失败");
        }
        List<Long> companyIds = companyUserDOList.stream().map(CompanyUserDO::getCoId).collect(Collectors.toList());
        List<CompanyDO> companyDOS = listByIds(companyIds);
        long total = pageRes.getTotal();
        return new PageResult<>(CompanyConvert.INSTANCE.convert(companyDOS),total);
    }

    /**
     * @return
     */
    @Override
    public List<CompanyResVO> getLoginCompanyTreeList() {
        LoginUserInfo loginUser = tokenService.getLoginUser();
        List<CompanyUserDO> companyUserDOList = companyUserMapper.selectList(new QueryWrapper<CompanyUserDO>().eq("user_id", loginUser.getUserId()));
        if(CollectionUtils.isEmpty(companyUserDOList)){
            throw new ServiceException("获取登录用户所属公司失败");
        }
        List<Long> companyIds = companyUserDOList.stream().map(CompanyUserDO::getCoId).collect(Collectors.toList());
        List<CompanyDO> companyDOS = listByIds(companyIds);
        return CompanyConvert.INSTANCE.convert(companyDOS);
    }
}
