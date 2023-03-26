package com.sc.admin.service.account;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sc.common.exception.ServiceException;
import com.sc.persistence.app.dao.dataobject.account.AccountDO;
import com.sc.persistence.app.dao.mysql.account.AccountMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/*** @description 针对表【scj_account(账号表)】的数据库操作Service实现
* @createDate 2023-03-25 12:29:31
*/
@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements IAccountService {
    private final AccountMapper accountMapper;

    /**
     * 根据用户id获取账号信息
     *
     * @param userId
     * @return
     */
    @Override
    public List<AccountDO> getAccountByUserId(Long userId) {
        return accountMapper.selectList(new LambdaQueryWrapper<AccountDO>().eq(AccountDO::getUserId, userId));
    }
}




