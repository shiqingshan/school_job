package com.sc.web.controller.account;

import com.sc.app.service.account.IAccountService;
import com.sc.common.base.PageResult;
import com.sc.common.base.Result;
import com.sc.common.utils.ResultUtils;
import com.sc.model.entity.account.vo.AccountPageQueryReqVO;
import com.sc.model.entity.account.vo.AccountResVO;
import com.sc.model.entity.account.vo.AccountUpdateReqVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户管理
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {
    private final IAccountService accountService;
    /**
     * 获取账户列表
     */
    @RequestMapping("/page/list")
    public Result<PageResult<AccountResVO>> getPageAccountList(AccountPageQueryReqVO accountPageQueryReqVO){
        return ResultUtils.success(accountService.getPageAccountList(accountPageQueryReqVO));
    }
    /**
     * 获取账户
     * @param id
     * @return
     */
    @RequestMapping("/{id}")
    public Result<AccountResVO> getAccount(@PathVariable(value = "id") String id){
        return ResultUtils.success("获取账号成功！", accountService.getAccountById(id));
    }
    /**
     * 更新账户
     */
    @RequestMapping("/update")
    public Result<AccountResVO> updateAccount(@RequestBody AccountUpdateReqVO accountUpdateReqVO){
        return ResultUtils.success(accountService.updateAccount(accountUpdateReqVO));
    }

    /**
     * 删除账户
     */
    @RequestMapping("/delete/{id}")
    public Result<Boolean> deleteAccount(@PathVariable(value = "id") String id){
        return ResultUtils.success("删除账户成功！", accountService.removeById(id));
    }

}
