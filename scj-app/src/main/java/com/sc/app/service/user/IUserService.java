package com.sc.app.service.user;


import com.baomidou.mybatisplus.extension.service.IService;
import com.sc.model.entity.user.UserDO;

public interface IUserService extends IService<UserDO> {
    UserDO getUserByName(String username);

    UserDO getUserById(Long userId);
}
