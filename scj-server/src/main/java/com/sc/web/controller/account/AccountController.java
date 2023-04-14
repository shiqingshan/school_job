package com.sc.web.controller.account;

import com.sc.app.service.account.IAccountService;
import com.sc.common.base.PageResult;
import com.sc.common.base.Result;
import com.sc.common.utils.ResultUtils;
import com.sc.model.entity.account.vo.AccountPageQueryReqVO;
import com.sc.model.entity.account.vo.AccountResVO;
import com.sc.model.entity.account.vo.AccountUpdateReqVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户管理
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/system/account")
public class AccountController {
    private final IAccountService accountService;
    /**
     * 获取账户列表
     */
    @RequestMapping("/page/list")
    public PageResult<AccountResVO> getPageAccountList(AccountPageQueryReqVO accountPageQueryReqVO){
        return accountService.getPageAccountList(accountPageQueryReqVO);
    }
    /**
     * 更新账户
     */
    @RequestMapping("/update")
    public Result<AccountResVO> updateAccount(@RequestBody AccountUpdateReqVO accountUpdateReqVO){
        return ResultUtils.success(accountService.updateAccount(accountUpdateReqVO));
    }
}
