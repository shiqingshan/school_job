package com.sc.app.convert.account;

import com.sc.model.entity.account.AccountDO;
import com.sc.model.entity.account.vo.AccountPageQueryReqVO;
import com.sc.model.entity.account.vo.AccountResVO;
import com.sc.model.entity.account.vo.AccountUpdateReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountConvert {
    AccountConvert INSTANCE = Mappers.getMapper(AccountConvert.class);

    AccountDO convert(AccountPageQueryReqVO accountPageQueryReqVO);

    List<AccountResVO> convert(List<AccountDO> records);

    AccountDO convert(AccountUpdateReqVO accountUpdateReqVO);

    AccountResVO convert(AccountDO accountDO);
}
