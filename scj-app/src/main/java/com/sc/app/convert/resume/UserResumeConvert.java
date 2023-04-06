package com.sc.app.convert.resume;

import com.sc.model.entity.resume.UserResumeDO;
import com.sc.model.entity.resume.vo.UserResumeCreateReqVO;
import com.sc.model.entity.resume.vo.UserResumePageQueryReqVO;
import com.sc.model.entity.resume.vo.UserResumeResVO;
import com.sc.model.entity.resume.vo.UserResumeUpdateReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserResumeConvert {
    UserResumeConvert INSTANCE = Mappers.getMapper(UserResumeConvert.class);

    UserResumeDO convert(UserResumePageQueryReqVO userResumePageQueryReqVO);

    List<UserResumeResVO> convert(List<UserResumeDO> records);

    UserResumeDO convert(UserResumeCreateReqVO userResumeCreateReqVO);

    UserResumeResVO convert(UserResumeDO userResumeDO);

    UserResumeDO convert(UserResumeUpdateReqVO userResumeUpdateReqVO);
}
