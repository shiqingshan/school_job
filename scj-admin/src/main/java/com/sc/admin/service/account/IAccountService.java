package com.sc.admin.service.account;

import com.sc.persistence.app.dao.dataobject.account.AccountDO;

import java.util.List;

/**@description 针对表【scj_account(账号表)】的数据库操作Service
* @createDate 2023-03-25 12:29:31
*/
public interface IAccountService {
    /**
     * 根据用户id获取账号信息
     * @param userId
     * @return
     */
    List<AccountDO> getAccountByUserId(Long userId);
}
