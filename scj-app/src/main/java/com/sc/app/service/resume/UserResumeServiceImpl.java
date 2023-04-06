package com.sc.app.service.resume;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sc.app.convert.resume.UserResumeConvert;
import com.sc.common.base.PageInfoVO;
import com.sc.common.base.PageResult;
import com.sc.common.exception.ServiceException;
import com.sc.common.exception.enums.ErrorCode;
import com.sc.model.entity.resume.UserResumeDO;
import com.sc.model.entity.resume.vo.UserResumeCreateReqVO;
import com.sc.model.entity.resume.vo.UserResumePageQueryReqVO;
import com.sc.model.entity.resume.vo.UserResumeResVO;
import com.sc.model.entity.resume.vo.UserResumeUpdateReqVO;
import com.sc.persistence.user.UserResumeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserResumeServiceImpl extends ServiceImpl<UserResumeMapper, UserResumeDO> implements IUserResumeService {
    /**
     * @param userResumePageQueryReqVO
     * @return
     */
    @Override
    public PageResult<UserResumeResVO> getPageUserResumeList(UserResumePageQueryReqVO userResumePageQueryReqVO) {
        UserResumeDO userResumeDO = UserResumeConvert.INSTANCE.convert(userResumePageQueryReqVO);
        PageInfoVO pageInfo = userResumePageQueryReqVO.getPageInfo();
        Page<UserResumeDO> page = new Page<>(pageInfo.getPageNum(), pageInfo.getPageSize());
        Page<UserResumeDO> pageRes = page(page, new QueryWrapper<>(userResumeDO));
        long total = pageRes.getTotal();
        List<UserResumeDO> records = pageRes.getRecords();
        List<UserResumeResVO> userResumeResVOList =  UserResumeConvert.INSTANCE.convert(records);
        return new PageResult<>(userResumeResVOList,total);
    }

    /**
     * @param userResumeCreateReqVO
     * @return
     */
    @Override
    public UserResumeResVO addUserResume(UserResumeCreateReqVO userResumeCreateReqVO) {
        UserResumeDO userResumeDO = UserResumeConvert.INSTANCE.convert(userResumeCreateReqVO);
        if(save(userResumeDO)){
            return UserResumeConvert.INSTANCE.convert(userResumeDO);
        }
        throw new ServiceException(ErrorCode.SERVICE_ERROR.getCode(),"添加用户简历失败");
    }

    /**
     * @param userResumeUpdateReqVO
     * @return
     */
    @Override
    public UserResumeResVO updateUserResume(UserResumeUpdateReqVO userResumeUpdateReqVO) {
        UserResumeDO userResumeDO = UserResumeConvert.INSTANCE.convert(userResumeUpdateReqVO);
        if(updateById(userResumeDO)){
            return UserResumeConvert.INSTANCE.convert(userResumeDO);
        }
        throw new ServiceException(ErrorCode.SERVICE_ERROR.getCode(),"更新用户简历失败");
    }
}
