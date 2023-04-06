package com.sc.app.service.auth;

import com.sc.app.convert.auth.AuthConverter;
import com.sc.model.entity.auth.vo.*;
import com.sc.app.enums.exception.ErrorCode;
import com.sc.app.service.account.IAccountService;
import com.sc.app.service.item.IAdminItemService;
import com.sc.app.service.menu.IAdminMenuService;
import com.sc.app.service.permission.IPermissionService;
import com.sc.app.service.role.IRoleService;
import com.sc.app.service.user.IUserService;
import com.sc.common.exception.ServiceException;
import com.sc.model.entity.account.AccountDO;
import com.sc.model.entity.user.UserDO;
import com.sc.web.security.core.LoginUserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminAuthServiceImpl implements IUserAuthService {
    private final IUserService userService;
    private final IAccountService accountService;
    private final IPermissionService permissionService;
    private final IAdminMenuService adminMenuService;
    private final IAdminItemService adminItemService;
    private final IRoleService roleService;


    @Override
    public UserLoginResVO login(UserLoginReqVO adminUserLoginReqVO) {
        UserDO userDO = userService.getUserByName(adminUserLoginReqVO.getUserName());
        if(Objects.isNull(userDO)){
            log.error(ErrorCode.AUTH_LOGIN_BAD_CREDENTIALS.getMessage());
            throw new ServiceException(ErrorCode.AUTH_LOGIN_BAD_CREDENTIALS);
        }
        String userPwd = userDO.getUserPwd();
        if(!userPwd.equals(adminUserLoginReqVO.getPassword())){
            log.error(ErrorCode.AUTH_LOGIN_BAD_CREDENTIALS.getMessage());
            throw new ServiceException(ErrorCode.AUTH_LOGIN_BAD_CREDENTIALS);
        }
    /*    List<AccountDO> accountDOList = accountService.getAccountByUserId(userDO.getId());
        if(CollectionUtils.isEmpty(accountDOList)){
            log.error(ErrorCode.AUTH_LOGIN_BAD_CREDENTIALS.getMessage());
            throw new ServiceException(ErrorCode.AUTH_LOGIN_BAD_CREDENTIALS);
        }*/
        //判断 accountDOList 中是否有 accountType 的账号
       /* accountDOList.stream().filter(accountDO -> accountDO.getAccountType().equals(adminUserLoginReqVO.getAccountType())).findFirst().orElseThrow(() -> {
            log.error(ErrorCode.AUTH_LOGIN_BAD_CREDENTIALS.getMessage());
            return new ServiceException(ErrorCode.AUTH_LOGIN_BAD_CREDENTIALS);
        });*/
        //spring security 生成token
        return createToken(userDO);
    }

    /**
     * 生成token
     */
    private UserLoginResVO createToken(UserDO userDO) {
        UserLoginResVO userLoginResVO = new UserLoginResVO();
        userLoginResVO.setToken("54321");
        return userLoginResVO;
    }


    /**
     * @param userInfo
     * @return
     */
    @Override
    public UserLoginInfoResVO getUserInfo(LoginUserInfo userInfo) {
        userInfo = new LoginUserInfo();
        userInfo.setUserId(1L);
        userInfo.setAccountId(1L);
        userInfo.setRoleType("admin");
        userInfo.setUserName("admin");
        checkUserLogin(userInfo);
        return AuthConverter.INSTANCE.convert(userInfo);
    }

    //校验token
    private void checkUserLogin(LoginUserInfo userInfo) {
        if(Objects.isNull(userInfo) || userInfo.getUserId() == null ||
                userInfo.getAccountId() == null ||
                StringUtils.isBlank(userInfo.getRoleType())){
            log.error(ErrorCode.AUTH_USER_BAD_TOKEN.getMessage());
            throw new ServiceException(ErrorCode.AUTH_USER_BAD_TOKEN);
        }
    }


    private UserDO getUserById(Long loginUserId) {
        UserDO userDO = userService.getUserById(loginUserId);
        if(Objects.isNull(userDO)){
            log.error(ErrorCode.AUTH_LOGIN_BAD_CREDENTIALS.getMessage());
            throw new ServiceException(ErrorCode.AUTH_USER_BAD);
        }
        return userDO;
    }


    /**
     * @param loginUserId
     * @return
     */
    @Override
    public UserPermissionInfoResVO getPermissionInfo(Long loginUserId) {
        UserDO userDO = getUserById(loginUserId);
        List<AccountDO> accountDOList = accountService.getAccountByUserId(userDO.getId());
        if(CollectionUtils.isEmpty(accountDOList)){
            log.error(ErrorCode.AUTH_LOGIN_BAD_CREDENTIALS.getMessage());
            throw new ServiceException(ErrorCode.AUTH_USER_ACCOUNT_BAD);
        }


        return null;
    }

    /**
     * @param loginUserId
     * @return
     */
    @Override
    public UserMenuInfoResVO getMenuInfo(Long loginUserId) {
        return null;
    }
}
