package com.sc.app.service.user;


import com.baomidou.mybatisplus.extension.service.IService;
import com.sc.common.base.PageResult;
import com.sc.model.entity.user.UserDO;
import com.sc.model.entity.user.vo.UserPageQueryReqVO;
import com.sc.model.entity.user.vo.UserResVO;

import java.util.List;

public interface IUserService extends IService<UserDO> {
    UserDO getUserByName(String username);

    UserDO getUserById(Long userId);

    PageResult<UserResVO> getPageUserList(UserPageQueryReqVO userPageQueryReqVO);
}
