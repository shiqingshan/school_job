package com.sc.admin.service.user;


import com.sc.persistence.app.dao.dataobject.user.UserDO;

public interface IUserService {
    UserDO getUserByName(String username);

    UserDO getUserById(Long userId);
}
