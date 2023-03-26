package com.sc.admin.service.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sc.persistence.app.dao.dataobject.user.UserDO;
import com.sc.persistence.app.dao.mysql.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService{
    private final UserMapper userMapper;
    /**
     * @param username
     * @return
     */
    @Override
    public UserDO getUserByName(String username) {
        return userMapper.selectOne(new LambdaQueryWrapper<UserDO>().eq(UserDO::getUserName, username));
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public UserDO getUserById(Long userId) {
        return userMapper.selectOne(new LambdaQueryWrapper<UserDO>().eq(UserDO::getId, userId));
    }
}
