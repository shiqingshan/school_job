package com.sc.app.service.user;


import com.sc.persistence.app.dao.dataobject.user.UserDO;

public interface IUserService {
    UserDO getUserByName(String username);
}
