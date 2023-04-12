package com.sc.app.service.auth;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sc.app.convert.auth.AuthConverter;
import com.sc.app.convert.user.UserConvert;
import com.sc.app.enums.account.AccountEnum;
import com.sc.app.service.TokenService;
import com.sc.app.service.company.ICompanyService;
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
import com.sc.model.entity.company.CompanyDO;
import com.sc.model.entity.company.CompanyUserDO;
import com.sc.model.entity.user.UserDO;
import com.sc.model.enumdict.account.AccountStatusEnum;
import com.sc.model.enumdict.company.CompanyStatusEnum;
import com.sc.persistence.company.CompanyUserMapper;
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
    private final ICompanyService companyService;
    private final CompanyUserMapper companyUserMapper;


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

    /**
     * @param userRegisterReqVO
     * @return
     */
    @Override
    public UserRegisterResVO register(UserRegisterReqVO userRegisterReqVO) {
        Integer accountType = userRegisterReqVO.getAccountType();
        AccountEnum accountEnum = AccountEnum.valueOfCode(accountType);
        registerAccount(userRegisterReqVO,accountEnum);
        return AuthConverter.INSTANCE.convert(userRegisterReqVO);
    }

    private void registerAccount(UserRegisterReqVO userRegisterReqVO, AccountEnum accountEnum) {
        if(Objects.isNull(accountEnum)||accountEnum.equals(AccountEnum.ADMIN)){
            throw new ServiceException("账号类型错误");
        }
        UserDO userDO = createUser(userRegisterReqVO,accountEnum);
        if(AccountEnum.PERSONAL.equals(accountEnum)){
            createAccount(userDO,accountEnum,AccountStatusEnum.NORMAL);
        }else {
            createAccount(userDO,accountEnum,AccountStatusEnum.PENDING);
            CompanyDO companyDO = createCompany(userRegisterReqVO);
            //建立用户与公司的关联
            createCompanyUser(userDO,companyDO);
        }

    }

    private void createCompanyUser(UserDO userDO, CompanyDO companyDO) {
        CompanyUserDO companyUserDO = new CompanyUserDO();
        companyUserDO.setCoId(companyDO.getId());
        companyUserDO.setUserId(userDO.getId());
        int save = companyUserMapper.insert(companyUserDO);
        if(save<1){
            log.error("公司用户关联创建失败!");
            throw new ServiceException("公司用户关联创建失败！");
        }
    }

    private CompanyDO createCompany(UserRegisterReqVO userRegisterReqVO) {
        CompanyDO companyDO = AuthConverter.INSTANCE.convertToCompanyDO(userRegisterReqVO);
        CompanyDO one = companyService.getOne(new LambdaQueryWrapper<CompanyDO>().eq(CompanyDO::getName, companyDO.getName()));
        if(Objects.nonNull(one)){
            return one;
        }
        companyDO.setStatus(CompanyStatusEnum.PENDING.getCode());
        boolean save = companyService.save(companyDO);
        if(!save){
            log.error("公司创建失败!");
            throw new ServiceException("公司创建失败！");
        }
        return companyDO;
    }

    private void createAccount(UserDO userDO, AccountEnum accountEnum,AccountStatusEnum accountStatusEnum) {
        AccountDO accountDO = new AccountDO();
        accountDO.setUserId(userDO.getId());
        accountDO.setAccountType(accountEnum.getCode());
        accountDO.setStatus(accountStatusEnum.getCode());
        AccountDO account = accountService.getOne(new QueryWrapper<AccountDO>().eq("user_id", userDO.getId()).eq("account_type", accountEnum.getCode()));
        if(Objects.nonNull(account)){
            throw new ServiceException("账号已存在！");
        }
        if(!accountService.save(accountDO)){
            log.error("账号创建失败!");
            throw new ServiceException("账号创建失败！");
        }
    }

    private UserDO createUser(UserRegisterReqVO userRegisterReqVO, AccountEnum accountEnum) {
        UserDO userDO = UserConvert.INSTANCE.convert(userRegisterReqVO);
        UserDO userByName = userService.getUserByName(userDO.getUserName());
        if(accountEnum.equals(AccountEnum.COMPANY)&&Objects.nonNull(userByName)){
            return userByName;
        }
        if(Objects.nonNull(userByName)){
            log.error("用户已存在!");
            throw new ServiceException("用户已存在！");
        }
        if(userService.save(userDO)){
            return userDO;
        }
        log.error("用户创建失败!");
        throw new ServiceException("用户创建失败！");
    }
}
