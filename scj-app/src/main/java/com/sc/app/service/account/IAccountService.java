package com.sc.app.service.account;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sc.common.base.PageResult;
import com.sc.model.entity.account.AccountDO;
import com.sc.model.entity.account.vo.AccountPageQueryReqVO;
import com.sc.model.entity.account.vo.AccountResVO;
import com.sc.model.entity.account.vo.AccountUpdateReqVO;

import java.util.List;

/**@description 针对表【scj_account(账号表)】的数据库操作Service
* @createDate 2023-03-25 12:29:31
*/
public interface IAccountService extends IService<AccountDO> {
    /**
     * 根据用户id获取账号信息
     * @param userId
     * @return
     */
    List<AccountDO> getAccountByUserId(Long userId);

    /**
     * 获取账户列表
     * @param accountPageQueryReqVO
     * @return
     */
    PageResult<AccountResVO> getPageAccountList(AccountPageQueryReqVO accountPageQueryReqVO);

    AccountResVO updateAccount(AccountUpdateReqVO accountUpdateReqVO);

    AccountResVO getAccountById(String id);
}
