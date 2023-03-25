package com.sc.app.service.auth;

import com.sc.app.controller.user.vo.UserAuthLoginReqVO;
import com.sc.app.controller.user.vo.UserAuthLoginResVO;
import com.sc.app.enums.exception.ErrorCode;
import com.sc.app.service.user.IUserService;
import com.sc.common.exception.ServiceException;
import com.sc.persistence.app.dao.dataobject.user.UserDO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserAuthServiceImpl implements IUserAuthService{
    private final IUserService userService;

    /**
     * 用户登录
     *
     * @param userLoginReqVO
     * @return
     */
    @Override
    public UserAuthLoginResVO login(UserAuthLoginReqVO userLoginReqVO) {
        UserDO userDO = userService.getUserByName(userLoginReqVO.getUsername());
        if(Objects.isNull(userDO)){
            throw new ServiceException(ErrorCode.AUTH_LOGIN_BAD_CREDENTIALS);
        }
        String userPwd = userDO.getUserPwd();
        if(!userPwd.equals(userLoginReqVO.getPassword())){
            throw new ServiceException(ErrorCode.AUTH_LOGIN_BAD_CREDENTIALS);
        }

        return null;
    }
}
