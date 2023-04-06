package com.sc.app.service.user;


import com.sc.model.entity.user.UserDO;

public interface IUserService {
    UserDO getUserByName(String username);

    UserDO getUserById(Long userId);
}
