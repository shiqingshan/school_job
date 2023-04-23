package com.sc.web.controller.company;

import com.sc.app.convert.company.CompanyConvert;
import com.sc.app.service.company.ICompanyService;
import com.sc.common.base.PageResult;
import com.sc.common.base.Result;
import com.sc.common.utils.ResultUtils;
import com.sc.model.entity.company.vo.CompanyCreateReqVO;
import com.sc.model.entity.company.vo.CompanyPageQueryReqVO;
import com.sc.model.entity.company.vo.CompanyResVO;
import com.sc.model.entity.company.vo.CompanyUpdateReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(tags = "企业管理")
@RequestMapping("/company")
public class CompanyController {
    private final ICompanyService companyService;
    /**
     * 获取企业列表
     */
    @ApiOperation("获取企业列表(分页)")
    @GetMapping("/page/list")
    public Result<PageResult<CompanyResVO>> getPageCompanyList(CompanyPageQueryReqVO companyPageQueryReqVO){
        return ResultUtils.success("获取企业分页列表成功！",companyService.getPageCompanyList(companyPageQueryReqVO));
    }

    @RequestMapping("/{id}")
    public Result<CompanyResVO> getCompany(@PathVariable(value = "id") String id){
        return ResultUtils.success("获取企业成功！", CompanyConvert.INSTANCE.convert(companyService.getById(id)));
    }

    /**
     * 添加企业
     */
    @ApiOperation("添加企业")
    @PostMapping("/add")
    public Result<CompanyResVO> addCompany(@RequestBody CompanyCreateReqVO companyCreateReqVO){
        return ResultUtils.success("添加企业成功！",companyService.addCompany(companyCreateReqVO));
    }

    /**
     * 更新企业
     * @param companyUpdateReqVO
     * @return
     */
    @ApiOperation("更新企业")
    @PostMapping("/update")
    public Result<CompanyResVO> updateCompany(@RequestBody CompanyUpdateReqVO companyUpdateReqVO){
        return ResultUtils.success("更新企业成功！",companyService.updateCompany(companyUpdateReqVO));
    }

    /**
     * 删除企业
     * @param id
     * @return
     */
    @ApiOperation("删除企业")
    @DeleteMapping("/delete/{id}")
    public Result<Boolean> deleteComPanyById(@PathVariable("id") Long id){
        return ResultUtils.success("删除企业成功！",companyService.removeById(id));
    }

    /**
     * 根据用户id获取企业
     */
    @ApiOperation("根据用户id获取企业")
    @GetMapping("/loginUser/page/list")
    public Result<PageResult<CompanyResVO>> getPageCompanyListByLoginUserId(CompanyPageQueryReqVO companyPageQueryReqVO){
        return ResultUtils.success("获取企业分页列表成功！",companyService.getPageCompanyListByLoginUserId(companyPageQueryReqVO));
    }
    /**
     * 获取用户企业树
     */
    @ApiOperation("获取用户企业树")
    @GetMapping("/loginUser/treeList")
    public Result<List<CompanyResVO>> getLoginCompanyTreeList() {
        return ResultUtils.success("获取用户企业树！", companyService.getLoginCompanyTreeList());
    }
    /**
     * 获取热门企业
     */
    @ApiOperation("获取热门企业")
    @GetMapping("/hot/list")
    public Result<List<CompanyResVO>> getHotCompanyList(CompanyPageQueryReqVO companyPageQueryReqVO) {
        return ResultUtils.success("获取热门企业！", companyService.getHotCompanyList(companyPageQueryReqVO));
    }
}
