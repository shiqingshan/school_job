package com.sc.app.service.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.app.convert.user.UserConvert;
import com.sc.common.base.PageResult;
import com.sc.common.exception.ServiceException;
import com.sc.model.entity.user.UserDO;
import com.sc.model.entity.user.vo.UserCreateReqVO;
import com.sc.model.entity.user.vo.UserPageQueryReqVO;
import com.sc.model.entity.user.vo.UserResVO;
import com.sc.model.entity.user.vo.UserUpdateReqVo;
import com.sc.persistence.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper,UserDO> implements IUserService{
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

    @Override
    public PageResult<UserResVO> getPageUserList(UserPageQueryReqVO userPageQueryReqVO) {
        UserDO userDO =UserConvert.INSTANCE.convert(userPageQueryReqVO);
        Page<UserDO> pageParam = new Page<>(userPageQueryReqVO.getPageNum(),userPageQueryReqVO.getPageSize());
        Page<UserDO> page = page(pageParam, new LambdaQueryWrapper<>(userDO));
        List<UserDO> records = page.getRecords();
        long total = page.getTotal();
        return new PageResult<>(UserConvert.INSTANCE.convert(records),total);
    }

    /**
     * @param userCreateReqVO
     * @return
     */
    @Override
    public UserResVO addUser(UserCreateReqVO userCreateReqVO) {
        UserDO userDO = UserConvert.INSTANCE.convert(userCreateReqVO);
        /**
         * 用户默认密码
         */
        userDO.setUserPwd("1234");
        if(save(userDO)){
            return UserConvert.INSTANCE.convert(userDO);
        }
        throw new ServiceException("添加用户失败");
    }

    /**
     * @param userUpdateReqVo
     * @return
     */
    @Override
    public UserResVO updateUser(UserUpdateReqVo userUpdateReqVo) {
        UserDO userDO = UserConvert.INSTANCE.convert(userUpdateReqVo);
        if(updateById(userDO)){
            return UserConvert.INSTANCE.convert(userDO);
        }
        throw new ServiceException("更新用户失败");
    }

    /**
     * @param userId
     * @return
     */
    @Override
    public UserResVO getUserInfo(String userId) {
        UserDO userDO = getById(userId);
        if(userDO!=null){
            return UserConvert.INSTANCE.convert(userDO);
        }
        return null;
    }
}
