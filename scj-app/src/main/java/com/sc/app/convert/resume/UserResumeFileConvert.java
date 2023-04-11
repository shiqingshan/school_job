package com.sc.app.convert.resume;

import com.sc.model.entity.resume.UserResumeFileDO;
import com.sc.model.entity.resume.vo.UserResumeFileCreateReqVO;
import com.sc.model.entity.resume.vo.UserResumeFileResVO;
import com.sc.model.entity.resume.vo.UserResumeFileUpdateReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserResumeFileConvert {
    UserResumeFileConvert INSTANCE = Mappers.getMapper(UserResumeFileConvert.class);

    UserResumeFileDO convert(UserResumeFileCreateReqVO userResumeFileCreateReqVO);

    UserResumeFileResVO convert(UserResumeFileDO userResumeFileDO);

    UserResumeFileDO convert(UserResumeFileUpdateReqVO userResumeFileUpdateReqVO);
}
