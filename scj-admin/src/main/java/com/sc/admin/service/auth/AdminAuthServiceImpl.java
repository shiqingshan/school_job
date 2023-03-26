package com.sc.admin.service.auth;

import com.sc.admin.controller.auth.vo.UserLoginReqVO;
import com.sc.admin.controller.auth.vo.UserLoginResVO;
import com.sc.admin.controller.auth.vo.UserMenuInfoResVO;
import com.sc.admin.controller.auth.vo.UserPermissionInfoResVO;
import com.sc.admin.enums.exception.ErrorCode;
import com.sc.admin.service.account.IAccountService;
import com.sc.admin.service.item.IAdminItemService;
import com.sc.admin.service.menu.IAdminMenuService;
import com.sc.admin.service.permission.IPermissionService;
import com.sc.admin.service.role.IRoleService;
import com.sc.admin.service.user.IUserService;
import com.sc.common.exception.ServiceException;
import com.sc.persistence.app.dao.dataobject.account.AccountDO;
import com.sc.persistence.app.dao.dataobject.user.UserDO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
        UserDO userDO = userService.getUserByName(adminUserLoginReqVO.getUsername());
        if(Objects.isNull(userDO)){
            log.error(ErrorCode.AUTH_LOGIN_BAD_CREDENTIALS.getMessage());
            throw new ServiceException(ErrorCode.AUTH_LOGIN_BAD_CREDENTIALS);
        }
        String userPwd = userDO.getUserPwd();
        if(!userPwd.equals(adminUserLoginReqVO.getPassword())){
            log.error(ErrorCode.AUTH_LOGIN_BAD_CREDENTIALS.getMessage());
            throw new ServiceException(ErrorCode.AUTH_LOGIN_BAD_CREDENTIALS);
        }
        List<AccountDO> accountDOList = accountService.getAccountByUserId(userDO.getId());
        if(CollectionUtils.isEmpty(accountDOList)){
            log.error(ErrorCode.AUTH_LOGIN_BAD_CREDENTIALS.getMessage());
            throw new ServiceException(ErrorCode.AUTH_LOGIN_BAD_CREDENTIALS);
        }
        //判断 accountDOList 中是否有 accountType 的账号
        accountDOList.stream().filter(accountDO -> accountDO.getAccountType().equals(adminUserLoginReqVO.getAccountType())).findFirst().orElseThrow(() -> {
            log.error(ErrorCode.AUTH_LOGIN_BAD_CREDENTIALS.getMessage());
            return new ServiceException(ErrorCode.AUTH_LOGIN_BAD_CREDENTIALS);
        });
        //spring security 生成token
        return createToken(userDO);
    }

    /**
     * 生成token
     */
    private UserLoginResVO createToken(UserDO userDO) {
        return null;
    }

    /**
     * @param loginUserId
     * @return
     */
    @Override
    public UserPermissionInfoResVO getPermissionInfo(Long loginUserId) {
        UserDO userDO = userService.getUserById(loginUserId);
        if(Objects.isNull(userDO)){
            log.error(ErrorCode.AUTH_LOGIN_BAD_CREDENTIALS.getMessage());
            throw new ServiceException(ErrorCode.AUTH_USER_BAD);
        }
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
