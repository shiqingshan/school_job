package com.sc.app.service.resume;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sc.common.base.PageResult;
import com.sc.model.entity.resume.UserResumeDO;
import com.sc.model.entity.resume.vo.UserResumeCreateReqVO;
import com.sc.model.entity.resume.vo.UserResumePageQueryReqVO;
import com.sc.model.entity.resume.vo.UserResumeResVO;
import com.sc.model.entity.resume.vo.UserResumeUpdateReqVO;

public interface IUserResumeService extends IService<UserResumeDO> {
    PageResult<UserResumeResVO> getPageUserResumeList(UserResumePageQueryReqVO userResumePageQueryReqVO);

    UserResumeResVO addUserResume(UserResumeCreateReqVO userResumeCreateReqVO);

    UserResumeResVO addOrUpdateUserResume(UserResumeUpdateReqVO userResumeUpdateReqVO);

    UserResumeResVO getOnlineUserResume();
}
