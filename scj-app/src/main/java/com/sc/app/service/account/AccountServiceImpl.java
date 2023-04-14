package com.sc.app.service.account;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.app.convert.account.AccountConvert;
import com.sc.common.base.PageResult;
import com.sc.common.exception.ServiceException;
import com.sc.model.entity.account.AccountDO;
import com.sc.model.entity.account.vo.AccountPageQueryReqVO;
import com.sc.model.entity.account.vo.AccountResVO;
import com.sc.model.entity.account.vo.AccountUpdateReqVO;
import com.sc.model.entity.user.UserDO;
import com.sc.persistence.account.AccountMapper;
import com.sc.persistence.user.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/*** @description 针对表【scj_account(账号表)】的数据库操作Service实现
* @createDate 2023-03-25 12:29:31
*/
@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl extends ServiceImpl<AccountMapper,AccountDO> implements IAccountService {
    private final AccountMapper accountMapper;
    private final UserMapper userMapper;

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

    /**
     * 获取账户列表
     *
     * @param accountPageQueryReqVO
     * @return
     */
    @Override
    public PageResult<AccountResVO> getPageAccountList(AccountPageQueryReqVO accountPageQueryReqVO) {
        AccountDO accountDO = AccountConvert.INSTANCE.convert(accountPageQueryReqVO);
        Page<AccountDO> pageParam = new Page<>(accountPageQueryReqVO.getPageNum(), accountPageQueryReqVO.getPageSize());
        Page<AccountDO> page = page(pageParam, new LambdaQueryWrapper<>(accountDO));
        List<AccountDO> records = page.getRecords();
        List<AccountResVO> accountResVOList = AccountConvert.INSTANCE.convert(records);
        if(!CollectionUtils.isEmpty(accountResVOList)){
            addUserName(accountResVOList);
        }
        long total = page.getTotal();
        return new PageResult<>(accountResVOList, total);
    }

    private void addUserName(List<AccountResVO> accountResVOList) {
        Set<String> ids = accountResVOList.stream().map(AccountResVO::getUserId).collect(Collectors.toSet());
        List<UserDO> userDOS = userMapper.selectList(Wrappers.lambdaQuery(UserDO.class).in(UserDO::getId, ids));
        Map<Long,String> userMap = userDOS.stream().collect(Collectors.toMap(UserDO::getId, UserDO::getUserName));
        accountResVOList.forEach(accountResVO -> accountResVO.setUserName(userMap.get(Long.parseLong(accountResVO.getUserId()))));
    }

    @Override
    public AccountResVO updateAccount(AccountUpdateReqVO accountUpdateReqVO) {
        AccountDO accountDO = AccountConvert.INSTANCE.convert(accountUpdateReqVO);
        if(updateById(accountDO)){
            return AccountConvert.INSTANCE.convert(accountDO);
        }
        throw new ServiceException("更新账户失败");
    }
}




