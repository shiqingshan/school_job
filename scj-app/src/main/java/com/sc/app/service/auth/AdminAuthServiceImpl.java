package com.sc.app.service.auth;

import com.sc.app.convert.auth.AuthConverter;
import com.sc.app.enums.account.AccountEnum;
import com.sc.app.service.TokenService;
import com.sc.model.entity.auth.LoginUserInfo;
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
    private final TokenService tokenService;


    @Override
    public UserLoginResVO login(UserLoginReqVO userLoginReqVO) {

        Integer accountType = userLoginReqVO.getAccountType();
        AccountEnum accountEnum = AccountEnum.valueOfCode(accountType);
        if (Objects.isNull(accountEnum)){
            throw new ServiceException("账号类型错误");
        }

        UserDO userDO = userService.getUserByName(userLoginReqVO.getUserName());
        if(Objects.isNull(userDO)){
            log.error(ErrorCode.AUTH_LOGIN_BAD_CREDENTIALS.getMessage());
            throw new ServiceException(ErrorCode.AUTH_LOGIN_BAD_CREDENTIALS);
        }
        String userPwd = userDO.getUserPwd();
        if(!userPwd.equals(userLoginReqVO.getPassword())){
            log.error(ErrorCode.AUTH_LOGIN_BAD_CREDENTIALS.getMessage());
            throw new ServiceException(ErrorCode.AUTH_LOGIN_BAD_CREDENTIALS);
        }

        List<AccountDO> accountDOList = accountService.getAccountByUserId(userDO.getId());
        if(CollectionUtils.isEmpty(accountDOList)){
            log.error(ErrorCode.AUTH_LOGIN_BAD_CREDENTIALS.getMessage());
            throw new ServiceException(ErrorCode.AUTH_LOGIN_BAD_CREDENTIALS);
        }
        //判断 accountDOList 中是否有 accountType 的账号
        AccountDO accountDO = accountDOList.stream().filter(ac -> ac.getAccountType().equals(userLoginReqVO.getAccountType())).findFirst().orElseThrow(() -> {
            log.error(ErrorCode.AUTH_LOGIN_BAD_CREDENTIALS.getMessage());
            return new ServiceException(ErrorCode.AUTH_LOGIN_BAD_CREDENTIALS);
        });

        return createToken(userDO,accountDO);
    }
    /**
     * 生成token
     */
    private UserLoginResVO createToken(UserDO userDO, AccountDO accountDO) {
        LoginUserInfo userLogonInfo = new LoginUserInfo();
        userLogonInfo.setUserId(userDO.getId());
        userLogonInfo.setAccountId(accountDO.getId());
        userLogonInfo.setUserInfo(userDO);
        userLogonInfo.setAccountInfo(accountDO);
        UserLoginResVO userLoginResVO = new UserLoginResVO();
        String token = tokenService.createToken(userLogonInfo);
        userLoginResVO.setToken(token);
        return userLoginResVO;
    }


    /**
     * @param userInfo
     * @return
     */
    @Override
    public UserLoginInfoResVO getUserInfo(com.sc.common.core.LoginUserInfo userInfo) {
        userInfo = new com.sc.common.core.LoginUserInfo();
        userInfo.setUserId(1L);
        userInfo.setAccountId(1L);
        userInfo.setRoleType("admin");
        userInfo.setUserName("admin");
        checkUserLogin(userInfo);
        return AuthConverter.INSTANCE.convert(userInfo);
    }

    //校验token
    private void checkUserLogin(com.sc.common.core.LoginUserInfo userInfo) {
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
